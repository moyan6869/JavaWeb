package com.sky.dao.vo;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/3/10
 * Description:视频信息，用于前台展示
 */
public class MemberVideoInfoVo {
    private String userPhone;
    private String nickName;
    private Long invitationCode;//邀请码
    private Long clickRate;//点击数
    private Long intentionCount;//意向客户人数

    private VideoDisplayBean video;

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

    public Long getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(Long invitationCode) {
        this.invitationCode = invitationCode;
    }

    public Long getClickRate() {
        return clickRate;
    }

    public void setClickRate(Long clickRate) {
        this.clickRate = clickRate;
    }

    public Long getIntentionCount() {
        return intentionCount;
    }

    public void setIntentionCount(Long intentionCount) {
        this.intentionCount = intentionCount;
    }

    public VideoDisplayBean getVideo() {
        return video;
    }

    public void setVideo(VideoDisplayBean video) {
        this.video = video;
    }
}
