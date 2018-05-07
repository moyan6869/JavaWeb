package com.sky.dao.express.saien.model.response;

/**
 * Created by Administrator on 2015/12/26.
 */
public class edbTradeGet_order {;
    private String tid;
    private String shop_name;
    private String province;
    private String city;
    private String district;
    private String address;
    private String post;
    private String express_no;
    private String express;
    private String express_coding;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getExpress_no() {
        return express_no;
    }

    public void setExpress_no(String express_no) {
        this.express_no = express_no;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }

    public String getExpress_coding() {
        return express_coding;
    }

    public void setExpress_coding(String express_coding) {
        this.express_coding = express_coding;
    }

    @Override
    public String toString() {
        return "edbTradeGet_order{" +
                "tid='" + tid + '\'' +
                ", shop_name='" + shop_name + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", post='" + post + '\'' +
                ", express_no='" + express_no + '\'' +
                ", express='" + express + '\'' +
                ", express_coding='" + express_coding + '\'' +
                '}';
    }
}
