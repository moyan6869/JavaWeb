package com.sky.dao.enums;

public class RawStatus {
	
	/*
	 * 业绩表 没有 挂起和取消状态
	 * 收益 都有
	 */
	public final static int raw = 0; // 初始状态（raw data）

	public final static int normal = 1; // 正常状态（raw data）

	//public final static int hang = 2; // 挂起(暂时冻结)（raw data）

	//public final static int cancel = 3; // 取消（raw data）

	public final static int refund = 4; // 退单 退收益（raw data)

	public final static int change_normal = 10; // 调整数据，原始数据变更为正常（new data）

	//public final static int change_hang = 11;// 调整数据，原始数据变更为挂机（new data）

	//public final static int change_cancel = 12; // 调整数据，原始数据变更为取消（new data）

	public final static int change_refund = 13; // 调整数据,原始数据变为退单 退收益(new data)

	
	public static String getName(int key) {
		switch (key) {
		case raw:
			return "正常";
		case normal:
			return "正常";
		//case hang:
		//	return "挂起";
		//case cancel:
		//	return "取消";
		case refund:
			return "退单";
		case change_normal:
			return "正常(调整数据)";
		//case change_hang:
		//	return "挂起(调整数据)";
		//case change_cancel:
		//	return "取消(调整数据)";
		case change_refund:
			return "退单(调整数据)";
		default:
			return "";
		}
	}
}
