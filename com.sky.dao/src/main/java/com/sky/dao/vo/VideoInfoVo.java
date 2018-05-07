package com.sky.dao.vo;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/3/10
 * Description:视频信息，用于前台展示
 */
public class VideoInfoVo extends VideoDisplayVo{
    private String userPhone;
    private String nickName;
    private String headImage;
    private String userEqCodeUrl;
    private String shareUrl;

    private String videoImage;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String getHeadImage() {
        return headImage;
    }

    @Override
    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

	public String getUserEqCodeUrl() {
		return userEqCodeUrl;
	}

	public void setUserEqCodeUrl(String userEqCodeUrl) {
		this.userEqCodeUrl = userEqCodeUrl;
	}

	public String getShareUrl() {
		return shareUrl;
	}

	public void setShareUrl(String shareUrl) {
		this.shareUrl = shareUrl;
	}

    public String getVideoImage() {
        return videoImage;
    }

    public void setVideoImage(String videoImage) {
        this.videoImage = videoImage;
    }
}
