package com.sky.dao.model;

import com.sky.dao.vo.BannerBean;
import com.sky.dao.vo.BuylimitBean;
import com.sky.dao.vo.NullObjectBean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by weiyunliang on 2017/7/19.
 */
public class CoinlistBean implements Serializable {

    private List<CoinaddBean> compoundcoinBeen;//币种添加记录
    private List<CoinuseBean> changecoinBeen;//币种使用记录
    private Object ex = new NullObjectBean();//扩展字段

    public Object getEx() {
        return ex;
    }

    public void setEx(Object ex) {
        this.ex = ex;
    }

    public List<CoinaddBean> getCompoundcoinBeen() {
        return compoundcoinBeen;
    }

    public void setCompoundcoinBeen(List<CoinaddBean> compoundcoinBeen) {
        this.compoundcoinBeen = compoundcoinBeen;
    }

    public List<CoinuseBean> getChangecoinBeen() {
        return changecoinBeen;
    }

    public void setChangecoinBeen(List<CoinuseBean> changecoinBeen) {
        this.changecoinBeen = changecoinBeen;
    }
}
