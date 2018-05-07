package com.sky.service.directsale.impl;

import com.sky.common.bean.StatusBean;
import com.sky.common.piting.Pager;
import com.sky.common.profitUtil.ConnectionCallBack;
import com.sky.common.profitUtil.JdbcModuleDaoSupport;
import com.sky.common.service.impl.BaseServiceImpl;
import com.sky.common.util.*;
import com.sky.dao.enums.*;
import com.sky.dao.log.TransferFailureLogBean;
import com.sky.dao.model.*;
import com.sky.dao.shopapi.CoinBalanceBean;
import com.sky.service.directsale.DoingOrderService;
import com.sky.service.directsale.MemberProfitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * MemberProfitServiceImpl
 **/
@Service("memberProfitService")
public class MemberProfitServiceImpl extends BaseServiceImpl implements MemberProfitService  {
    @Resource
    private DoingOrderService doingOrderService;

    @Resource
    private MemberProfitService memberProfitService;

    @Override
    public int count(String memberId) throws Exception {
        String feezeTableName = DbUtil.getMemberFreezeTableName(memberId);
        String profitTableName = DbUtil.getMemberProfitTableName(memberId);

        StringBuffer sbSql = new StringBuffer();
        sbSql.append("SELECT SUM(c) FROM (");
        sbSql.append("  SELECT COUNT(1) c FROM " + feezeTableName + " f WHERE member_id='" + memberId + "'");
        sbSql.append("  UNION ALL ");
        sbSql.append("  SELECT COUNT(1) c FROM " + profitTableName + " p WHERE `status` = 1  AND member_id='" + memberId + "'");
        sbSql.append(") T");

        return JdbcModuleDaoSupport2.count(DataBaseType.PROFIT_DATA, sbSql.toString(), null, memberId);
    }

    @Override
    public Pager<MemberFreezeBean> list(String memberId, Pager<MemberFreezeBean> pageData) throws Exception {
        return null;
    }


    @Override
    public Pager<CoinBalanceBean> getSupplyCoinList(String memberId, Pager<CoinBalanceBean> pageData) throws Exception {

        List<CoinBalanceBean> datas = new ArrayList<CoinBalanceBean>();
        int totalRows = this.countSupplyCoin(memberId);
        if (totalRows > 0) {
            String coinBalanceTableName = DbUtil.getCoinBalanceTableName(memberId);
            StringBuffer sbSql = new StringBuffer();
            sbSql.append("  SELECT * ");
            sbSql.append("  FROM " + coinBalanceTableName + " p  WHERE delete_flag =0 AND coin_type=1 AND member_id='" + memberId + "' ");
            sbSql.append(" ORDER BY sort_index  DESC");
            sbSql.append(" limit " + (pageData.getPageOffset() - 1) * pageData.getPageSize() + "," + pageData.getPageSize() + "");
            datas = JdbcModuleDaoSupport2.getList(DataBaseType.PROFIT_DATA, sbSql.toString(), new CoinBalanceBean() , memberId);
            for (CoinBalanceBean coinBalanceBean :datas) {
                if (coinBalanceBean.getType() == CoinBalanceType.ProfitSend.getCode()) {
                    coinBalanceBean.setTypeStr(CoinBalanceType.ProfitSend.getMsg());
                }
                if (coinBalanceBean.getType() == CoinBalanceType.ProfitSend.getCode()) {
                    coinBalanceBean.setTypeStr(CoinBalanceType.ProfitSend.getMsg());
                }
                if (coinBalanceBean.getType() == CoinBalanceType.Pay.getCode()) {
                    coinBalanceBean.setTypeStr(CoinBalanceType.Pay.getMsg());
                }
                if (coinBalanceBean.getType() == CoinBalanceType.TransIn.getCode()) {
                    coinBalanceBean.setTypeStr(CoinBalanceType.TransIn.getMsg());
                }
                if (coinBalanceBean.getType() == CoinBalanceType.TransOut.getCode()) {
                    coinBalanceBean.setTypeStr(CoinBalanceType.TransOut.getMsg());
                }
                if (coinBalanceBean.getType() == CoinBalanceType.Recharge.getCode()) {
                    coinBalanceBean.setTypeStr(CoinBalanceType.Recharge.getMsg());
                }
                if (coinBalanceBean.getType() == CoinBalanceType.SystemImport.getCode()) {
                    coinBalanceBean.setTypeStr(CoinBalanceType.SystemImport.getMsg());
                }
                if (coinBalanceBean.getType() == CoinBalanceType.Maintenance.getCode()) {
                    coinBalanceBean.setTypeStr(CoinBalanceType.Maintenance.getMsg());
                }
                if (coinBalanceBean.getType() == CoinBalanceType.PayRefund.getCode()) {
                    coinBalanceBean.setTypeStr(CoinBalanceType.PayRefund.getMsg());
                }
                if (coinBalanceBean.getType() == CoinBalanceType.PayErrorBack.getCode()) {
                    coinBalanceBean.setTypeStr(CoinBalanceType.PayErrorBack.getMsg());
                }
                if (coinBalanceBean.getType() == CoinBalanceType.ProfitSendBack.getCode()) {
                    coinBalanceBean.setTypeStr(CoinBalanceType.ProfitSendBack.getMsg());
                }

            }
        }

        pageData.setDatas(datas);
        pageData.setTotalRecord(totalRows);
        pageData.setTotalPage(totalRows);

        return pageData;
    }


