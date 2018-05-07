/**   
* @Title: MemberDealInfoVo.java 
* @Package com.sibu.dao.directsale.vo 
* @company: SI Bu kanger
* @Description: 用户提现信息vo
* @author zenglinhua
* @date 2016年1月20日 上午9:51:35
* @version V1.0
*/
package com.sky.dao.vo;

import java.io.Serializable;

/** 
 * @ClassName: MemberDealInfoVo 
 * @Description: 用户提现信息vo
 * @author zenglinhua
 * @date 2016年1月20日 上午9:51:35 
 *  
 */
public class MemberDealInfoVo implements Serializable {

	/** 
	* @Fields serialVersionUID : 序列化
	*/ 
	private static final long serialVersionUID = 6579678470510528488L;

	/**
	 * 提现信息
	 */
	private MemberDealBean memberDealBean;
	
	/**
	 * 账号信息
	 */
	private MemberAccountBean memberAccountBean;
    
	/**
	 * 用户信息
	 */
	private MemberBean memberBean;
	
	/**
	 * 月累计提现金额
	 */
	private long monthApplyMoney;
	
	/**
	 * 本次打款金额
	 */
	private long thisGiveMoney;
	
	/**
	 * 本次查询打款总金额
	 */
	private long queryGiveMoney = 0;
	
	/**
	 * 本页查询打款总金额
	 */
	private long pageGiveMoney = 0;
	
	public MemberDealBean getMemberDealBean() {
		return memberDealBean;
	}

	public void setMemberDealBean(MemberDealBean memberDealBean) {
		this.memberDealBean = memberDealBean;
	}

	public MemberAccountBean getMemberAccountBean() {
		return memberAccountBean;
	}

	public void setMemberAccountBean(MemberAccountBean memberAccountBean) {
		this.memberAccountBean = memberAccountBean;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public long getMonthApplyMoney() {
		return monthApplyMoney;
	}

	public void setMonthApplyMoney(long monthApplyMoney) {
		this.monthApplyMoney = monthApplyMoney;
	}

	public long getThisGiveMoney() {
		return thisGiveMoney;
	}

	public void setThisGiveMoney(long thisGiveMoney) {
		this.thisGiveMoney = thisGiveMoney;
	}

	public long getQueryGiveMoney() {
		return queryGiveMoney;
	}

	public void setQueryGiveMoney(long queryGiveMoney) {
		this.queryGiveMoney = queryGiveMoney;
	}

	public long getPageGiveMoney() {
		return pageGiveMoney;
	}

	public void setPageGiveMoney(long pageGiveMoney) {
		this.pageGiveMoney = pageGiveMoney;
	}
	
}
