package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * TeacherTagBean
 * @version 1.0
 * @author Geoffrey
 */ 
public class TeacherTagBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String tagId;
	private String teacherId;
	@JsonIgnore
	private Integer sortIndex;
	private String backcolor;
	private String tagName;
	private Date createDate;
	@JsonIgnore
	private Date updateDate;
	@JsonIgnore
	private Integer deleteFlag;

	public String getTagId(){
		return tagId;
	}
	public void setTagId(String tagId){
		this.tagId = tagId;
	}
	public String getTeacherId(){
		return teacherId;
	}
	public void setTeacherId(String teacherId){
		this.teacherId = teacherId;
	}
	public Integer getSortIndex(){
		return sortIndex;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public void setSortIndex(Integer sortIndex){
		this.sortIndex = sortIndex;
	}
	public String getBackcolor(){
		return backcolor;
	}
	public void setBackcolor(String backcolor){
		this.backcolor = backcolor;
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

