package com.sky.web.model;

import java.io.Serializable;
import java.util.Date;
public class EditProductHot  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String hotId;
	private String productId;
	private String title;
	private String imageUrl;
	private Integer sortIndex;
	private Date startDate;
	private Date endDate;
	private String remark;
	private Date updateDate;
	private Integer deleteFlag;
	private String productName;

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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
}




