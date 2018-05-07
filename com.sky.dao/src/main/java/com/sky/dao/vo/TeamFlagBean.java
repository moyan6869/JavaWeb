package com.sky.dao.vo;

import java.io.Serializable;

public class TeamFlagBean implements Serializable {

    private String memberId;
    private int incId;
    private int teamId;
    private int teamFlag;


    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public int getIncId() {
        return incId;
    }

    public void setIncId(int incId) {
        this.incId = incId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getTeamFlag() {
        return teamFlag;
    }

    public void setTeamFlag(int teamFlag) {
        this.teamFlag = teamFlag;
    }
}
