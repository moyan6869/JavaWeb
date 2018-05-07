package com.sky.common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sky.common.datasource.ClusterDatasource;
import com.sky.common.log.LogMessage;
import org.apache.log4j.Logger;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jolbox.bonecp.BoneCPDataSource;
import com.sky.dao.vo.ServerConfigBean;

/**
 * 动态库 增删改查
 *
 * @author lx
 */
public class JdbcModuleDaoSupport2 {

	public ClusterDatasource clusterDatasource;

	private static Logger log = Logger.getLogger("JdbcModuleDaoSupport2");

	public static ClusterDatasource getClusterDatasource() {
		return SpringUtils.getBean("clusterDatasource");
	}

	public void setClusterDatasource(ClusterDatasource clusterDatasource) {
		this.clusterDatasource = clusterDatasource;
	}

	/**
	 * 根据对象的模 获取数据库连接
	 *
	 * @param module
	 * @return
	 */
		public static BoneCPDataSource getRedisBoneCPConfig(int dataBaseType, String module) {
		BoneCPDataSource newDateSource = null;
		ServerConfigBean bean = null;
		boolean checkSession = false;
		module = DbUtil.getMod4Db(module);
		System.out.println(module + "==============");
		String key = SessionUtil.REDIS_JDBC_DATE_MODULE + module + dataBaseType;
		String geto = SessionUtil.getSessionString(key);
		bean = JacksonUtil.fromJson(geto, ServerConfigBean.class);
		if (StringUtil.isNull(bean)) {
			bean = new ServerConfigBean();
			bean.setModules(Integer.parseInt(module));
			bean.setDatabaseType(dataBaseType);
			String sql = "select * from server_config where modules=:modules and database_type=:databaseType";
			bean = (ServerConfigBean) JdbcTemplateDaoSupport.getUserDate(sql, bean);
			checkSession = true;
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			newDateSource = getClusterDatasource().getBoneCPDataSource(dataBaseType, module, bean.getDatabaseUrl(),
					bean.getDatabaseUsername(), bean.getDatabasePassword());
			if (checkSession) {
				String stro = JacksonUtil.toJson(bean);
					SessionUtil.setSessionString(key, stro);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newDateSource;
	}

	/**
	 * 查询 当前用户对应的数据库 数据.
	 *
	 * @param sql
	 * @param params
	 *            参数 对象
	 * @param obj
	 *            需要查询的对象
	 * @return 返回要查询的对象结果
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T getObjectDateInfo(int dataBaseType, String sql, T obj, String module) {
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
		SqlParameterSource ps = new BeanPropertySqlParameterSource(obj);
		try {
			obj = (T) npjdbc.queryForObject(sql, ps, new BeanPropertyRowMapper(obj.getClass()));
			if (StringUtil.isNull(obj)) {
				log.info(LogMessage.DATE_MESSAGE_INFO_0 + "==>" + sql + "==>" + obj.getClass());
			}
		} catch (DataAccessException e) {
			log.error(LogMessage.DATE_MESSAGE_ERROR_0 + "==>" + sql + "==>" + obj.getClass(), e.getRootCause());
			obj = null;
		}
		return obj;
	}

	/**
	 * 查询 当前用户对应的数据库 数据. 
	 *
	 * @param sql
	 * @param params
	 *            参数 Map
	 * @param obj
	 *            需要查询的对象
	 * @return 返回要查询的对象结果
	 */
	public static Map<String, Object> getObjectDateInfo(int dataBaseType, String module, String sql,
			Map<String, Object> params) {
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
		try {
			params = npjdbc.queryForMap(sql, params);
			if (StringUtil.isNull(params)) {
				log.info(LogMessage.DATE_MESSAGE_INFO_0 + "==>" + sql + "==>" + params);
			}
		} catch (DataAccessException e) {
			log.error(LogMessage.DATE_MESSAGE_ERROR_0 + "==>" + sql + "==>" + params, e.getRootCause());
			params = null;
		}
		return params;
	}

	/**
	 * 查询 当前用户对应的数据库 数据.
	 *
	 * @param sql
	 * @param params
	 *            参数 Map
	 * @param obj
	 *            需要查询的对象
	 * @return 返回要查询的对象结果
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObjectDateInfo(int dataBaseType, String sql, Map<String, Object> params, T obj,
			String module) {
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
		SqlParameterSource ps = new BeanPropertySqlParameterSource(obj);
		try {
			obj = (T) npjdbc.queryForObject(sql, params, new BeanPropertyRowMapper(obj.getClass()));
			if (StringUtil.isNull(obj)) {
				log.info(LogMessage.DATE_MESSAGE_INFO_0 + "==>" + sql + "==>" + obj.getClass());
			}
		} catch (DataAccessException e) {
			log.error(LogMessage.DATE_MESSAGE_ERROR_0 + "==>" + sql + "==>" + obj.getClass(), e.getRootCause());
			obj = null;
		}
		return obj;
	}

	/**
	 * 增删改 格式为:
	 *
	 * @param sql
	 *            delete stu where s_id=:id或者 insert into stu
	 *            values(:sname,:ssex,:sbrith)
	 * @param params
	 *            Map 类型
	 * @return
	 */
	public static boolean updateOrAddOrDele(int dataBaseType, String sql, Map<String, Object> params, String module) {
		boolean status = false;
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
		try {
			if (npjdbc.update(sql, params) >= 1) {
				status = true;
			}
		} catch (DataAccessException e) {
			log.error(LogMessage.DATE_UPDATE_ERROR_0 + "==>" + sql, e.getRootCause());
		}
		return status;
	}

	/**
	 * 更新数据修改删除 格式为:
	 *
	 * @param <T>
	 * @param sql
	 *            delete stu where s_id=:id或者 insert into stu
	 *            values(:sname,:ssex,:sbrith)
	 * @param ob
	 *            更新的对象
	 * @return
	 */
	public static <T> boolean updateOrAddOrDele(int dataBaseType, String sql, T ob, String module) {
		boolean status = false;
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
		try {
			// :后面的名称必须和stu属性名称一样
			SqlParameterSource ps = new BeanPropertySqlParameterSource(ob);
			if (npjdbc.update(sql, ps) >= 1) {
				status = true;
			}
		} catch (DataAccessException e) {
			log.error(LogMessage.DATE_UPDATE_ERROR_0 + "==>" + sql, e.getRootCause());
		}
		return status;
	}

	/**
	 * 获取数据列表 map方式传参
	 *
	 * @param sql
	 * @param params
	 *            参数
	 * @param brean
	 *            返回列表结果对象
	 * @return 返回对象
	 */
	public static <T> List<T> getList(int dataBaseType, String sql, Map<String, Object> params, T brean,
			String module) {
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
		List<T> T = (List<T>) npjdbc.queryForList(sql, params, brean.getClass());
		return T;
	}

//	public static T getBean(int dataBaseType, String sql,T brean,String module){
//		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
//		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
//		T t = npjdbc.queryForObject(sql,new BeanPropertyRowMapper<T>(T.class),null);
//		return t;
//	}
	/**
	 * 获取数据列表: 对象传参
	 *
	 * @param sql
	 *            sql 语句
	 * @param clazz
	 *            需要查询的条件对象
	 * @return 需要返回的结果集
	 */
	public static <T> List<T> getBeanList(int dataBaseType, String sql, Map<String, Object> params, Class<T> clazz, String module) {
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
		return npjdbc.query(sql, params, new BeanPropertyRowMapper(clazz));
	}

	/**
	 * 获取数据列表: 对象传参
	 * //todo 这个方法用不了，请使用getBeanList
	 * @param sql
	 *            sql 语句
	 * @param brean
	 *            需要查询的条件对象
	 * @return 需要返回的结果集
	 */
	public static <T> List<T> getList(int dataBaseType, String sql, T brean, String module) {
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
		SqlParameterSource ps = new BeanPropertySqlParameterSource(brean);
		List<T> T = npjdbc.query(sql, ps, new BeanPropertyRowMapper(brean.getClass()));
		return T;
	}



	public static  <T> List<T> getOnlyOne(int dataBaseType, String sql, T brean, String module, Map map){
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
		SqlParameterSource ps = new BeanPropertySqlParameterSource(brean);
		int num = npjdbc.queryForInt(sql,ps);
		List list = new ArrayList<>();
		list.add(num);
		return list;
	}
	/**
	 * 获取行数,或者 int类型的数
	 *
	 * @param sql
	 *            sql语句
	 * @param paramMap
	 *            查询条件
	 * @return
	 */
	public static int count(int dataBaseType, String sql, Map<String, Object> paramMap, String module) {
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
		int count = npjdbc.queryForInt(sql, paramMap);
		return count;
	}

	/**
	 * @param @param
	 *            commandInfos
	 * @param @param
	 *            module
	 * @param @return
	 *            设定文件
	 * @return boolean 返回类型
	 * @throws @Title:
	 *             saveBatch
	 * @Description: 批量保存
	 */
	public static <T> boolean saveBatchTrans(int dataBaseType, List<JdbcCommandInfo> commandInfos, String module) {
		boolean status = false;
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		Connection connection = null;
		try {
			// 获取连接并开启事务
			connection = dcSource.getConnection();
			try {
				ConnectionUtil.beginTransaction(connection);
				try {
					PreparedStatement preparedStatement = null;
					// 执行sql
					for (JdbcCommandInfo commandInfo : commandInfos) {
						preparedStatement = connection.prepareStatement(commandInfo.getSql());
						createSqlParams(commandInfo.getData(), preparedStatement);
						preparedStatement.executeUpdate();
					}
					// 提交事务
					ConnectionUtil.commitTransaction(connection);
					status = true;
				} catch (Exception e) {
					ConnectionUtil.rollbackTransaction(connection);
					log.error("数据库事务出错，", e);
				}
			} finally {
				ConnectionUtil.closeConnection(connection);
			}
		} catch (Exception e) {
			log.error("获取数据库连接出错", e);
		}
		return status;
	}

	/**
	 * @param @param
	 *            paramList
	 * @param @param
	 *            preparedStatement 设定文件
	 * @return void 返回类型
	 * @throws @Title:
	 *             initSqlParams
	 * @Description: 生成sql语句的参数
	 */
	@SuppressWarnings("unchecked")
	private static void createSqlParams(Object paramsData, PreparedStatement preparedStatement) {
		Object obj = null;
		List<Object> paramList = null;
		try {
			paramList = (List<Object>) paramsData;
			for (int i = 0; i < paramList.size(); i++) {
				obj = paramList.get(i);
				if (obj instanceof String) {
					preparedStatement.setString(i + 1, String.valueOf(obj));
				} else if (obj instanceof Integer) {
					preparedStatement.setInt(i + 1, ((Integer) obj).intValue());
				} else if (obj instanceof Date) {
					// java.util.Date转为java.sql.Date
					preparedStatement.setTimestamp(i + 1, new Timestamp(((Date) obj).getTime()));
				} else if (null == obj) {// 默认当做字符串处理
					preparedStatement.setObject(i + 1, null);
				} else {// 默认当做字符串处理
					preparedStatement.setString(i + 1, String.valueOf(obj));
				}
			}
		} catch (Exception e) {
			log.error("createSqlParams error!", e);
		}
	}
}
