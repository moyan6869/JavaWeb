package com.sky.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 建帆 on 2015/11/11.
 */
public class MemberWeb implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long incId;
    //邀请码（随机两位数）
    private Long inviteCode;
    private String memberId;
    private String headImage;
    private String phone;
    private String nickName;
    private String wechat;
    private Integer memberType;
    private String referrerMemberId;
    private String placeMemberId;
    private String leftMemberId;
    private String rightMemberId;
    protected Date createDate;
    protected Date updateDate;
    private Integer deleteFlag;
    private String userName;
    private String identityCard;
    //代报单人ID
    private String proxyMemberId;
    //运营id
    private Integer osId;
    //所属系统
    private String systemStr;
    private Integer freezeType;
    private Date freezeDate;
    private String freezeReason;

    private String referrerUserName;
    private String placeUserName;
    private String proxyMemberName;

    protected Date shopDay;

    private Integer ywsMemberType;
    /**
     * 左右区(1:左区 2:右区)
     */
    private Integer placeType;
    /**
     * 推荐上级集合
     */
    private String refMemberIds;

    /**
     * 店铺级别
     */
    private Integer shopType;

    /**
     * 荣誉奖衔
     */
    private Integer leaderLevel;

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public Integer getLeaderLevel() {
        return leaderLevel;
    }

    public void setLeaderLevel(Integer leaderLevel) {
        this.leaderLevel = leaderLevel;
    }

    public String getRefMemberIds() {
        return refMemberIds;
    }

    public void setRefMemberIds(String refMemberIds) {
        this.refMemberIds = refMemberIds;
    }

    public Integer getPlaceType() {
        return placeType;
    }

    public void setPlaceType(Integer placeType) {
        this.placeType = placeType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getIncId() {
        return incId;
    }

    public void setIncId(Long incId) {
        this.incId = incId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getReferrerMemberId() {
        return referrerMemberId;
    }

    public void setReferrerMemberId(String referrerMemberId) {
        this.referrerMemberId = referrerMemberId;
    }

    public String getSystemStr() {
        return systemStr;
    }

    public void setSystemStr(String systemStr) {
        this.systemStr = systemStr;
    }

    public String getPlaceMemberId() {
        return placeMemberId;
    }

    public void setPlaceMemberId(String placeMemberId) {
        this.placeMemberId = placeMemberId;
    }

    public String getLeftMemberId() {
        return leftMemberId;
    }

    public void setLeftMemberId(String leftMemberId) {
        this.leftMemberId = leftMemberId;
    }

    public String getRightMemberId() {
        return rightMemberId;
    }

    public void setRightMemberId(String rightMemberId) {
        this.rightMemberId = rightMemberId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getProxyMemberId() {
        return proxyMemberId;
    }

    public void setProxyMemberId(String proxyMemberId) {
        this.proxyMemberId = proxyMemberId;
    }

    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }

    public Integer getFreezeType() {
        return freezeType;
    }

    public void setFreezeType(Integer freezeType) {
        this.freezeType = freezeType;
    }

    public Date getFreezeDate() {
        return freezeDate;
    }

    public void setFreezeDate(Date freezeDate) {
        this.freezeDate = freezeDate;
    }

    public String getFreezeReason() {
        return freezeReason;
    }

    public void setFreezeReason(String freezeReason) {
        this.freezeReason = freezeReason;
    }

    public Long getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(Long inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getReferrerUserName() {
        return referrerUserName;
    }

    public void setReferrerUserName(String referrerUserName) {
        this.referrerUserName = referrerUserName;
    }

    public String getPlaceUserName() {
        return placeUserName;
    }

    public void setPlaceUserName(String placeUserName) {
        this.placeUserName = placeUserName;
    }

    public Date getShopDay() {
        return shopDay;
    }

    public void setShopDay(Date shopDay) {
        this.shopDay = shopDay;
    }

    public Integer getYwsMemberType() {
        return ywsMemberType;
    }

    public void setYwsMemberType(Integer ywsMemberType) {
        this.ywsMemberType = ywsMemberType;
    }

    public String getProxyMemberName() {
        return proxyMemberName;
    }

    public void setProxyMemberName(String proxyMemberName) {
        this.proxyMemberName = proxyMemberName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "incId=" + incId +
                ", inviteCode=" + inviteCode +
                ", memberId='" + memberId + '\'' +
                ", headImage='" + headImage + '\'' +
                ", phone='" + phone + '\'' +
                ", nickName='" + nickName + '\'' +
                ", wechat='" + wechat + '\'' +
                ", memberType=" + memberType +
                ", referrerMemberId='" + referrerMemberId + '\'' +
                ", placeMemberId='" + placeMemberId + '\'' +
                ", leftMemberId='" + leftMemberId + '\'' +
                ", rightMemberId='" + rightMemberId + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", deleteFlag=" + deleteFlag +
                ", userName='" + userName + '\'' +
                ", identityCard='" + identityCard + '\'' +
                ", proxyMemberId='" + proxyMemberId + '\'' +
                ", osId=" + osId +
                ", freezeType=" + freezeType +
                ", freezeDate=" + freezeDate +
                ", freezeReason='" + freezeReason + '\'' +
                ", referrerUserName='" + referrerUserName + '\'' +
                ", placeUserName='" + placeUserName + '\'' +
                '}';
    }
}
