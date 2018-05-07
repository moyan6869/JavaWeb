package com.sky.dao.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/2/22
 * Description:转账
 */
public class MemberTransferBean implements Serializable{
    private String transferId;
    /**
     * 流水号
     */
    private String transferCode;
    /**
     * 来源
     */
    private Integer transferFrom;
    /**
     * 付款方memberId
     */
    private String outMemberId;
    private String outPhone;
    private String outNickName;
    private String outUserName;
    /**
     * 收款方memberId
     */
    private String inMemberId;
    private String inPhone;
    private String inNickName;
    private String inUserName;
    /**
     * 转帐类型：1：转入，2：转出
     */
    private Integer transferType;
    private String transferTypeStr;
    /**
     * 转账金额
     */
    private Long transferMoney;
    /**
     * 转帐成功标识：0初始化，1成功，2失败
     */
    private Integer status;
    private String statusStr;

    private Date createTime;
    private Date updateTime;
    private Integer deleteFlag;
    /**
     * 交易摘要
     */
    private String transferMemo;


    public String getTransferId() {
        return transferId;
    }

    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }

    public Integer getTransferFrom() {
        return transferFrom;
    }

    public void setTransferFrom(Integer transferFrom) {
        this.transferFrom = transferFrom;
    }

    public String getOutMemberId() {
        return outMemberId;
    }

    public void setOutMemberId(String outMemberId) {
        this.outMemberId = outMemberId;
    }

    public String getInMemberId() {
        return inMemberId;
    }

    public void setInMemberId(String inMemberId) {
        this.inMemberId = inMemberId;
    }

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    public String getTransferTypeStr() {
        return transferTypeStr;
    }

    public void setTransferTypeStr(String transferTypeStr) {
        this.transferTypeStr = transferTypeStr;
    }

    public Long getTransferMoney() {
        return transferMoney;
    }

    public void setTransferMoney(Long transferMoney) {
        this.transferMoney = transferMoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getTransferMemo() {
        return transferMemo;
    }

    public void setTransferMemo(String transferMemo) {
        this.transferMemo = transferMemo;
    }

    public String getOutPhone() {
        return outPhone;
    }

    public void setOutPhone(String outPhone) {
        this.outPhone = outPhone;
    }

    public String getOutNickName() {
        return outNickName;
    }

    public void setOutNickName(String outNickName) {
        this.outNickName = outNickName;
    }

    public String getOutUserName() {
        return outUserName;
    }

    public void setOutUserName(String outUserName) {
        this.outUserName = outUserName;
    }

    public String getInPhone() {
        return inPhone;
    }

    public void setInPhone(String inPhone) {
        this.inPhone = inPhone;
    }

    public String getInNickName() {
        return inNickName;
    }

    public void setInNickName(String inNickName) {
        this.inNickName = inNickName;
    }

    public String getInUserName() {
        return inUserName;
    }

    public void setInUserName(String inUserName) {
        this.inUserName = inUserName;
    }
}
