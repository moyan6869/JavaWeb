package com.sky.web.model;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 功能：
 * 		商品实体类[管理站点使用]
 * @version 1.0
 * @author Geoffrey
 */
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String productId;
	private String categoryId;
	private Integer sortIndex;
	private String categoryName;
	private String name;
	private String shortName;
	private String brand;
	private String desc;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	private String size;
	private String details;
	private String remark;
	private String erpCode;
	private Integer inventory;
	private Integer sales;
	private Integer retailPrice;
	private Integer marketPrice;
	private Date createDate;
	private Date updateDate;
	private Integer deleteFlag;
	private String thumbUrl;
	private long stock;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private Integer status;
	public String getProductId(){
		return productId;
	}
	public void setProductId(String productId){
		this.productId = productId;
	}
	public String getCategoryId(){
		return categoryId;
	}
	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}
	public Integer getSortIndex() {		return sortIndex;	}
	public void setSortIndex(Integer sortIndex) {this.sortIndex = sortIndex;	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getShortName(){
		return shortName;
	}
	public void setShortName(String shortName){
		this.shortName = shortName;
	}
	public String getBrand(){
		return brand;
	}
	public void setBrand(String brand){
		this.brand = brand;
	}
	public String getDesc(){
		return desc;
	}
	public void setDesc(String desc){
		this.desc = desc;
	}
	public String getDetails(){
		return details;
	}
	public void setDetails(String details){
		this.details = details;
	}
	public String getRemark(){
		return remark;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getErpCode(){
		return erpCode;
	}
	public void setErpCode(String erpCode){
		this.erpCode = erpCode;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public Integer getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public Integer getRetailPrice(){
		return retailPrice;
	}
	public void setRetailPrice(int retailPrice){
		this.retailPrice = retailPrice;
	}
	public Integer getMarketPrice(){
		return marketPrice;
	}
	public void setMarketPrice(int marketPrice){
		this.marketPrice = marketPrice;
	}
	@JsonIgnore
	public Date getCreateDate(){
		return createDate;
	}
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	@JsonIgnore
	public Date getUpdateDate(){
		return updateDate;
	}
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	@JsonIgnore
	public Integer getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag){
		this.deleteFlag = deleteFlag;
	}
	public String getThumbUrl() {
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}
	
}

