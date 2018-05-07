package com.sky.common.profitUtil;

import com.sky.common.bean.StatusBean;

import java.sql.Connection;

/**
 * Created with IntelliJ IDEA.
 * User: qiujingwang
 * Date: 2016/2/23
 * Description:
 */
public interface ConnectionCallBack {
    StatusBean execute(Connection connection) throws Exception;
}