    public int countSupplyCoin(String memberId) throws Exception {
        String coinBalanceTableName = DbUtil.getCoinBalanceTableName(memberId);

        StringBuffer sbSql = new StringBuffer();
        sbSql.append("  SELECT COUNT(1) c FROM " + coinBalanceTableName + " p WHERE delete_flag =0 AND coin_type=1  AND member_id='" + memberId + "'");

        return JdbcModuleDaoSupport2.count(DataBaseType.PROFIT_DATA, sbSql.toString(), null, memberId);
    }



    /**
     * 转账
     * @param
     * @return 成功状态
     * @throws Exception
     */

    public StatusBean tansferSupplyCoin(String inMemberId, String outMemberId, long coin)//0是余额，1是货款
            throws Exception {
        final String trsCode = DbUtil.getNewBalanceCode(outMemberId);//流水号
        //定义余额还是货款转账
        /**
         * 当A转账给B，A成功，B失败时，则回滚A金额，若回滚失败，则记录日志（手动处理）
         */
        final TransferFailureLogBean logBean = new TransferFailureLogBean();
        //1.付款方--------1.1更新可用余额（减） 1.2插入流水记录 1.3插入转账业务记录
        StatusBean exSuccess = JdbcModuleDaoSupport.execute(DataBaseType.PROFIT_DATA, outMemberId, new ConnectionCallBack() {
            @Override
            public StatusBean execute(Connection connection) throws Exception {
                //转出
                return MemberProfitServiceImpl.this.transferOutMoney( connection, trsCode, inMemberId,  outMemberId,  coin, logBean );
            }
        });
        if(exSuccess.getStatus()){ //转出成功
            //2.收款方--------1.1更新可用余额(加) 1.2插入流水记录 1.3插入转账业务记录
            exSuccess = JdbcModuleDaoSupport.execute(DataBaseType.PROFIT_DATA, inMemberId, new ConnectionCallBack() {
                @Override
                public StatusBean execute(Connection connection) throws Exception {
                    //转入
                    return MemberProfitServiceImpl.this.transferInMoney(connection, trsCode, inMemberId,  outMemberId,  coin, logBean);
                }
            });
            if(!exSuccess.getStatus()){
                //3.收款方失败，则回滚付款方操作，更新余额以及转账业务表里的状态为失败
                StatusBean rollBackStatusBean = JdbcModuleDaoSupport.execute(DataBaseType.PROFIT_DATA, outMemberId, new ConnectionCallBack() {
                    @Override
                    public StatusBean execute(Connection connection) throws Exception{
                        return MemberProfitServiceImpl.this.rollbackTransferOutMoney(connection, trsCode, inMemberId,  outMemberId,  coin);
                    }
                });
            }
        }

        if(StringUtil.isNull(exSuccess) || (!exSuccess.getStatus() && !StringUtil.isNull(exSuccess.getData()))){
            exSuccess = new StatusBean(false,"9999","转账失败",null);
        }
        return exSuccess;
    }

    @Override
    public CoinlistBean coinlist(String memberId, CoinlistBean pageData) throws Exception {
        return null;
    }

    @Override
    public Pager<CoinaddBean> coinaddlist(String memberId, Pager<CoinaddBean> pageData) throws Exception {
        return null;
    }

    @Override
    public Pager<CoinuseBean> coinuselist(String memberId, Pager<CoinuseBean> pageData) throws Exception {
        return null;
    }

    @Override
    public APIUserProfitBean getUserProfit(String memberId) throws Exception {
        return null;
    }

    @Override
    public APIMemberLimitLogBean getMemberLimitLog(String memberId) throws Exception {
        return null;
    }




