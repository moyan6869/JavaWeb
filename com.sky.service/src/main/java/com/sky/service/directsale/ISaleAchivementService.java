package com.sky.service.directsale;

import com.sky.common.piting.Pager;
import com.sky.dao.model.APIJoinStatisticsDayBean;
import com.sky.dao.model.APISaleAchivementLogBean;
import com.sky.dao.model.APISaleAchivementMonthBean;
import com.sky.dao.shopapi.AcheivementVo;
import com.sky.dao.shopapi.WarehouseOrder;

import java.util.List;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.service.directsale
 * @company: SIBU Kanger
 * @Description: 会员每月销售业绩
 * @Date: 2016/10/7 19:56
 */
public interface ISaleAchivementService {
    public AcheivementVo list(String memberId, String startDate, String endDate) throws Exception;


}
