package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * ProductHotBean
 * @version 1.0
 * @author
 */ 
public class ProductHotBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String hotId;
	private String productId;
	private String title;
	private String imageUrl;
	private Integer sortIndex;
	private Date startDate;
	private Date endDate;
	private String remark;
    @JsonIgnore
	private Date createDate;
    @JsonIgnore
	private Date updateDate;
	private Integer deleteFlag;
    private Integer retailPrice;
    private Integer marketPrice;

	private int pageOffset; //当前的页数
	private int pageSize; //一页显示多少条
	private long totalRecord; //总记录数
	private int totalPage; //总页数

	public int getPageOffset() {
		return pageOffset;
	}

	public void setPageOffset(int pageOffset) {
		this.pageOffset = pageOffset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getHotId(){
		return hotId;
	}
	public void setHotId(String hotId){
		this.hotId = hotId;
	}
	public String getProductId(){
		return productId;
	}
	public void setProductId(String productId){
		this.productId = productId;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getImageUrl(){
		return imageUrl;
	}
	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}
	public Integer getSortIndex(){
		return sortIndex;
	}
	public void setSortIndex(Integer sortIndex){
		this.sortIndex = sortIndex;
	}
	public Date getStartDate(){
		return startDate;
	}
	public void setStartDate(Date startDate){
		this.startDate = startDate;
	}
	public Date getEndDate(){
		return endDate;
	}
	public void setEndDate(Date endDate){
		this.endDate = endDate;
	}
	public String getRemark(){
		return remark;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public Date getCreateDate(){
		return createDate;
	}
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	public Date getUpdateDate(){
		return updateDate;
	}
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	public Integer getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag){
		this.deleteFlag = deleteFlag;
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
}

