package com.sky.service.directsale;

import com.sky.common.bean.StatusBean;
import com.sky.common.piting.Pager;
import com.sky.dao.model.APIOrderBean;
import com.sky.dao.model.MemberMoneyTotalBean;
import com.sky.dao.shopapi.WarehouseOrder;
import com.sky.dao.vo.*;

import java.sql.Connection;
import java.util.List;

/**
 * DoingOrderService
 *
 * @author dao
 **/
public interface DoingOrderService {


    /**
     * 根据订单ID获取订单信息
     *
     * @param orderId  订单ID
     * @param memberId 用户ID
     * @return DoingOrderBean 数据bean对象
     * @throws Exception
     **/
//    public APIOrderBean getById(String orderId, String memberId) throws Exception;




    /**
     * 查询用户的订单列表数量
     *
     * @param memberId
     * @return
     * @throws Exception
     */
    public int count(String memberId, Integer orderStatus) throws Exception;

    /**
     * 查询用户的订单列表
     *
     * @param memberId 查询条件
     * @param page
     * @return List<DoingOrderBean> 查询后返回的结果
     * @throws Exception
     **/
    public Pager<WarehouseOrder> list(String memberId, Integer orderStatus, Pager<WarehouseOrder> page) throws Exception;

    /**
     * 查询自提点的订单列表
     *
     * @param memberId 查询条件
     * @param page
     * @return List<DoingOrderBean> 查询后返回的结果
     * @throws Exception
     **/
    public Pager<ReissueOrder> supplyOrderList(String memberId,  Pager<ReissueOrder> page) throws Exception;


    /**
     * 根据订单code获取订单详情
     *
     * @param orderCode
     * @return
     */
    public APIOrderBean getOrderDetaiByOrderCode(String orderCode)throws Exception;



    public StatusBean<?> delReissueOrder(String memberId , String orderCode) throws Exception;

    public StatusBean<?> supplyOrderReceive(String memberId , String orderCode) throws Exception;

    /**
     * 添加换货币订单
     *
     * @param reissueOrder   reissue订单主表
     * @param reissueOrders reissue订单子表
     * @return StatusBean 操作状态
     * @throws Exception
     **/
    public StatusBean<?> addHuanhuo(ReissueOrder reissueOrder, List<ReissueOrder1> reissueOrders) throws Exception;


    /*
     * 获取换货订单
     * */
    public ReissueOrder getReissueOrderBean(String memberId,String orderId);

    /**
     * 换货币支付（短信验证码+支付密码+订单Id）
     * @param
     * @return
     * @throws Exception
     */
    public StatusBean paymentReissueOrder(String memberId ,String orderId , int totalMoney) throws Exception;


    public ReissueOrder getReissueById(String orderId, String memberId) throws Exception;

    public List<ReissueOrder> getSupplyOrderList (String memberId, Integer orderStatus);


    /**
     * 更新交易金额和  订单状态
     *
     * @param
     * @param
     * @return StatusBean 操作状态
     * @throws Exception
     **/
    public StatusBean<?> updateMoneyAndOrder(String memberId, String orderMemberId, String orderCode) throws Exception;

    public MemberMoneyTotalBean getSupplyCoin(String memberId);

    /**
     *
     * @param orderId
     * @param memberId
     * @return
     */
    public StatusBean getProductStock(String orderId, String memberId) throws Exception;

}
