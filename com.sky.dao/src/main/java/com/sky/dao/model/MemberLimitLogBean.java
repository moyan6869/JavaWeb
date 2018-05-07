package com.sky.dao.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.math.BigInteger;
import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: Kanger
 * @Description: 会员返本基金额度
 * @Date: 2016/10/22 14:14
 */
public class MemberLimitLogBean {
    @JsonIgnore
    private String memberId;
    private Integer type;
    @JsonIgnore
    private String orderId;
    private BigInteger score;
    private BigInteger sumScore;
    private Date createDate;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public BigInteger getScore() {
        return score;
    }

    public void setScore(BigInteger score) {
        this.score = score;
    }

    public BigInteger getSumScore() {
        return sumScore;
    }

    public void setSumScore(BigInteger sumScore) {
        this.sumScore = sumScore;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
