package com.sky.dao.model;

import java.util.Date;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.model
 * @company: Kanger
 * @Description: 描述
 * @Date: 2016/10/22 15:09
 */
public class ReBackFundMemberFreenBean {
    private int type;
    private String typeStr;
    private int freezeProfitMoney;
    private Date createDate;//数据库是 create_time,修改是为了时间输出表示统一



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public int getFreezeProfitMoney() {
        return freezeProfitMoney;
    }

    public void setFreezeProfitMoney(int freezeProfitMoney) {
        this.freezeProfitMoney = freezeProfitMoney;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
