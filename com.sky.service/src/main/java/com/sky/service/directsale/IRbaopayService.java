package com.sky.service.directsale;

import com.sky.dao.rbaopay.BankCardBean;
import com.sky.dao.rbaopay.BankCardPortalBean;

/**
 * Created by Administrator on 2017/12/3.
 */
public interface IRbaopayService {
    /**
     * 增加支付用的  储蓄卡或银行卡
     * @param bankCardPortalBean
     * @return
     */
    public boolean addBankCard (BankCardPortalBean bankCardPortalBean) ;


    /**
     * 查询 bankcard
     * @param card_no
     * @param member_id
     * @return
     */
    public BankCardBean get(String card_no, String member_id) ;



    /**
     * 更新银行预留手机号
     * @param bankCardPortalBean
     * @return
     */
    public boolean updatePhone (BankCardPortalBean bankCardPortalBean) ;
}
