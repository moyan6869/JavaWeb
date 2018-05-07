package com.sky.dao.enums;

public enum OrderMemberTypeEnums {

	unknown(0, "未知状态"),
	joinGold(1, "金卡加盟"),
	joinWhite(2,"白金卡加盟"),
	joinCrown(3, "钻卡加盟"),


	goldUpWhite(12,"金卡升级白金卡"),
	goldUpCrown(13,"金卡升级钻卡"),
	whiteUpCrown(23,"白金卡升级钻卡"),



	retail(20, "零售");

	private int code; // 错误代码
	private String msg; // 错误消息

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	private OrderMemberTypeEnums(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public static OrderMemberTypeEnums valueOf(int value) { // 手写的从int到enum的转换函数
		switch (value) {
			case 0:
				return unknown;
			case 1:
				return joinGold;
			case 2:
				return joinWhite;
			case 3:
				return joinCrown;

			case 12:
				return goldUpWhite;
			case 13:
				return goldUpCrown;
			case 23:
				return whiteUpCrown;
			case 20:
				return retail;

			default:
				return unknown;
		}
	}
}
