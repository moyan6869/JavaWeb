package com.sky.dao.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by weiyunliang on 2017/7/19.
 */
public class CoinaddBean implements Serializable {
    private int pageOffset; //当前的页数
    private int pageSize; //一页显示多少条
    private long totalRecord; //总记录数
    private int totalPage; //总页数

    private String bonus_id;
    private String order_id;
    private int compound_coin;
    private int change_coin;
    private Date create_time;
    private int type; //流动方向（0流出，1流入，11复消币发放 12换货币发放）
    private int flow_money; //流动金额

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }



    public int getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(int pageOffset) {
        this.pageOffset = pageOffset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public String getBonus_id() {
        return bonus_id;
    }

    public void setBonus_id(String bonus_id) {
        this.bonus_id = bonus_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public int getCompound_coin() {
        return compound_coin;
    }

    public void setCompound_coin(int compound_coin) {
        this.compound_coin = compound_coin;
    }

    public int getChange_coin() {
        return change_coin;
    }

    public void setChange_coin(int change_coin) {
        this.change_coin = change_coin;
    }


    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFlow_money() {
        return flow_money;
    }

    public void setFlow_money(int flow_money) {
        this.flow_money = flow_money;
    }
}
