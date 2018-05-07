package com.sky.dao.model;

import com.sky.dao.vo.ProductBean;
import com.sky.dao.vo.ReissueOrder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DoingOrderBean
 *
 * @author dao
 * @version 1.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class APIOrderBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String orderId;
    @JsonIgnore
    private String memberId;
    private String memberType;

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    private String orderCode;
    private Integer orderStatus;
    private String orderStatusStr;
//    private String addressId;
    private String contact;
    private String phone;
//    private String address;
    private String zipcode;
    private Integer totalMoney;
    private Integer freight;
    private Integer isPay;
    private Integer isProfit;
    private Integer payType;
    private String payTypeStr;
    private String payMoney;
    //支付的现金字段(混合支付时，记录支付宝或者微信的金额) 2017-11-14 wangguofeng
    private Integer payCash;
    private Integer payCoin;
    private Date payDate;
    private String payRemark;
    private Integer isReceived;
    private Date receivedDate;
    private Integer orderFrom;
    private String buyerRemark;
    private String sellerRemark;
//    private Integer expressId;
//    private String expressName;
//    private String expressCode;
//    private String expressCode2;
    private Date preShipDate;
    private Date shipDate;
    private Date createDate;
    private Integer refundType;
    private String refundTypeStr;
    private int orderType;
    private List<ProductBean> products=new ArrayList<>();

    public List<ReissueOrder> getReissueOrders() {
        return reissueOrders;
    }

    public void setReissueOrders(List<ReissueOrder> reissueOrders) {
        this.reissueOrders = reissueOrders;
    }

    private List<ReissueOrder> reissueOrders=new ArrayList<>();
    private List<Integer> productAmounts=new ArrayList<>();
    private String proxyMemberId;

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

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
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

    public String getOrderStatusStr() {
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
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

//    public String getAddress() {
//        return address.replace("@", "");
//    }

//    public void setAddress(String address) {
//        this.address = address;
//    }

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

    public Integer getIsProfit() {
        return isProfit;
    }

    public void setIsProfit(Integer isProfit) {
        this.isProfit = isProfit;
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

    public String getPayTypeStr() {
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
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

//    public Integer getExpressId() {
//        return expressId;
//    }

//    public void setExpressId(Integer expressId) {
//        this.expressId = expressId;
//    }

//    public String getExpressName() {
//        return expressName;
//    }

//    public void setExpressName(String expressName) {
//        this.expressName = expressName;
//    }

//    public String getExpressCode() {
//        return expressCode;
//    }

//    public void setExpressCode(String expressCode) {
//        this.expressCode = expressCode;
//    }

//    public String getExpressCode2() {
//        return expressCode2;
//    }

//    public void setExpressCode2(String expressCode2) {
//        this.expressCode2 = expressCode2;
//    }

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<Integer> getProductAmounts() {
        return productAmounts;
    }

    public void setProductAmounts(List<Integer> productAmounts) {
        this.productAmounts = productAmounts;
    }

    public List<ProductBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductBean> products) {
        this.products = products;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public String getRefundTypeStr() {
        return refundTypeStr;
    }

    public void setRefundTypeStr(String refundTypeStr) {
        this.refundTypeStr = refundTypeStr;
    }

	public String getProxyMemberId() {
		return proxyMemberId;
	}

	public void setProxyMemberId(String proxyMemberId) {
		this.proxyMemberId = proxyMemberId;
	}

    public Integer getPayCash() {
        return payCash;
    }

    public void setPayCash(Integer payCash) {
        this.payCash = payCash;
    }

    public Integer getPayCoin() {
        return payCoin;
    }

    public void setPayCoin(Integer payCoin) {
        this.payCoin = payCoin;
    }

//    public String getAddressId() {
//        return addressId;
//    }

//    public void setAddressId(String addressId) {
//        this.addressId = addressId;
//    }

}

