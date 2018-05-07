package com.sky.common.profitUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sky.common.log.LogMessage;
import com.sky.common.util.JacksonUtil;
import com.sky.common.util.JdbcTemplateDaoSupport;
import com.sky.common.bean.StatusBean;
import com.sky.common.datasource.ClusterDatasource;
import com.sky.common.util.SpringUtils;
import com.sky.common.util.StringUtil;
import com.sky.dao.vo.ServerConfigBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jolbox.bonecp.BoneCPDataSource;
import com.sky.common.util.DbUtil;

/**
 * 动态库 增删改查
 *
 * @author lx
 */
public class JdbcModuleDaoSupport {

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
		//String key = SessionUtil.REDIS_JDBC_DATE_MODULE + module + dataBaseType;
		//String geto = SessionUtil.getSessionString(key);
		//bean = JacksonUtil.fromJson(geto, ServerConfigBean.class);
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
				//SessionUtil.setSessionString(key, stro);
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

	/**
	 * 获取数据列表: 对象传参
	 *
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
				connection.setAutoCommit(false);
				try {
					PreparedStatement preparedStatement = null;
					// 执行sql
					for (JdbcCommandInfo commandInfo : commandInfos) {
						preparedStatement = connection.prepareStatement(commandInfo.getSql());
						createSqlParams(commandInfo.getData(), preparedStatement);
						preparedStatement.executeUpdate();
					}
					// 提交事务
					connection.commit();
                    connection.setAutoCommit(true);
					status = true;
				} catch (Exception e) {
					connection.rollback();
					log.error("数据库事务出错，", e);
				}
			} finally {
				connection.close();
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
	/**
	 * @param @param connection 设定文件
	 * @return void 返回类型
	 * @throws Exception 
	 * @throws @Title: beginTransaction
	 * @Description: 开启事务
	 */
	public static void beginTransaction(Connection connection) throws Exception {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			log.error("开启事务出错!", e);
			e.printStackTrace();
			if(e.getMessage().indexOf("Communications link failure") >= 0)
			{
				throw new Exception("Communications link failure");
			}
		}
	}

	/**
	 * @param @param connection 设定文件
	 * @return void 返回类型
	 * @throws Exception 
	 * @throws @Title: commitTransaction
	 * @Description: 提交事务
	 */
	public static void commitTransaction(Connection connection) throws Exception {
		try {
			connection.commit();
		} catch (Exception e) {
			log.error("提交事务出错!", e);
			e.printStackTrace();
			if(e.getMessage().indexOf("Communications link failure") >= 0)
			{
				throw new Exception("Communications link failure");
			}
		}
	}

	/**
	 * @param @param connection 设定文件
	 * @return void 返回类型
	 * @throws Exception 
	 * @throws @Title: rollbackTransaction
	 * @Description: 事务回滚
	 */
	public static void rollbackTransaction(Connection connection) throws Exception {
		try {
			connection.rollback();
		} catch (SQLException e) {
			log.error("回滚事务出错!", e);
			e.printStackTrace();
			if(e.getMessage().indexOf("Communications link failure") >= 0)
			{
				throw new Exception("Communications link failure");
			}
		}
	}
	/**
	 * 事物关闭数据库连接
	 *
	 * @param dcSource
	 */
	public static void closeConnection(Connection connection) {
		try {
			if (null != connection) {
				connection.setAutoCommit(true);
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static <T> BoneCPDataSource getTranConnection(int dataBaseType,
			String module) throws SQLException {
		BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
		return dcSource;
	}

	public static ResultSet queryResultSet(Connection connection,
			JdbcCommandInfo commandInfo) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(commandInfo.getSql());
		createSqlParams(commandInfo.getData(), preparedStatement);
		return preparedStatement.executeQuery();
	}

	public static int execTran(Connection connection,
			JdbcCommandInfo commandInfo) throws SQLException {
		PreparedStatement preparedStatement = connection
				.prepareStatement(commandInfo.getSql());
		createSqlParams(commandInfo.getData(), preparedStatement);
		return preparedStatement.executeUpdate();
	}

	/**
	 * @param dataBaseType
	 * @param module
	 * @param call
	 * @return StatusBean
	 */
	public static StatusBean execute(int dataBaseType,
									 String module, ConnectionCallBack call) {
		BoneCPDataSource dcSource = null;
		Connection connection = null;
		StatusBean status = null;
		try {
			dcSource = JdbcModuleDaoSupport.getTranConnection(dataBaseType, module);
			connection = dcSource.getConnection();
			JdbcModuleDaoSupport.beginTransaction(connection);

			status = call.execute(connection);
			if(status != null && !status.getStatus()){//业务上的不成功，则回滚
				JdbcModuleDaoSupport.rollbackTransaction(connection);
			}else{
				JdbcModuleDaoSupport.commitTransaction(connection);
			}
		} catch (Exception e) {
			// 出错回滚
			log.error("事务执行出错", e);
			try {
				JdbcModuleDaoSupport.rollbackTransaction(connection);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
//				e1.printStackTrace();
				log.error("回滚事务出错", e);
			}
			//异常
			status = new StatusBean(false,"9999",e.getMessage(), StringUtils.defaultString(e.getMessage(), "系统异常，请重试！"));
		} finally {
			JdbcModuleDaoSupport.closeConnection(connection);
		}
		return status;
	}
}
