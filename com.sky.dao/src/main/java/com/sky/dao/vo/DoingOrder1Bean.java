package com.sky.dao.vo;

import java.io.Serializable;

/**
 * DoingOrder1Bean
 * @version 1.0
 * @author dao
 */
public class DoingOrder1Bean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String order1Id;
	private String orderId;
	private Integer sortIndex;
	private String productId;
	private Integer purchaseQuantity;
	private Integer shippedQuantity;
	private Integer price;
	private Integer lineTotal;
	private Integer isProfit;
	private Integer discount;

	public Integer getDiscount() {
		return discount;
	}

	public void setDiscount(Integer discount) {
		this.discount = discount;
	}

	public Integer getIsProfit() {
		return isProfit;
	}

	public void setIsProfit(Integer isProfit) {
		this.isProfit = isProfit;
	}

	public String getOrder1Id(){
		return order1Id;
	}
	public void setOrder1Id(String order1Id){
		this.order1Id = order1Id;
	}
	public String getOrderId(){
		return orderId;
	}
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	public Integer getSortIndex(){
		return sortIndex;
	}
	public void setSortIndex(Integer sortIndex){
		this.sortIndex = sortIndex;
	}
	public String getProductId(){
		return productId;
	}
	public void setProductId(String productId){
		this.productId = productId;
	}
	public Integer getPurchaseQuantity(){
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(Integer purchaseQuantity){
		this.purchaseQuantity = purchaseQuantity;
	}
	public Integer getShippedQuantity(){
		return shippedQuantity;
	}
	public void setShippedQuantity(Integer shippedQuantity){
		this.shippedQuantity = shippedQuantity;
	}
	public Integer getPrice(){
		return price;
	}
	public void setPrice(Integer price){
		this.price = price;
	}
	public Integer getLineTotal(){
		return lineTotal;
	}
	public void setLineTotal(Integer lineTotal){
		this.lineTotal = lineTotal;
	}

}

