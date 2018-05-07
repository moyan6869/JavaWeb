package com.sky.service.directsale;

import com.sky.common.piting.Pager;
import com.sky.dao.model.APIJoinStatisticsDayBean;
import com.sky.dao.model.APIRetailAchivementLogBean;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.service.directsale
 * @company: SIBU Kanger
 * @Description: 会员零售业绩
 * @Date: 2016/10/7 19:56
 */
public interface IRetailAchivementService {
    public Pager<APIRetailAchivementLogBean> list(String memberId,Integer month, Pager<APIRetailAchivementLogBean> page) throws Exception;
}
