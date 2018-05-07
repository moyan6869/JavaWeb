package com.sky.dao.enums;

public class OrderProfitStatus {
	public static final int PROFIT_NONE = 0;  // 订单is_profit未计算状态
	public static final int PROFIT_CALC = 1;  // 订单is_profit计算中状态
	public static final int PROFIT_NOT_JOIN = 2; // 未安置
	public static final int PROFIT_SUCCESS  = 3; // 已完成
	public static final int PROFIT_ERROR = 4; // 计算错误


	public static final int REFUND_NONE = 10; //订单退款收益状态未计算
	public static final int REFUND_CALC = 11; //订单退款收益状态计算中
	public static final int REFUND_SUCCESS = 12; //订单退款收益状态计算成功
	public static final int REFUND_ERROR = 13; //订单退款收益状态计算成功

	public static final int NO_PROFIT=20;//此订单不计算收益
}
