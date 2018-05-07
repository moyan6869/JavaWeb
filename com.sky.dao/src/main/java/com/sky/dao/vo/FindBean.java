package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Date;

/**
 * Created by weiyunliang on 2017/7/10.
 */
public class FindBean {

    private String notice_id;//发现id
    private String title;//标题
    private String notice_info;//公告具体信息
    private String notice_img1;
    private String notice_img2;
    private String notice_img3;
    private String notice_img4;
    private String notice_img5;
    private String notice_img6;
    private String product_id;
    private String associated_name;//发现活动名称
    private int like_no;//点赞数
    private int is_stick;//是否置顶

    @JsonIgnore
    private Date createDate;//创建时间
//    @JsonIgnore
//    private Date updateDate;
    private Integer deleteFlag;

    public String getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(String notice_id) {
        this.notice_id = notice_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotice_info() {
        return notice_info;
    }

    public void setNotice_info(String notice_info) {
        this.notice_info = notice_info;
    }

    public String getNotice_img1() {
        return notice_img1;
    }

    public void setNotice_img1(String notice_img1) {
        this.notice_img1 = notice_img1;
    }

    public String getNotice_img2() {
        return notice_img2;
    }

    public void setNotice_img2(String notice_img2) {
        this.notice_img2 = notice_img2;
    }

    public String getNotice_img3() {
        return notice_img3;
    }

    public void setNotice_img3(String notice_img3) {
        this.notice_img3 = notice_img3;
    }

    public String getNotice_img4() {
        return notice_img4;
    }

    public void setNotice_img4(String notice_img4) {
        this.notice_img4 = notice_img4;
    }

    public String getNotice_img5() {
        return notice_img5;
    }

    public void setNotice_img5(String notice_img5) {
        this.notice_img5 = notice_img5;
    }

    public String getNotice_img6() {
        return notice_img6;
    }

    public void setNotice_img6(String notice_img6) {
        this.notice_img6 = notice_img6;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getAssociated_name() {
        return associated_name;
    }

    public void setAssociated_name(String associated_name) {
        this.associated_name = associated_name;
    }

    public int getLike_no() {
        return like_no;
    }

    public void setLike_no(int like_no) {
        this.like_no = like_no;
    }

    public int getIs_stick() {
        return is_stick;
    }

    public void setIs_stick(int is_stick) {
        this.is_stick = is_stick;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
