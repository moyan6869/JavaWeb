package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by weiyunliang on 2017/12/1.
 */
public class MhopMgmtBean implements Serializable {
    protected String shopId;
    protected String applyMemberId;
    protected String auditor;
    private Integer shopType;
    private Integer status;
    protected String createUser;
    private Date createDate;
    private Integer applyShopType;
    private Integer ratio;




    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getApplyMemberId() {
        return applyMemberId;
    }

    public void setApplyMemberId(String applyMemberId) {
        this.applyMemberId = applyMemberId;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Integer getShopType() {
        return shopType;
    }

    public void setShopType(Integer shopType) {
        this.shopType = shopType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Integer getApplyShopType() {
        return applyShopType;
    }

    public Integer getRatio() {
        return ratio;
    }

    public void setRatio(Integer ratio) {
        this.ratio = ratio;
    }

    public void setApplyShopType(Integer applyShopType) {
        this.applyShopType = applyShopType;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
