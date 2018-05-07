package com.sky.dao.vo;

import java.io.Serializable;
import java.math.BigInteger;

public class OrderStatsVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类型：报单990，报单9900，报单99000，月复消，年复消，其他销售，合计
     */
    private String orderType;

    /**
     * 新增订单数（格式化）
     */
    private String addOrderCountStr;

    /**
     * 新增订单数
     */
    private BigInteger addOrderCount = BigInteger.ZERO;

    /**
     * 新增订单金额（格式化）
     */
    private String addOrderMoneyStr;

    /**
     * 新增订单金额
     */
    private BigInteger addOrderMoney = BigInteger.ZERO;

    /**
     * 升级订单数（格式化）
     */
    private String promoteOrderCountStr;

    /**
     * 升级订单数
     */
    private BigInteger promoteOrderCount = BigInteger.ZERO;

    /**
     * 升级订单金额（格式化）
     */
    private String promoteOrderMoneyStr;

    /**
     * 升级订单金额
     */
    private BigInteger promoteOrderMoney = BigInteger.ZERO;



    /**
     * 新增和升级订单金额运费（格式化）
     */
    private String addOrderFreightStr;

    /**
     * 新增和升级订单金额运费
     */
    private BigInteger addOrderFreight = BigInteger.ZERO;

    /**
     * 减少订单数（格式化）
     */
    private String reduceOrderCountStr;

    /**
     * 减少订单数
     */
    private BigInteger reduceOrderCount = BigInteger.ZERO;

    /**
     * 减少订单金额（格式化）
     */
    private String reduceOrderMoneyStr;

    /**
     * 减少订单金额
     */
    private BigInteger reduceOrderMoney = BigInteger.ZERO;

    /**
     * 退款订单金额（格式化）
     */
    private String refundOrderMoneyStr;

    /**
     * 退款订单金额
     */
    private BigInteger refundOrderMoney = BigInteger.ZERO;

    /**
     * 新增订单金额、减少订单金额冲抵合计（格式化）
     */
    private String totalOffsetMoneyStr;

    /**
     * 新增订单金额、减少订单金额冲抵合计
     */
    private BigInteger totalOffsetMoney = BigInteger.ZERO;

    /**
     * 新增订单金额、减少订单退款金额冲抵合计（格式化）
     */
    private String totalOffsetRefundMoneyStr;

    /**
     * 新增订单金额、减少订单退款金额冲抵合计
     */
    private BigInteger totalOffsetRefundMoney = BigInteger.ZERO;

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getAddOrderCountStr() {
        return addOrderCountStr;
    }

    public void setAddOrderCountStr(String addOrderCountStr) {
        this.addOrderCountStr = addOrderCountStr;
    }

    public BigInteger getAddOrderCount() {
        return addOrderCount;
    }

    public void setAddOrderCount(BigInteger addOrderCount) {
        this.addOrderCount = addOrderCount;
    }

    public String getAddOrderMoneyStr() {
        return addOrderMoneyStr;
    }

    public void setAddOrderMoneyStr(String addOrderMoneyStr) {
        this.addOrderMoneyStr = addOrderMoneyStr;
    }

    public BigInteger getAddOrderMoney() {
        return addOrderMoney;
    }

    public void setAddOrderMoney(BigInteger addOrderMoney) {
        this.addOrderMoney = addOrderMoney;
    }

    public String getAddOrderFreightStr() {
        return addOrderFreightStr;
    }

    public void setAddOrderFreightStr(String addOrderFreightStr) {
        this.addOrderFreightStr = addOrderFreightStr;
    }

    public BigInteger getAddOrderFreight() {
        return addOrderFreight;
    }

    public void setAddOrderFreight(BigInteger addOrderFreight) {
        this.addOrderFreight = addOrderFreight;
    }

    public String getReduceOrderCountStr() {
        return reduceOrderCountStr;
    }

    public void setReduceOrderCountStr(String reduceOrderCountStr) {
        this.reduceOrderCountStr = reduceOrderCountStr;
    }

    public BigInteger getReduceOrderCount() {
        return reduceOrderCount;
    }

    public void setReduceOrderCount(BigInteger reduceOrderCount) {
        this.reduceOrderCount = reduceOrderCount;
    }

    public String getReduceOrderMoneyStr() {
        return reduceOrderMoneyStr;
    }

    public void setReduceOrderMoneyStr(String reduceOrderMoneyStr) {
        this.reduceOrderMoneyStr = reduceOrderMoneyStr;
    }

    public BigInteger getReduceOrderMoney() {
        return reduceOrderMoney;
    }

    public void setReduceOrderMoney(BigInteger reduceOrderMoney) {
        this.reduceOrderMoney = reduceOrderMoney;
    }

    public String getTotalOffsetMoneyStr() {
        return totalOffsetMoneyStr;
    }

    public void setTotalOffsetMoneyStr(String totalOffsetMoneyStr) {
        this.totalOffsetMoneyStr = totalOffsetMoneyStr;
    }

    public BigInteger getTotalOffsetMoney() {
        return totalOffsetMoney;
    }

    public void setTotalOffsetMoney(BigInteger totalOffsetMoney) {
        this.totalOffsetMoney = totalOffsetMoney;
    }

    public BigInteger getPromoteOrderCount() {
        return promoteOrderCount;
    }

    public void setPromoteOrderCount(BigInteger promoteOrderCount) {
        this.promoteOrderCount = promoteOrderCount;
    }

    public String getPromoteOrderCountStr() {
        return promoteOrderCountStr;
    }

    public void setPromoteOrderCountStr(String promoteOrderCountStr) {
        this.promoteOrderCountStr = promoteOrderCountStr;
    }

    public BigInteger getPromoteOrderMoney() {
        return promoteOrderMoney;
    }

    public void setPromoteOrderMoney(BigInteger promoteOrderMoney) {
        this.promoteOrderMoney = promoteOrderMoney;
    }

    public String getPromoteOrderMoneyStr() {
        return promoteOrderMoneyStr;
    }

    public void setPromoteOrderMoneyStr(String promoteOrderMoneyStr) {
        this.promoteOrderMoneyStr = promoteOrderMoneyStr;
    }

    public String getRefundOrderMoneyStr() {
        return refundOrderMoneyStr;
    }

    public void setRefundOrderMoneyStr(String refundOrderMoneyStr) {
        this.refundOrderMoneyStr = refundOrderMoneyStr;
    }

    public BigInteger getRefundOrderMoney() {
        return refundOrderMoney;
    }

    public void setRefundOrderMoney(BigInteger refundOrderMoney) {
        this.refundOrderMoney = refundOrderMoney;
    }

    public String getTotalOffsetRefundMoneyStr() {
        return totalOffsetRefundMoneyStr;
    }

    public void setTotalOffsetRefundMoneyStr(String totalOffsetRefundMoneyStr) {
        this.totalOffsetRefundMoneyStr = totalOffsetRefundMoneyStr;
    }

    public BigInteger getTotalOffsetRefundMoney() {
        return totalOffsetRefundMoney;
    }

    public void setTotalOffsetRefundMoney(BigInteger totalOffsetRefundMoney) {
        this.totalOffsetRefundMoney = totalOffsetRefundMoney;
    }
}
