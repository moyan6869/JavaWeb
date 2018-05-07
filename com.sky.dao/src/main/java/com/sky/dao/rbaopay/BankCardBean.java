package com.sky.dao.rbaopay;

import java.util.Date;

/**
 * Created by Administrator on 2017/12/2.
 */
public class BankCardBean {

        private String bank_id; //主键ID
        private String member_id; //用户ID
        private String bind_id;//绑卡ID
        private String bank_name;//银行名称
        private String bank_code;//银行编码
        private String transtime;//
        private Date creat_time;//
        private String card_no;//银行卡号
        private String owner;//持卡人姓名
        private String cert_no;//身份证号码
        private String phone;//用户在银行预留手机号
        private Integer bank_card_type;//银行卡类型 0 储蓄卡；1 信用卡

        private String cvv2;//信用卡背后的3位数字
        private String validthru;//卡有效期 (月年格式 例如2020年09月应写为0920)

        private String certificate ;//0 未认证（不下发短信，需调用卡密接口） 1 已认证（自动发送短信）

    public String getBank_id() {
        return bank_id;
    }

    public void setBank_id(String bank_id) {
        this.bank_id = bank_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getBind_id() {
        return bind_id;
    }

    public void setBind_id(String bind_id) {
        this.bind_id = bind_id;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    public String getBank_code() {
        return bank_code;
    }

    public void setBank_code(String bank_code) {
        this.bank_code = bank_code;
    }

    public String getTranstime() {
        return transtime;
    }

    public void setTranstime(String transtime) {
        this.transtime = transtime;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    public String getCard_no() {
        return card_no;
    }

    public void setCard_no(String card_no) {
        this.card_no = card_no;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCert_no() {
        return cert_no;
    }

    public void setCert_no(String cert_no) {
        this.cert_no = cert_no;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getBank_card_type() {
        return bank_card_type;
    }

    public void setBank_card_type(Integer bank_card_type) {
        this.bank_card_type = bank_card_type;
    }

    public String getCvv2() {
        return cvv2;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public String getValidthru() {
        return validthru;
    }

    public void setValidthru(String validthru) {
        this.validthru = validthru;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "BankCardBean{" +
                "member_id='" + member_id + '\'' +
                ", bind_id='" + bind_id + '\'' +
                ", bank_name='" + bank_name + '\'' +
                ", bank_code='" + bank_code + '\'' +
                ", transtime='" + transtime + '\'' +
                ", creat_time='" + creat_time + '\'' +
                ", card_no='" + card_no + '\'' +
                ", owner='" + owner + '\'' +
                ", cert_no='" + cert_no + '\'' +
                ", phone='" + phone + '\'' +
                ", bank_card_type=" + bank_card_type +
                ", cvv2='" + cvv2 + '\'' +
                ", validthru='" + validthru + '\'' +
                ", certificate='" + certificate + '\'' +
                '}';
    }
}
