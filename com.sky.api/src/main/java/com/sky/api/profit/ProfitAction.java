package com.sky.api.profit;

import com.sky.common.MsgHelp;
import com.sky.common.massage.ResponseUtil;
import com.sky.common.piting.Pager;
import com.sky.common.util.JdbcModuleDaoSupport2;
import com.sky.common.util.SessionUtil;
import com.sky.common.util.StringUtil;
import com.sky.common.util.Version;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.model.*;
import com.sky.dao.shopapi.CoinBalanceBean;
import com.sky.dao.shopapi.HomePageVo;
import com.sky.dao.vo.FoodWareHouse;
import com.sky.dao.vo.HomepageBean;
import com.sky.dao.vo.MemberBean;
import com.sky.service.directsale.MemberProfitService;
import com.sky.service.directsale.MemberService;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 功能：收益列表
 *
 * @author
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/profit", produces = "application/json")
public class ProfitAction {

    private Logger log = Logger.getLogger(ProfitAction.class);
    /**
     * 收益服务接口
     */
    @Resource
    MemberProfitService memberProfitService;

    @Resource
    MemberService memberService;


    /**
     * 获取个人中心首页
     * @param version
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/homePage", method = RequestMethod.GET)
    @ResponseBody

    public String getHomePage(String version,String username) throws Exception {
        if (Version.V10.equals(version)) {
            FoodWareHouse user = SessionUtil.getSessionByUserName(username);
            if (StringUtil.isNull(user)){
                return ResponseUtil.error(MsgHelp.NOT_LOGIN);
            }
            HomePageVo homePageVo = new HomePageVo();

            String sql = "select * from member_money_total where member_id = :memberId  limit 1 ";
            MemberMoneyTotalBean memberMoneyTotalBean = new MemberMoneyTotalBean();
            memberMoneyTotalBean.setMemberId(user.getMemberId());
            memberMoneyTotalBean = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.PROFIT_DATA, sql, memberMoneyTotalBean, user.getMemberId());
            if (StringUtil.isNull(memberMoneyTotalBean)) {
                homePageVo.setSupplyCoin(0l);//如果没有此账户的金额信息，设置补货币为0元
            } else {
                homePageVo.setSupplyCoin(memberMoneyTotalBean.getSupplyCoin());//补货币金额
            }

            homePageVo.setUsername(user.getUsername());
            homePageVo.setFoodWarehouseType(user.getFoodWarehouseType());
            homePageVo.setWarehouseName(user.getWarehouseName());
            homePageVo.setAddress(user.getAddress());
            homePageVo.setContact(user.getContact());
            homePageVo.setPhone(user.getPhone());
            homePageVo.setHeadImage(user.getHeadImage());
            homePageVo.setWarehouseCode(user.getWarehouseCode());

            return ResponseUtil.data(homePageVo);
        }
        return ResponseUtil.unknownVersion();
    }



    /**
     * 收益提现列表
     *
     * @param pageOffset 页码
     * @param pageSize   页数
     * @param version    接口版本号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/supplycoinlist", method = RequestMethod.GET)
    @ResponseBody
//    @RequiresAuthentication
    public String supplycoinlist(String pageOffset, String pageSize, String version, String username) throws Exception {
        if (StringUtil.isNull(pageOffset)) {
            pageOffset = "1";
        }
        if (StringUtil.isNull(pageSize)) {
            pageSize = "15";
        }
        if (StringUtil.isNumeric(pageOffset)) {
            return ResponseUtil.error(MsgHelp.PAGE_OFFSET_MUST_NUM);
        }
        if (Version.V10.equals(version)) {

            FoodWareHouse user = SessionUtil.getSessionByUserName(username);
            if (StringUtil.isNull(user)){
                return ResponseUtil.error(MsgHelp.NOT_LOGIN);
            }

            Pager<CoinBalanceBean> page = new Pager<CoinBalanceBean>();
            page.setPageOffset(Integer.parseInt(pageOffset));
            page.setPageSize(Integer.parseInt(pageSize));
            page = memberProfitService.getSupplyCoinList(user.getMemberId(), page);

            return ResponseUtil.data(page);
        }
        return ResponseUtil.unknownVersion();
    }

    /*获取返本基金*/
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    @ResponseBody
//    @RequiresAuthentication
    public String getReBackFund(String username, String supplyCoin , String warehouseCode, String version) throws Exception {
        if (Version.V10.equals(version)) {
            FoodWareHouse outUser = SessionUtil.getSessionByUserName(username);
            if (StringUtil.isNull(outUser)){
                return ResponseUtil.error(MsgHelp.NOT_LOGIN);
            }
            FoodWareHouse inUser = memberService.getByWarehouseCode(warehouseCode);
            if (StringUtil.isNull(inUser)){
                return ResponseUtil.error(MsgHelp.OUT_WAREHOUSR_IS_NOT_FUND);
            }
            if(inUser.getMemberId().equals(outUser.getMemberId())){
                return ResponseUtil.error("亲，不能给自己转账！");
            }

            Long supplyCoin2 = Long.parseLong(supplyCoin);

            if (StringUtil.isNull(supplyCoin)) {
                return ResponseUtil.error("请输入转账金额！");
            }
            if (supplyCoin2 < 0) {
                return ResponseUtil.error("转账金额必须大于0！");
            }
            if (supplyCoin2 > 1000000) {
                return ResponseUtil.error("单次转账金额不能超过100万！");
            }
            Long userCoin = memberProfitService.getSupplyCoin(outUser.getMemberId());
            log.error("userCoin>>>>>>>>>" +userCoin/100);
            if (supplyCoin2 > userCoin ) {
                return ResponseUtil.error("余额不足,转账金额不能超过: "+userCoin/100+" ");
            }

            if (memberProfitService.tansferSupplyCoin(inUser.getMemberId(),outUser.getMemberId(),supplyCoin2).getStatus()) {
                return ResponseUtil.success("转账成功！");
            } else {
                return ResponseUtil.error("操作失败");
            }

        }
        return ResponseUtil.unknownVersion();
    }





}


