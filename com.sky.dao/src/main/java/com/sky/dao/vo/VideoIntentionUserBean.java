package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * VideoIntentionUserBean
 * @version 1.0
 * @author dao
 */ 
public class VideoIntentionUserBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String intentionUserId;
	private String invitationCode;
	private String userPhone;
	private String nickName;
	private String remark;
	@JsonIgnore()
	private Integer status;
	private Integer videoId;
	@JsonIgnore()
	private Integer deleteFlag;
	@JsonIgnore()
	private Date createTime;

	public String getIntentionUserId(){
		return intentionUserId;
	}
	public void setIntentionUserId(String intentionUserId){
		this.intentionUserId = intentionUserId;
	}
	
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public String getUserPhone(){
		return userPhone;
	}
	public void setUserPhone(String userPhone){
		this.userPhone = userPhone;
	}
	public String getNickName(){
		return nickName;
	}
	public void setNickName(String nickName){
		this.nickName = nickName;
	}
	public String getRemark(){
		return remark;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public Integer getStatus(){
		return status;
	}
	public void setStatus(Integer status){
		this.status = status;
	}
	public Integer getVideoId(){
		return videoId;
	}
	public void setVideoId(Integer videoId){
		this.videoId = videoId;
	}
	public Integer getDeleteFlag(){
		return deleteFlag;
	}
	public void setDeleteFlag(Integer deleteFlag){
		this.deleteFlag = deleteFlag;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

}

