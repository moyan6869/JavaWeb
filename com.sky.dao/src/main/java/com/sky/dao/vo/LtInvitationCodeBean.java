package com.sky.dao.vo;

import java.util.Date;

/**
 * Created by 建帆 on 2015/12/17.
 */
public class LtInvitationCodeBean {

    private String ltInvitationCodeId;
    private String ltInvitationCode;
    private String reffrePhone;
    private String currentPhone;
    private Date createDate;
    private String dealAdmin;

    public String getLtInvitationCodeId() {
        return ltInvitationCodeId;
    }

    public void setLtInvitationCodeId(String ltInvitationCodeId) {
        this.ltInvitationCodeId = ltInvitationCodeId;
    }

    public String getLtInvitationCode() {
        return ltInvitationCode;
    }

    public void setLtInvitationCode(String ltInvitationCode) {
        this.ltInvitationCode = ltInvitationCode;
    }

    public String getReffrePhone() {
        return reffrePhone;
    }

    public void setReffrePhone(String reffrePhone) {
        this.reffrePhone = reffrePhone;
    }

    public String getCurrentPhone() {
        return currentPhone;
    }

    public void setCurrentPhone(String currentPhone) {
        this.currentPhone = currentPhone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDealAdmin() {
        return dealAdmin;
    }

    public void setDealAdmin(String dealAdmin) {
        this.dealAdmin = dealAdmin;
    }
}
