package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;

/**
 * AddressBean
 *
 * @author Geoffrey
 * @version 1.0
 */
public class BankBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int bankId = 0;
    private String bankName;
    private String bankLogo;

    @JsonIgnore()
    private int isEnable;

    public int getBankId() {
        return bankId;
    }

    public void setBankId(int bankId) {
        this.bankId = bankId;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankLogo() {
        return bankLogo;
    }

    public void setBankLogo(String bankLogo) {
        this.bankLogo = bankLogo;
    }

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
    }
}

