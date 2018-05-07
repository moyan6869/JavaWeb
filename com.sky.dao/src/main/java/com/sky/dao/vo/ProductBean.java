package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * 功能：
 * 		商品实体类
 * @version 1.0
 * @author xiaoheliu
 */
public class ProductBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String productId;
	private String categoryId;
	private String name;
	private String shortName;
	private String brand;
	private String desc;
	private String details;
	private String remark;
	private String erpCode;
	private Integer inventory;
	private Integer sales=0;
	private Integer retailPrice;
	private Integer marketPrice;
	private Date createDate;
	private Date updateDate;
	private Integer deleteFlag;
	private String thumbUrl;
    	private boolean hiddenFlag;
    	private long stock;
	private int isProfit;

	private int multiple;
	private Date startDate;
	private Date endDate;

	private int amount;


	private String teamFlag;//该产品的 团队权限组别 对应 TeamFlag枚举

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public void setRetailPrice(Integer retailPrice) {
		this.retailPrice = retailPrice;
	}

	public void setMarketPrice(Integer marketPrice) {
		this.marketPrice = marketPrice;
	}

	public String getTeamFlag() {
		return teamFlag;
	}

	public void setTeamFlag(String teamFlag) {
		this.teamFlag = teamFlag;
	}

	public int getMultiple() {
		return multiple;
	}

	public void setMultiple(int multiple) {
		this.multiple = multiple;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getIsProfit() {
		return isProfit;
	}

	public void setIsProfit(int isProfit) {
		this.isProfit = isProfit;
	}

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
    public boolean isHiddenFlag() {
        return hiddenFlag;
    }
    public void setHiddenFlag(boolean hiddenFlag) {
        this.hiddenFlag = hiddenFlag;
    }
    public long getStock() {
        return stock;
    }
    public void setStock(long stock) {
        this.stock = stock;
    }
}

