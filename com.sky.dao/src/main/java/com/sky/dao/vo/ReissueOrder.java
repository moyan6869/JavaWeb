package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
public class ReissueOrder implements Serializable{

    private static final long serialVersionUID = 1L;
    private String orderId;
    private String memberId;
    private String orderCode;
    private Integer orderStatus = 0;
    private String contact;
    private String phone;
    private String address;
    private String zipcode;
    private Integer totalMoney = 0;
    private Integer freight = 0;
    private Integer isPay = 0;
    private Integer payType = 0;
    private Integer payMoney = 0;
    private Date payDate;
    private String payRemark;

    private Integer isReceived = 0;
    private Date receivedDate;
    private Integer orderFrom = 0;
    private String buyerRemark;
    private String sellerRemark;
    private Integer expressId = 0;
    private String expressName;
    private String expressCode;

    private String expressCode2;
    private Date createDate;
    private Date preShipDate;
    private Date shipDate;

    private Date updateDate;
    private Integer deleteFlag = 0;
    private Integer memberType = 0;
    private Integer refundType ;

    private Date pushDate;
    private String pushResult;
    private String paymentNumber;
    private String drawId;

    private Integer shopType = 0;
    private Integer isProfit = 0;
    private List<ProductBean> products=new ArrayList<>();
    private List<Integer> productAmounts=new ArrayList<>();
    private String payTypeStr;
    private String refundTypeStr;
    private Integer orderType;

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getRefundTypeStr() {
        return refundTypeStr;
    }

    public void setRefundTypeStr(String refundTypeStr) {
        this.refundTypeStr = refundTypeStr;
    }

    public String getPayTypeStr() {
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderStatusStr() {
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    private String orderStatusStr;

    public List<ProductBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductBean> products) {
        this.products = products;
    }

    public List<Integer> getProductAmounts() {
        return productAmounts;
    }

    public void setProductAmounts(List<Integer> productAmounts) {
        this.productAmounts = productAmounts;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Integer totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getFreight() {
        return freight;
    }

    public void setFreight(Integer freight) {
        this.freight = freight;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public void setIsPay(Integer isPay) {
        this.isPay = isPay;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getPayRemark() {
        return payRemark;
    }

    public void setPayRemark(String payRemark) {
        this.payRemark = payRemark;
    }

    public Integer getIsReceived() {
        return isReceived;
    }

    public void setIsReceived(Integer isReceived) {
        this.isReceived = isReceived;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Integer getOrderFrom() {
        return orderFrom;
    }

    public void setOrderFrom(Integer orderFrom) {
        this.orderFrom = orderFrom;
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

    public Integer getExpressId() {
        return expressId;
    }

    public void setExpressId(Integer expressId) {
        this.expressId = expressId;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getPreShipDate() {
        return preShipDate;
    }

    public void setPreShipDate(Date preShipDate) {
        this.preShipDate = preShipDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public Date getPushDate() {
        return pushDate;
    }

    public void setPushDate(Date pushDate) {
        this.pushDate = pushDate;
    }

    public String getPushResult() {
        return pushResult;
    }

    public void setPushResult(String pushResult) {
        this.pushResult = pushResult;
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getDrawId() {
        return drawId;
    }

    public void setDrawId(String drawId) {
        this.drawId = drawId;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public Integer getIsProfit() {
        return isProfit;
    }

    public void setIsProfit(Integer isProfit) {
        this.isProfit = isProfit;
    }

    @Override
    public String toString() {
        return "ReissueOrder{" +
                "orderId='" + orderId + '\'' +
                ", memberId='" + memberId + '\'' +
                ", orderCode='" + orderCode + '\'' +
                ", orderStatus=" + orderStatus +
                ", contact='" + contact + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", totalMoney=" + totalMoney +
                ", freight=" + freight +
                ", isPay=" + isPay +
                ", payType=" + payType +
                ", payMoney=" + payMoney +
                ", payDate=" + payDate +
                ", payRemark='" + payRemark + '\'' +
                ", isReceived=" + isReceived +
                ", receivedDate=" + receivedDate +
                ", orderFrom=" + orderFrom +
                ", buyerRemark='" + buyerRemark + '\'' +
                ", sellerRemark='" + sellerRemark + '\'' +
                ", expressId=" + expressId +
                ", expressName='" + expressName + '\'' +
                ", expressCode='" + expressCode + '\'' +
                ", expressCode2='" + expressCode2 + '\'' +
                ", createDate=" + createDate +
                ", preShipDate=" + preShipDate +
                ", shipDate=" + shipDate +
                ", updateDate=" + updateDate +
                ", deleteFlag=" + deleteFlag +
                ", memberType=" + memberType +
                ", refundType=" + refundType +
                ", pushDate=" + pushDate +
                ", pushResult='" + pushResult + '\'' +
                ", paymentNumber='" + paymentNumber + '\'' +
                ", drawId='" + drawId + '\'' +
                ", shopType=" + shopType +
                ", isProfit=" + isProfit +
                ", products=" + products +
                ", productAmounts=" + productAmounts +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", refundTypeStr='" + refundTypeStr + '\'' +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                '}';
    }
}
