package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

public class ProductOrderSendVo {


    private String system_order_id;
    private String contact;
    private String phone;
    private Date   create_date;
    private Date   pay_date;
    private String address;
    private Integer purchase_quantity;
    private String order_code;
    private Integer delete_flag;
    private String product_id;
    private Integer order_from;
    private Integer status;
    private String pv;
    private String type;
    private String user_name;
    private String user_phone;


    public String getSystem_order_id() {
        return system_order_id;
    }

    public void setSystem_order_id(String system_order_id) {
        this.system_order_id = system_order_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getPay_date() {
        return pay_date;
    }

    public void setPay_date(Date pay_date) {
        this.pay_date = pay_date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPurchase_quantity() {
        return purchase_quantity;
    }

    public void setPurchase_quantity(Integer purchase_quantity) {
        this.purchase_quantity = purchase_quantity;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Integer getOrder_from() {
        return order_from;
    }

    public void setOrder_from(Integer order_from) {
        this.order_from = order_from;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPv() {
        return pv;
    }

    public void setPv(String pv) {
        this.pv = pv;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_phone() {
        return user_phone;
    }

    public void setUser_phone(String user_phone) {
        this.user_phone = user_phone;
    }
}
