package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * MemberBean
 * 
 * @version 1.0
 * @author Geoffrey
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MemberBean extends MemberBeanRedis implements Serializable {
	private static final long serialVersionUID = 1L;

	//自增ID
	private int incId;

	//邀请码，由incId+两位随机数字生成 StringUtil.randomTwo()
	private long inviteCode;
	private String password;
	private String secondPwd;
	private String salt;
	private Integer freezeType;
	private Date freezeDate;
	private String freezeReason;
	private String referrerMemberId;
	private  int upFlag;
//	private String headImage;
//	private String phone;
//	private String identityCard;
//	private String userName;
//	private String nickName;
	private int memberFrom;
	private int yunType;
	private Integer memberTypeYun;
	private int teamFlag;

	@JsonIgnore
	private Date createDate;
	@JsonIgnore
	private Date updateDate;
	private Integer deleteFlag;
	private String proxyMemberId;
	private Integer osId;

	@JsonIgnore
	private String referrerPhone;
	@JsonIgnore
	private String referrerUserName;
	@JsonIgnore
	private String cont;//安卓预留
	@JsonIgnore
	private Integer memberSource;
	private Integer shopType;

	private  int leaderLevel;

	private int whiteCounts; //直推白金代理个数[培育奖计算用]
	private int presentCounts;//系统赠送直推白金资格个数
	private int registerMemberType;  //注册级别

	//导入系统的唯一标识
	private String memberNo;
	@JsonIgnore
	private String mzgtag;

	public int getWhiteCounts() {
		return whiteCounts;
	}

	public void setWhiteCounts(int whiteCounts) {
		this.whiteCounts = whiteCounts;
	}

	public int getPresentCounts() {
		return presentCounts;
	}

	public void setPresentCounts(int presentCounts) {
		this.presentCounts = presentCounts;
	}

	public int getRegisterMemberType() {
		return registerMemberType;
	}

	public void setRegisterMemberType(int registerMemberType) {
		this.registerMemberType = registerMemberType;
	}

	public int getUpFlag() {
		return upFlag;
	}

	public void setUpFlag(int upFlag) {
		this.upFlag = upFlag;
	}

	public String getMzgtag() {
		return mzgtag;
	}

	public void setMzgtag(String mzgtag) {
		this.mzgtag = mzgtag;
	}

	@Override
	public String getReferrerPhone() {
		return referrerPhone;
	}

	@Override
	public void setReferrerPhone(String referrerPhone) {
		this.referrerPhone = referrerPhone;
	}

	public Integer getShopType() {
		return shopType;
	}

	public void setShopType(Integer shopType) {
		this.shopType = shopType;
	}

	@Override
	public String getReferrerUserName() {
		return referrerUserName;
	}

	@Override
	public void setReferrerUserName(String referrerUserName) {
		this.referrerUserName = referrerUserName;
	}

	public Integer getMemberTypeYun() {
		return memberTypeYun;
	}

	public void setMemberTypeYun(Integer memberTypeYun) {
		this.memberTypeYun = memberTypeYun;
	}

	public int getMemberFrom() {
		return memberFrom;
	}

	public Integer getMemberSource() {
		return memberSource;
	}

	public void setMemberSource(Integer memberSource) {
		this.memberSource = memberSource;
	}

	public void setMemberFrom(int memberFrom) {
		this.memberFrom = memberFrom;
	}

	public int getYunType() {
		return yunType;
	}

	public int getLeaderLevel() {
		return leaderLevel;
	}

	public void setLeaderLevel(int leaderLevel) {
		this.leaderLevel = leaderLevel;
	}

	public void setYunType(int yunType) {
		this.yunType = yunType;
	}


	public int getTeamFlag() {
		return teamFlag;
	}

	public void setTeamFlag(int teamFlag) {
		this.teamFlag = teamFlag;
	}

	@Override
	public String getHeadImage() {
		return headImage;
	}

	@Override
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}

	@Override
	public String getPhone() {
		return phone;
	}

	@Override
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String getIdentityCard() {
		return identityCard;
	}

	@Override
	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	@Override
	public String getUserName() {
		return userName;
	}

	@Override
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String getNickName() {
		return nickName;
	}

	@Override
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}

	public String getSecondPwd() {
		return secondPwd;
	}

	public void setSecondPwd(String secondPwd) {
		this.secondPwd = secondPwd;
	}

	public int getIncId() {
		return incId;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public void setIncId(int incId) {
		this.incId = incId;
	}

	public Integer getFreezeType() {
		return freezeType;
	}

	public void setFreezeType(Integer freezeType) {
		this.freezeType = freezeType;
	}

	public Date getFreezeDate() {
		return freezeDate;
	}

	public void setFreezeDate(Date freezeDate) {
		this.freezeDate = freezeDate;
	}


	public String getFreezeReason() {
		return freezeReason;
	}

	public void setFreezeReason(String freezeReason) {
		this.freezeReason = freezeReason;
	}

	public long getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(long inviteCode) {
		this.inviteCode = inviteCode;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}




	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	@JsonIgnore()
	public String getCredentialsSalt()
	{
		return phone+salt;
	}

	public String getReferrerMemberId() {
		return referrerMemberId;
	}

	public void setReferrerMemberId(String referrerMemberId) {
		this.referrerMemberId = referrerMemberId;
	}
	

	public String getProxyMemberId() {
		return proxyMemberId;
	}

	public void setProxyMemberId(String proxyMemberId) {
		this.proxyMemberId = proxyMemberId;
	}

	public Integer getOsId() {
		return osId;
	}

	public void setOsId(Integer osId) {
		this.osId = osId;
	}


	@Override
	public String toString() {
		return "MemberBean{" +
				"inviteCode=" + inviteCode +
				", password='" + password + '\'' +
				", salt='" + salt + '\'' +
				", incId=" + incId +
				", freezeType=" + freezeType +
				", freezeDate=" + freezeDate +
				", freezeReason='" + freezeReason + '\'' +
				", referrerMemberId='" + referrerMemberId + '\'' +
				", secondPwd='" + secondPwd + '\'' +
				", memberFrom=" + memberFrom +
				", yunType=" + yunType +
				", memberTypeYun=" + memberTypeYun +
				", teamFlag=" + teamFlag +
				", upFlag=" + upFlag +
				", createDate=" + createDate +
				", updateDate=" + updateDate +
				", deleteFlag=" + deleteFlag +
				", proxyMemberId='" + proxyMemberId + '\'' +
				", osId=" + osId +
				'}';
	}
}
