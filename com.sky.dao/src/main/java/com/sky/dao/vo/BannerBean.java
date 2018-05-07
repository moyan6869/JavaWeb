package com.sky.dao.vo;

import java.util.Date;

/**
 * Created by weiyunliang on 2017/7/11.
 */
public class BannerBean {
    private String circle_id;
    private String img_url;
    private String jump_url;
    private int sort_no;
    private Date create_date;



    public String getCircle_id() {
        return circle_id;
    }

    public void setCircle_id(String circle_id) {
        this.circle_id = circle_id;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getJump_url() {
        return jump_url;
    }

    public void setJump_url(String jump_url) {
        this.jump_url = jump_url;
    }

    public int getSort_no() {
        return sort_no;
    }

    public void setSort_no(int sort_no) {
        this.sort_no = sort_no;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
