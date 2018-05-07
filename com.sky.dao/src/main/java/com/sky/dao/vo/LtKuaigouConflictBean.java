package com.sky.dao.vo;

import java.util.Date;

/**
 * Created by 建帆 on 2015/12/21.
 */
public class LtKuaigouConflictBean {
    private String ltKuaigouConflictId;
    private String   yunwsParentPhone;
    private String   yunwsPhone;
    private String   kuaigouParentPhone;
    private String   kuaigouPhone;
    private int type;
    private String operationUser;
    private Date createDate;

    public String getLtKuaigouConflictId() {
        return ltKuaigouConflictId;
    }

    public void setLtKuaigouConflictId(String ltKuaigouConflictId) {
        this.ltKuaigouConflictId = ltKuaigouConflictId;
    }

    public String getYunwsParentPhone() {
        return yunwsParentPhone;
    }

    public void setYunwsParentPhone(String yunwsParentPhone) {
        this.yunwsParentPhone = yunwsParentPhone;
    }

    public String getYunwsPhone() {
        return yunwsPhone;
    }

    public void setYunwsPhone(String yunwsPhone) {
        this.yunwsPhone = yunwsPhone;
    }

    public String getKuaigouParentPhone() {
        return kuaigouParentPhone;
    }

    public void setKuaigouParentPhone(String kuaigouParentPhone) {
        this.kuaigouParentPhone = kuaigouParentPhone;
    }

    public String getKuaigouPhone() {
        return kuaigouPhone;
    }

    public void setKuaigouPhone(String kuaigouPhone) {
        this.kuaigouPhone = kuaigouPhone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOperationUser() {
        return operationUser;
    }

    public void setOperationUser(String operationUser) {
        this.operationUser = operationUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
