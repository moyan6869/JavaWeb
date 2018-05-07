package com.sky.dao.express.yto.model.order;

import java.util.List;

/**
 * 销售出库单
 * Created by wangyun on 2015/12/10.
 */
public class Order {

    //销售单号	字符	32	要求唯一		是
    private String orderNo;

    //仓库编码	字符	32	要求唯一		是
    private String storageNo;

    //配送公司	枚举字符	32			是  ExpressTypeCompany
    private String expressType;

    //期望收货开始日期	字符		yyyy-MM-dd
    private String predictStartTimeStr;

    //期望收货结束日期	字符		yyyy-MM-dd
    private String predictEndTimeStr;

    //收货人	字符	32			是
    private String name;

    //手机	字符	16
    private String mobile;

    //电话	字符	32
    private String telephone;

    //收货地址-省	字符	32			是
    private String province;

    //收货地址-市	字符	32			是
    private String city;

    //收货地址-区	字符	32			是
    private String district;

    //收货详细地址	字符	64			是
    private String address;

    //邮编	字符	8
    private String postCode;

    //支付方式	枚举数字				是   OrderPaymentType
    private int payment;

    //代收金额	字符		单位元	0
    private String agencyFund;

    //订单金额	字符		单位元	0
    private String goodsFund;

    //运费金额	字符		单位元	0
    private String freight;

    //商品总额	字符		单位元	0
    private String totalFund;

    //已付金额	字符		单位元	0
    private String paidFund;

    //发票类型	枚举数字				是  OrderInvoiceType
    private int plateId;

    //发票抬头	字符	64
    private String invoiceHead;

    //发票金额	字符		单位元
    private String invoiceFund;

    //邮报信息	字符
    private String postInfo;

    //渠道编码	字符		要求唯一		是
    private String channelCode;

    //备注	字符
    private String remark;

    //销售出库单明细
    private List<OrderDetail> dataList;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getStorageNo() {
        return storageNo;
    }

    public void setStorageNo(String storageNo) {
        this.storageNo = storageNo;
    }

    public String getExpressType() {
        return expressType;
    }

    public void setExpressType(String expressType) {
        this.expressType = expressType;
    }

    public String getPredictStartTimeStr() {
        return predictStartTimeStr;
    }

    public void setPredictStartTimeStr(String predictStartTimeStr) {
        this.predictStartTimeStr = predictStartTimeStr;
    }

    public String getPredictEndTimeStr() {
        return predictEndTimeStr;
    }

    public void setPredictEndTimeStr(String predictEndTimeStr) {
        this.predictEndTimeStr = predictEndTimeStr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public String getAgencyFund() {
        return agencyFund;
    }

    public void setAgencyFund(String agencyFund) {
        this.agencyFund = agencyFund;
    }

    public String getGoodsFund() {
        return goodsFund;
    }

    public void setGoodsFund(String goodsFund) {
        this.goodsFund = goodsFund;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    public String getTotalFund() {
        return totalFund;
    }

    public void setTotalFund(String totalFund) {
        this.totalFund = totalFund;
    }

    public String getPaidFund() {
        return paidFund;
    }

    public void setPaidFund(String paidFund) {
        this.paidFund = paidFund;
    }

    public int getPlateId() {
        return plateId;
    }

    public void setPlateId(int plateId) {
        this.plateId = plateId;
    }

    public String getInvoiceHead() {
        return invoiceHead;
    }

    public void setInvoiceHead(String invoiceHead) {
        this.invoiceHead = invoiceHead;
    }

    public String getInvoiceFund() {
        return invoiceFund;
    }

    public void setInvoiceFund(String invoiceFund) {
        this.invoiceFund = invoiceFund;
    }

    public String getPostInfo() {
        return postInfo;
    }

    public void setPostInfo(String postInfo) {
        this.postInfo = postInfo;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<OrderDetail> getDataList() {
        return dataList;
    }

    public void setDataList(List<OrderDetail> dataList) {
        this.dataList = dataList;
    }
}