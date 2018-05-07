package jdbcUtil;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.sky.common.util.DbUtil;
import com.sky.common.util.StringUtil;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;
import com.sky.common.log.LogMessage;
import com.sky.dao.vo.ServerConfigBean;

/**
 * 动态库 增删改查
 *
 * @author lx
 */
public class JdbcModuleDaoSupport {
    private static Logger log = Logger.getLogger("JdbcTemplateDaoSupport");

    /**
     * 根据对象的模 获取数据库连接
     *
     * @param module
     * @return
     */
    private static BoneCPDataSource getRedisBoneCPConfig(int dataBaseType, String module) {
        BoneCPDataSource newDateSource = null;
        BoneCPConfig jdbcconfig = null;
        ServerConfigBean bean = null;
        module = DbUtil.getMod4Db(module);

        bean = new ServerConfigBean();
        bean.setModules(Integer.parseInt(module));
        String sql = "select * from server_config where modules= :modules AND database_type=" + dataBaseType + " LIMIT 1";
        bean = (ServerConfigBean) JdbcTemplateDaoSupport.getUserDate(sql, bean);
        try {
            jdbcconfig = new BoneCPConfig();
            jdbcconfig.setJdbcUrl(bean.getDatabaseUrl());
            jdbcconfig.setUsername(bean.getDatabaseUsername());
            jdbcconfig.setPassword(bean.getDatabasePassword());
            jdbcconfig.setMinConnectionsPerPartition(2);
            jdbcconfig.setMaxConnectionsPerPartition(2);
            jdbcconfig.setPartitionCount(1);
            newDateSource = new BoneCPDataSource(jdbcconfig);
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        newDateSource = new BoneCPDataSource(jdbcconfig);
        // 数据库连接池的最小连接数
        newDateSource.setMinConnectionsPerPartition(5);
        // 数据库连接池的最大连接数
        newDateSource.setMaxConnectionsPerPartition(10);
        newDateSource.setPartitionCount(1);
        return newDateSource;
    }

    /**
     * 查询 当前用户对应的数据库 数据.
     *
     * @param sql
     * @param params 参数 对象
     * @param obj    需要查询的对象
     * @return 返回要查询的对象结果
     */
    @SuppressWarnings("unchecked")
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
            // TODO Auto-generated catch block
            log.error(LogMessage.DATE_MESSAGE_ERROR_0 + "==>" + sql + "==>" + obj.getClass(), e.getRootCause());
            // e.printStackTrace();
            obj = null;
        } finally {
            clones(dcSource);
        }
        return obj;

    }

    /**
     * 查询 当前用户对应的数据库 数据.
     *
     * @param sql
     * @param params 参数 Map
     * @param obj    需要查询的对象
     * @return 返回要查询的对象结果
     */
    @SuppressWarnings("unchecked")
    public static <T> T getObjectDateInfo(int dataBaseType, String sql, Map<String, Object> params, T obj, String module) {
        BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
        NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
        SqlParameterSource ps = new BeanPropertySqlParameterSource(obj);
        try {
            obj = (T) npjdbc.queryForObject(sql, params, new BeanPropertyRowMapper(obj.getClass()));
            if (StringUtil.isNull(obj)) {
                log.info(LogMessage.DATE_MESSAGE_INFO_0 + "==>" + sql + "==>" + obj.getClass());
            }
        } catch (DataAccessException e) {
            // TODO Auto-generated catch block
            log.error(LogMessage.DATE_MESSAGE_ERROR_0 + "==>" + sql + "==>" + obj.getClass(), e.getRootCause());
            // e.printStackTrace();
            obj = null;
        } finally {
            clones(dcSource);
        }
        return obj;
    }

    /**
     * 增删改 格式为:
     *
     * @param sql    delete stu where s_id=:id或者 insert into stu
     *               values(:sname,:ssex,:sbrith)
     * @param params Map 类型
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
            // TODO Auto-generated catch block
            log.error(LogMessage.DATE_UPDATE_ERROR_0 + "==>" + sql, e.getRootCause());
            //e.printStackTrace();
            status = false;
        } finally {
            clones(dcSource);
        }
        return status;
    }

    /**
     * 更新数据修改删除 格式为:
     *
     * @param <T>
     * @param sql delete stu where s_id=:id或者 insert into stu
     *            values(:sname,:ssex,:sbrith)
     * @param ob  更新的对象
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
            // TODO Auto-generated catch block
            log.error(LogMessage.DATE_UPDATE_ERROR_0 + "==>" + sql, e.getRootCause());
            //e.printStackTrace();
            status = false;
        } finally {
            clones(dcSource);
        }
        return status;
    }

    /**
     * 事物更新多个库中数据
     *
     * @param <T>
     * @param commandInfos
     * @return
     */
    public static <T> boolean saveAll(int dataBaseType, List<JdbcCommandInfo> commandInfos) {
        boolean status = false;
        HashMap<String, Object> source = new HashMap<String, Object>();
        HashMap<String, Object> source_np = new HashMap<String, Object>();
        BoneCPDataSource mainSource = null;
        // 事物开启
        try {

            mainSource = JdbcTemplateDaoSupport.getDataSource();
            NamedParameterJdbcTemplate main_npjdbc = new NamedParameterJdbcTemplate(mainSource);

            beginTransaction(mainSource);

            //SqlParameterSource ps = null;
            for (JdbcCommandInfo jd : commandInfos) {
                if (jd.getModule() != null && source.get(jd.getModule()) == null) {
                    BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, jd.getModule());
                    NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
                    source.put(jd.getModule(), dcSource);
                    source_np.put(jd.getModule(), npjdbc);
                    beginTransaction(dcSource);
                }

                if (jd.getModule() == null) {
                    if (main_npjdbc.update(jd.getSql(), (Map<String, Object>) jd.getData()) >= 1) {
                        status = true;
                    }
                } else {
                    NamedParameterJdbcTemplate npjdbc = (NamedParameterJdbcTemplate) source_np.get(jd.getModule());

                    if (npjdbc.update(jd.getSql(), (Map<String, Object>) jd.getData()) >= 1) {
                        status = true;
                    }
                }
            }

            commitTransaction(mainSource);
            for (Entry<String, Object> entry : source.entrySet()) {
                BoneCPDataSource dcSource = (BoneCPDataSource) entry.getValue();
                System.out.println("source" + entry.getKey());
                System.out.println("value" + entry.getValue());
                commitTransaction(dcSource);
            }
        } catch (Exception e) {

            rollbackTransaction(mainSource);
            for (Entry<String, Object> entry : source.entrySet()) {
                BoneCPDataSource dcSource = (BoneCPDataSource) entry.getValue();
                rollbackTransaction(dcSource);
            }
            status = false;
            log.error("回滚数据######");
            for (JdbcCommandInfo jd : commandInfos) {
                log.error(jd.toString());
            }

        } finally {
            clones(mainSource);
            for (Entry<String, Object> entry : source.entrySet()) {
                BoneCPDataSource dcSource = (BoneCPDataSource) entry.getValue();
                clones(dcSource);
            }
        }
        return status;
    }

    /**
     * 更新数据修改删除 格式为:
     *
     * @param <T>
     * @param commandInfos
     * @return
     */
    public static <T> boolean saveBatch(int dataBaseType, List<JdbcCommandInfo> commandInfos, String module) {
        boolean status = false;
        BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
        NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
        SqlParameterSource ps = null;
        try {
            //获取连接并开启事务
            beginTransaction(dcSource);
            //执行sql
            for (JdbcCommandInfo commandInfo : commandInfos) {
                ps = new BeanPropertySqlParameterSource(commandInfo.getData());
                if (npjdbc.update(commandInfo.getSql(), ps) >= 1) {
                    status = true;
                }
            }
            //提交事务
            commitTransaction(dcSource);
        } catch (DataAccessException e) {
            //出错回滚
            rollbackTransaction(dcSource);
            log.error(LogMessage.DATE_UPDATE_ERROR_0 + "==>", e.getRootCause());
        } catch (Exception e) {
            //出错回滚
            rollbackTransaction(dcSource);

        } finally {
            clones(dcSource);
        }
        return status;
    }

    /**
     * 获取数据列表 map方式传参
     *
     * @param sql
     * @param params 参数
     * @param brean  返回列表结果对象
     * @return 返回对象
     */
    public static <T> List<T> getList(int dataBaseType, String sql, Map<String, Object> params, T brean, String module) {
        BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
        NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
        List<T> T = (List<T>) npjdbc.queryForList(sql, params, brean.getClass());
        clones(dcSource);
        return T;
    }

    /**
     * 获取数据列表: 对象传参
     *
     * @param sql   sql 语句
     * @param brean 需要查询的条件对象
     * @return 需要返回的结果集
     */
    public static <T> List<T> getList(int dataBaseType, String sql, T brean, String module) {
        BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
        NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
        SqlParameterSource ps = new BeanPropertySqlParameterSource(brean);
        List<T> T = npjdbc.query(sql, ps, new BeanPropertyRowMapper(brean.getClass()));
        clones(dcSource);
        return T;
    }

    /**
     * 获取行数,或者 int类型的数
     *
     * @param sql      sql语句
     * @param paramMap 查询条件
     * @return
     */
    public static int count(int dataBaseType, String sql, Map<String, Object> paramMap, String module) {
        BoneCPDataSource dcSource = getRedisBoneCPConfig(dataBaseType, module);
        NamedParameterJdbcTemplate npjdbc = new NamedParameterJdbcTemplate(dcSource);
        int count = npjdbc.queryForInt(sql, paramMap);
        clones(dcSource);
        return count;
    }

    /**
     * 关闭数据库连接
     *
     * @param dcSource
     */
    private static void clones(BoneCPDataSource dcSource) {
        try {
            dcSource.getConnection().close();
            dcSource.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @param @param dcSource    设定文件
     * @return void    返回类型
     * @throws
     * @Title: beginTransaction
     * @Description: 开启事务
     */
    private static void beginTransaction(BoneCPDataSource dcSource) {
        try {
            dcSource.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            log.error("开启事务出错!", e);
            e.printStackTrace();
        }
    }

    /**
     * @param @param dcSource    设定文件
     * @return void    返回类型
     * @throws
     * @Title: commitTransaction
     * @Description: 提交事务
     */
    private static void commitTransaction(BoneCPDataSource dcSource) {
        try {
            dcSource.getConnection().commit();
        } catch (SQLException e) {
            log.error("提交事务出错!", e);
            e.printStackTrace();
        }
    }

    /**
     * @param @param dcSource    设定文件
     * @return void    返回类型
     * @throws
     * @Title: rollbackTransaction
     * @Description: 事务回滚
     */
    private static void rollbackTransaction(BoneCPDataSource dcSource) {
        try {
            dcSource.getConnection().rollback();
        } catch (SQLException e) {
            log.error("回滚事务出错!", e);
            e.printStackTrace();
        }
    }

}
