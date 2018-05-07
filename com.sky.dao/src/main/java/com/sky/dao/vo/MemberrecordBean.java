package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by weiyunliang on 2017/9/4.
 */
public class MemberrecordBean implements Serializable {
    private String member_id;
    private String referrer_member_id;//推荐人
    private String old_referrer_member_id;//原来的推荐人
    private String phone;
    private String old_phone;
    private String user_name;
    private String old_use_name;
    private String identity_card;
    private String old_identity_card;
    private int type;
    @JsonIgnore
    private Date create_date;
    @JsonIgnore
    private Date update_date;
    private Integer delete_flag;

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getReferrer_member_id() {
        return referrer_member_id;
    }

    public void setReferrer_member_id(String referrer_member_id) {
        this.referrer_member_id = referrer_member_id;
    }

    public String getOld_referrer_member_id() {
        return old_referrer_member_id;
    }

    public void setOld_referrer_member_id(String old_referrer_member_id) {
        this.old_referrer_member_id = old_referrer_member_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOld_phone() {
        return old_phone;
    }

    public void setOld_phone(String old_phone) {
        this.old_phone = old_phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getOld_use_name() {
        return old_use_name;
    }

    public void setOld_use_name(String old_use_name) {
        this.old_use_name = old_use_name;
    }

    public String getIdentity_card() {
        return identity_card;
    }

    public void setIdentity_card(String identity_card) {
        this.identity_card = identity_card;
    }

    public String getOld_identity_card() {
        return old_identity_card;
    }

    public void setOld_identity_card(String old_identity_card) {
        this.old_identity_card = old_identity_card;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }
}
