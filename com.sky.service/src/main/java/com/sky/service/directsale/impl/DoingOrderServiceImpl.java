package com.sky.service.directsale.impl;

import com.sky.common.Constants;
import com.sky.common.bean.StatusBean;
import com.sky.common.enums.OrderStatusEnums;
import com.sky.common.massage.ResponseUtil;
import com.sky.common.massage.Status;
import com.sky.common.piting.Pager;
import com.sky.common.profitUtil.ConnectionCallBack;
import com.sky.common.profitUtil.JdbcCommandInfo;
import com.sky.common.profitUtil.JdbcModuleDaoSupport;
import com.sky.common.service.impl.BaseServiceImpl;
import com.sky.common.util.*;
import com.sky.dao.enums.*;
import com.sky.dao.log.TradeLogBean;
import com.sky.dao.log.TransferFailureLogBean;
import com.sky.dao.model.*;
import com.sky.dao.shopapi.WarehouseOrder;
import com.sky.dao.staysend.OrderExpress;
import com.sky.dao.vo.*;
import com.sky.kafka.IKafkaProducer;
import com.sky.service.directsale.*;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * DoingOrderServiceImpl
 *
 * @author dao
 **/
@Service("doingOrderService")
public class DoingOrderServiceImpl extends BaseServiceImpl implements DoingOrderService {

    @Resource
    private ProductService productService;

    @Resource
    private ProductStockService productStockService;

    @Resource
    private IPurchaseService purchaseService;

    @Resource
    private MemberService membeService;

    @Resource
    private DoingOrderService doingOrderService;


    /**
     * 收益服务接口
     */
    @Resource
    MemberProfitService memberProfitService;

    @Resource
    MemberService memberService;






    @Override
    public int count(String warehouseMemberId, Integer orderStatus) throws Exception {
        StringBuffer sbSql = new StringBuffer();
        Map<String, Object> map = new HashMap<String, Object>();
        sbSql.append(" SELECT COUNT(*) from warehouse_order WHERE warehouse_member_id=:warehouseMemberId ");
        sbSql.append(" and order_status=:orderStatus ");
        sbSql.append(" and delete_flag=0 ");

        map.put("orderStatus", orderStatus);
        map.put("warehouseMemberId", warehouseMemberId);
        return JdbcTemplateDaoSupport.count(sbSql.toString(),map);
    }

