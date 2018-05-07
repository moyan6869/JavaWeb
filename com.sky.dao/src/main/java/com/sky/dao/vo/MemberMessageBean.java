package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JacksonInject;

import java.io.Serializable;
import java.util.Date;

/**
 * MemberMessageBean
 * @version 1.0
 * @author Geoffrey
 */ 
public class MemberMessageBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String msgId;
	private String memberId;
	private Integer type;
	private String infoId;
	private String thumbUrl;
	private Integer isRead=0;
	private String title;
	private String content;
	private Date createDate=new Date();;
	@JsonIgnore
	private Boolean deleteFlag;

	public String getMsgId(){
		return msgId;
	}
	public void setMsgId(String msgId){
		this.msgId = msgId;
	}
	public String getMemberId(){
		return memberId;
	}
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public Integer getType(){
		return type;
	}
	public void setType(Integer type){
		this.type = type;
	}
	public String getInfoId(){
		return infoId;
	}
	public void setInfoId(String infoId){
		this.infoId = infoId;
	}
	public String getThumbUrl(){
		return thumbUrl;
	}
	public void setThumbUrl(String thumbUrl){
		this.thumbUrl = thumbUrl;
	}
	public Integer getIsRead(){
		return isRead;
	}
	public void setIsRead(Integer isRead){
		this.isRead = isRead;
	}
	public String getTitle(){
		return title;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public Date getCreateDate(){
		return createDate;
	}
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	public Boolean getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(Boolean deleteFlag){
		this.deleteFlag = deleteFlag;
	}

}

