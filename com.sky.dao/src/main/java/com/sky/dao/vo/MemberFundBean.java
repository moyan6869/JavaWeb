package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created by chuhui on 2017/3/20.
 * 功能：预存款流水记录备bean
 */
public class MemberFundBean implements Serializable {
    private String fund_id;//主键uuid
    private String member_id;//会员id
    private String sort_index;//流水排序
    private String fund_code;//预存编号
    private String type;//交易类型
    private String fund_money;//交易金额（分）：进为正数、出为负数
    private String fund_sum_money;//当前总金额（分）：正负都累积
    private String fund_total_money;//累积充值金额（分）：只累积充值金额
    private String create_time;//创建时间
    private String update_time;//修改时间
    private String delete_flag;//删除标志
    private String in_out_member_id;//转账来源/去向会员编号
    private String order_code;//订单编号

    public String getFund_id() {
        return fund_id;
    }

    public void setFund_id(String fund_id) {
        this.fund_id = fund_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getSort_index() {
        return sort_index;
    }

    public void setSort_index(String sort_index) {
        this.sort_index = sort_index;
    }

    public String getFund_code() {
        return fund_code;
    }

    public void setFund_code(String fund_code) {
        this.fund_code = fund_code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFund_money() {
        return fund_money;
    }

    public void setFund_money(String fund_money) {
        this.fund_money = fund_money;
    }

    public String getFund_sum_money() {
        return fund_sum_money;
    }

    public void setFund_sum_money(String fund_sum_money) {
        this.fund_sum_money = fund_sum_money;
    }

    public String getFund_total_money() {
        return fund_total_money;
    }

    public void setFund_total_money(String fund_total_money) {
        this.fund_total_money = fund_total_money;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public String getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(String delete_flag) {
        this.delete_flag = delete_flag;
    }

    public String getIn_out_member_id() {
        return in_out_member_id;
    }

    public void setIn_out_member_id(String in_out_member_id) {
        this.in_out_member_id = in_out_member_id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }
}
