package com.sky.dao.vo;

import com.google.zxing.client.result.AddressBookAUResultParser;
import com.sky.dao.model.ProductDetail;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/5 0005.
 */
public class RecordDetail implements Serializable{

    private int code =0;

    private String msg;

    private boolean isDraw = true;//true 中奖  false 未中奖

    private String isSend ;

    private ProductDetail product;

    private Address address;

    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ProductDetail getProduct() {
        return product;
    }

    public void setProduct(ProductDetail product) {
        this.product = product;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isDraw() {
        return isDraw;
    }

    public void setDraw(boolean draw) {
        isDraw = draw;
    }

    public String isSend() {
        return isSend;
    }

    public void setSend(String send) {
        isSend = send;
    }
}
