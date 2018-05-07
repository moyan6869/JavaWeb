package com.sky.web.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by 建帆 on 2015/11/11.
 */
public class Member  implements Serializable {
    private static final long serialVersionUID = 1L;
    //	@JsonIgnore
    private String memberId;
    private String headImage;
    private String phone;
    private String nickName;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String wechat;
    private Integer memberType=0;
    private String referrerMemberId;
    private String referrerUserName;
    private String identityCard;
    private Date createDate;
	private Integer freezeType;
	private Date freezeDate;
	private String freezeReason;
	private String proxyMemberId;
    //报单时间
    private Date appDate;
    //复购有效期
    private Date stopDate;
    /**
     * 团队活跃期
     */
    private Date teamStopDate;
    /**
     *
     */
    private Integer isMemberTeam;
    //团队当月是否有活跃点
    private boolean teamMemberIsActive;
    private long monthMeMoney;
    //本月团队业绩
    private long monthMoney;
    //冠级名称
    private String silverCrownName;
    //报单级别名称
    private String gemnumName;
    private Integer inviteCode;


    //运营id
    private Integer osId;

    public Integer getIsMemberTeam() {
        return isMemberTeam;
    }

    public void setIsMemberTeam(Integer isMemberTeam) {
        this.isMemberTeam = isMemberTeam;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public Date getTeamStopDate() {
        return teamStopDate;
    }

    public void setTeamStopDate(Date teamStopDate) {
        this.teamStopDate = teamStopDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
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

	public String getProxyMemberId() {
		return proxyMemberId;
	}

	public void setProxyMemberId(String proxyMemberId) {
		this.proxyMemberId = proxyMemberId;
	}

	public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public long getMonthMeMoney() {
        return monthMeMoney;
    }

    public void setMonthMeMoney(long monthMeMoney) {
        this.monthMeMoney = monthMeMoney;
    }

    public long getMonthMoney() {
        return monthMoney;
    }

    public void setMonthMoney(long monthMoney) {
        this.monthMoney = monthMoney;
    }

    public String getGemnumName() {
        return gemnumName;
    }

    public String getSilverCrownName() {
        return silverCrownName;
    }

    public void setSilverCrownName(String silverCrownName) {
        this.silverCrownName = silverCrownName;
    }


    public void setGemnumName(String gemnumName) {
        this.gemnumName = gemnumName;
    }

    public Integer getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(Integer inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }
    public String getReferrerUserName() { return referrerUserName;    }

    public void setReferrerUserName(String referrerUserName) {        this.referrerUserName = referrerUserName;    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
    public Integer getMemberType() {
        return memberType;
    }

    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    public String getReferrerMemberId() {
        return referrerMemberId;
    }

    public void setReferrerMemberId(String referrerUserId) {
        this.referrerMemberId = referrerUserId;
    }

    public boolean isTeamMemberIsActive() {
        return teamMemberIsActive;
    }

    public void setTeamMemberIsActive(boolean teamMemberIsActive) {
        this.teamMemberIsActive = teamMemberIsActive;
    }
    public Integer getOsId() {
        return osId;
    }

    public void setOsId(Integer osId) {
        this.osId = osId;
    }
    @Override
	public String toString() {
		return "Member [memberId=" + memberId + ", headImage=" + headImage + ", phone="
				+ phone + ", nickName=" + nickName + ", wechat=" + wechat + ", memberType=" + memberType
				+ ", referrerUserId=" + referrerMemberId + ", referrerUserName=" + referrerUserName
				+ "]";
	}
}
