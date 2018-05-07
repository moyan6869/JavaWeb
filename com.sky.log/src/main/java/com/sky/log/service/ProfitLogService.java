package com.sky.log.service;

import com.sky.common.util.DbUtil;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.log.BaseLogBean;
import com.sky.dao.log.ProfitLogBean;
import jdbcUtil.JdbcModuleDaoSupport;

/**
 * Created by Administrator on 2015/11/12.
 */
public class ProfitLogService implements BaseLogService {
    @Override
    public boolean WriteLog(BaseLogBean baseLogBean) {
        ProfitLogBean bean = (ProfitLogBean) baseLogBean;
        String module = bean.getMemberId();
        String tableName = DbUtil.getProfitLogTableName(bean.getMemberId());
        String sql = "INSERT INTO `" + tableName + "`(member_id, log_data, create_date) " +
                " VALUES" +
                " (:memberId, :logData, :createDate)";

        System.out.println("ProfitLogService:" + bean);
        return (JdbcModuleDaoSupport.updateOrAddOrDele(DataBaseType.ORDER_LOG, sql, bean, module));
    }
}
