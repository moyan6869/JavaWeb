/**   
* @Title: RewardCarVo.java 
* @Package com.sibu.dao.directsale.vo 
* @company: SI Bu kanger
* @Description: 豪车奖vo 
* @author zenglinhua
* @date 2016年1月14日 下午7:44:53
* @version V1.0
*/
package com.sky.dao.vo;

import java.io.Serializable;

import com.sky.dao.model.MemberCrownMonthBean;
import com.sky.dao.model.RewardCarLog;
import com.sky.web.model.Member;

/** 
 * @ClassName: RewardCarVo 
 * @Description: 豪车奖vo
 * @author zenglinhua
 * @date 2016年1月14日 下午7:44:53 
 *  
 */
public class RewardCarVo implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化 
	*/ 
	private static final long serialVersionUID = 4153514715544509963L;

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
	private RewardCarLog rewardCarLog;

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

	public RewardCarLog getRewardCarLog() {
		return rewardCarLog;
	}

	public void setRewardCarLog(RewardCarLog rewardCarLog) {
		this.rewardCarLog = rewardCarLog;
	}

	@Override
	public String toString() {
		return "RewardCarVo [memberCrownMonthBean=" + memberCrownMonthBean
				+ ", member=" + member + ", rewardCarLog=" + rewardCarLog + "]";
	}
	
	
}
