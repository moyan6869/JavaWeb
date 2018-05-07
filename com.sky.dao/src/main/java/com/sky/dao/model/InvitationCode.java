/**   
* @Title: InvitationCode.java 
* @Package com.sibu.dao.directsale.model 
* @company: SI Bu kanger
* @Description: TODO(用一句话描述该文件做什么) 
* @author xiaoheliu
* @date 2016年1月5日 下午9:17:41
* @version V1.0
*/
package com.sky.dao.model;

/** 
 * @ClassName: InvitationCode 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author xiaoheliu
 * @date 2016年1月5日 下午9:17:41 
 *  
 */
public class InvitationCode {
	
	private long invitationCode;
	private String randomNum;
	private String memberId;
	private String referenceMemberId;
	
	public long getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(long invitationCode) {
		this.invitationCode = invitationCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getReferenceMemberId() {
		return referenceMemberId;
	}
	public void setReferenceMemberId(String referenceMemberId) {
		this.referenceMemberId = referenceMemberId;
	}
	public String getRandomNum() {
		return randomNum;
	}
	public void setRandomNum(String randomNum) {
		this.randomNum = randomNum;
	}
	
}
