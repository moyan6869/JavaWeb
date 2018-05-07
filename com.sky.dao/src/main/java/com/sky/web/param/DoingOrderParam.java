
/**   
* @Title: DoingOrderParam.java 
* @Package com.sibu.directSale.web.param 
* @Description: 订单查询参数
* @author zenglinhua
* @date 2015年10月28日 下午2:39:57 
* @version V1.0   
*/ 
package com.sky.web.param;

import java.io.Serializable;
import java.util.List;

import com.sky.dao.vo.DoingOrder1Bean;

/** 
 * @ClassName: DoingOrderParam 
 * @Description: 订单查询参数
 * @author zenglinhua
 * @date 2015年10月28日 下午2:39:57 
 *  
 */
public class DoingOrderParam implements Serializable{
	

	/** 
	* 序列化
	*/ 
	private static final long serialVersionUID = 7411339509380095550L;

	/**
	 * 订单号
	 */
	private String orderCode;
	
	/**
	 * 订单状态
	 */
	private Integer orderStatus;
	
	/**
	 * 收件人
	 */
	private String contact;
	
	/**
	 * 收件人电话
	 */
	private String phone;
	
	/**
	 * 收件人地址
	 */
	private String address;
	
	/**
	 * 开始下单日期
	 */
	private String startDate;
	
	/**
	 * 结束下单日期
	 */
	private String endDate;
	
	/**
	 * 删除标示
	 */
	private Integer deleteFlag;
	
	/**
	 * 订单id
	 */
	private String orderId;
	
	/**
	 * 用户id
	 */
	private String memberId;
	
	/**
	 * 快递编号
	 */
	private Integer expressId;
	
	/**
	 * 快递名称
	 */
	private String expressName;
	
	/**
	 * 快递单号
	 */
	private String expressCode;
	
	/**
	 * 快递结束单号
	 */
	private String expressCode2;
	
	/**
	 * 支付备注
	 */
	private String payRemark;
	
	/**
	 * 卖家备注
	 */
	private String sellerRemark;
	
	/**
	 * 是否支付
	 */
	private Integer isPay;
	
	/**
	 * 支付方式
	 */
	private String payType;
	
	/**
	 * 支付金额
	 */
	private String payMoney;
	
	/**
	 * 子单列表（主要传递发货数量）
	 */
	private List<DoingOrder1Bean> doingOrder1List;
	
	/**
	 * 分库模
	 */
	private String module;
	
	/**
	 * 跳转url
	 */
	private String redirectUrl;
	
	/**
	 * 推荐人电话号码
	 */
	private String referencePhone;
	
	public String getReferencePhone() {
		return referencePhone;
	}

	public void setReferencePhone(String referencePhone) {
		this.referencePhone = referencePhone;
	}

	/** 
	 * @return orderCode 
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/** 
	 * @param orderCode 要设置的 orderCode 
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/** 
	 * @return orderStatus 
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}

	/** 
	 * @param orderStatus 要设置的 orderStatus 
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	/** 
	 * @return contact 
	 */
	public String getContact() {
		return contact;
	}

	/** 
	 * @param contact 要设置的 contact 
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/** 
	 * @return phone 
	 */
	public String getPhone() {
		return phone;
	}

	/** 
	 * @param phone 要设置的 phone 
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/** 
	 * @return address 
	 */
	public String getAddress() {
		return address;
	}

	/** 
	 * @param address 要设置的 address 
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/** 
	 * @return startDate 
	 */
	public String getStartDate() {
		return startDate;
	}

	/** 
	 * @param startDate 要设置的 startDate 
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/** 
	 * @return endDate 
	 */
	public String getEndDate() {
		return endDate;
	}

	/** 
	 * @param endDate 要设置的 endDate 
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/** 
	 * @return deleteFlag 
	 */
	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	/** 
	 * @param deleteFlag 要设置的 deleteFlag 
	 */
	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/** 
	 * @return expressId 
	 */
	public Integer getExpressId() {
		return expressId;
	}

	/** 
	 * @param expressId 要设置的 expressId 
	 */
	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}

	/** 
	 * @return expressName 
	 */
	public String getExpressName() {
		return expressName;
	}

	/** 
	 * @param expressName 要设置的 expressName 
	 */
	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	/** 
	 * @return expressCode 
	 */
	public String getExpressCode() {
		return expressCode;
	}

	/** 
	 * @param expressCode 要设置的 expressCode 
	 */
	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	/** 
	 * @return expressCode2 
	 */
	public String getExpressCode2() {
		return expressCode2;
	}

	/** 
	 * @param expressCode2 要设置的 expressCode2 
	 */
	public void setExpressCode2(String expressCode2) {
		this.expressCode2 = expressCode2;
	}

	/** 
	 * @return doingOrder1List 
	 */
	public List<DoingOrder1Bean> getDoingOrder1List() {
		return doingOrder1List;
	}

	/** 
	 * @param doingOrder1List 要设置的 doingOrder1List 
	 */
	public void setDoingOrder1List(List<DoingOrder1Bean> doingOrder1List) {
		this.doingOrder1List = doingOrder1List;
	}

	/** 
	 * @return orderId 
	 */
	public String getOrderId() {
		return orderId;
	}

	/** 
	 * @param orderId 要设置的 orderId 
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/** 
	 * @return memberId 
	 */
	public String getMemberId() {
		return memberId;
	}

	/** 
	 * @param memberId 要设置的 memberId 
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/** 
	 * @return module 
	 */
	public String getModule() {
		return module;
	}

	/** 
	 * @param module 要设置的 module 
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/** 
	 * @return payRemark 
	 */
	public String getPayRemark() {
		return payRemark;
	}

	/** 
	 * @param payRemark 要设置的 payRemark 
	 */
	public void setPayRemark(String payRemark) {
		this.payRemark = payRemark;
	}

	/** 
	 * @return isPay 
	 */
	public Integer getIsPay() {
		return isPay;
	}

	/** 
	 * @param isPay 要设置的 isPay 
	 */
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	/** 
	 * @return payType 
	 */
	public String getPayType() {
		return payType;
	}

	/** 
	 * @param payType 要设置的 payType 
	 */
	public void setPayType(String payType) {
		this.payType = payType;
	}

	/** 
	 * @return payMoney 
	 */
	public String getPayMoney() {
		return payMoney;
	}

	/** 
	 * @param payMoney 要设置的 payMoney 
	 */
	public void setPayMoney(String payMoney) {
		this.payMoney = payMoney;
	}

	/** 
	 * @return sellerRemark 
	 */
	public String getSellerRemark() {
		return sellerRemark;
	}

	/** 
	 * @param sellerRemark 要设置的 sellerRemark 
	 */
	public void setSellerRemark(String sellerRemark) {
		this.sellerRemark = sellerRemark;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	
	
}

