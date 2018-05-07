package com.sky.common.util;

import org.apache.log4j.Logger;
import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/4/26
 * Description:connection 关闭、回滚管理工具
 */
public class ConnectionUtil {

    private static Logger log = Logger.getLogger(ConnectionUtil.class);

    /**
     * 关闭数据库连接
     *
     * @param connection
     */
    public static void closeConnection(Connection connection) {
        if(connection != null){
            try {
                if(!connection.getAutoCommit()){
                    connection.setAutoCommit(true);
                }
            } catch (Exception e) {
                log.error("设置事务自动提交出错!", e);
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     *
     * @Title: beginTransaction
     * @Description: 开启事务
     * @param @param connection 设定文件
     * @return void 返回类型
     * @throws
     */
    public static void beginTransaction(Connection connection) {
        if (connection != null) {
            try {
                if(connection.getAutoCommit()){
                    connection.setAutoCommit(false);
                }
            } catch (Exception e) {
                log.error("开启事务出错!", e);
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @Title: commitTransaction
     * @Description: 提交事务
     * @param @param connection 设定文件
     * @return void 返回类型
     * @throws
     */
    public static void commitTransaction(Connection connection) {
        if(connection != null){
            try {
                connection.commit();
            } catch (Exception e) {
                log.error("提交事务出错!", e);
                e.printStackTrace();
            }
        }
    }

    /**
     *
     * @Title: rollbackTransaction
     * @Description: 事务回滚
     * @param @param connection 设定文件
     * @return void 返回类型
     * @throws
     */
    public static void rollbackTransaction(Connection connection) {
        if(connection != null){
            try {
                connection.rollback();
            } catch (Exception e) {
                log.error("回滚事务出错!", e);
                e.printStackTrace();
            }
        }
    }
}
