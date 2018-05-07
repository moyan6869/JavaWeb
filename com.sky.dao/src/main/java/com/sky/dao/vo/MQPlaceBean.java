package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/10/27.
 */
public class MQPlaceBean  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6784889526017342262L;
	private String memberId;
    
    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

	@Override
	public String toString() {
		return "MQPlaceBean [memberId=" + memberId + "]";
	}

}
