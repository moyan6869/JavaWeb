/**   
* @Title: RewardCashVo.java 
* @Package com.sibu.dao.directsale.vo 
* @company: SI Bu kanger
* @Description: 全球分红奖vo
* @author zenglinhua
* @date 2016年1月14日 下午7:45:24
* @version V1.0
*/
package com.sky.dao.vo;

import java.io.Serializable;

import com.sky.dao.model.MemberCrownMonthBean;
import com.sky.dao.model.RewardCashLog;
import com.sky.web.model.Member;

/** 
 * @ClassName: RewardCashVo 
 * @Description: 全球分红奖vo 
 * @author zenglinhua
 * @date 2016年1月14日 下午7:45:24 
 *  
 */
public class RewardCashVo implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化 
	*/ 
	private static final long serialVersionUID = 5126317008913365321L;
	
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
	private RewardCashLog rewardCashLog;

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

	public RewardCashLog getRewardCashLog() {
		return rewardCashLog;
	}

	public void setRewardCashLog(RewardCashLog rewardCashLog) {
		this.rewardCashLog = rewardCashLog;
	}

	@Override
	public String toString() {
		return "RewardCashVo [memberCrownMonthBean=" + memberCrownMonthBean
				+ ", member=" + member + ", rewardCashLog=" + rewardCashLog
				+ "]";
	}

	
}
