/**   
* @Title: RewardStatus.java 
* @Package com.sibu.dao.directsale.enums 
* @company: SI Bu kanger
* @Description: 月结奖流转状态 
* @author zenglinhua
* @date 2016年1月8日 下午4:43:07
* @version V1.0
*/
package com.sky.dao.enums;

/** 
 * @ClassName: RewardStatus 
 * @Description: 月结奖流转状态 
 * @author zenglinhua
 * @date 2016年1月8日 下午4:43:07 
 *  
 */
public enum RewardStatus {
	
	none(0, "未获取用户"),
    calc(1, "已获取用户"),
    create(2, "已计算"),
    appPart(3, "部分已审核"),
    appAll(4, "已审核"),
    issue(5, "已发放");

	private int code; //代码
    private String msg; //消息
    
    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private RewardStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RewardStatus valueOf(int value) {
        switch (value) {
            case 0:
                return none;
            case 1:
                return calc;
            case 2:
                return create;
            case 3:
                return appPart;
            case 4:
                return appAll;
            case 5:
                return issue;
            default:
                return none;
        }
    }
}
