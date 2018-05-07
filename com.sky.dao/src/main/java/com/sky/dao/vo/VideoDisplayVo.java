package com.sky.dao.vo;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/3/10
 * Description:视频列表，用于前台展示
 */
public class VideoDisplayVo {
    private Long videoId;
    private String url;
    private String title;
    private String intro;
    private String headImage;
    private Integer sortIndex;
    private String appShareVideoUrl;

    private Long clickRate;//点击数

    private String invitationCode;//邀请码
    private Long intentionCount;//意向客户人数

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
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

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Long getClickRate() {
        return clickRate;
    }

    public void setClickRate(Long clickRate) {
        this.clickRate = clickRate;
    }


    public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public Long getIntentionCount() {
        return intentionCount;
    }

    public void setIntentionCount(Long intentionCount) {
        this.intentionCount = intentionCount;
    }

	public String getAppShareVideoUrl() {
		return appShareVideoUrl;
	}

	public void setAppShareVideoUrl(String appShareVideoUrl) {
		this.appShareVideoUrl = appShareVideoUrl;
	}
}