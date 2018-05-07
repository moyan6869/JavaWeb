package com.sky.service.directsale.impl;

import com.sky.common.piting.Pager;
import com.sky.common.util.DateUtil;
import com.sky.common.util.DbUtil;
import com.sky.common.util.JdbcModuleDaoSupport2;
import com.sky.common.util.JdbcTemplateDaoSupport;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.model.APISaleAchivementLogBean;
import com.sky.dao.shopapi.AcheivementVo;
import com.sky.dao.shopapi.WarehouseOrder;
import com.sky.service.directsale.ISaleAchivementService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.service.directsale.impl
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/10/7 20:04
 */
@Service("saleAchivementService")
public class SaleAchivementService implements ISaleAchivementService {


    @Override
    public AcheivementVo list(String memberId, String startDate, String endDate) throws Exception {

        Map<String, Object> map = new HashMap<>();
        String sql = " select  count(*) count ,SUM(order_money) sumMoney  FROM warehouse_order " +
                " WHERE delete_flag = 0" +
                " AND order_status in (4 ,8) " +
                " AND pay_date > '"+startDate+"'" +
                " AND pay_date < '"+endDate+"'" +
                " AND warehouse_member_id ='"+memberId+"' ";
        AcheivementVo saleBean = JdbcTemplateDaoSupport.getObject(sql,map,AcheivementVo.class);

        String sql2 = " select  count(*) count ,SUM(order_money) sumMoney  FROM warehouse_order " +
                " WHERE delete_flag = 0" +
                " AND order_status = 8" +
                " AND pay_date > '"+startDate+"'" +
                " AND pay_date < '"+endDate+"'" +
                " AND warehouse_member_id ='"+memberId+"' ";
        AcheivementVo refundBean = JdbcTemplateDaoSupport.getObject(sql2,map,AcheivementVo.class);

        AcheivementVo returnBean = new AcheivementVo();
        if ( 0 != saleBean.getCount()) {

            returnBean.setCount(saleBean.getCount());
            returnBean.setSumMoney(saleBean.getSumMoney());
            if ( 0 != refundBean.getCount()) {
                returnBean.setActivityMoney(saleBean.getSumMoney() - refundBean.getSumMoney());
                System.out.println("WarehouseOrder>>>>>returnBean>>datas>>" + returnBean);
            } else {
                returnBean.setActivityMoney(saleBean.getSumMoney());
            }
        } else {
            returnBean.setCount(0l);
            returnBean.setSumMoney(0l);
            returnBean.setActivityMoney(0l);
        }
        return returnBean;

    }

    public static void main(String[] args) {


        Date now = new Date();

        String startDatestartDate = DateUtil.getStartDate(DateUtil.addDate ("MM",0-2, now));
        String endDate = DateUtil.getEndDate(DateUtil.addDate ("MM",-2, now));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String endDate2 = sdf.format(DateUtil.addDate ("MM",0-1, now));

    }
    //月的第一天
    public static String getStartDate (Date now) {
        SimpleDateFormat sdfyyyy = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfMM = new SimpleDateFormat("MM");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String firstDayOfMonth = DateUtil.getFistDayOfMonth(Integer.parseInt(sdfyyyy.format(now)), Integer.parseInt(sdfMM.format(now)));
        String startDate = firstDayOfMonth + "00:00:00";


        System.out.println("startDate>>>"+ startDate);
        return  startDate;

    }


    //月的最后一天 结束时间
    public static String getEndDate (Date now) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        Date monthLastDay  = DateUtil.getMonthLastDay(new Date());
        String endDate = sdf.format(monthLastDay) + "23:59:59";
        System.out.println("endDate  >>>"+ endDate);
        return endDate;
    }


}
