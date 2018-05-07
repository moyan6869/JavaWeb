package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

import com.sky.dao.enums.DataBaseType;
import com.sky.dao.enums.GemType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * MemberBean
 * 
 * @version 1.0
 * @author Geoffrey
 */
public class MemberBeanRedis implements Serializable {
	protected static final long serialVersionUID = 1L;
	protected String memberId;
	protected String headImage;
	protected String phone;
	protected String nickName;
	protected String wechat; 
	protected String wechatOpenId;
	protected String userName;
	protected String identityCard;
	protected Integer memberType=0;
	protected String memberTypeStr;
	protected String placeMemberId;
	protected String leftMemberId;
	protected String rightMemberId;
	protected String referrerMemberId;
	protected String referrerPhone;
	protected String referrerUserName;
	protected String mzgtag;

	public String getReferrerPhone() {
		return referrerPhone;
	}

	public void setReferrerPhone(String referrerPhone) {
		this.referrerPhone = referrerPhone;
	}

	public String getMzgtag() {
		return mzgtag;
	}

	public void setMzgtag(String mzgtag) {
		this.mzgtag = mzgtag;
	}

	public String getReferrerUserName() {
		return referrerUserName;
	}

	public void setReferrerUserName(String referrerUserName) {
		this.referrerUserName = referrerUserName;
	}

	public String getReferrerMemberId() {
		return referrerMemberId;
	}

	public void setReferrerMemberId(String referrerMemberId) {
		this.referrerMemberId = referrerMemberId;
	}

	private Date joinDate;
	public String getHeadImage() {
		return headImage;
	}

//	@Override
//	public String toString() {
//		return "MemberBeanRedis [headImage=" + headImage + ", phone=" + phone
//				+ ", nickName=" + nickName + ", wechat=" + wechat
//				+ ", wechatOpenId=" + wechatOpenId + ", userName=" + userName
//				+ ", identityCard=" + identityCard + "]";
//	}

	@Override
	public String toString() {
		return "MemberBeanRedis{" +
				"memberId='" + memberId + '\'' +
				", headImage='" + headImage + '\'' +
				", phone='" + phone + '\'' +
				", nickName='" + nickName + '\'' +
				", wechat='" + wechat + '\'' +
				", wechatOpenId='" + wechatOpenId + '\'' +
				", userName='" + userName + '\'' +
				", identityCard='" + identityCard + '\'' +
				", memberType=" + memberType +
				", memberTypeStr='" + memberTypeStr + '\'' +
				", placeMemberId='" + placeMemberId + '\'' +
				", leftMemberId='" + leftMemberId + '\'' +
				", rightMemberId='" + rightMemberId + '\'' +
				", referrerMemberId='" + referrerMemberId + '\'' +
				", joinDate=" + joinDate +
				'}';
	}

	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getWechatOpenId() {
		return wechatOpenId;
	}

	public void setWechatOpenId(String wechatOpenId) {
		this.wechatOpenId = wechatOpenId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public Integer getMemberType() {
		return memberType;
	}

	public void setMemberType(Integer memberType) {
		this.memberType = memberType;
	}

	public String getMemberTypeStr() {
		return GemType.getGemTypeName(memberType);
	}

	public void setMemberTypeStr(String memberTypeStr) {
		this.memberTypeStr = memberTypeStr;
	}

	public String getPlaceMemberId() {
		return placeMemberId;
	}

	public void setPlaceMemberId(String placeMemberId) {
		this.placeMemberId = placeMemberId;
	}

	public String getLeftMemberId() {
		return leftMemberId;
	}

	public void setLeftMemberId(String leftMemberId) {
		this.leftMemberId = leftMemberId;
	}

	public String getRightMemberId() {
		return rightMemberId;
	}

	public void setRightMemberId(String rightMemberId) {
		this.rightMemberId = rightMemberId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		MemberBeanRedis that = (MemberBeanRedis) o;

		return new EqualsBuilder()
				.append(memberId, that.memberId)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(memberId)
				.toHashCode();
	}
}
