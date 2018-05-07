package com.sky.dao.vo;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: SIBU Kanger
 * @Description: 单独获取会员邀请码
 * @Date: 2016/9/28 9:43
 */
public class APIInvoteCodeBean {
    private String memberId;
    private String inviteCode;
    private String imgUrl;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
