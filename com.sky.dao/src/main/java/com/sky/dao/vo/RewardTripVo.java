/**   
* @Title: RewardTripVo.java 
* @Package com.sibu.dao.directsale.vo 
* @company: SI Bu kanger
* @Description: 海外旅游奖vo
* @author zenglinhua
* @date 2016年1月14日 下午7:45:53
* @version V1.0
*/
package com.sky.dao.vo;

import java.io.Serializable;

import com.sky.dao.model.MemberCrownMonthBean;
import com.sky.dao.model.RewardTripLog;
import com.sky.web.model.Member;

/** 
 * @ClassName: RewardTripVo 
 * @Description: 海外旅游奖vo 
 * @author zenglinhua
 * @date 2016年1月14日 下午7:45:53 
 *  
 */
public class RewardTripVo implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化 
	*/ 
	private static final long serialVersionUID = 1753329487415993201L;
	
	/**
	 * 月信息
	 */
	private MemberCrownMonthBean memberCrownMonthBean;
	
	/**
	 * 会员信息
	 */
	private Member member;

	/**
	 * 奖励信息
	 */
	private RewardTripLog rewardTripLog;

	public MemberCrownMonthBean getMemberCrownMonthBean() {
		return memberCrownMonthBean;
	}

	public void setMemberCrownMonthBean(MemberCrownMonthBean memberCrownMonthBean) {
		this.memberCrownMonthBean = memberCrownMonthBean;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public RewardTripLog getRewardTripLog() {
		return rewardTripLog;
	}

	public void setRewardTripLog(RewardTripLog rewardTripLog) {
		this.rewardTripLog = rewardTripLog;
	}

	@Override
	public String toString() {
		return "RewardTripVo [memberCrownMonthBean=" + memberCrownMonthBean
				+ ", member=" + member + ", rewardTripLog=" + rewardTripLog
				+ "]";
	}
	
	
}
