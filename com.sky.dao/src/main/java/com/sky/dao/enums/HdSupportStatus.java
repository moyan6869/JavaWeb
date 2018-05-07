package com.sky.dao.enums;

public class HdSupportStatus {

	/**
	 * 未计算
	 */
	public final static int start = 0;
	/**
	 * 已计算
	 */
	public final static int calc = 1;
	/**
	 * 已审核
	 */
	public final static int check = 2;
	/**
	 * 已发放
	 */
	public final static int send = 3;

	public static String getGemTypeName(int status) {
		switch (status) {
		case start:
			return "未计算";
		case calc:
			return "已计算";
		case check:
			return "已审核";
		case send:
			return "已发放";
		default:
			return "未计算";
		}
	}
}
