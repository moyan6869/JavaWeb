package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * TeacherBean
 * @version 1.0
 * @author Geoffrey
 */ 
public class TeacherBean implements Serializable{
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	private String teacherId;
	private String name;
	private String intro;
	private String headImg;

	private Date createDate;
	@JsonIgnore
	private Date updateDate;
	@JsonIgnore
	private Integer deleteFlag;
	private List<TeacherTagBean> teacherTag=new ArrayList<>();
	public String getTeacherId(){
		return teacherId;
	}
	public void setTeacherId(String teacherId){
		this.teacherId = teacherId;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getIntro(){
		return intro;
	}
	public void setIntro(String intro){
		this.intro = intro;
	}
	public String getHeadImg(){
		return headImg;
	}
	public void setHeadImg(String headImg){
		this.headImg = headImg;
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

	public List<TeacherTagBean> getTeacherTag() {
		return teacherTag;
	}

	public void setTeacherTag(List<TeacherTagBean> teacherTag) {
		this.teacherTag = teacherTag;
	}
}

