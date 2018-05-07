package com.sky.web.model;

import java.util.List;

/**
 * Created by 叶子林 on 2016/10/20.
 */
public class MemberTree {
    private String id;
    private String parentId;
    private String name;
    private Integer memberType;
    private String leftMemberId;
    private String rightMemberId;
    private List<MemberTree> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public List<MemberTree> getChildren() {
        return children;
    }

    public void setChildren(List<MemberTree> children) {
        this.children = children;
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
}
