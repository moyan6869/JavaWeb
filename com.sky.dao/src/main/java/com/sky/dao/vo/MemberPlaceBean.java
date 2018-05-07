package com.sky.dao.vo;

import java.io.Serializable;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.vo
 * @company: SIBU Kanger
 * @Description: 会员安置服务类
 * @Date: 2016/10/3 19:57
 */
public class MemberPlaceBean extends MemberBeanRedis implements Serializable {
    public class BaseObject implements Serializable {

    }
    private Object leftMember=new BaseObject();
    private Object rightMember=new BaseObject();

    public Object getMeMember() {
        return meMember;
    }

    public void setMeMember(Object meMember) {
        this.meMember = meMember;
    }

    private Object meMember=new BaseObject();

    public Object getLeftMember() {
        return leftMember;
    }

    public void setLeftMember(Object leftMember) {
        this.leftMember = leftMember;
    }

    public Object getRightMember() {
        return rightMember;
    }

    public void setRightMember(Object rightMember) {
        this.rightMember = rightMember;
    }
}
