package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
public class MemberDiscount implements Serializable{
    private String memberId;
    private String discountId;
    private Integer counts;
    private Date updateDate;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
