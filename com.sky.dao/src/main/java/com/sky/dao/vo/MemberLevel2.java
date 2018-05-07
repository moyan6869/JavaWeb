package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/3/12 0012.
 */
public class MemberLevel2 implements Serializable{

    private String member_id;
    private String leftMemberId;
    private String rightMemberId;
    private int level;
    private int memberType;

    public int getMemberType() {
        return memberType;
    }

    public void setMemberType(int memberType) {
        this.memberType = memberType;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
