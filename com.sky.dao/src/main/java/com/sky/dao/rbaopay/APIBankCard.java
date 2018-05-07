package com.sky.dao.rbaopay;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
public class APIBankCard {

    private String merchant_id;
    private String member_id;
    private String result_code;
    private String result_msg;

    private List<BankCard> bind_card_list;


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

    public List<BankCard> getBind_card_list() {
        return bind_card_list;
    }

    public void setBind_card_list(List<BankCard> bind_card_list) {
        this.bind_card_list = bind_card_list;
    }

    @Override
    public String toString() {
        return "APIBankCard{" +
                "merchant_id='" + merchant_id + '\'' +
                ", member_id='" + member_id + '\'' +
                ", bind_card_list=" + bind_card_list +
                '}';
    }
}
