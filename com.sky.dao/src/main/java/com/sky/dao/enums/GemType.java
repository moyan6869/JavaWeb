package com.sky.dao.enums;

public class GemType {

	/**
	 * 非会员
	 */
	public final static int notMember = 0;
	/**
	 * 金卡
	 */
	public final static int gold = 1;
	/**
	 * 白金卡
	 */
	public final static int whiteGold = 2;
	/**
	 * 钻卡
	 */
	public final static int crown = 3;




	public static String getGemTypeName(int gemType) {
		switch (gemType) {
			case notMember:
				return "非会员";
			case gold:
				return "金卡";
			case whiteGold:
				return "白金卡";
			case crown:
				return "钻卡";
			default:
				return "非会员";
		}
	}
}
