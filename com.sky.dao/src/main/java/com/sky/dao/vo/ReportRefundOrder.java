package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 建帆 on 2016/1/8.
 */
public class ReportRefundOrder implements Serializable{
    private String memberName;
    private String memberPhoen; 
    private String memberIdenticard;
    private String orderCode;
    private double totalMoney;
    private Date refundDate;
    private String refundRemark;

    private String reffrenmemberName;
    private String reffrenmemberPhoen;
    private String reffrenmemberIdenticard;

    private String departmentHeadName;
    private String departmentHeadPhone;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberPhoen() {
        return memberPhoen;
    }

    public void setMemberPhoen(String memberPhoen) {
        this.memberPhoen = memberPhoen;
    }

    public String getMemberIdenticard() {
        return memberIdenticard;
    }

    public void setMemberIdenticard(String memberIdenticard) {
        this.memberIdenticard = memberIdenticard;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public String getRefundRemark() {
        return refundRemark;
    }

    public void setRefundRemark(String refundRemark) {
        this.refundRemark = refundRemark;
    }

    public String getReffrenmemberName() {
        return reffrenmemberName;
    }

    public void setReffrenmemberName(String reffrenmemberName) {
        this.reffrenmemberName = reffrenmemberName;
    }

    public String getReffrenmemberPhoen() {
        return reffrenmemberPhoen;
    }

    public void setReffrenmemberPhoen(String reffrenmemberPhoen) {
        this.reffrenmemberPhoen = reffrenmemberPhoen;
    }

    public String getReffrenmemberIdenticard() {
        return reffrenmemberIdenticard;
    }

    public void setReffrenmemberIdenticard(String reffrenmemberIdenticard) {
        this.reffrenmemberIdenticard = reffrenmemberIdenticard;
    }

    public String getDepartmentHeadName() {
        return departmentHeadName;
    }

    public void setDepartmentHeadName(String departmentHeadName) {
        this.departmentHeadName = departmentHeadName;
    }

    public String getDepartmentHeadPhone() {
        return departmentHeadPhone;
    }

    public void setDepartmentHeadPhone(String departmentHeadPhone) {
        this.departmentHeadPhone = departmentHeadPhone;
    }
}
