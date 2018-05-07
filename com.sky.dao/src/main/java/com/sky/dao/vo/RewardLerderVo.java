/**   
* @Title: RewardLerderVo.java 
* @Package com.sibu.dao.directsale.vo 
* @company: SI Bu kanger
* @Description: 领导奖明细vo
* @author zenglinhua
* @date 2016年1月11日 下午1:22:19
* @version V1.0
*/
package com.sky.dao.vo;

import java.io.Serializable;

import com.sky.dao.model.MemberCrownMonthBean;
import com.sky.dao.model.RewardLeaderLog;
import com.sky.web.model.Member;

/** 
 * @ClassName: RewardLerderVo 
 * @Description: 领导奖明细vo
 * @author zenglinhua
 * @date 2016年1月11日 下午1:22:19 
 *  
 */
public class RewardLerderVo implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化
	*/ 
	private static final long serialVersionUID = -7891885278695361442L;
	
	/**
	 * 获得提成的业绩信息
	 */
	private MemberCrownMonthBean memberCrownMonth;
	
	/**
	 * 被提成的业绩信息
	 */
	private MemberCrownMonthBean crownMemberCrownMonth;

	/**
	 * 奖励信息
	 */
	private RewardLeaderLog rewardLeader;
	
	/**
	 * 获得提成的会员
	 */
	private Member member;
	
	/**
	 * 被提成的会员
	 */
	private Member crownMember;

	public RewardLeaderLog getRewardLeader() {
		return rewardLeader;
	}

	public void setRewardLeader(RewardLeaderLog rewardLeader) {
		this.rewardLeader = rewardLeader;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Member getCrownMember() {
		return crownMember;
	}

	public void setCrownMember(Member crownMember) {
		this.crownMember = crownMember;
	}

	public MemberCrownMonthBean getMemberCrownMonth() {
		return memberCrownMonth;
	}

	public void setMemberCrownMonth(MemberCrownMonthBean memberCrownMonth) {
		this.memberCrownMonth = memberCrownMonth;
	}

	public MemberCrownMonthBean getCrownMemberCrownMonth() {
		return crownMemberCrownMonth;
	}

	public void setCrownMemberCrownMonth(MemberCrownMonthBean crownMemberCrownMonth) {
		this.crownMemberCrownMonth = crownMemberCrownMonth;
	}
	
	
}
