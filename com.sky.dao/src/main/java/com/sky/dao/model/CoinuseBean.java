package com.sky.dao.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by weiyunliang on 2017/7/19.
 */
public class CoinuseBean implements Serializable {


    private String use_change_coin;//换货币
    private int type;//订单类型
    private String order_id;//订单id
    private Date create_time;//创建时间


    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    private String member_id;


    public String getUse_change_coin() {
        return use_change_coin;
    }

    public void setUse_change_coin(String use_change_coin) {
        this.use_change_coin = use_change_coin;
    }


    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }





}
