package com.sky.log.service;

import com.sky.common.util.DbUtil;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.log.BaseLogBean;
import com.sky.dao.log.TradeLogBean;
import jdbcUtil.JdbcModuleDaoSupport;

/**
 * Created by Administrator on 2015/11/12.
 */
public class TradeLogService implements BaseLogService {
    @Override
    public boolean WriteLog(BaseLogBean baseLogBean) {
        TradeLogBean bean = (TradeLogBean) baseLogBean;
        String module = bean.getMemberId();
        String tableName = DbUtil.getTradeLogTableName(bean.getMemberId());
        String sql = "INSERT INTO `" + tableName + "`(trade_type, trade_id, member_id, order_id, order_code, pay_money, log_data, create_date) " +
                " VALUES" +
                " (:tradeType, :tradeId, :memberId, :orderId, :orderCode, :payMoney, :logData, :createDate)";

        System.out.println("TradeLogService:" + bean);
        return (JdbcModuleDaoSupport.updateOrAddOrDele(DataBaseType.ORDER_LOG, sql, bean, module));
    }
}
