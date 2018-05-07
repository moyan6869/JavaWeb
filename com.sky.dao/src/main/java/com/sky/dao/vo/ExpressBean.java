package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * ExpressBean
 * @version 1.0
 * @author Geoffrey
 */ 
public class ExpressBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer expressId;
	private String expressName;
	private Date createDate;
	private Date updateDate;
	private Integer deleteFlag;

	public Integer getExpressId(){
		return expressId;
	}
	public void setExpressId(Integer expressId){
		this.expressId = expressId;
	}
	public String getExpressName(){
		return expressName;
	}
	public void setExpressName(String expressName){
		this.expressName = expressName;
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

}

