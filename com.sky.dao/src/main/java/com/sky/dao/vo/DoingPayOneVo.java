package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: chuhui
 * Date: 2017/4/24
 * Description:一元夺宝余额支付类
 */
public class DoingPayOneVo implements Serializable {

    /**
     * 付款memberId
     */
    private String memberId;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 短信验证码

     */
    private String checkNumber;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }




    @Override
    public String toString() {
        return "DoingPayOrderVo{" +
                " memberId='" + memberId + '\'' +
                ", password='" + password + '\'' +
                ", checkNumber='" + checkNumber + '\'' +
                '}';
    }
}

