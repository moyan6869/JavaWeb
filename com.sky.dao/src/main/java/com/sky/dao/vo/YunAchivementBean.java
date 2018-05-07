package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created by weiyunliang on 2017/10/17.
 */
public class YunAchivementBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String memberId;
    private String month;
    private String phone;
    private Long monthAchivement;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getMonthAchivement() {
        return monthAchivement;
    }

    public void setMonthAchivement(Long monthAchivement) {
        this.monthAchivement = monthAchivement;
    }
}
