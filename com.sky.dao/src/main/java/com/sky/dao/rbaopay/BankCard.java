package com.sky.dao.rbaopay;

/**
 * Created by Administrator on 2017/12/2.
 */
public class BankCard {

    private String merchant_id;
    private String member_id;
    private String bank_card_type;
    private String bank_name;
    private String bank_code;
    private String bind_id;
    private String card_last;
    private String card_top;
    private String phone;
    private String result_code;//签约错误列表
    private String result_msg;

    public String getMerchant_id() {
        return merchant_id;
    }

    public void setMerchant_id(String merchant_id) {
        this.merchant_id = merchant_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getBank_card_type() {
        return bank_card_type;
    }

    public void setBank_card_type(String bank_card_type) {
        this.bank_card_type = bank_card_type;
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

    public String getBind_id() {
        return bind_id;
    }

    public void setBind_id(String bind_id) {
        this.bind_id = bind_id;
    }

    public String getCard_last() {
        return card_last;
    }

    public void setCard_last(String card_last) {
        this.card_last = card_last;
    }

    public String getCard_top() {
        return card_top;
    }

    public void setCard_top(String card_top) {
        this.card_top = card_top;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return "BankCard{" +
                "merchant_id='" + merchant_id + '\'' +
                ", member_id='" + member_id + '\'' +
                ", bank_card_type='" + bank_card_type + '\'' +
                ", bank_name='" + bank_name + '\'' +
                ", bank_code='" + bank_code + '\'' +
                ", bind_id='" + bind_id + '\'' +
                ", card_last='" + card_last + '\'' +
                ", card_top='" + card_top + '\'' +
                ", phone='" + phone + '\'' +
                ", result_code='" + result_code + '\'' +
                ", result_msg='" + result_msg + '\'' +
                '}';
    }
}
