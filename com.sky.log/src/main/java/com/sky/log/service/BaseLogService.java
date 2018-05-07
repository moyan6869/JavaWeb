package com.sky.log.service;

import com.sky.dao.log.BaseLogBean;

/**
 * Created by Administrator on 2015/11/12.
 */
public interface BaseLogService {
    public boolean WriteLog(BaseLogBean baseLogBean);
}
