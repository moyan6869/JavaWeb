package com.sky.dao.log;

import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/2/22
 * Description:金额转出、支付失败日志记录
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "typeName")
public class TransferFailureLogBean extends BaseLogBean {

    private static final long serialVersionUID = 1L;

    public TransferFailureLogBean() {
        super();
    }

    private String payerMemberId;//付款方

    private Long payerAvailableMoney;//付款方当前可用余额

    private String payeeMemberId;//收款方

    private String memberBalanceId;//交易流水表ID

    private String memberTransferId;//转帐业务表ID

    private Long transferMoney;//转帐金额

    private Integer transferType;//4:转入, 5转出、6:支付 类型，目前只记录转出 @see MemberTransferType

    public String getPayerMemberId() {
        return payerMemberId;
    }

    public void setPayerMemberId(String payerMemberId) {
        this.payerMemberId = payerMemberId;
    }

    public Long getPayerAvailableMoney() {
        return payerAvailableMoney;
    }

    public void setPayerAvailableMoney(Long payerAvailableMoney) {
        this.payerAvailableMoney = payerAvailableMoney;
    }

    public String getPayeeMemberId() {
        return payeeMemberId;
    }

    public void setPayeeMemberId(String payeeMemberId) {
        this.payeeMemberId = payeeMemberId;
    }

    public String getMemberBalanceId() {
        return memberBalanceId;
    }

    public void setMemberBalanceId(String memberBalanceId) {
        this.memberBalanceId = memberBalanceId;
    }

    public String getMemberTransferId() {
        return memberTransferId;
    }

    public void setMemberTransferId(String memberTransferId) {
        this.memberTransferId = memberTransferId;
    }

    public Long getTransferMoney() {
        return transferMoney;
    }

    public void setTransferMoney(Long transferMoney) {
        this.transferMoney = transferMoney;
    }

    public Integer getTransferType() {
        return transferType;
    }

    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    @Override
    public String toString() {
        return "TransferFailureLogBean{" +
                "payerMemberId='" + payerMemberId + '\'' +
                ", payerAvailableMoney=" + payerAvailableMoney +
                ", payeeMemberId='" + payeeMemberId + '\'' +
                ", memberBalanceId='" + memberBalanceId + '\'' +
                ", memberTransferId='" + memberTransferId + '\'' +
                ", transferMoney=" + transferMoney +
                ", transferType=" + transferType +
                '}';
    }
}