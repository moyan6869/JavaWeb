package com.sky.dao.model;

import java.io.Serializable;

/**
 * Created by weiyunliang on 2017/7/26.
 */
public class CoinBean implements Serializable {
   private Long  compound_coin;
    private Long  change_coin;

    public Long getCompound_coin() {
        return compound_coin;
    }

    public void setCompound_coin(Long compound_coin) {
        this.compound_coin = compound_coin;
    }

    public Long getChange_coin() {
        return change_coin;
    }

    public void setChange_coin(Long change_coin) {
        this.change_coin = change_coin;
    }
}
