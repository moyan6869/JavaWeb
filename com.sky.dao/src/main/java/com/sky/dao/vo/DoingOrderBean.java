package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * DoingOrderBean
 *
 * @author dao
 * @version 1.0
 */
public class DoingOrderBean implements Serializable {


    private static final long serialVersionUID = 1L;
    private String orderId;
    private String memberId;
    private String orderCode;
    private Integer orderStatus = 0;
    private String addressId;
    private String contact;
    private String phone;
    private String address;
    private String zipcode;
    private Integer totalMoney = 0;
    //by wangguofeng 2017-11-17 增加
    private Integer payCash = 0;
    private Integer freight = 0;
    private Integer isPay = 0;
    private Integer payType = 0;
    private Integer payMoney = 0;
    private Date payDate;
    private String payRemark;
    private Date preShipDate;
    private Date shipDate;

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

    private Date  pushDate;
    private String pushResult;
    private String paymentNumber;
    @JsonIgnore
    private Date updateDate;
    @JsonIgnore
    private Integer deleteFlag = 0;
    @JsonIgnore
    private Integer memberType = 0;
    @JsonIgnore
    private Integer shopType = 0;
    @JsonIgnore
    private Integer isProfit = 0;
    private String proxyMemberId;
    private Integer addUpType=0;//0、累计升级，1、复消升级
	private Integer otherMoney = 0;
	private String discountId ;
	private Integer pv;
	private int orderType;

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public String getDiscountId() {
		return discountId;
	}

	public void setDiscountId(String discountId) {
		this.discountId = discountId;
	}

	public Integer getOtherMoney() {
		return otherMoney;
	}

	public void setOtherMoney(Integer otherMoney) {
		this.otherMoney = otherMoney;
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

	public String getProxyMemberId() {
		return proxyMemberId;
	}

	public void setProxyMemberId(String proxyMemberId) {
		this.proxyMemberId = proxyMemberId;
	}

	public Integer getAddUpType() {
		return addUpType;
	}

	public void setAddUpType(Integer addUpType) {
		this.addUpType = addUpType;
	}

	public Integer getPayCash() {
		return payCash;
	}

	public void setPayCash(Integer payCash) {
		this.payCash = payCash;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "DoingOrderBean{" +
				"orderId='" + orderId + '\'' +
				", memberId='" + memberId + '\'' +
				", orderCode='" + orderCode + '\'' +
				", orderStatus=" + orderStatus +
				", addressId='" + addressId + '\'' +
				", contact='" + contact + '\'' +
				", phone='" + phone + '\'' +
				", address='" + address + '\'' +
				", zipcode='" + zipcode + '\'' +
				", totalMoney=" + totalMoney +
				", payCash=" + payCash +
				", freight=" + freight +
				", isPay=" + isPay +
				", payType=" + payType +
				", payMoney=" + payMoney +
				", payDate=" + payDate +
				", payRemark='" + payRemark + '\'' +
				", preShipDate=" + preShipDate +
				", shipDate=" + shipDate +
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
				", pushDate=" + pushDate +
				", pushResult='" + pushResult + '\'' +
				", paymentNumber='" + paymentNumber + '\'' +
				", updateDate=" + updateDate +
				", deleteFlag=" + deleteFlag +
				", memberType=" + memberType +
				", shopType=" + shopType +
				", isProfit=" + isProfit +
				", proxyMemberId='" + proxyMemberId + '\'' +
				", addUpType=" + addUpType +
				", otherMoney=" + otherMoney +
				", discountId='" + discountId + '\'' +
				", pv=" + pv +
				", orderType=" + orderType +
				'}';
	}
}
