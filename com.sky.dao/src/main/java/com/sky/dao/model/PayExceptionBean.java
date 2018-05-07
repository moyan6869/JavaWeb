package com.sky.dao.model;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/8.
 */
public class PayExceptionBean {
private String exception_id;
private String order_code;
private Integer pay_type;
private Integer pay_cash;
private String ex_msg;
private Date create_time;

    public String getException_id() {
        return exception_id;
    }

    public void setException_id(String exception_id) {
        this.exception_id = exception_id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public Integer getPay_cash() {
        return pay_cash;
    }

    public void setPay_cash(Integer pay_cash) {
        this.pay_cash = pay_cash;
    }

    public String getEx_msg() {
        return ex_msg;
    }

    public void setEx_msg(String ex_msg) {
        this.ex_msg = ex_msg;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
