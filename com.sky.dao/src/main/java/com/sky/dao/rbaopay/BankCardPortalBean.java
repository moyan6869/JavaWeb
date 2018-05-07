package com.sky.dao.rbaopay;

/**
 * Created by Administrator on 2017/12/1.
 */
public class BankCardPortalBean {
    private String merchant_id; //商户在融宝的账户ID
    private String member_id; //用户ID
    private String order_no;//商户订单号
    private String result_code;//返回码 0000表示成功
    private String bind_id;//绑卡ID
    private String result_msg;//错误信息描述
    private String bank_name;//银行名称
    private String bank_code;//银行编码
    private String transtime;//
    private String creat_time;//

    private String card_no;//银行卡号
    private String owner;//持卡人姓名
    private String cert_no;//身份证号码
    private String phone;//用户在银行预留手机号
    private Integer bank_card_type;//银行卡类型 0 储蓄卡；1 信用卡

    private String cvv2;//信用卡背后的3位数字
    private String validthru;//卡有效期 (月年格式 例如2020年09月应写为0920)

    private String certificate ;//0 未认证（不下发短信，需调用卡密接口） 1 已认证（自动发送短信）

    private String card_last;

    private String status;

    private String timestamp;

    private String total_fee;
    private String trade_no;

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
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

    public String getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(String creat_time) {
        this.creat_time = creat_time;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getResult_msg() {
        return result_msg;
    }

    public void setResult_msg(String result_msg) {
        this.result_msg = result_msg;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
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

    public String getCard_last() {
        return card_last;
    }

    public void setCard_last(String card_last) {
        this.card_last = card_last;
    }

    public String getTranstime() {
        return transtime;
    }

    public void setTranstime(String transtime) {
        this.transtime = transtime;
    }
}
