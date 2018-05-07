package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/11/12.
 */
public class DataBaseType {

    /**
     * 主数据库
     * 设置server_config表的database_type字段为0
     */
    public final static int BASE_DATA = 0;

    /**
     * 订单库
     * 设置server_config表的database_type字段为1
     */
    public final static int ORDER_DATA = 1;

    /**
     * 系统日志库的数据库连接字符串的类型
     * 设置server_config表的database_type字段为2
     */
    public final static int SYS_LOG = 2;

    /**
     * 订单的交易日志库的数据库连接字符串的类型
     * 设置server_config表的database_type字段为3
     */
    public final static int ORDER_LOG = 3;

    /**
     * 用户地址库和邀请码库
     * 设置server_config表的database_type字段为4
     */
    public final static int MEMBER_DATA = 4;

    /**
     * 收益库
     * 设置server_config表的database_type字段为5
     */
    public final static int PROFIT_DATA = 5;

    /**
     * 业绩库
     * 设置server_config表的database_type字段为6
     */
    public final static int ACHIVEMENT_DATA = 6;

    /**
     * 防伪码库
     * 设置server_config表的database_type字段为7
     */
    public final static int SAFECODE_DATA = 7;

    /**
     * 防伪码主库
     * 设置server_config表的database_type字段为8
     */
    public final static int SAFECODE_MAIN_DATA = 8;
    
    /**
     * 分享视频 意向库
     * 设置server_config表的database_type字段为9
     */
    public final static int SAFECODE_SHARE_DATA = 9;

    /**
     * 仓储系统主库
     * 设置server_config表的database_type字段为10
     */
    public final static int WMS_DATA=10;

    /**
     * 防伪码存储库
     * 设置server_config表的database_type字段为12
     */
    public final static int FW_DATA=12;
}
