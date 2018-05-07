package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by weiyunliang on 2017/9/4.
 */
public class ResultMemberBean implements Serializable {
    //自增ID
    private Integer incId;
    //邀请码，由incId+两位随机数字生成 StringUtil.randomTwo()
    private Long inviteCode;
    private String password;
    private String salt;
    private Integer freezeType;
    @JsonIgnore
    private Date freezeDate;
    private String freezeReason;
    private String referrerMemberId;
    private String secondPwd;

    private Integer memberTypeYun;

    private Integer memberFrom;
    private Integer yunType;
    protected String memberId;
    protected String headImage;
    protected String phone;
    protected String nickName;
    protected String wechat;
    protected String wechatOpenId;
    protected String userName;
    protected String identityCard;
    protected Integer memberType=0;
    protected String memberTypeStr;
    protected String placeMemberId;
    protected String leftMemberId;
    protected String rightMemberId;


    @JsonIgnore
    private Date joinDate;
    @JsonIgnore
    private Date createDate;
    @JsonIgnore
    private Date updateDate;
    private Integer deleteFlag;
    private String proxyMemberId;
    private Integer osId;
    private Integer teamFlag;
    private String shopDay;// 活跃期
    private Boolean buyOrNot;//云猫返回字段   是否存在已支付订单  true  报过单  false 没报过


    public Boolean getBuyOrNot() {
        return buyOrNot;
    }

    public void setBuyOrNot(Boolean buyOrNot) {
        this.buyOrNot = buyOrNot;
    }

    public String getShopDay() {
        return shopDay;
    }

    public void setShopDay(String shopDay) {
        this.shopDay = shopDay;
    }

    public Integer getTeamFlag() {
        return teamFlag;
    }

    public void setTeamFlag(Integer teamFlag) {
        this.teamFlag = teamFlag;
    }

    public Integer getIncId() {
        return incId;
    }

    public void setIncId(Integer incId) {
        this.incId = incId;
    }

    public Long getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(Long inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    public String getReferrerMemberId() {
        return referrerMemberId;
    }

    public void setReferrerMemberId(String referrerMemberId) {
        this.referrerMemberId = referrerMemberId;
    }

    public String getSecondPwd() {
        return secondPwd;
    }

    public void setSecondPwd(String secondPwd) {
        this.secondPwd = secondPwd;
    }

    public Integer getMemberTypeYun() {
        return memberTypeYun;
    }

    public void setMemberTypeYun(Integer memberTypeYun) {
        this.memberTypeYun = memberTypeYun;
    }

    public Integer getMemberFrom() {
        return memberFrom;
    }

    public void setMemberFrom(Integer memberFrom) {
        this.memberFrom = memberFrom;
    }

    public Integer getYunType() {
        return yunType;
    }

    public void setYunType(Integer yunType) {
        this.yunType = yunType;
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

    public String getWechatOpenId() {
        return wechatOpenId;
    }

    public void setWechatOpenId(String wechatOpenId) {
        this.wechatOpenId = wechatOpenId;
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

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getMemberTypeStr() {
        return memberTypeStr;
    }

    public void setMemberTypeStr(String memberTypeStr) {
        this.memberTypeStr = memberTypeStr;
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

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
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

    @Override
    public String toString() {
        return "MemberBean [memberId=" + memberId + ", headImage=" + headImage
                + ", phone=" + phone + ", password=" + password + ", salt=" + salt + ", nickName=" + nickName
                + ", wechat=" + wechat + ", wechatOpenId=" + wechatOpenId
                + ", memberType=" + memberType + ", referrerMemberId=" + referrerMemberId + ", createDate=" + createDate
                + ", updateDate=" + updateDate + ", deleteFlag=" + deleteFlag + "]";
    }
}
