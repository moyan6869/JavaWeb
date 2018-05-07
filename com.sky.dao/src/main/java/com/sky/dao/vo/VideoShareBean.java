package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * VideoShareBean
 * @version 1.0
 * @author dao
 */ 
public class VideoShareBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer videoShareId;
	private String memberId;
	private Integer invitationCode;
	private Integer videoId;
	private Integer intentionCount;
	private Date createTime;

	public Integer getVideoShareId(){
		return videoShareId;
	}
	public void setVideoShareId(Integer videoShareId){
		this.videoShareId = videoShareId;
	}
	public String getMemberId(){
		return memberId;
	}
	public void setMemberId(String memberId){
		this.memberId = memberId;
	}
	public Integer getInvitationCode(){
		return invitationCode;
	}
	public void setInvitationCode(Integer invitationCode){
		this.invitationCode = invitationCode;
	}
	public Integer getVideoId(){
		return videoId;
	}
	public void setVideoId(Integer videoId){
		this.videoId = videoId;
	}
	public Integer getIntentionCount(){
		return intentionCount;
	}
	public void setIntentionCount(Integer intentionCount){
		this.intentionCount = intentionCount;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}

}

