package com.sky.common.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sky.common.log.LogMessage;
import com.sky.common.bean.StatusBean;
import com.sky.common.profitUtil.ConnectionCallBack;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jolbox.bonecp.BoneCPDataSource;


/**
 * 查询 主库的数据
 * @author lx
 *
 */
public class JdbcTemplateDaoSupport {
	private static Logger log = Logger.getLogger("JdbcTemplateDaoSupport");
	
	/**
	 * 获取数据源配置
	 * @return
	 */
	private static BoneCPDataSource getUserDateSource(){
		BoneCPDataSource boneCPDataSource = SpringUtils.getBean("dataSource");
		return boneCPDataSource;
	}
	
	/**
	 * 从spring 获取 jdbc
	 * @return
	 */
	private static JdbcTemplate getJdbcTemplate(){
		return SpringUtils.getBean("jdbcTemplate");
	}
	
	/**
	 * 获取默认jdbc
	 * @return
	 */
	private static NamedParameterJdbcTemplate getDefoultDateSource(){
		BoneCPDataSource bcd = getUserDateSource();
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		jdbcTemplate.setDataSource(bcd);
		NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(jdbcTemplate);
		return npjdbc;
	}

	/**
	 * 增删改 格式为:
	 * @param sql delete stu where s_id=:id或者 insert into stu values(:sname,:ssex,:sbrith)
	 * @param params Map 类型
	 * @return
	 */
	public static boolean updateOrAddOrDele(String sql,Map<String, Object> params){
		boolean status=false;
		NamedParameterJdbcTemplate npjdbc = getDefoultDateSource();
		try {
			if(npjdbc.update(sql, params)>=1){
				status = true;
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.error(LogMessage.DATE_UPDATE_ERROR_0+"==>"+sql,e.getRootCause());
			e.printStackTrace();
		}
		return status;
	}
	/**
	 * 获取 默认数据的用户信息
	 * @param sql  例如: select * from user where id=:id and db_user_name=:dbUserName
	 * @param obj  用户对象
 	 * @return
	 */
	public static <T> Object getUserDate(String sql,T obj){
		NamedParameterJdbcTemplate npjdbc = getDefoultDateSource();
		SqlParameterSource ps=new BeanPropertySqlParameterSource(obj);
		try {
			obj = (T) npjdbc.queryForObject(sql, ps, new BeanPropertyRowMapper(obj.getClass()));
			if(StringUtil.isNull(obj)){
				log.info("没有获取到数据"+obj);
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.error("获取当前用户信息异常",e.getRootCause());
//			e.printStackTrace();
			obj=null;
		}
		return obj;
	}
	
	/**
	 * 查询 当前用户对应的数据库 数据.
	 * @param sql 
	 * @param params 参数 Map 
	 * @return       返回要查询的对象结果
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getObjectDateInfo(String sql,Map<String, Object> params){
		NamedParameterJdbcTemplate npjdbc = getDefoultDateSource();
		try {
			params =   npjdbc.queryForMap(sql, params);
			if(StringUtil.isNull(params)){
				log.info(LogMessage.DATE_MESSAGE_INFO_0+"==>"+sql+"==>"+params);
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.error(LogMessage.DATE_MESSAGE_ERROR_0+"==>"+sql+"==>"+params,e.getRootCause());
//			e.printStackTrace();
			params=null;
		} 
		return params;
	}
	
	
	/**
	 * 查询 当前用户对应的数据库 数据.
	 * @param sql 
	 * @param sql 参数 对象
	 * @param obj    需要查询的对象
	 * @return       返回要查询的对象结果
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObjectDateInfo(String sql,T obj){
		NamedParameterJdbcTemplate npjdbc = getDefoultDateSource();
		SqlParameterSource ps=new BeanPropertySqlParameterSource(obj);
		try {
			obj = (T) npjdbc.queryForObject(sql, ps, new BeanPropertyRowMapper(obj.getClass()));
			if(StringUtil.isNull(obj)){
				log.info(LogMessage.DATE_MESSAGE_INFO_0+"==>"+sql+"==>"+obj.getClass());
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.error(LogMessage.DATE_MESSAGE_ERROR_0+"==>"+sql+"==>"+obj.getClass(),e.getRootCause());
//			e.printStackTrace();
			obj=null;
		}  
		return obj;
	
	}

	/**
	 * 查询 当前用户对应的数据库 数据.
	 * @param sql
	 * @param params 参数 Map 
	 * @param obj    需要查询的对象
	 * @return       返回要查询的对象结果
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObjectDateInfo(String sql,Map<String, Object> params,T obj){
		NamedParameterJdbcTemplate npjdbc = getDefoultDateSource();
		try {
			obj = (T) npjdbc.queryForObject(sql, params, new BeanPropertyRowMapper(obj.getClass()));
			if(StringUtil.isNull(obj)){
				log.info(LogMessage.DATE_MESSAGE_INFO_0+"==>"+sql+"==>"+obj.getClass());
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.error(LogMessage.DATE_MESSAGE_ERROR_0+"==>"+sql+"==>"+obj.getClass(),e.getRootCause());
			log.error(e);
//			e.printStackTrace();
			obj=null;
		}
		return obj;
	}

	/**
	 * 查询 当前用户对应的数据库 数据.
	 * @param sql
	 * @param params 参数 Map
	 * @return       返回要查询的对象结果
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getObject(String sql,Map<String, Object> params, Class<T> clazz){
		NamedParameterJdbcTemplate npjdbc = getDefoultDateSource();
		try {
			return npjdbc.queryForObject(sql, params, new BeanPropertyRowMapper<T>(clazz));
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.error(LogMessage.DATE_MESSAGE_ERROR_0+"==>"+sql+"==>"+clazz, e.getRootCause());
//			e.printStackTrace();
		}
		return null;
	}
	

	
	/**
	 * 更新数据修改删除 格式为:
	 * @param <T>
	 * @param sql delete stu where s_id=:id或者 insert into stu values(:sname,:ssex,:sbrith)  
	 * @param ob  更新的对象
	 * @return
	 */
	public static <T> boolean updateOrAddOrDele(String sql, T ob){
		boolean status=false;
		NamedParameterJdbcTemplate npjdbc = getDefoultDateSource();
		try {
			//:后面的名称必须和stu属性名称一样
			SqlParameterSource ps=new BeanPropertySqlParameterSource(ob);
			if(npjdbc.update(sql, ps)>=1){
				status = true;
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			log.error(LogMessage.DATE_UPDATE_ERROR_0+"==>"+sql,e.getRootCause());
			e.printStackTrace();
		} 
		return status;
	}
	
	/**
	 * 获取数据列表  map方式传参
	 * @param sql
	 * @param params  参数
	 * @param brean   返回列表结果对象
	 * @return        返回对象
	 */
	public static <T> List<T> getList(String sql,Map<String, Object> params,T brean){
		NamedParameterJdbcTemplate npjdbc = getDefoultDateSource();
		List<T> list = (List<T>) npjdbc.queryForList(sql, params, brean.getClass());
		return list;
	}
	/**
	 * 获取数据列表: 对象传参
	 * @param sql    sql 语句
	 * @param brean  需要查询的条件对象
	 * @return       需要返回的结果集
	 */
	public static <T> List<T> getList(String sql,T brean){
		NamedParameterJdbcTemplate npjdbc = getDefoultDateSource();
		SqlParameterSource ps=new BeanPropertySqlParameterSource(brean);
		List<T> list = npjdbc.query(sql, ps, new BeanPropertyRowMapper(brean.getClass()));
		return list;
	}

	/**
	 * 获取数据列表: 对象传参
	 *
	 * @param sql
	 *            sql 语句
	 * @param clazz
	 *            需要查询的条件对象
	 * @return 需要返回的结果集
	 */
	public static <T> List<T> getBeanList(String sql, Map<String, Object> params, Class<T> clazz) {
		NamedParameterJdbcTemplate npjdbc = getDefoultDateSource();
		return npjdbc.query(sql, params, new BeanPropertyRowMapper(clazz));
	}
	
	/**
	 * 获取行数,或者 int类型的数
	 * @param sql  		sql语句 
	 * @param paramMap  查询条件
	 * @return
	 */
	public static int count(String sql,Map<String, Object> paramMap){
		NamedParameterJdbcTemplate npjdbc = getDefoultDateSource();
		return npjdbc.queryForInt(sql, paramMap);
	}


    /**
     *
     * @Title: initSqlParams
     * @Description: 生成sql语句的参数
     * @param @param paramList
     * @param @param preparedStatement 设定文件
     * @return void 返回类型
     * @throws
     */
    @SuppressWarnings("unchecked")
    private static void createSqlParams(Object paramsData,
                                        PreparedStatement preparedStatement) {
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
                    preparedStatement.setTimestamp(i + 1, new Timestamp(
                            ((Date) obj).getTime()));
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
     *
     * @Title: saveBatch
     * @Description: 批量保存
     * @param @param commandInfos
     * @param @return 设定文件
     * @return boolean 返回类型
     * @throws
     */
    public static <T> boolean saveBatch(List<JdbcCommandInfo> commandInfos) {
        boolean status = false;
        BoneCPDataSource dcSource = getUserDateSource();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 获取连接并开启事务
            connection = dcSource.getConnection();
			ConnectionUtil.beginTransaction(connection);
            // 执行sql
            for (JdbcCommandInfo commandInfo : commandInfos) {
                preparedStatement = connection.prepareStatement(commandInfo
                        .getSql());
                createSqlParams(commandInfo.getData(), preparedStatement);
                preparedStatement.executeUpdate();
            }
            // 提交事务
			ConnectionUtil.commitTransaction(connection);
            status = true;
        } catch (DataAccessException e) {
            // 出错回滚
			ConnectionUtil.rollbackTransaction(connection);
            log.error(LogMessage.DATE_UPDATE_ERROR_0 + "==>", e.getRootCause());
        } catch (Exception e) {
            // 出错回滚
			ConnectionUtil.rollbackTransaction(connection);
            log.error(e);
        } finally {
			ConnectionUtil.closeConnection(connection);
        }
        return status;
    }

	/**
	 * @param call
	 * @return StatusBean
	 */
	public static StatusBean execute(ConnectionCallBack call) {
		BoneCPDataSource dcSource = getUserDateSource();
		Connection connection = null;
		StatusBean status = null;
		try {
			connection = dcSource.getConnection();
			ConnectionUtil.beginTransaction(connection);

			try {
				status = call.execute(connection);
				if(status != null && !status.getStatus()){//业务上的不成功，则回滚
					ConnectionUtil.rollbackTransaction(connection);
				}else{
					ConnectionUtil.commitTransaction(connection);
				}
			} catch (Exception e) {
				// 出错回滚
				log.error("事务执行出错", e);
				ConnectionUtil.rollbackTransaction(connection);
				//异常
				status = new StatusBean(false,"9999",e.getMessage(), StringUtils.defaultString(e.getMessage(), "系统异常，请重试！"));
			}
		} catch (SQLException e) {
			log.error("获取连接出错", e);
			e.printStackTrace();
		}finally {
			ConnectionUtil.closeConnection(connection);
		}
		return status;
	}
}
