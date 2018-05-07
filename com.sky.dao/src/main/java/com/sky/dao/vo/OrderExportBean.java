package com.sky.dao.vo;

import java.util.Date;

/**
 * @Author: suzheng
 * @Version: V1.0
 * @Package: com.sibu.dao.directsale.vo
 * @Company: SIBU_KANGER
 * @Description: 物流模块-订单导出bean
 * @Date: 2016/04/28
 */
public class OrderExportBean {
    /**
     * 订单号
     */
    private String orderCode;
    /**
     * 快递名称
     */
    private String expressName;
    /**
     * 当前快递单号
     */
    private String expressCode;
    /**
     * 原始快递单号
     */
    private String expressCode2;
    /**
     * 推送日期
     */
    private Date pushDate;

    /**
     * 创建日期
     */
    private Date payDate;

    /**
     * 创建日期
     */
    private Date createDate;


    /**
     * 创建日期
     */
    private Date shipDate;
    /**
     * 收件人名称
     */
    private String contact;
    /**
     * 收件地址
     */
    private String address;
    /**
     * 产品明细
     */
    private String productDetail;
    /**
     * 买家备注
     */
    private String buyerRemark;
    /**
     * 卖家备注
     */
    private String sellerRemark;

    /**
     * 产品数量
     */
    private int productQuantity;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 推送流水号
     */
    private String pushCode;

    /**
     * 快递状态
     */
    private int expressStatus;

    public int getExpressStatus() {
        return expressStatus;
    }

    public void setExpressStatus(int expressStatus) {
        this.expressStatus = expressStatus;
    }

    public String getPushCode() {
        return pushCode;
    }

    public void setPushCode(String pushCode) {
        this.pushCode = pushCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode;
    }

    public String getExpressCode2() {
        return expressCode2;
    }

    public void setExpressCode2(String expressCode2) {
        this.expressCode2 = expressCode2;
    }

    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public String getBuyerRemark() {
        return buyerRemark;
    }

    public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
    }

    public String getSellerRemark() {
        return sellerRemark;
    }

    public void setSellerRemark(String sellerRemark) {
        this.sellerRemark = sellerRemark;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
