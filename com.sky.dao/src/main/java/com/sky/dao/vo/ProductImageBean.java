package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 功能：
 * 		商品图片实体类
 * @version 1.0
 * @author xiaoheliu
 */
public class ProductImageBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String productImageId;
	private String productId;
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
	private Date createDate;
	private Date updateDate;

	public String getProductImageId(){
		return productImageId;
	}
	public void setProductImageId(String productImageId){
		this.productImageId = productImageId;
	}
	public String getProductId(){
		return productId;
	}
	public void setProductId(String productId){
		this.productId = productId;
	}
	public String getThumbUrl(){
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl){
		this.thumbUrl = thumbUrl;
	}
	public String getBannelThumb1(){
		return bannelThumb1;
	}
	public void setBannelThumb1(String bannelThumb1){
		this.bannelThumb1 = bannelThumb1;
	}
	public String getBannelThumb2(){
		return bannelThumb2;
	}
	public void setBannelThumb2(String bannelThumb2){
		this.bannelThumb2 = bannelThumb2;
	}
	public String getBannelThumb3(){
		return bannelThumb3;
	}
	public void setBannelThumb3(String bannelThumb3){
		this.bannelThumb3 = bannelThumb3;
	}
	public String getBannelThumb4(){
		return bannelThumb4;
	}
	public void setBannelThumb4(String bannelThumb4){
		this.bannelThumb4 = bannelThumb4;
	}
	public String getBannelThumb5(){
		return bannelThumb5;
	}
	public void setBannelThumb5(String bannelThumb5){
		this.bannelThumb5 = bannelThumb5;
	}
	public String getBannerImage1(){
		return bannerImage1;
	}
	public void setBannerImage1(String bannerImage1){
		this.bannerImage1 = bannerImage1;
	}
	public String getBannerImage2(){
		return bannerImage2;
	}
	public void setBannerImage2(String bannerImage2){
		this.bannerImage2 = bannerImage2;
	}
	public String getBannerImage3(){
		return bannerImage3;
	}
	public void setBannerImage3(String bannerImage3){
		this.bannerImage3 = bannerImage3;
	}
	public String getBannerImage4(){
		return bannerImage4;
	}
	public void setBannerImage4(String bannerImage4){
		this.bannerImage4 = bannerImage4;
	}
	public String getBannerImage5(){
		return bannerImage5;
	}
	public void setBannerImage5(String bannerImage5){
		this.bannerImage5 = bannerImage5;
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

}

