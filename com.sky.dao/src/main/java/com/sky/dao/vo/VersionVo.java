package com.sky.dao.vo;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/3/4
 * Description: 版本号
 */
public class VersionVo implements Serializable {

    private String version;

    private boolean needUpdate;

    private String msg;

    public VersionVo() {
    }

    public VersionVo(String version) {
        this.version = version;
    }

    public VersionVo(String version, boolean needUpdate) {
        this.version = version;
        this.needUpdate = needUpdate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isNeedUpdate() {
        return needUpdate;
    }

    public void setNeedUpdate(boolean needUpdate) {
        this.needUpdate = needUpdate;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
