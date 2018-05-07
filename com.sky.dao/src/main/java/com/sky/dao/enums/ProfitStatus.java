package com.sky.dao.enums;

/**
 * 收益状态（冻结，解冻，挂起）
 * Created by Administrator on 2015/10/22.
 */
public enum ProfitStatus {

    /**
     * 未知状态
     */
    Unknown(-1, "未知状态"),
    /**
     * 冻结
     */
    Freeze(0, "冻结"),
    /**
     *解冻
     */
    Unfreeze(1, "解冻"),
    /**
     * 挂起
     */
    Hangup(2,"挂起"),
	
	/*
	 * 撤销,如果记录已经解冻，则该状态继续保持 为 解冻
	 */
	Refund(3,"撤销");
	
    private int code; //代码
    private String desc; //描述


    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    private ProfitStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public static ProfitStatus valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 0:
                return Freeze;
            case 1:
                return Unfreeze;
            case 2:
                return Hangup;
            case 3:
            	return Refund;
            default:
                return Unknown;
        }
    }
}
