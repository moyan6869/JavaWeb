package com.sky.dao.model;

import com.sky.dao.enums.GemType;
import org.supercsv.cellprocessor.constraint.StrRegEx;

/**
 * 新春好礼团队实体
 * Created by Administrator on 2015/11/26.
 */
public class APISpringFestivalGroupUsersBean {

    private String memberId;
    private String memberHeadImage;
    private String memberPhone;
    private String memberNickName;
    private String memberUserName;
    private Integer memberType=0;
    private String memberTypeStr;
    private String createDate;
    private Integer isSend=0;
    private String orderCode;
    private String orderId;
    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getMemberTypeStr() {
        return GemType.getGemTypeName(memberType);
    }

    public void setMemberTypeStr(String memberTypeStr) {
        this.memberTypeStr = memberTypeStr;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberHeadImage() {
        return memberHeadImage;
    }

    public void setMemberHeadImage(String memberHeadImage) {
        this.memberHeadImage = memberHeadImage;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberNickName() {
        return memberNickName;
    }

    public void setMemberNickName(String memberNickName) {
        this.memberNickName = memberNickName;
    }

    public String getMemberUserName() {
        return memberUserName;
    }

    public void setMemberUserName(String memberUserName) {
        this.memberUserName = memberUserName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
