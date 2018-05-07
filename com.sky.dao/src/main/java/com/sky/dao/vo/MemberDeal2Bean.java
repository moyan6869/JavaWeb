package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

/**
 * MemberDealBean
 *
 * @author dao
 * @version 1.0
 */
public class MemberDeal2Bean implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonIgnore()
    private String memberId;
    private String did;
    private BigInteger sortIndex;
    private String Code;
    private long money;
    private int typeId;
    private String typeName;
    private int status;
    private String statusStr;
    private Date createDate;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }


    public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

    public BigInteger getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(BigInteger sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}

