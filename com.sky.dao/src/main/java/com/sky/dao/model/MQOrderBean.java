package com.sky.dao.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/27.
 */
public class MQOrderBean  implements Serializable{
	private static final long serialVersionUID = -4499270990780305606L;
	private String memberId;
    private String orderId;
    //private Integer status ;  // 默认0 ，1为宝石报单,2为钻石报单，3为金钻报单
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

	@Override
	public String toString() {
		return "MQOrderBean [memberId=" + memberId + ", orderId=" + orderId + "]";
	}
	
	/*
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	*/
}
