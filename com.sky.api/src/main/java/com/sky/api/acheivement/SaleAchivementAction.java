package com.sky.api.acheivement;

import com.sky.common.MsgHelp;
import com.sky.common.massage.ResponseUtil;
import com.sky.common.piting.Pager;
import com.sky.common.util.DateUtil;
import com.sky.common.util.SessionUtil;
import com.sky.common.util.StringUtil;
import com.sky.common.util.Version;
import com.sky.dao.model.APISaleAchivementLogBean;
import com.sky.dao.shopapi.AcheivementVo;
import com.sky.dao.shopapi.WarehouseOrder;
import com.sky.dao.vo.FoodWareHouse;
import com.sky.service.directsale.ISaleAchivementService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.api.achivement
 * @company: SIBU Kanger
 * @Description: 销售业绩
 * @Date: 2016/10/7 19:54
 */
@Controller
@RequestMapping(value = "/saleachivment", produces = "application/json")
public class SaleAchivementAction {

    @Resource
    ISaleAchivementService saleAchivementService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String list(String username, Integer month, String version, HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (Version.V10.equals(version)) {
            String startDate ="";
            String endDate ="";
            Date now = new Date();

            if (StringUtil.isNull(month) || month == 0){
                startDate = DateUtil.getStartDate(now);
                endDate = DateUtil.getEndDate(now);
            } else if ( month == 1) {
                startDate = DateUtil.getStartDate(DateUtil.addDate ("MM",0-month, now));
                endDate = DateUtil.getEndDate(DateUtil.addDate ("MM",0-month, now));
            } else if ( month == 2) {
                startDate = DateUtil.getStartDate(DateUtil.addDate ("MM",0-month, now));
                endDate = DateUtil.getEndDate(DateUtil.addDate ("MM",0-month, now));
            }
            //缓存获取用户对象bean
            FoodWareHouse user = SessionUtil.getSessionByUserName(username);
            String memberId = user.getMemberId();


            AcheivementVo bean = saleAchivementService.list(memberId,startDate,endDate);
            if(StringUtil.isNull(bean)){
                return ResponseUtil.error("没有数据！");
            }
            bean.setStartDate(startDate);
            bean.setEndDate(endDate);
            return ResponseUtil.data(bean);
        }
        return ResponseUtil.unknownVersion();
    }



}
