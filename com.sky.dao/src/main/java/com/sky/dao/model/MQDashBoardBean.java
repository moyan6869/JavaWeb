package com.sky.dao.model;

import java.io.Serializable;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company:  Kanger
 * @Description: 仪表盘消息体
 * @Date: 2016/10/21 15:46
 */
public class MQDashBoardBean implements Serializable{
    private static final long serialVersionUID = 1L;
    //会员ID
    private String memberId;
    //消息类型 0、会员注册，1、订单支付，2、转账，3、提现，4、推送发货，5、物流发货，6、物流签收，7、系统确认签收，8、会员报单，9、升级钻石，10、升级金钻
    private int type;
    //根据type类型识别，订单ID，转账ID，提现ID
    private String infoId;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }
}
