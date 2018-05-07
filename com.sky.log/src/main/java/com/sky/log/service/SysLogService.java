package com.sky.log.service;

import com.sky.common.util.DbUtil;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.log.BaseLogBean;
import com.sky.dao.log.SysLogBean;
import jdbcUtil.JdbcModuleDaoSupport;

/**
 * Created by Administrator on 2015/11/12.
 */
public class SysLogService implements BaseLogService {
    @Override
    public boolean WriteLog(BaseLogBean baseLogBean) {
        SysLogBean bean = (SysLogBean) baseLogBean;
        String module = "00";
        String tableName = DbUtil.getSysLogTableName(bean.getCreateDate());
        String sql = "INSERT INTO `" + tableName + "`(log_type, sys_user_id, log_data, create_date) " +
                " VALUES" +
                " (:logType, :sysUserId, :logData, :createDate)";

        System.out.println("SysLogService:" + bean);
        return (JdbcModuleDaoSupport.updateOrAddOrDele(DataBaseType.SYS_LOG, sql, bean, module));
    }
}