    @Override
    public Pager<WarehouseOrder> list(String warehouseMemberId, Integer orderStatus, Pager<WarehouseOrder> pageData) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        StringBuffer sbSql = new StringBuffer();
        sbSql.append(" SELECT * from warehouse_order ");
        sbSql.append(" WHERE warehouse_member_id=:warehouseMemberId ");
        if (null != orderStatus ) {
            sbSql.append(" and order_status=:orderStatus ");
            map.put("orderStatus", orderStatus);
        }
        sbSql.append(" AND delete_flag=0 ORDER BY create_date DESC");
        sbSql.append(" limit :offset, :pageSize ");
        map.put("warehouseMemberId", warehouseMemberId);
        map.put("offset", (pageData.getPageOffset() - 1) * pageData.getPageSize());
        map.put("pageSize", pageData.getPageSize());
        List<WarehouseOrder> datas = JdbcTemplateDaoSupport.getBeanList(sbSql.toString(),map,WarehouseOrder.class);
        System.out.println("WarehouseOrder>>>>>>>datas>>"+datas);
        if (!StringUtil.isNull(datas) && datas.size() > 0) {

            pageData.setDatas(datas);

            int totalRows = this.count(warehouseMemberId, orderStatus);
            System.out.println("WarehouseOrder>>>>>>>totalRows>>"+totalRows);
            totalRows=totalRows>=15 ? totalRows : datas.size(); //
            pageData.setTotalRecord(totalRows);
            pageData.setTotalPage(totalRows);
        } else {
            pageData.setDatas(datas);
        }
        return pageData;
    }



    public Pager<ReissueOrder> supplyOrderList(String memberId,  Pager<ReissueOrder> pageData) throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();
        StringBuffer sbSql = new StringBuffer();
        sbSql.append(" SELECT * from reissue_order ");
        sbSql.append(" WHERE member_id=:memberId ");

        sbSql.append(" AND delete_flag=0 ORDER BY create_date DESC");
        sbSql.append(" limit :offset, :pageSize ");
        map.put("memberId", memberId);
        map.put("offset", (pageData.getPageOffset() - 1) * pageData.getPageSize());
        map.put("pageSize", pageData.getPageSize());
        List<ReissueOrder> datas = JdbcTemplateDaoSupport.getBeanList(sbSql.toString(),map,ReissueOrder.class);
        System.out.println("ReissueOrder>>>>>>>datas>>"+datas);
        if (!StringUtil.isNull(datas) && datas.size() > 0) {
            for (ReissueOrder reissueOrder :datas) {
                switch (reissueOrder.getOrderStatus()) {

                    case 0://OrderStatusEnums.HasClose.getCode()
                        reissueOrder.setOrderStatusStr(OrderStatusEnums.HasClose.getMsg());
                        break;
                    case 1://OrderStatusEnums.WaitPay.getCode()
                        reissueOrder.setOrderStatusStr("已申请");
                        break;
                    case 2://OrderStatusEnums.WaitShip.getCode()
                        reissueOrder.setOrderStatusStr(OrderStatusEnums.WaitShip.getMsg());
                        break;
                    case 3://OrderStatusEnums.HasShip.getCode()
                        reissueOrder.setOrderStatusStr(OrderStatusEnums.HasShip.getMsg());
                        break;
                    case 4://OrderStatusEnums.HasReceived.getCode()
                        reissueOrder.setOrderStatusStr(OrderStatusEnums.HasReceived.getMsg());
                        break;
                    case 5://OrderStatusEnums.ReturnMoneying.getCode()
                        reissueOrder.setOrderStatusStr(OrderStatusEnums.ReturnMoneying.getMsg());
                        break;
                    case 6://OrderStatusEnums.ReturnGooding.getCode()
                        reissueOrder.setOrderStatusStr(OrderStatusEnums.ReturnGooding.getMsg());
                        break;
                    case 7://OrderStatusEnums.ReturnMoneyClose.getCode()
                        reissueOrder.setOrderStatusStr(OrderStatusEnums.ReturnMoneyClose.getMsg());
                        break;
                    case 8://OrderStatusEnums.ReturnGoodClose.getCode()
                        reissueOrder.setOrderStatusStr(OrderStatusEnums.ReturnGoodClose.getMsg());
                        break;
                    case 9://OrderStatusEnums.ErrorOrder.getCode()
                        reissueOrder.setOrderStatusStr(OrderStatusEnums.ErrorOrder.getMsg());
                        break;
                }

            }

            pageData.setDatas(datas);

            int totalRows = this.reissueOrderCount(memberId);
            System.out.println("ReissueOrder>>>>>>>totalRows>>"+totalRows);
            totalRows=totalRows>=15 ? totalRows : datas.size(); //
            pageData.setTotalRecord(totalRows);
            pageData.setTotalPage(totalRows);
        } else {
            pageData.setDatas(datas);
        }
        return pageData;
    }

    public int  reissueOrderCount(String memberId ) {
        Map<String, Object> map = new HashMap<String, Object>();
        StringBuffer sbSql = new StringBuffer();
        sbSql.append(" SELECT count(*) from reissue_order ");
        sbSql.append(" WHERE member_id=:memberId ");
        sbSql.append(" AND delete_flag=0 ORDER BY create_date DESC");
        map.put("memberId", memberId);
        return JdbcTemplateDaoSupport.count(sbSql.toString(),map);
    }

    public StatusBean<?> delReissueOrder(String memberId , String orderCode) throws Exception{
        APIOrderBean bean = this.getOrderDetaiByOrderCode(orderCode);
        if (null == bean) {
            return error("订单不存在");
        }
        if (bean.getOrderStatus() != OrderStatusEnums.WaitPay.getCode()) {
            return error("亲，只有已申请的订单才可以撤单");
        }

        String sql = " UPDATE  reissue_order main " +
                " SET main.order_status = '"+OrderStatusEnums.HasClose.getCode()+"'," +
                " main.delete_flag = 1 " +
                " WHERE  main.order_code = '"+orderCode+"' ";
        boolean re = JdbcTemplateDaoSupport.updateOrAddOrDele(sql ,new HashMap<>() );
        if (re) {
            return success("撤销订单成功");
        } else {
            return error("撤销失败");
        }

    }

    public StatusBean<?> supplyOrderReceive(String memberId , String orderCode) throws Exception{

        APIOrderBean bean = this.getOrderDetaiByOrderCode(orderCode);
        if (null == bean) {
            return error("订单不存在");
        }
        if (bean.getOrderStatus() != OrderStatusEnums.HasShip.getCode()) {
            return error("亲，只有已发货的订单才可以确认收货");
        }

        String sql = " UPDATE  reissue_order main " +
                " SET main.order_status = '"+OrderStatusEnums.HasReceived.getCode()+"'" +
                " WHERE  main.order_code = '"+orderCode+"' ";
        boolean re = JdbcTemplateDaoSupport.updateOrAddOrDele(sql ,new HashMap<>() );
        if (re) {
            return success("确认订单收货成功");
        } else {
            return error("确认失败");
        }
    }



    /**
     * 根据订单code获取订单详情
     *
     * @param orderCode
     * @return
     */
    public APIOrderBean getOrderDetaiByOrderCode(String orderCode) throws Exception {
        //1、根据订单号获取所在数据库
        // String dbModule = DbUtil.getOrderInWhichDataBase(orderCode);

        //2、根据订单号获取所在表
        // String tableModule = DbUtil.getOrderInWhichTable(orderCode);

        //3、根据订单号获取会员ID
//        String memberIdModule = DbUtil.getMemberIdByOrderCode(orderCode);

        //4.根据订单号获取订单信息
        StringBuffer sbSql = new StringBuffer();

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("orderCode", orderCode);

        APIOrderBean bean = new APIOrderBean();
        bean.setOrderCode(orderCode);
        if(orderCode!=null &&orderCode.startsWith("BHH")){
            String sql0 = "SELECT * FROM  reissue_order  WHERE order_code=:orderCode AND delete_flag=0 LIMIT 1 ";
            bean = JdbcTemplateDaoSupport.getObjectDateInfo(sql0,params,  bean );
        }else {
            String memberIdModule = DbUtil.getMemberIdByOrderCode(orderCode);
            String doingOrderTableName = DbUtil.getDoingOrderTableName(memberIdModule);
            String sql = "SELECT * FROM " + doingOrderTableName + " WHERE order_code=:orderCode AND delete_flag=0 LIMIT 1";
            bean = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.ORDER_DATA, sql, params, bean, memberIdModule);
        }
        if (null == bean) {
            return null;
        }
        log.error("订单bean>>>>>"+bean);
        //订单状态
        bean.setOrderStatusStr(OrderStatus.valueOf(bean.getOrderStatus()).getMsg());

        //支付状态
        if (StringUtil.isNull(bean.getPayType())) {
            bean.setPayType(0);
        }
        bean.setPayTypeStr(PayType.valueOf(bean.getPayType()).getMsg());

        //退货退款状态
        if (StringUtil.isNull(bean.getRefundType())) {
            bean.setRefundType(0);
        }
        bean.setRefundTypeStr(RefundType.valueOf(bean.getRefundType()).getMsg());

        //订单的产品信息
        List<ProductBean> productBeans = new ArrayList<ProductBean>();
        List<Integer> productAmounts = new ArrayList<Integer>();
        List<DoingOrder1Bean> doingOrder1Beans = getDoingOrder1s(bean.getMemberId(), bean.getOrderId(),orderCode);
        for (DoingOrder1Bean doingOrder1Bean : doingOrder1Beans) {
            ProductBean productBean = productService.getByProductId(doingOrder1Bean.getProductId());
            productBean.setRetailPrice(doingOrder1Bean.getPrice());
            productBean.setMarketPrice(doingOrder1Bean.getPrice());
            productBean.setAmount(doingOrder1Bean.getPurchaseQuantity());
            productBeans.add(productBean);
            productAmounts.add(doingOrder1Bean.getPurchaseQuantity());
        }
        bean.setProducts(productBeans);
        bean.setProductAmounts(productAmounts);
        return bean;
    }


    private List<DoingOrder1Bean> getDoingOrder1s(String memberId, String orderId, String orderCode) throws Exception {


        DoingOrder1Bean bean = new DoingOrder1Bean();
        List<DoingOrder1Bean> list = new ArrayList<>();

        StringBuffer sbSql = new StringBuffer();
        if(orderCode!=null &&orderCode.startsWith("BHH")){
            sbSql.append(" SELECT * from reissue_order1 ");
            sbSql.append(" WHERE order_id='" + orderId + "' ORDER BY sort_index");
            list=JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA,sbSql.toString(),bean,memberId);
        }else{
            String doingOrder1TableName = DbUtil.getDoingOrder1TableName(memberId);
            sbSql.append("SELECT * from " + doingOrder1TableName + "");
            sbSql.append(" WHERE order_id='" + orderId + "' ORDER BY sort_index");
            list=JdbcModuleDaoSupport2.getList(DataBaseType.ORDER_DATA, sbSql.toString(), bean, memberId);
        }
        return list;
    }




    public StatusBean<?> addHuanhuo(ReissueOrder reissueOrder, List<ReissueOrder1> reissueOrders) throws Exception {

        List<com.sky.common.util.JdbcCommandInfo> commandInfos = new ArrayList<com.sky.common.util.JdbcCommandInfo>();
        com.sky.common.util.JdbcCommandInfo commandInfo = null;
        List<Object> paramList = null;

        //添加主表
        String sql = "insert into reissue_order " +
                "(  `order_id`,  `member_id`,  `order_code`,  `order_status`,  `contact`,  `phone`,  `address`,  `zipcode`,  `total_money`,  " +
                "`freight`, `is_pay`,  `order_from`,  `buyer_remark`, `create_date`, `delete_flag`, `member_type`,`pay_type`,`pay_money` ,order_type)" +
                "values" +
                "(  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?, ?, ?, ? ,?);";
        commandInfo = new com.sky.common.util.JdbcCommandInfo();
        paramList = new ArrayList<Object>();
        paramList.add(reissueOrder.getOrderId());
        paramList.add(reissueOrder.getMemberId());
        paramList.add(reissueOrder.getOrderCode());
        paramList.add(reissueOrder.getOrderStatus());
        paramList.add(reissueOrder.getContact());

        paramList.add(reissueOrder.getPhone());
        paramList.add(reissueOrder.getAddress());
        paramList.add(reissueOrder.getZipcode());
        paramList.add(reissueOrder.getTotalMoney());
        paramList.add(reissueOrder.getFreight());
        paramList.add("0");

        paramList.add(reissueOrder.getOrderFrom());
        paramList.add(reissueOrder.getBuyerRemark());
        paramList.add(reissueOrder.getCreateDate());
        paramList.add(reissueOrder.getDeleteFlag());
        paramList.add(reissueOrder.getMemberType());
        paramList.add(PayType.SupplyPay.getCode());//payType 补货币
        paramList.add(reissueOrder.getTotalMoney());
        paramList.add(reissueOrder.getOrderType());

        commandInfo.setSql(sql);
        commandInfo.setData(paramList);
        commandInfos.add(commandInfo);

        //添加子表
        sql = "insert into reissue_order1" +
                "(  `order1_id`,  `order_id`,  `sort_index`,  `product_id`,  `purchase_quantity`,  `shipped_quantity`,  `price`,  `line_total`)" +
                "values" +
                "(  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?);";
        for (ReissueOrder1 reissueOrder1 : reissueOrders) {
            commandInfo = new com.sky.common.util.JdbcCommandInfo();
            paramList = new ArrayList<Object>();
            paramList.add(reissueOrder1.getOrder1Id());
            paramList.add(reissueOrder1.getOrderId());
            paramList.add(reissueOrder1.getSortIndex());
            paramList.add(reissueOrder1.getProductId());
            paramList.add(reissueOrder1.getPurchaseQuantity());
            paramList.add(reissueOrder1.getShippedQuantity());
            paramList.add(reissueOrder1.getPrice());
            paramList.add(reissueOrder1.getLineTotal());

            commandInfo.setSql(sql);
            commandInfo.setData(paramList);
            commandInfos.add(commandInfo);
        }

        if (JdbcTemplateDaoSupport.saveBatch(commandInfos)) {
            //执行减库存操作
            for (ReissueOrder1 reissueOrder1 : reissueOrders) {
                productStockService.delProductStock(reissueOrder1.getProductId(), reissueOrder1.getPurchaseQuantity());
            }
            return success("操作成功");
        }
        return error("操作失败");
    }

    @Override
    public ReissueOrder getReissueOrderBean(String memberId, String orderId) {
        return null;
    }

    /**
     *  自提点换货单 支付
     * @param memberId
     * @param orderId
     * @param totalMoney
     * @return
     * @throws Exception
     */
    @Override
    public StatusBean paymentReissueOrder(String memberId, String orderId, int totalMoney) throws Exception {
        long payMoney = totalMoney;//订单金额
        final String memberPayId = StringUtil.getUUID();//支付流水ID，当更新订单状态失败时，回滚删除支付流水
        final String newPayCode = DbUtil.getNewPayCode(memberId);//新生成一个支付号
        //2.判断余额并更新余额（可用余额减去订单金额）
        StatusBean exSuccess = JdbcModuleDaoSupport.execute(DataBaseType.PROFIT_DATA ,memberId, new ConnectionCallBack() {
            @Override
            public StatusBean execute(Connection connection) throws Exception {
                //余额支付
                return DoingOrderServiceImpl.this.memberPayReissue(connection, orderId,  memberId, "sys", payMoney);//系统操作
            }
        });

        if (exSuccess.getStatus()) {
            //3.更新reissue订单状态为待发货
            exSuccess = JdbcTemplateDaoSupport.execute(new ConnectionCallBack() {
                @Override
                public StatusBean execute(Connection connection) throws Exception {
                    //更新订单状态
                    return DoingOrderServiceImpl.this.queryAndUpdateReissueOrder(connection, orderId, memberId);
                }
            });
            if (!exSuccess.getStatus()) {
                //更新订单状态失败，则回滚余额信息
                StatusBean rollBackStatusBean = JdbcTemplateDaoSupport.execute(new ConnectionCallBack() {
                    @Override
                    public StatusBean execute(Connection connection) throws Exception {
                        return DoingOrderServiceImpl.this.rollbackChangeCoin(connection,orderId, memberId, payMoney, memberPayId);
                    }
                });
            }
        }
        if (StringUtil.isNull(exSuccess) || (!exSuccess.getStatus() && !StringUtil.isNull(exSuccess.getData()))) {
            exSuccess = new StatusBean(false, "9999", "支付失败，请重试！", null);
        }
        return exSuccess;
    }




    /**
     * 回滚换货币金额
     *
     * @param connection
     * @param memberId    付款方memberId
     * @param payMoney    支付金额
     * @param memberPayId 支付流水Id
     * @return
     */
    private StatusBean rollbackChangeCoin(Connection connection,String orderId, String memberId, long payMoney, String memberPayId) throws Exception {

        long trsInMoney = payMoney;
        final String trsCode = DbUtil.getNewBalanceCode(memberId);//流水号

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

        List<Object> paramList = new ArrayList<Object>();
        //1.更新余额总表
        String sql2 = "UPDATE member_money_total SET supply_coin =supply_coin + ? where member_id = ? ";
        paramList.add(payMoney);
        paramList.add(memberId);
        JdbcCommandInfo jd2 = new JdbcCommandInfo(sql2, paramList, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "总收益余额表修改");
        int cnum = JdbcModuleDaoSupport.execTran(connection, jd2);
        if (cnum < 1) {
            return error("回滚余额记录失败");
        }

        //3.插入流水
        String uuid = StringUtil.getUUID();
        StringBuilder sbSql = new StringBuilder();
        params = new ArrayList<Object>();

        sbSql.append("insert into ");
        sbSql.append(DbUtil.getCoinBalanceTableName(memberId));
        sbSql.append(" (balance_id,sort_index,balance_code, order_id,member_id,coin_type,type,flow_type,");
        sbSql.append("flow_coin, in_member_id, out_member_id," +
                " supply_coin,operation ,create_date,update_date,delete_flag)");
        sbSql.append(" values (?,?,?,?,?,?,   ?,?,?,?,?,   ?,?,now(),now(),0) ");

        params.add(uuid);
        params.add(indexNumber + 1);
        params.add(trsCode);
        params.add(orderId);
        params.add(memberId);
        params.add(1);//coin_type=1  is supply_coin
        params.add(CoinBalanceType.PayErrorBack.getCode());//支付失败退回
        params.add(1);//流动方向（0流出，1流入）
        params.add(trsInMoney);
        params.add(memberId);
        params.add("sys");
        params.add( supplyCoin + trsInMoney);
        params.add("sys");
        jd = new com.sky.common.profitUtil.JdbcCommandInfo(sbSql.toString(), params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "插入转出流水");
        cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return error("插入转出流水记录失败");
        }
        return success("更新转账记录成功");
    }



    /**
     * 更新reissue
     *订单信息(更新状态为待发货、余额支付)
     *
     * @param connection
     * @param orderId    订单Id
     * @param memberId
     * @return
     * @throws Exception
     */
    private StatusBean<Object> queryAndUpdateReissueOrder(Connection connection, String orderId, String memberId) throws Exception {
        List<Object> params = new ArrayList<>(2);
        params.add(orderId);
        params.add(memberId);
        String sql = "SELECT order_status, total_money, pay_type FROM reissue_order WHERE order_id=? AND member_id=? AND delete_flag=0 FOR UPDATE";

        JdbcCommandInfo jd = new JdbcCommandInfo(sql, params, DataBaseType.BASE_DATA,
                DbUtil.getMod4Db(memberId), "更新订单状态");
        ResultSet rs = JdbcModuleDaoSupport.queryResultSet(connection, jd);
        int orderStatus = 0;//订单状态
        long totalMoney = 0;//订单总金额
        int payType = 0;
        boolean isExist = false;
        if (rs != null && rs.next()) {
            orderStatus = rs.getInt("order_status");
            totalMoney = rs.getLong("total_money");
            payType = rs.getInt("pay_type");
            isExist = true;
        }
        JdbcUtils.closeResultSet(rs);

        if (!isExist) {
            return error("订单不存在");
        }

        if (OrderStatus.WaitPay.getCode() != orderStatus) {
            return error("订单状态必须为“" + OrderStatus.WaitPay.getMsg() + "”");
        }
        //更新订单状态
        return updateReissueOrderStauts(connection, orderId, memberId, OrderStatus.WaitShip.getCode(), 1, PayType.SupplyPay.getCode(), totalMoney);
    }



    /**
     * 更新reissue订单状态
     *
     * @param connection
     * @param orderId     订单Id
     * @param memberId    会员Id
     * @param orderStatus 订单状态
     * @param isPay       是否支付 0：未支付、1：已支付
     * @param payType     支付类型
     * @param payMoney    支付金额
     * @return
     * @throws Exception
     */
    private StatusBean<Object> updateReissueOrderStauts(Connection connection, String orderId, String memberId, int orderStatus, int isPay, int payType, long payMoney) throws Exception {
        log.error("--------更新reissue订单状态开始-----------");
        List<Object> params = new ArrayList<>(3);
        params.add(orderId);
        params.add(memberId);
        String sql = "UPDATE reissue_order SET " +
                "order_status=" + orderStatus + "," +
                "is_pay=" + isPay + ", " +
                "pay_type=" + payType + ", " +
                "pay_money=" + payMoney + ", " +
                "pay_date=now() " +
                "WHERE order_id=? AND member_id=?";
        JdbcCommandInfo jd = new JdbcCommandInfo(sql, params, DataBaseType.BASE_DATA,
                DbUtil.getMod4Db(memberId), "更新reissueOrder订单状态");

        int cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return error("更新reissueOrder订单状态失败");
        }
        //插入物流表invoice 数据
