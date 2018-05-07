package com.sky.dao.enums;

//新零售的团队标示
public class TeamFlag {


	/**
	 * ODO正常会员
	 */
	public final static int ODO = 1;
	/**
	 * 共赢国际
	 */
	public final static int GY = 2;
	/**
	 * 康鸿
	 */
	public final static int KH = 3;

	/**
	 * 泽鸿(王剑波)
	 */
	public final static int ZHW = 4;
	/**
	 * 井冈山
	 */
	public final static int JGS = 5;

	/**
	 * 海葵
	 */
	public final static int HK = 6;
	/**
	 * 龙腾
	 */
	public final static int LT = 7;
	/**
	 * 正弘
	 */
	public final static int ZH = 8;
	/**
	 * 海纳 (培育奖考核独立)
	 */
	public final static int HN = 9;
	/**
	 * 正道(无极系统会员)
	 */
	public final static int ZD = 10;
	/**
	 * 海天(不知道是不是海天酱油的= =)
	 */
	public final static int HT = 11;
	/**
	 * 正道2(无极系统会员)
	 */
	public final static int ZD_2 = 12;
	/**
	 * 正道3(无极系统会员)
	 */
	public final static int ZD_3 = 13;



	//    判断是否是正弘  正道  海天团队的标识
	public final static boolean isTeamFlag( int teamFlag) {
		if(teamFlag== TeamFlag.ZH||teamFlag== TeamFlag.ZD||teamFlag== TeamFlag.HT
				||teamFlag== TeamFlag.ZD_2||teamFlag== TeamFlag.ZD_3){
			return true;
		}
		return false;
	}


	public static String getTeamFlagName(int type) {
		switch (type) {
			case ODO:
				return "ODO";
			case GY:
				return "共赢";
			case KH:
				return "康鸿";
			case ZHW:
				return "泽鸿";
			case JGS:
				return "井冈山";
			case HK:
				return "海葵";
			case LT:
				return "龙腾";
			case ZH:
				return "正弘";
			case HN:
				return "海纳";
			case ZD:
				return "正道";
			case HT:
				return "海天";
			case ZD_2:
				return "正道2";
			case ZD_3:
				return "正道3";
			default:
				return "ODO";
		}
	}
}
