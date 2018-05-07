package com.sky.dao.model;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * 功能：
 * 		商品和商品图片视图类
 * @author xiaoheliu
 *
 */
public class ProductDetail {
	private String productId;
	private String categoryId;
	private Integer sortIndex;
	private String name;
	private String shortName;
	private String brand;
	private String size;
	private String desc;
	private String details;
	private String remark;
	private String erpCode;
	private int inventory;
	private int sales;
	private int retailPrice;
	private int marketPrice;
	private int profitPrice;
	private Date createDate;
	private Date updateDate;
	private Integer deleteFlag;
	private String productImageId;
	private String thumbUrl;
	private String bannelThumb1;
	private String bannelThumb2;
	private String bannelThumb3;
	private String bannelThumb4;
	private String bannelThumb5;
	private String bannerImage1;
	private String bannerImage2;
	private String bannerImage3;
	private String bannerImage4;
	private String bannerImage5;
	private int isProfit;
	private Integer pv;
	private String team_flag;
	private int type;
	private int discountRate;
	private Integer shopFlag;//正弘团队特殊产品标识



	public String getTeam_flag() {
		return team_flag;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void setTeam_flag(String team_flag) {
		this.team_flag = team_flag;
	}

	public Integer getPv() {
		return pv;
	}

	public void setPv(Integer pv) {
		this.pv = pv;
	}

	public int getIsProfit() {
		return isProfit;
	}

	public void setIsProfit(int isProfit) {
		this.isProfit = isProfit;
	}

	public Integer getStatus() {
		return status;
	}

	public Integer getShopFlag() {
		return shopFlag;
	}

	public void setShopFlag(Integer shopFlag) {
		this.shopFlag = shopFlag;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private Integer status;
    private long stock;
    @JsonIgnore
    private int memberType;
    @JsonIgnore
    private int groupId;

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
	public void setSortIndex(Integer sortIndex) {		this.sortIndex = sortIndex;	}
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
	public String getSize() {
		return size;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public void setSize(String size) {
		this.size = size;
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
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getRetailPrice(){
		return retailPrice;
	}
	public void setRetailPrice(int retailPrice){
		this.retailPrice = retailPrice;
	}
	public int getMarketPrice(){
		return marketPrice;
	}
	public void setMarketPrice(int marketPrice){
		this.marketPrice = marketPrice;
	}
	public int getProfitPrice(){
		return profitPrice;
	}
	public void setProfitPrice(int profitPrice){
		this.profitPrice = profitPrice;
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
	public String getProductImageId() {
		return productImageId;
	}
	public void setProductImageId(String productImageId) {
		this.productImageId = productImageId;
	}
	public String getBannelThumb1() {
		return bannelThumb1;
	}
	public void setBannelThumb1(String bannelThumb1) {
		this.bannelThumb1 = bannelThumb1;
	}
	public String getBannelThumb2() {
		return bannelThumb2;
	}
	public void setBannelThumb2(String bannelThumb2) {
		this.bannelThumb2 = bannelThumb2;
	}
	public String getBannelThumb3() {
		return bannelThumb3;
	}
	public void setBannelThumb3(String bannelThumb3) {
		this.bannelThumb3 = bannelThumb3;
	}
	public String getBannelThumb4() {
		return bannelThumb4;
	}
	public void setBannelThumb4(String bannelThumb4) {
		this.bannelThumb4 = bannelThumb4;
	}
	public String getBannelThumb5() {
		return bannelThumb5;
	}
	public void setBannelThumb5(String bannelThumb5) {
		this.bannelThumb5 = bannelThumb5;
	}
	public String getBannerImage1() {
		return bannerImage1;
	}
	public void setBannerImage1(String bannerImage1) {
		this.bannerImage1 = bannerImage1;
	}
	public String getBannerImage2() {
		return bannerImage2;
	}
	public void setBannerImage2(String bannerImage2) {
		this.bannerImage2 = bannerImage2;
	}
	public String getBannerImage3() {
		return bannerImage3;
	}
	public void setBannerImage3(String bannerImage3) {
		this.bannerImage3 = bannerImage3;
	}
	public String getBannerImage4() {
		return bannerImage4;
	}
	public void setBannerImage4(String bannerImage4) {
		this.bannerImage4 = bannerImage4;
	}
	public String getBannerImage5() {
		return bannerImage5;
	}
	public void setBannerImage5(String bannerImage5) {
		this.bannerImage5 = bannerImage5;
	}
    public long getStock() {
        return stock;
    }
    public void setStock(long stock) {
        this.stock = stock;
    }

    public int getMemberType() {
        return memberType;
    }

    public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public void setMemberType(int memberType) {
        this.memberType = memberType;
    }
}
