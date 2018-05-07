package com.sky.log.service;

import com.sky.dao.enums.DataBaseType;
import com.sky.dao.log.BaseLogBean;
import com.sky.dao.log.TransferFailureLogBean;
import jdbcUtil.JdbcModuleDaoSupport;

/**
 * @author qiujingwang
 * @Description: 金额转出、支付失败日志记录接口实现
 * @date 2016年02月24日 下午2:51:10
 */
public class TransferFailureLogService implements BaseLogService {
    @Override
    public boolean WriteLog(BaseLogBean baseLogBean) {
        TransferFailureLogBean bean = (TransferFailureLogBean) baseLogBean;
        String module = bean.getPayerMemberId();
        String sql = "INSERT INTO `transfer_failure_Log`(transfer_type, payer_member_id, payer_available_money, payee_member_id, member_balance_id, member_transfer_id, transfer_money, log_data, create_date) " +
                " VALUES" +
                " (:transferType, :payerMemberId, :payerAvailableMoney, :payeeMemberId, :memberBalanceId, :memberTransferId, :transferMoney, :logData, :createDate)";

        System.out.println("TransferFailureLogService:" + bean);
        return (JdbcModuleDaoSupport.updateOrAddOrDele(DataBaseType.BASE_DATA, sql, bean, module));
    }
}