//
        StringBuilder sb = new StringBuilder();
        sb.append("insert into invoice (invoice_id,order_id,member_id,order_type,purchaser_id,create_date) " +
                "values('"+StringUtil.getUUID()+"','"+orderId+"','"+memberId+"',1,'"+memberId+"',NOW()) ");
        params = new ArrayList<>();
        log.fatal("插入sql:"+sb.toString());
        boolean flag  = JdbcModuleDaoSupport2.updateOrAddOrDele(DataBaseType.ORDER_DATA,sb.toString(),params,memberId);
        log.fatal("更新invoice结束,status:"+flag);
        if(!flag){
            log.fatal("更新invoice表失败："+sql+";");
        }

        return success("更新reissueOrder订单状态成功");
    }


    /**
     * supplyCoin 支付
     * @param connection
     * @param memberId
     * @param operation
     * @param payMoney
     * @return
     * @throws Exception
     */
        private StatusBean<?> memberPayReissue(Connection connection,String orderId, String memberId, String operation, long payMoney) throws Exception {
            //三：更新收益信息
            //1、从会员收益信息表中取出可提现余额available_money和支付总余额pay_sum_money
            final String trsCode = DbUtil.getNewBalanceCode(memberId);//流水号
            log.error("换货单开始------01");
            String sql = "SELECT index_number, supply_coin  FROM member_money_total WHERE member_id=? LIMIT 1 FOR UPDATE";
            List<Object> params = new ArrayList<Object>();
            params.add(memberId);
            JdbcCommandInfo jd = new JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                    DbUtil.getMod4Db(memberId), "查询收益表总余额记录");

            ResultSet rs = JdbcModuleDaoSupport.queryResultSet(connection, jd);

            long supplyCoin = 0L;//换货币
            int indexNumber = 0;

            if (rs.next()) {
                supplyCoin = rs.getLong("supply_coin");
                indexNumber=rs.getInt("index_number");
            }
            rs.close();

            if (supplyCoin < 1) {
                return error("您的换货币为0");
            }
            if (payMoney > supplyCoin) {
                return error("您的换货币不足");
            }


            //2.更新余额总表（减去订单金额）log.error("换货单开始------02");
            sql = "UPDATE member_money_total SET supply_coin = supply_coin - ? , index_number = index_number + 1 where member_id = ? ";
            params = new ArrayList<Object>();
            params.add(payMoney);
            params.add(memberId);
            jd = new JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                    DbUtil.getMod4Db(memberId), "修改reissue表换货币记录");
            int cnum = JdbcModuleDaoSupport.execTran(connection, jd);
            if (cnum < 1) {
                return error("修改reissue表换货币记录失败");
            }

            log.error("换货单开始------03");
            //3.插入支付流水
                       String uuid = StringUtil.getUUID();
            StringBuilder sbSql = new StringBuilder();
            params = new ArrayList<Object>();

            sbSql.append("insert into ");
            sbSql.append(DbUtil.getCoinBalanceTableName(memberId));
            sbSql.append(" (balance_id,sort_index,balance_code,member_id, order_id,coin_type,type,flow_type,");
            sbSql.append("flow_coin, out_member_id," +
                    " supply_coin,operation ,create_date,update_date,delete_flag)");
            sbSql.append(" values (?,?,?,?,?,?,   ?,?,?,?,   ?,?,now(),now(),0) ");

            params.add(uuid);
            params.add(indexNumber + 1);
            params.add(trsCode);
            params.add(memberId);
            params.add(orderId);
            params.add(1);//coin_type=1  is supply_coin
            params.add(CoinBalanceType.Pay.getCode());//支付
            params.add(0);//流出
            params.add(payMoney);
            params.add(memberId);
            params.add( supplyCoin - payMoney);
            params.add(operation);
            jd = new com.sky.common.profitUtil.JdbcCommandInfo(sbSql.toString(), params, DataBaseType.PROFIT_DATA,
                    DbUtil.getMod4Db(memberId), "插入转出流水");
            cnum = JdbcModuleDaoSupport.execTran(connection, jd);
            if (cnum < 1) {
                return error("插入转出流水记录失败");
            }
            return success("更新转账记录成功");
        }

        @Override
        public ReissueOrder getReissueById(String orderId, String memberId) throws Exception {

            HashMap<String, Object> params = new HashMap<String, Object>();
            params.put("orderId", orderId);
            params.put("memberId", memberId);

            ReissueOrder bean = new ReissueOrder();
            String sql = "SELECT * FROM reissue_order WHERE order_id=:orderId AND member_id=:memberId AND delete_flag=0 LIMIT 1";
            bean = JdbcTemplateDaoSupport.getObjectDateInfo( sql, params, bean);
            return bean;
        }

        public List<ReissueOrder> getSupplyOrderList (String memberId, Integer orderStatus) {
            Map<String, Object> map = new HashMap<String, Object>();
            StringBuffer sbSql = new StringBuffer();
            sbSql.append(" SELECT * from reissue_order ");
            sbSql.append(" WHERE member_id='"+memberId+"'");
            sbSql.append(" AND order_status='"+orderStatus+"' ");
            sbSql.append(" AND delete_flag=0 ORDER BY create_date DESC");

            List<ReissueOrder> datas = JdbcTemplateDaoSupport.getBeanList(sbSql.toString(),map,ReissueOrder.class);
            return datas;
        }


    public StatusBean<?> updateMoneyAndOrder(String warehouseMemberId , String orderMemberId, String orderCode) throws Exception {
        //查询订单状态
        //1.根据订单号获取订单信息
        log.error("orderCode :" + orderCode);
        //根据订单号获取会员ID

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("orderCode", orderCode);
        params.put("warehouseMemberId", warehouseMemberId);

        APIOrderBean2 bean = new APIOrderBean2();

        String sql = "SELECT * FROM warehouse_order  WHERE order_code=:orderCode AND warehouse_member_id=:warehouseMemberId  AND delete_flag=0 LIMIT 1";
        bean = JdbcTemplateDaoSupport.getObjectDateInfo( sql , params ,bean);

        System.out.println("WarehouseOrder>>>>>>>datas>>"+bean);

        if (StringUtil.isNull(bean)) {
            log.debug("该订单不存在");
            return error("该订单不存在");
        }

        if (bean.getOrderStatus() != OrderStatusEnums.WaitShip.getCode()) {//2为 待发货状态
            if (bean.getOrderStatus() == OrderStatusEnums.WaitPay.getCode()) {
                return error("该订单未付款");
            } else if (bean.getOrderStatus() == OrderStatusEnums.HasShip.getCode()) {
                return error("该订单已发货");
            } else {
                return error("该订单未付款或者已发货");
            }
        }


        //更新表的状态   update  Doingorder AND  foodwarehouser order
        boolean ordermain = false;
        if (orderCode.startsWith("BHH")) {//换货单支付的
            ordermain = this.updateOrderReissue(orderCode);
        } else {//非换货单支付的
            ordermain = this.updateOrderMain(orderCode, orderMemberId);
        }

        boolean orderhouse = this.updateOrderhouse(orderCode);

        if (ordermain && orderhouse) {
            //插入 db_mesage 表数据,便于店补结算
            if (this.insertDbMessage(warehouseMemberId, bean.getOrderId())) {
                StatusBean st = new StatusBean();
                st.setStatus(true);
                st.setCode("0");
                st.setMessage("提货成功，订单为已发货");
                st.setData(orderCode);
                return st;
            } else {
                return error("更新订单失败");
            }
        }
        return error("更新订单失败");
    }


    //店补的秒接计算
    public boolean insertDbMessage(String memberId, String orderId) {
        String msgId = StringUtil.getUUID();
        String sql = " INSERT INTO db_message (msg_id ,member_id, info_id, type, create_date, update_date, delete_flag ) " +
                " VALUES ('"+msgId+"','"+memberId+"','"+orderId+"' ,'2', NOW(),NOW() ,'0' )";
        boolean re = JdbcTemplateDaoSupport.updateOrAddOrDele(sql, new HashMap<>());
        return re;
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
                return DoingOrderServiceImpl.this.transferOutMoney( connection, trsCode, inMemberId,  outMemberId,  coin, logBean );
            }
        });
        if(exSuccess.getStatus()){ //转出成功
            //2.收款方--------1.1更新可用余额(加) 1.2插入流水记录 1.3插入转账业务记录
            exSuccess = JdbcModuleDaoSupport.execute(DataBaseType.PROFIT_DATA, inMemberId, new ConnectionCallBack() {
                @Override
                public StatusBean execute(Connection connection) throws Exception {
                    //转入
                    return DoingOrderServiceImpl.this.transferInMoney(connection, trsCode, inMemberId,  outMemberId,  coin, logBean);
                }
            });
            if(!exSuccess.getStatus()){
                //3.收款方失败，则回滚付款方操作，更新余额以及转账业务表里的状态为失败
                StatusBean rollBackStatusBean = JdbcModuleDaoSupport.execute(DataBaseType.PROFIT_DATA, outMemberId, new ConnectionCallBack() {
                    @Override
                    public StatusBean execute(Connection connection) throws Exception{
                        return DoingOrderServiceImpl.this.rollbackTransferOutMoney(connection, trsCode, inMemberId,  outMemberId,  coin);
                    }
                });
            }
        }

        if(StringUtil.isNull(exSuccess) || (!exSuccess.getStatus() && !StringUtil.isNull(exSuccess.getData()))){
            exSuccess = new StatusBean(false,"9999","转账失败",null);
        }
        return exSuccess;


    }




    /**
     * 转出 foodCoin
     * @param
     * @param
     */
    private StatusBean transferOutMoney(Connection connection,String trsCode,String inMemberId, String outMemberId, long coin, TransferFailureLogBean logBean) throws Exception {

        String memberId = outMemberId;
        long trsOutMoney = coin;

        //1、从会员收益信息表中取出可提现余额available_money和转出总余额trsout_sum_money  use_money
        String sql = "SELECT  index_number, food_coin FROM member_money_total WHERE member_id=? LIMIT 1 FOR UPDATE";
        List<Object> params = new ArrayList<Object>();
        params.add(memberId);
        com.sky.common.profitUtil.JdbcCommandInfo jd = new com.sky.common.profitUtil.JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "查询收益表总余额记录");

        ResultSet rs = JdbcModuleDaoSupport.queryResultSet(connection, jd);

        long foodCoin = 0L;//2017.12.6  换货币
        int indexNumber=0;
        if (rs.next()) {
            foodCoin=rs.getLong("food_coin");//
            indexNumber=rs.getInt("index_number");
        }
        rs.close();

        //判断
        if (trsOutMoney > foodCoin) {
            if (foodCoin>0){
                return error("您的食品券余额不足,仅可支付"+foodCoin/100+"元");
            }else {
                return error("您的食品券余额不足,仅可支付 0 元");
            }
        }
        //2.更新余额总表
        sql = "UPDATE member_money_total SET food_coin = food_coin - ?,"
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
        sbSql.append("food_coin, in_member_id, out_member_id," +
                " supply_coin,operation ,create_date,update_date,delete_flag)");
        sbSql.append(" values (?,?,?,?,?,   ?,?,?,?,?,   ?,?,now(),now(),0) ");

        params.add(uuid);
        params.add(indexNumber + 1);
        params.add(trsCode);
        params.add(memberId);
        params.add(1);//coin_type=1  is supply_coin
        params.add(CoinBalanceType.TransOut.getCode());//余额转出
        params.add(0);//流出
        params.add(trsOutMoney);
        params.add(inMemberId);
        params.add(memberId);
        params.add( foodCoin - trsOutMoney);
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
     * 转入 supplyCoin
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

    /**
     * 回滚转出金额  foodCoin
     * @param
     * @param
     * @param
     * @return
     */                                         //connection, trsCode, inMemberId,  outMemberId,  coin, logBean
    private StatusBean rollbackTransferOutMoney(Connection connection, String trsCode ,String inMemberId, String outMemberId, long coin) throws Exception {
        //memberTransferType 0.余额转账，1，货款
        String memberId = inMemberId;
        long trsInMoney = coin;

        //1、从会员收益信息表中取出food_coin
        String sql = "SELECT  index_number,  food_coin FROM member_money_total WHERE member_id=? LIMIT 1 FOR UPDATE";
        List<Object> params = new ArrayList<Object>();
        params.add(memberId);
        com.sky.common.profitUtil.JdbcCommandInfo jd = new com.sky.common.profitUtil.JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "查询收益表总余额记录");

        ResultSet rs = JdbcModuleDaoSupport.queryResultSet(connection, jd);

        long trsTotalOutMoney = 0L;//转出总余额
        int indexNumber=0;

        long foodCoin = 0L;//2017.12.6  换货币
        if (rs.next()) {
            indexNumber=rs.getInt("index_number");
            foodCoin = rs.getLong("food_coin");//
        }
        rs.close();

        //2.更新余额总表
        List<Object> paramList = new ArrayList<Object>();

        sql = "UPDATE member_money_total SET food_coin = food_coin + ?,"
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
                " food_coin,operation ,create_date,update_date,delete_flag)");
        sbSql.append(" values (?,?,?,?,?,   ?,?,?,?,?,   ?,?,now(),now(),0) ");

        params.add(uuid);
        params.add(indexNumber + 1);
        params.add(trsCode);
        params.add(memberId);
        params.add(0);//0  foodCoin    coin_type=1  is supply_coin
        params.add(CoinBalanceType.TransIn.getCode());//余额转出
        params.add(1);//流动方向（0流出，1流入）
        params.add(trsInMoney);
        params.add(inMemberId);
        params.add(memberId);
        params.add( foodCoin + trsInMoney);
        params.add(memberId);
        jd = new com.sky.common.profitUtil.JdbcCommandInfo(sbSql.toString(), params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "插入转出流水");
        cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return error("插入转出流水记录失败");
        }
        return success("更新转账记录成功");
    }


    //更新本地 订单的支付状态 orderStatus
    public  boolean updateOrderMain(String orderCode ,String memberId) {
        //根据订单号获取
        log.error("获取到的订单号为：" + orderCode);
//        String memberIdModule = DbUtil.getMemberIdByOrderCode(orderCode);
        //根据订单号获取订单信息
        HashMap<String, Object> params2 = new HashMap<String, Object>();

        String doingOrderTableName = DbUtil.getDoingOrderTableName(memberId);

        StringBuilder ordersql = new StringBuilder();
        ordersql.append(" UPDATE " + doingOrderTableName + " SET ");
        ordersql.append(" order_status=" + OrderStatus.HasReceived.getCode() + ",");
        ordersql.append(" update_date = now() ");
        ordersql.append(" WHERE order_code='" + orderCode + "' and member_id = '"+memberId+"' ");
        System.out.println("ordersql.toString() " + ordersql.toString());
        try {
            if (JdbcModuleDaoSupport2.updateOrAddOrDele(DataBaseType.ORDER_DATA, ordersql.toString(), params2, memberId)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("保存异常>>>>>>>");
            e.printStackTrace();
            return false;
        }

    }


    //换货币支付的    更新 订单的支付状态 orderStatus  reissue_order
    public  boolean updateOrderReissue(String orderCode ) {
        //根据订单号获取
        String sql = "UPDATE sky.reissue_order  SET order_status = " + OrderStatus.HasReceived.getCode() + " where order_code = '"+orderCode+"' ";
        try {
            if (JdbcTemplateDaoSupport.updateOrAddOrDele(sql.toString(),null)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("保存异常>>>>>>>");
            e.printStackTrace();
            return false;
        }

    }

    //更新本地 订单的支付状态 orderStatus  warehouse_order
    public  boolean updateOrderhouse(String orderCode ) {
        //根据订单号获取
        String sql = "UPDATE sky.warehouse_order  SET order_status = " + OrderStatus.HasReceived.getCode() + " where order_code = '"+orderCode+"' ";
        try {
            if (JdbcTemplateDaoSupport.updateOrAddOrDele(sql.toString(),null)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            log.error("保存异常>>>>>>>");
            e.printStackTrace();
            return false;
        }

    }


    public MemberMoneyTotalBean getSupplyCoin(String memberId) {

        String sql = "select * from member_money_total where member_id = :memberId  limit 1 ";
        MemberMoneyTotalBean memberMoneyTotalBean = new MemberMoneyTotalBean();
        memberMoneyTotalBean.setMemberId(memberId);
        memberMoneyTotalBean = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.PROFIT_DATA, sql, memberMoneyTotalBean, memberId);
        return  memberMoneyTotalBean;
    }

    public StatusBean getProductStock(String orderId, String memberId) throws Exception {
        DoingOrder1Bean bean = new DoingOrder1Bean();
        List<DoingOrder1Bean> list = new ArrayList<>();

        StringBuilder sbSql = new StringBuilder();
        sbSql.append(" SELECT * from reissue_order1 ");
        sbSql.append(" WHERE order_id='" + orderId + "' ORDER BY sort_index");
        list=JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA,sbSql.toString(),bean,memberId);
        Map<String,Integer> map = new HashMap<String,Integer>();
        for( DoingOrder1Bean  reissueBean : list ) {
            //判断库存
            ProductDetail productBean = productService.get(reissueBean.getProductId());
            log.error("产品库存 stockNum" + productBean.getStock());
            if (reissueBean.getPurchaseQuantity() > productBean.getStock()) {
                return error(" "+productBean.getShortName()+" 库存不足, 库存仅剩下： "+productBean.getStock()+" ");
            }
        }

        return success("库存充足");
    }

}
