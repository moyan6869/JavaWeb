package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * VideoDisplayBean
 * @version 1.0
 * @author dao
 */ 
public class VideoDisplayBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String videoId;
	private String url;
	private String title;
	private String intro;
	private Integer videoType;
	private String headImage;
	private Integer fromType;
	private Date createDate;
	private Integer status;
	private Integer sortIndex;
	private String appShareVideoUrl;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getVideoType() {
		return videoType;
	}

	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
	}

	public String getHeadImage() {
		return headImage;
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public Integer getFromType() {
		return fromType;
	}

	public void setFromType(Integer fromType) {
		this.fromType = fromType;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getSortIndex() {
		return sortIndex;
	}

	public void setSortIndex(Integer sortIndex) {
		this.sortIndex = sortIndex;
	}

	public String getAppShareVideoUrl() {
		return appShareVideoUrl;
	}

	public void setAppShareVideoUrl(String appShareVideoUrl) {
		this.appShareVideoUrl = appShareVideoUrl;
	}
}