    /**
     * 转出
     * @param
     * @param
     */
    private StatusBean transferOutMoney(Connection connection,String trsCode,String inMemberId, String outMemberId, long coin, TransferFailureLogBean logBean) throws Exception {

        String memberId = outMemberId;
        long trsOutMoney = coin;

        //1、从会员收益信息表中取出可提现余额available_money和转出总余额trsout_sum_money  use_money
        String sql = "SELECT  index_number, supply_coin FROM member_money_total WHERE member_id=? LIMIT 1 FOR UPDATE";
        List<Object> params = new ArrayList<Object>();
        params.add(memberId);
        com.sky.common.profitUtil.JdbcCommandInfo jd = new com.sky.common.profitUtil.JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "查询收益表总余额记录");

        ResultSet rs = JdbcModuleDaoSupport.queryResultSet(connection, jd);

        long supplyCoin = 0L;//2017.12.6  换货币
        int indexNumber=0;
        if (rs.next()) {
            supplyCoin=rs.getLong("supply_coin");//
            indexNumber=rs.getInt("index_number");
        }
        rs.close();

       //判断
        if (trsOutMoney > supplyCoin) {
            if (supplyCoin>0){
                return error("您的可转账余额不足,仅可转账"+supplyCoin/100+"元");
            }else {
                return error("您的可转账余额不足,仅可转账 0 元");
            }
        }
        //2.更新余额总表
        sql = "UPDATE member_money_total SET supply_coin = supply_coin - ?,"
                + " index_number=index_number+1  where member_id = ? ";
        params = new ArrayList<Object>();
        params.add(trsOutMoney);
        params.add(memberId);
        jd = new com.sky.common.profitUtil.JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "修改收益表余额记录");
        int cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return error("更新总收益余额记录失败");
        }

        //3.插入转出流水
        String uuid = StringUtil.getUUID();
        StringBuilder sbSql = new StringBuilder();
        params = new ArrayList<Object>();

        sbSql.append("insert into ");
        sbSql.append(DbUtil.getCoinBalanceTableName(memberId));
        sbSql.append(" (balance_id,sort_index,balance_code,member_id,coin_type,type,flow_type,");
        sbSql.append("flow_coin, in_member_id, out_member_id," +
                " supply_coin,operation ,create_date,update_date,delete_flag)");
        sbSql.append(" values (?,?,?,?,?,   ?,?,?,?,?,   ?,?,now(),now(),0) ");

        params.add(uuid);
        params.add(indexNumber + 1);
        params.add(trsCode);
        params.add(memberId);
        params.add(1);//0食品券1补货券       coin_type=1  is supply_coin
        params.add(CoinBalanceType.TransOut.getCode());//余额转出
        params.add(0);//流出
        params.add(trsOutMoney);
        params.add(inMemberId);
        params.add(memberId);
        params.add( supplyCoin - trsOutMoney);
        params.add(memberId);
        jd = new com.sky.common.profitUtil.JdbcCommandInfo(sbSql.toString(), params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "插入转出流水");
        cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return error("插入转出流水记录失败");
        }
        return success("更新转账记录成功");
    }

    /**
     * 回滚转出金额
     * @param
     * @param
     * @param
     * @return
     */                                         //connection, trsCode, inMemberId,  outMemberId,  coin, logBean
    private StatusBean rollbackTransferOutMoney(Connection connection, String trsCode ,String inMemberId, String outMemberId, long coin) throws Exception {
        //memberTransferType 0.余额转账，1，货款
        String memberId = outMemberId;
        long trsInMoney = coin;

        //1、从会员收益信息表中取出可提现余额available_money和转出总余额trsout_sum_money
        String sql = "SELECT  index_number,  supply_coin FROM member_money_total WHERE member_id=? LIMIT 1 FOR UPDATE";
        List<Object> params = new ArrayList<Object>();
        params.add(memberId);
        com.sky.common.profitUtil.JdbcCommandInfo jd = new com.sky.common.profitUtil.JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "查询收益表总余额记录");

        ResultSet rs = JdbcModuleDaoSupport.queryResultSet(connection, jd);

        int indexNumber=0;
        long supplyCoin = 0L;//2017.12.6  换货币
        if (rs.next()) {
            indexNumber=rs.getInt("index_number");
            supplyCoin = rs.getLong("supply_coin");//
        }
        rs.close();

        //2.更新余额总表
        List<Object> paramList = new ArrayList<Object>();

            sql = "UPDATE member_money_total SET supply_coin = supply_coin + ?,"
                    + " index_number = index_number+1 where member_id = ? ";

        paramList.add(trsInMoney);
        paramList.add(memberId);
        jd = new com.sky.common.profitUtil.JdbcCommandInfo(sql, paramList, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "总收益余额表修改");
        int cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return error("更新总收益余额记录失败");
        }

        //3.插入转出流水
        String uuid = StringUtil.getUUID();
        StringBuilder sbSql = new StringBuilder();
        params = new ArrayList<Object>();

        sbSql.append("insert into ");
        sbSql.append(DbUtil.getCoinBalanceTableName(memberId));
        sbSql.append(" (balance_id,sort_index,balance_code,member_id,coin_type,type,flow_type,");
        sbSql.append("flow_coin, in_member_id, out_member_id," +
                " supply_coin,operation ,create_date,update_date,delete_flag)");
        sbSql.append(" values (?,?,?,?,?,   ?,?,?,?,?,   ?,?,now(),now(),0) ");

        params.add(uuid);
        params.add(indexNumber + 1);
        params.add(trsCode);
        params.add(memberId);
        params.add(1);//coin_type=1  is supply_coin
        params.add(CoinBalanceType.ProfitSendBack.getCode());//余额转入
        params.add(1);//流动方向（0流出，1流入）
        params.add(trsInMoney);
        params.add(inMemberId);
        params.add(memberId);
        params.add( supplyCoin + trsInMoney);
        params.add(memberId);
        jd = new com.sky.common.profitUtil.JdbcCommandInfo(sbSql.toString(), params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "插入转出流水");
        cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return error("插入转出流水记录失败");
        }
        return success("更新转账记录成功");
    }

    /**
     * 转入
     * @param
     * @param trsCode 交易流水号
     * @return
     */
    private StatusBean transferInMoney(Connection connection,String trsCode,String inMemberId, String outMemberId, long coin, TransferFailureLogBean logBean) throws Exception{
        String memberId = inMemberId;
        long trsInMoney = coin;

        //1、从会员收益信息表中取出可提现余额a和转出总余额  supply_coin
        String sql = "SELECT  index_number, supply_coin FROM member_money_total WHERE member_id=? LIMIT 1 FOR UPDATE";
        List<Object> params = new ArrayList<Object>();
        params.add(memberId);
        com.sky.common.profitUtil.JdbcCommandInfo jd = new com.sky.common.profitUtil.JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "查询收益表总余额记录");

        ResultSet rs = JdbcModuleDaoSupport.queryResultSet(connection, jd);

        long supplyCoin = 0L;//2017.12.6  换货币
        int indexNumber=0;
        if (rs.next()) {
            supplyCoin=rs.getLong("supply_coin");//
            indexNumber=rs.getInt("index_number");
        }
        rs.close();


        //2.更新余额总表
        sql = "UPDATE member_money_total SET supply_coin = supply_coin + ?,"
                + " index_number=index_number+1  where member_id = ? ";
        params = new ArrayList<Object>();
        params.add(trsInMoney);
        params.add(memberId);
        jd = new com.sky.common.profitUtil.JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "修改收益表余额记录");
        int cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return error("更新总收益余额记录失败");
        }

        //3.插入转出流水
        String uuid = StringUtil.getUUID();
        StringBuilder sbSql = new StringBuilder();
        params = new ArrayList<Object>();

        sbSql.append("insert into ");
        sbSql.append(DbUtil.getCoinBalanceTableName(memberId));
        sbSql.append(" (balance_id,sort_index,balance_code,member_id,coin_type,type,flow_type,");
        sbSql.append("flow_coin, in_member_id, out_member_id," +
                " supply_coin,operation ,create_date,update_date,delete_flag)");
        sbSql.append(" values (?,?,?,?,?,   ?,?,?,?,?,   ?,?,now(),now(),0) ");

        params.add(uuid);
        params.add(indexNumber + 1);
        params.add(trsCode);
        params.add(memberId);
        params.add(1);//coin_type=1  is supply_coin
        params.add(CoinBalanceType.TransOut.getCode());//余额转出
        params.add(1);//流入
        params.add(trsInMoney);
        params.add(memberId);
        params.add(outMemberId);
        params.add( supplyCoin + trsInMoney);
        params.add(memberId);
        jd = new com.sky.common.profitUtil.JdbcCommandInfo(sbSql.toString(), params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "插入转出流水");
        cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return error("插入转出流水记录失败");
        }
        return success("更新转账记录成功");
    }


    public Long getSupplyCoin (String memberId) {

        String sql = "SELECT  *  FROM member_money_total WHERE member_id='"+memberId+"' LIMIT 1 FOR UPDATE";
        MemberMoneyTotalBean memberMoneyTotalBean = new MemberMoneyTotalBean();
        memberMoneyTotalBean.setMemberId(memberId);
        memberMoneyTotalBean = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.PROFIT_DATA, sql, memberMoneyTotalBean, memberId);
        if (null != memberMoneyTotalBean) {
            return memberMoneyTotalBean.getSupplyCoin();
        }

        return null;
    }

}


