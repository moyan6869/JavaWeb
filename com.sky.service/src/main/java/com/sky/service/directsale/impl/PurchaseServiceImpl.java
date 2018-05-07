package com.sky.service.directsale.impl;

import com.sky.common.bean.StatusBean;
import com.sky.common.piting.Pager;
import com.sky.common.profitUtil.ConnectionCallBack;
import com.sky.common.profitUtil.JdbcCommandInfo;
import com.sky.common.profitUtil.JdbcModuleDaoSupport;
import com.sky.common.util.*;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.enums.MemberTransferType;
import com.sky.dao.log.TransferFailureLogBean;
import com.sky.dao.model.ProductDetail;
import com.sky.dao.vo.*;
import com.sky.kafka.IKafkaProducer;
import com.sky.service.directsale.IPurchaseService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by Administrator on 2017/4/20 0020.
 */
@Service("purchaseService")
public class PurchaseServiceImpl implements IPurchaseService {
    private Logger log = Logger.getLogger(PurchaseServiceImpl.class);
    private IKafkaProducer sysLogProducer;
    private int totalCount = 0;
    private int userNumber = 0;
    private IKafkaProducer memberMessageProducer;
    private String pname;
    private int isLottery;
    private int lotteryTAG;


    @Override
    public List<LuckIndianaProduct> getActivities() {
        String nowDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//        String sql = "select * from luck_indiana_product where status = 0 and total_quantity >0 and " +
//                "start_date < '" + nowDate + "' and end_date > '" + nowDate + "' and consume_quantity < total_quantity";
        String sql  = "select * from luck_indiana_product where status = 0";
        List<LuckIndianaProduct> productList = JdbcTemplateDaoSupport.getList(sql, new LuckIndianaProduct());
        if (StringUtil.isNull(productList)) {
            return new ArrayList<LuckIndianaProduct>();
        }
        for (int i = 0; i < productList.size(); i++) {
            ProductDetail productDetail = new ProductDetail();
            StringBuffer sqlb = new StringBuffer();
            sqlb.append("select p.category_id, p.product_id, p.name, p.short_name, p.size, p.brand,p.sales, p.desc, p.details, p.remark, p.retail_price, p.market_price, p.is_profit ,p.member_type,p.group_id, " +
                    "pi.thumb_url, pi.bannel_thumb1, pi.bannel_thumb2, pi.bannel_thumb3, pi.bannel_thumb4, pi.bannel_thumb5, pi.banner_image1, pi.banner_image2, pi.banner_image3, pi.banner_image4, pi.banner_image5 " +
                    "from product p left join product_image pi on p.product_id = pi.product_id where 1=1 AND p.delete_flag=0");
            sqlb.append(" and p.product_id = '" + productList.get(i).getProductId() + "'");
            productDetail = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sqlb.toString(), productDetail, DbUtil.getMod4DbRandom());
            productList.get(i).setProductDetail(productDetail);
            ///////////////////////////////////////////
            int total_quantity = productList.get(i).getTotalQuantity();
            String luckId = productList.get(i).getLuckId();
            String sqll = "select IFNULL(MAX(luck_product_index),0) from luck_indiana_buyrecord where  luck_id ='" + luckId + "' and is_lottery='1'";
            int count = JdbcTemplateDaoSupport.count(sqll, null);
            if (count >= total_quantity) {
                productList.get(i).setOutOfDate(true);
            }//活动过期

                String sqll2 = "select IFNULL(SUM(buy_number),0) from luck_indiana_buyrecord where  luck_id ='" + luckId + "' and is_pay='1' and luck_product_index ='" + (count + 1) + "' ";
                int buySum = JdbcTemplateDaoSupport.count(sqll2, null);
                productList.get(i).setTotalPayNumber(buySum);
                productList.get(i).setMount(count + 1);
        }

        return productList;
    }

    @Override
    public LuckIndianaProduct getActivity(String productId, String luckId, int mount) {
        Date nowDate = new Date();
        String sql = "select * from luck_indiana_product where luck_id = '" + luckId + "' limit 1";
        LuckIndianaProduct luckIndianaProduct = JdbcTemplateDaoSupport.getObjectDateInfo(sql, new LuckIndianaProduct());
        if (luckIndianaProduct.getStatus() != 0) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("此活动已下架！");
            return luckIndianaProduct;
        } else if (!(luckIndianaProduct.getStartDate().before(nowDate) && (luckIndianaProduct.getEndDate().after(nowDate)))) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("不在活动期间！");
            return luckIndianaProduct;
        } else if (!(luckIndianaProduct.getConsumeQuantity() < luckIndianaProduct.getTotalQuantity())) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("商品已销售一空！");
            return luckIndianaProduct;
        } else {
            ProductDetail productDetail = new ProductDetail();
            StringBuffer sqlb = new StringBuffer();
            sqlb.append("select p.category_id, p.product_id, p.name, p.short_name, p.size, p.brand,p.sales, p.desc, p.details, p.remark, p.retail_price, p.market_price, p.is_profit ,p.member_type,p.group_id, " +
                    "pi.thumb_url, pi.bannel_thumb1, pi.bannel_thumb2, pi.bannel_thumb3, pi.bannel_thumb4, pi.bannel_thumb5, pi.banner_image1, pi.banner_image2, pi.banner_image3, pi.banner_image4, pi.banner_image5 " +
                    "from product p left join product_image pi on p.product_id = pi.product_id where 1=1 AND p.delete_flag=0");
            sqlb.append(" and p.product_id = '" + luckIndianaProduct.getProductId() + "'");
            productDetail = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sqlb.toString(), productDetail, DbUtil.getMod4DbRandom());
            luckIndianaProduct.setProductDetail(productDetail);
//          String sqll2="select IFNULL(SUM(buy_number),0) from luck_indiana_buyrecord where  luck_id ='"+luckIndianaProduct.getLuckId()+"' and luck_product_index ='"+mount+"'";
            String sqll = "select IFNULL(MAX(luck_product_index),0) from luck_indiana_buyrecord where  luck_id ='" + luckId + "' and is_lottery='1'";
            int count = JdbcTemplateDaoSupport.count(sqll, null);
            String sqll2 = "select IFNULL(SUM(buy_number),0) from luck_indiana_buyrecord where  luck_id='" + luckId + "' and is_pay='1' and luck_product_index='" + (count + 1) + "'";
            int buySum = JdbcTemplateDaoSupport.count(sqll2, null);

            luckIndianaProduct.setTotalPayNumber(buySum);

            return luckIndianaProduct;
        }
    }

    public RecordDetail getrecorddetail(String memberId, String buyId){
        RecordDetail recordDetail = new RecordDetail();
        try {
            //1.判断是否中奖，返回参数给前端用来校验是否可以点进去
            String sql = "select * from luck_indiana_buyrecord where buy_id = '" + buyId + "'";
            LuckIndianaBuyrecord luckIndianaBuyrecord = JdbcTemplateDaoSupport.getObjectDateInfo(sql, new LuckIndianaBuyrecord());
            if (StringUtil.isNull(luckIndianaBuyrecord)) {
                recordDetail.setCode(1);
                recordDetail.setMsg("数据错误");
                return recordDetail;
            }
            if (StringUtil.isNull(luckIndianaBuyrecord.getRefOrderCode())) {
                recordDetail.setDraw(false);
                recordDetail.setProduct(getProduct(buyId));
                return recordDetail;
            }
            //2.判断是否已经领取
            if (luckIndianaBuyrecord.getIsSend() == -1) {//已领取
                recordDetail.setSend("-1");
                recordDetail.setDate(luckIndianaBuyrecord.getCreateDate());
                recordDetail.setAddress(getAddress(buyId));
                recordDetail.setProduct(getProduct(buyId));
                return recordDetail;
            } else if (luckIndianaBuyrecord.getIsSend() == 0) {//未发放
                recordDetail.setSend("0");
                recordDetail.setDate(luckIndianaBuyrecord.getCreateDate());
                recordDetail.setAddress(getAddress(buyId));
                recordDetail.setProduct(getProduct(buyId));
                return recordDetail;
            } else if (luckIndianaBuyrecord.getIsSend() == 1) {//已发放
                recordDetail.setSend("1");
                recordDetail.setDate(luckIndianaBuyrecord.getCreateDate());
                recordDetail.setAddress(getAddress(buyId));
                recordDetail.setProduct(getProduct(buyId));
                return recordDetail;
            }
        }catch (Exception e){
            recordDetail.setCode(1);
            recordDetail.setMsg("数据错误");
            return recordDetail;
        }
        return recordDetail;
    }

    public Address getAddress(String buyId){
        String sql = "select express_name,express_code,contact,phone,address from reissue_order where order_code = (select ref_order_code from luck_indiana_buyrecord where buy_id='"+buyId+"')";
        Address bean = JdbcTemplateDaoSupport.getObjectDateInfo(sql,new Address());
        if(StringUtil.isNull(bean)){
            return new Address();
        }
        if(StringUtil.isNull(bean.getExpressName())){
            bean.setExpressName("暂无");
        }
        if(StringUtil.isNull(bean.getExpressCode())){
            bean.setExpressCode("暂无");
        }
        return bean;
    }

    public ProductDetail getProduct(String buyId){
        StringBuffer sqlb = new StringBuffer();
        sqlb.append("select p.category_id, p.product_id, p.name, p.short_name, p.size, p.brand,p.sales, p.desc, p.details, p.remark, p.retail_price, p.market_price, p.is_profit ,p.member_type,p.group_id, " +
                "pi.thumb_url, pi.bannel_thumb1, pi.bannel_thumb2, pi.bannel_thumb3, pi.bannel_thumb4, pi.bannel_thumb5, pi.banner_image1, pi.banner_image2, pi.banner_image3, pi.banner_image4, pi.banner_image5 " +
                "from product p left join product_image pi on p.product_id = pi.product_id where 1=1 AND p.delete_flag=0");
        sqlb.append(" and p.product_id = (select product_id from luck_indiana_buyrecord where buy_id='"+buyId+"')");
        ProductDetail productDetail = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sqlb.toString(),new ProductDetail(), DbUtil.getMod4DbRandom());
        if(StringUtil.isNull(productDetail)){return new ProductDetail();}
        return productDetail;
    }


    @Override
    public Pager<LuckIndianaBuyrecord> getActivityRecord(String memberId, String productId, int pageOffset, int pageSize) {
        Pager<LuckIndianaBuyrecord> pager = new Pager<LuckIndianaBuyrecord>();
        String sql = "select * from luck_indiana_buyrecord where member_id = '" + memberId + "' order by create_date desc limit " + (pageOffset - 1) * pageSize + "," + pageSize;
        List<LuckIndianaBuyrecord> list = JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA, sql, new LuckIndianaBuyrecord(), DbUtil.getMod4DbRandom());
        if (StringUtil.isNull(list)) {
            pager.setDatas(new ArrayList<LuckIndianaBuyrecord>());
            pager.setPageOffset(pageOffset);
            pager.setPageSize(pageSize);
            pager.setTotalRecord(0);
            pager.setTotalPage(0);
            return pager;
        }
        for (int i = 0; i < list.size(); i++) {
            //产品详情
            LuckIndianaBuyrecord luckIndianaBuyrecord = list.get(i);
            StringBuffer sqlb = new StringBuffer();
            sqlb.append("select p.name, " +
                    "pi.thumb_url " +
                    "from product p left join product_image pi on p.product_id = pi.product_id where 1=1 AND p.delete_flag=0");
            sqlb.append(" and p.product_id = '" + luckIndianaBuyrecord.getProductId() + "'");
            ProductDetail productDetail = new ProductDetail();
            productDetail = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sqlb.toString(), productDetail, DbUtil.getMod4DbRandom());
            luckIndianaBuyrecord.setProductDetail(productDetail);

            if (luckIndianaBuyrecord.getIsLottery() == 0) {
                luckIndianaBuyrecord.setStatStr("未开奖");
                luckIndianaBuyrecord.setStat("0");
            } else if (luckIndianaBuyrecord.getIsLottery() == 1 && luckIndianaBuyrecord.getIsDraw() == 1 && luckIndianaBuyrecord.getIsSend() == 0) {
                luckIndianaBuyrecord.setStatStr("未领取");
                luckIndianaBuyrecord.setStat("2");
            } else if (luckIndianaBuyrecord.getIsLottery() == 1 && luckIndianaBuyrecord.getIsDraw() == 1 && luckIndianaBuyrecord.getIsSend() == -1) {
                luckIndianaBuyrecord.setStatStr("已领取");
                luckIndianaBuyrecord.setStat("3");
            } else if (luckIndianaBuyrecord.getIsLottery() == 1 && luckIndianaBuyrecord.getIsDraw() == 1 && luckIndianaBuyrecord.getIsSend() == 1) {
                luckIndianaBuyrecord.setStatStr("已发货");
                luckIndianaBuyrecord.setStat("4");
            } else if (luckIndianaBuyrecord.getIsLottery() == 1 && luckIndianaBuyrecord.getIsDraw() == 0) {
                String sqlll = "select nick_name from member where member_id=(select member_id from luck_indiana_buyrecord where luck_product_index='" + luckIndianaBuyrecord.getLuckProductIndex() + "' " +
                        "and product_id='" + luckIndianaBuyrecord.getProductId() + "' and luck_id='" + luckIndianaBuyrecord.getLuckId() + "' and ref_order_code <> '') limit 1";
                Member member = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sqlll, new Member(), DbUtil.getMod4DbRandom());
                luckIndianaBuyrecord.setLuckManName(member.getNickName());
                luckIndianaBuyrecord.setStatStr("未中奖");
                luckIndianaBuyrecord.setStat("1");
            }
            continue;
        }
        String sql2 = "select count(*) from luck_indiana_buyrecord where member_id='" + memberId + "'";
        int count = JdbcModuleDaoSupport2.count(DataBaseType.BASE_DATA, sql2, null, memberId);
        pager.setDatas(list);
        pager.setPageOffset(pageOffset);
        pager.setPageSize(pageSize);
        pager.setTotalPage(count);
        pager.setTotalRecord(count);
        return pager;
    }

    @Override
    public LuckIndianaProduct buyOrNot(String memberId, String productId, int mount, int consumeQuantity) {
        Date nowDate = new Date();
        String sql1 = "select * from luck_indiana_product where product_id ='" + productId + "' limit 1";
        LuckIndianaProduct luckIndianaProduct = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sql1, new LuckIndianaProduct(), DbUtil.getMod4DbRandom());
        String sql2 = "select * from luck_indiana_buyrecord where product_id = '" + productId + "'and member_id = '" + memberId + "'and luck_product_index = '" + mount + "'";
        List<LuckIndianaBuyrecord> list = JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA, sql2, new LuckIndianaBuyrecord(), DbUtil.getMod4DbRandom());
        String sql3 = "select * from luck_indiana_buyrecord where product_id = '" + productId + "' and luck_product_index = '" + mount + "' order by create_date desc limit 1";
        LuckIndianaBuyrecord luckIndianaBuyrecord = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sql3, new LuckIndianaBuyrecord(), DbUtil.getMod4DbRandom());
        Date lastUpdateDate = luckIndianaBuyrecord.getCreateDate();
        if (StringUtil.isNull(luckIndianaProduct)) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("无法购买");
            return luckIndianaProduct;
        } else if ((luckIndianaProduct.getConsumeQuantity() + 1) != mount) {//期数不对
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("无法购买");
            return luckIndianaProduct;
        } else if (StringUtil.isNull(list) && list.size() > 0) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("您已购买，请耐心等待.");
            return luckIndianaProduct;
        } else if (!(luckIndianaProduct.getStartDate().before(nowDate) && (luckIndianaProduct.getEndDate().after(nowDate)))) {//时间不对
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("不在活动期间！");
            return luckIndianaProduct;
        } else if (luckIndianaProduct.getTotalPayNumber() == luckIndianaProduct.getTotalShareNumber()) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("本期购买数量已满");
            return luckIndianaProduct;
        } else if (compareDate(nowDate, lastUpdateDate) && luckIndianaProduct.getTotalBuyNumber() >= luckIndianaProduct.getTotalShareNumber()) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("本次可购买的剩余数量为" + (luckIndianaProduct.getTotalBuyNumber() - luckIndianaProduct.getTotalShareNumber()));
            return luckIndianaProduct;
        } else {

            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("异常，请重试！");
            return luckIndianaProduct;
        }
    }

    public LuckIndianaProduct pay(Connection connection, String memberId, String luckId, String productId, int mount, int consumeQuantity, int buyNumber, int totalMoney) throws Exception {
        String buy_id = StringUtil.getUUID();
        log.info("pay:" + buy_id);
        //try {
        LuckIndianaProduct luckIndianaProduct = new LuckIndianaProduct();
        String sql1 = "update luck_indiana_product SET total_buy_number=total_buy_number+" + buyNumber + ",update_date=NOW() where luck_id = '" + luckId + "'";

        JdbcCommandInfo jd = new JdbcCommandInfo(sql1, null, DataBaseType.BASE_DATA, DbUtil.getMod4DbRandom(), "修改夺宝product表的total_buy_number字段");
        connection.commit();
        JdbcTemplateDaoSupport.updateOrAddOrDele(sql1, null);

        String sql7 = "SELECT * FROM luck_indiana_buyrecord WHERE  member_id='" + memberId + "'AND luck_product_index='" + mount + "'AND product_id='" + productId + "'";
        LuckIndianaBuyrecord objectDateInfo = JdbcTemplateDaoSupport.getObject(sql7, null, LuckIndianaBuyrecord.class);


        String sql2 = "insert into luck_indiana_buyrecord (buy_id,luck_id,product_id,member_id,buy_number,luck_product_index,is_pay,is_draw,is_send,create_date,is_lottery,pay_money,pay_type)" +
                " values('" + buy_id + "','" + luckId + "','" + productId + "','" + memberId + "','" + buyNumber + "','" + mount + "','0','0','0',NOW(),'0','" + totalMoney * 100 + "','0')";
        JdbcCommandInfo jdd = new JdbcCommandInfo(sql2, null, DataBaseType.BASE_DATA, DbUtil.getMod4DbRandom(), "添加buyrecord表记录");
        boolean b = JdbcTemplateDaoSupport.updateOrAddOrDele(sql2, null);

        if (!b) {
            log.info("pay:<1");
            connection.rollback();
            connection.close();
            luckIndianaProduct.setCode(1);//失败
            return luckIndianaProduct;
        }
        log.info("pay:>1");
        connection.commit();
        connection.close();
        luckIndianaProduct.setCode(0);//成功
        luckIndianaProduct.setMsg(buy_id);
        return luckIndianaProduct;
    }

    public boolean compareDate(Date date1, Date date2) {//date1 now  date2 createDate
        if (date2 == null) {
            return false;
        }
        ;
        int year1 = date1.getYear();
        int month1 = date1.getMonth();
        int day1 = date1.getDay();
        int hour1 = date1.getHours();
        int minute1 = date1.getMinutes();
        int year2 = date2.getYear();
        int month2 = date2.getMonth();
        int day2 = date2.getDay();
        int hour2 = date2.getHours();
        int minute2 = date2.getMinutes();

        if (date1.after(date2) && year1 == year2 && month1 == month2 && day1 == day2 && hour1 == hour2 && (minute1 - minute2) <= 3) {
            log.info("year:" + year1 + year2);
            log.info("month:" + month1 + month2);
            log.info("day:" + day1 + day2);
            log.info("hoour:" + hour1 + hour2);
            return true;
        }
        return false;
    }


    @Override
    public LuckIndianaProduct payOne(String memberId, String luckId, String productId, int mount, int totalMoney, int consumeQuantity) {
//        String sql1 = "select IFNULL(sum(a.buy_number),0) as buyNumber,IFNULL(a.buy_id ,'') as buyId, b.total_share_number as totalShareNumber from  luck_indiana_buyrecord a JOIN luck_indiana_product b where a.luck_id = b.luck_id and a.luck_product_index ='"+mount+"' and a.luck_id= '"+luckId+"' " +
//                "and a.member_id = '"+memberId+"' GROUP BY a.buy_id,b.total_share_number";
        String sql1 = "select IFNULL(sum(a.buy_number),0) as buyNumber,max(b.total_share_number) as totalShareNumber from  luck_indiana_buyrecord a JOIN luck_indiana_product b where a.luck_id = b.luck_id and a.luck_product_index ='"+mount+"' and a.luck_id= '"+luckId+"' " +
                "and a.member_id = '"+memberId+"'and a.is_pay='1' GROUP BY b.total_share_number";
        LuckBean luckBean = JdbcTemplateDaoSupport.getObject(sql1,null,LuckBean.class);

        sql1 = "SELECT IFNULL(sum(buy_number),0) as totalPayNumber ,B.total_quantity,B.total_share_number as totalShareNumber,B.pname,B.consume_quantity as consumeQuantity,B.start_date AS startDate,B.end_date as endDate   FROM luck_indiana_buyrecord A JOIN luck_indiana_product  B  ON A.luck_id=B.luck_id " +
                " where A.luck_id='" + luckId + "' and A.luck_product_index='" + mount + "' and A.is_pay='1'";
        LuckIndianaProduct luckIndianaProduct = JdbcTemplateDaoSupport.getObject(sql1, null, LuckIndianaProduct.class);
        int total_share_number = 0;
        int consume_quantity = 0;
        int total_pay_number = 0;
        int total_quantity = 0;
        Date start_date;
        Date end_date;
        total_share_number = luckIndianaProduct.getTotalShareNumber();
        consume_quantity = luckIndianaProduct.getConsumeQuantity();
        total_quantity = luckIndianaProduct.getTotalQuantity();
        total_pay_number = luckIndianaProduct.getTotalPayNumber();

        start_date = luckIndianaProduct.getStartDate();
        end_date = luckIndianaProduct.getEndDate();
        Date nowDate = new Date();



        ///////////////////////////
        boolean flag = false;//true表示这一期还没有人买，false表示这一期已经有人购买
        sql1 = "select * from luck_indiana_buyrecord where luck_id='" + luckId + "' and luck_product_index='" + mount + "' and is_pay='1'";
        LuckIndianaBuyrecord luck = new LuckIndianaBuyrecord();
        List<LuckIndianaBuyrecord> list = JdbcTemplateDaoSupport.getList(sql1,luck);
        if(StringUtil.isNull(list))flag = true;

        ///////////////////////////
        if (total_quantity == consume_quantity) {//活动已完成
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("活动已结束");
            return luckIndianaProduct;
        } else if ((consume_quantity + 1) != mount) {//期数不对
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("亲，您要买的东西被抢走了...");
            return luckIndianaProduct;
        } else if (compareHour(start_date,end_date,nowDate) &  flag) {//不在活动期间，则看flag的情况
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("亲，暂时还不能买哦！");
            return luckIndianaProduct;
        }else if (total_pay_number + consumeQuantity > total_share_number) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("本次可购买的剩余数量不足");
            return luckIndianaProduct;
        }else  if(!StringUtil.isNull(luckBean)){
            int totalShareNumber = luckBean.getTotalShareNumber();
            int buyNumber = luckBean.getBuyNumber();
            if(totalShareNumber%2>0) totalShareNumber = totalShareNumber+1;//变成偶数
            log.error("1"+total_share_number);
            log.error("2"+buyNumber);

            if(buyNumber+consumeQuantity> (totalShareNumber/2)){
                luckIndianaProduct.setCode(1);
                luckIndianaProduct.setMsg("您购买的次数超限");
                return luckIndianaProduct;
            }
            luckIndianaProduct = payOneBefore2(memberId, luckId, productId, mount, totalMoney, consumeQuantity);
            return luckIndianaProduct;
        }  else {
            luckIndianaProduct = payOneBefore2(memberId, luckId, productId, mount, totalMoney, consumeQuantity);
        }
        return luckIndianaProduct;
    }

    public static boolean compareHour(Date start_date,Date end_date,Date nowDate){
        if(!(start_date.before(nowDate) & (end_date.after(nowDate)))){
            return true;
        }else{
            int hour = nowDate.getHours();
            if(!(hour>=12 & hour<14)){
                return true;
            }
        }
       return false;
    }

    public static void main(String[] arg){
        System.out.print(new Date().getHours());
    }


    public LuckIndianaProduct payOneBefore2(String memberId, String luckId, String productId, int mount, int totalMoney, int consumeQuantity) {
        String buy_id = StringUtil.getUUID();
        String orderCode = DbUtil.getNewPayCode(memberId);
        ;
        LuckIndianaProduct luck = new LuckIndianaProduct();
        String sql2 = "insert into luck_indiana_buyrecord (buy_id,luck_id,product_id,member_id,buy_number,luck_product_index,is_pay,is_draw,is_send,create_date,is_lottery,pay_money,pay_type,order_code)" +
                " values('" + buy_id + "','" + luckId + "','" + productId + "','" + memberId + "','" + consumeQuantity + "','" + mount + "','0','0','0',NOW(),'0','" + totalMoney + "','0','" + orderCode + "')";
        boolean b = JdbcTemplateDaoSupport.updateOrAddOrDele(sql2, null);
        if (!b) {
            luck.setCode(1);
            luck.setMsg("添加购买记录失败");
            return luck;
        } else {
            luck.setCode(0);
            luck.setBuyId("DB_" + buy_id);
            luck.setOrderCode("DB" + orderCode);
            return luck;
        }
    }

    public LuckIndianaProduct payOneBefore(Connection connection, String memberId, String luckId, String productId, int mount, int totalMoney, int consumeQuantity) throws Exception {
        Date nowDate = new Date();
        String sql1 = "select * from luck_indiana_product where luck_id ='" + luckId + "'";

        JdbcCommandInfo jd = new JdbcCommandInfo(sql1, null, DataBaseType.BASE_DATA,
                DbUtil.getMod4Db(memberId), "查询夺宝product表");
        LuckIndianaProduct luckIndianaProduct = JdbcTemplateDaoSupport.getObject(sql1, null, LuckIndianaProduct.class);

        int total_share_number = 0;
        int consume_quantity = 0;
        int total_pay_number = 0;
        int total_buy_number = 0;
        Date start_date;
        Date end_date;
        Date update_date;
        /////////////////////////////////////
        if (StringUtil.isNull(luckIndianaProduct)) {
            luckIndianaProduct = new LuckIndianaProduct();
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("暂无此活动");
            return luckIndianaProduct;
        }

        Date lastUpdateDate = null;
        total_share_number = luckIndianaProduct.getTotalShareNumber();
        consume_quantity = luckIndianaProduct.getConsumeQuantity();
        total_pay_number = luckIndianaProduct.getTotalPayNumber();
        total_buy_number = luckIndianaProduct.getTotalBuyNumber();
        start_date = luckIndianaProduct.getStartDate();
        end_date = luckIndianaProduct.getEndDate();
        update_date = luckIndianaProduct.getUpdateDate();
        log.info("多报数据：" + total_share_number + ":" + total_pay_number + ":" + total_buy_number + ":" + consume_quantity + ":" + start_date + ":" + end_date + ":" + update_date + ".....");
        if (total_share_number == consume_quantity) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("活动已完成");
            return luckIndianaProduct;
        } else if ((consume_quantity + 1) != mount) {//期数不对
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("期数错误");
            return luckIndianaProduct;
        } else if (!(start_date.before(nowDate) && (end_date.after(nowDate)))) {//时间不对
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("不在活动期间！");
            return luckIndianaProduct;
        } else if (total_pay_number == total_share_number) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("本期购买数量已满");
            return luckIndianaProduct;
        } else if (total_pay_number + consumeQuantity > total_share_number) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("本次可购买的剩余数量不足");
            return luckIndianaProduct;
        } else if (total_buy_number + consumeQuantity > total_share_number) {
            log.info("elseif");
            lastUpdateDate = update_date;
            //////////////////////////////////
            total_buy_number = delNoSenseTotalBuyNumber(connection, luckId, mount, total_buy_number);
            if (total_buy_number + consumeQuantity > total_share_number) {
                luckIndianaProduct.setCode(1);
                luckIndianaProduct.setMsg("本次可购买的剩余数量不足,请稍后再试");
                return luckIndianaProduct;
            }
            /////////////////////////////////

            LuckIndianaProduct p = pay(connection, memberId, luckId, productId, mount, consumeQuantity + total_pay_number - total_buy_number, consumeQuantity, totalMoney);
            if (p.getCode() == 0) {
                luckIndianaProduct.setCode(0);
                luckIndianaProduct.setBuyId("DB_" + p.getMsg());
                return luckIndianaProduct;
            }
            connection.rollback();
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("异常，请重试！");
            return luckIndianaProduct;


        } else {
            LuckIndianaProduct p = pay(connection, memberId, luckId, productId, mount, consumeQuantity + total_pay_number - total_buy_number, consumeQuantity, totalMoney);
            if (p.getCode() == 0) {
                luckIndianaProduct.setCode(0);
                luckIndianaProduct.setBuyId("DB_" + p.getMsg());
                return luckIndianaProduct;
            }
            connection.rollback();
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("异常，请重试！");
            return luckIndianaProduct;
        }
    }

    public int delNoSenseTotalBuyNumber(Connection connection, String luckId, int mount, int total_buy_number) {
        log.info("delNoSenseTotalBuyNumber:");
        try {
            String sql = "select count(buy_number) from luck_indiana_buyrecord where luck_id ='" + luckId + "' and is_pay='0' and luck_product_index ='" + mount + "' and TIMESTAMPDIFF(MINUTE,create_date,NOW())>3 ";
            int count = JdbcTemplateDaoSupport.count(sql, null);
            String sql1 = "update luck_indiana_product SET total_buy_number=total_buy_number-" + count + " where luck_id='" + luckId + "'";
            boolean b = JdbcTemplateDaoSupport.updateOrAddOrDele(sql1, null);

            if (b) {
                connection.commit();
                String sql2 = "select total_buy_number from luck_indiana_product where luck_id='" + luckId + "' limit 1";
                LuckIndianaProduct luckIndianaProduct = new LuckIndianaProduct();
                luckIndianaProduct = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sql2, luckIndianaProduct, DbUtil.getMod4DbRandom());
                if (!StringUtil.isNull(luckIndianaProduct)) {
                    total_buy_number = luckIndianaProduct.getTotalBuyNumber();
                }
            } else {
                connection.rollback();
            }
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return total_buy_number;
    }

    @Override
    public boolean acceptPrize(String buyId, String orderCode, String contact, String phone, String address) {
        String sql = "update reissue_order SET order_status='2',contact='" + contact + "',phone='" + phone + "',address='" + address + "',update_date=NOW() " +
                "where order_code ='" + orderCode + "'";

        if (JdbcTemplateDaoSupport.updateOrAddOrDele( sql, null)) {
            String sqll = "update luck_indiana_buyrecord SET is_send='-1' where buy_id='" + buyId + "' limit 1";
            if (JdbcTemplateDaoSupport.updateOrAddOrDele(sqll, null)) {

            } else {
                log.error("夺宝活动领取奖品异常，reissue_order表中订单号为" + orderCode + "的数据已更新,但buyrecord表中buyID为" + buyId + "的数据is_send没有更新成-1");
            }

            return true;
        }
        return false;
    }

    public LuckIndianaProduct payTwoBefore(String memberId, String luckId, String productId, int mount, int totalMoney, int consumeQuantity) {
        Date nowDate = new Date();
        String sql1 = "select * from luck_indiana_product where product_id ='" + productId + "' limit 1";
        LuckIndianaProduct luckIndianaProduct = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sql1, new LuckIndianaProduct(), DbUtil.getMod4DbRandom());
        String sql2 = "select * from luck_indiana_buyrecord where product_id = '" + productId + "'and member_id = '" + memberId + "'and luck_product_index = '" + mount + "'";
        List<LuckIndianaBuyrecord> list = JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA, sql2, new LuckIndianaBuyrecord(), DbUtil.getMod4DbRandom());

        Date lastUpdateDate = null;
        if (StringUtil.isNull(luckIndianaProduct)) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("无法购买");
            return luckIndianaProduct;
        } else if (luckIndianaProduct.getTotalShareNumber() == luckIndianaProduct.getConsumeQuantity()) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("活动已完成");
            return luckIndianaProduct;
        } else if ((luckIndianaProduct.getConsumeQuantity() + 1) != mount) {//期数不对
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("期数错误");
            return luckIndianaProduct;
        } else if (!(luckIndianaProduct.getStartDate().before(nowDate) && (luckIndianaProduct.getEndDate().after(nowDate)))) {//时间不对
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("不在活动期间！");
            return luckIndianaProduct;
        } else if (luckIndianaProduct.getTotalPayNumber() == luckIndianaProduct.getTotalShareNumber()) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("本期购买数量已满");
            return luckIndianaProduct;
        } else if (luckIndianaProduct.getTotalPayNumber() + consumeQuantity > luckIndianaProduct.getTotalShareNumber()) {
            luckIndianaProduct.setCode(1);
            luckIndianaProduct.setMsg("本次可购买的剩余数量不足");
            return luckIndianaProduct;
        } else if (luckIndianaProduct.getTotalBuyNumber() > luckIndianaProduct.getTotalShareNumber()) {
            log.info("lasrUpdateDate:" + lastUpdateDate);
            log.info("nowDate:" + nowDate);
            lastUpdateDate = luckIndianaProduct.getUpdateDate();
            if (compareDate(nowDate, lastUpdateDate)) {
                luckIndianaProduct.setCode(1);
                luckIndianaProduct.setMsg("本次可购买的剩余数量不足");
                return luckIndianaProduct;
            } else {
                luckIndianaProduct.setCode(0);
                return luckIndianaProduct;
            }

        } else {
            luckIndianaProduct.setCode(0);
            return luckIndianaProduct;
        }

    }

    /*
   一元夺宝
    */
    @Override
    public StatusBean payTwo(final DoingPayOneVo bean, String luckId, String productId, int mount, int totalMoney, int consumeQuantity, String buyId) throws Exception {

        return payment(bean, luckId, productId, mount, totalMoney, consumeQuantity, buyId);

    }

    @Override
    public StatusBean payDBOrder(String orderCode, int payMoney, int payType, String tradeCode) {
        String sql8 = "UPDATE luck_indiana_buyrecord SET is_pay=1,pay_type='" + payType + "',pay_date=NOW(),update_date=NOW(),pay_code=" + tradeCode + " WHERE order_code='" + orderCode + "'";
        if (JdbcModuleDaoSupport2.updateOrAddOrDele(DataBaseType.BASE_DATA, sql8, null, DbUtil.getMod4DbRandom())) {
            String sql = "SELECT * FROM luck_indiana_buyrecord WHERE order_code='" + orderCode + "'";
            LuckIndianaBuyrecord luckIndianaBuyrecord = JdbcTemplateDaoSupport.getObject(sql, null, LuckIndianaBuyrecord.class);
            String luckId = luckIndianaBuyrecord.getLuckId();
            String buyId = luckIndianaBuyrecord.getBuyId();
            int mount = luckIndianaBuyrecord.getLuckProductIndex();
            String productId = luckIndianaBuyrecord.getProductId();
            int payMONEY = luckIndianaBuyrecord.getPayMoney();
            if (payMONEY == payMoney) {
                boolean b = islottery(buyId, mount, luckId);
                if (b) {
                    lottery(mount, productId, luckId, orderCode);//开奖
                }
                return new StatusBean(true, "0000", "支付成功", null);
            } else {
                return new StatusBean(false, "9999", "订单金额异常", null);
            }


        } else {
            return new StatusBean(false, "9999", "修改幸运夺宝购买记录失败", null);
        }

    }

    /**
     * 余额支付（短信验证码+支付密码+订单Id）
     *
     * @param bean
     * @return
     * @throws Exception
     */
    private StatusBean payment(DoingPayOneVo bean, String luckId, String productId, int mount, int totalMoney, int consumeQuantity, String buyId) throws Exception {

        final String memberId = bean.getMemberId();//付款方memberId

        long payMoney = totalMoney;//订单金额
        //判断余额并更新余额（可用余额减去订单金额）一个支付号
        StatusBean exSuccess = JdbcModuleDaoSupport.execute(DataBaseType.PROFIT_DATA, memberId, new ConnectionCallBack() {
            @Override
            public StatusBean execute(Connection connection) throws Exception {
                //余额支付
                return PurchaseServiceImpl.this.memberPay(connection, memberId, totalMoney, buyId);
            }


        });
        if (exSuccess.getStatus()) {
            exSuccess = JdbcTemplateDaoSupport.execute(new ConnectionCallBack() {
                @Override
                public StatusBean execute(Connection connection) throws Exception {
                    //修改购买记录
                    log.error("修改购买记录开始");
                    return PurchaseServiceImpl.this.addPayOneOrderId(connection, buyId);
                }
            });
            if (!exSuccess.getStatus()) {
                //修改购买记录失败，则回滚余额信息
                log.error("修改购买记录失败");
                StatusBean rollBackStatusBean = JdbcModuleDaoSupport.execute(DataBaseType.PROFIT_DATA, memberId, new ConnectionCallBack() {
                    @Override
                    public StatusBean execute(Connection connection) throws Exception {
                        return PurchaseServiceImpl.this.rollbackMemberPay(connection, memberId, totalMoney);
                    }
                });
                //4.回滚失败，则记录支付日志(需要手工回滚)
                if (!rollBackStatusBean.getStatus()) {
                    TransferFailureLogBean logBean = new TransferFailureLogBean();
                    logBean.setPayerMemberId(memberId);//付款方
                    logBean.setTransferMoney(payMoney);
                    logBean.setCreateDate(new Date());
                    logBean.setTransferType(false ? MemberTransferType.PAY_MENT_FOR_PROXY.getCode() : MemberTransferType.PAY_MENT.getCode());//true:代报单余额支付,false:余额支付
                    logBean.setLogData(exSuccess.getMsg());
                    logPayMentFailureToMQ(logBean);
                }

            } else {
                try {
                    if (islottery(buyId, mount, luckId)) {
                        lottery(mount, productId, luckId, buyId);//开奖
                    }
                }catch (Exception e){
                }

            }


            if (StringUtil.isNull(exSuccess) || (!exSuccess.getStatus() && !StringUtil.isNull(exSuccess.getData()))) {
                exSuccess = new StatusBean(false, "9999", "支付失败，请重试！", null);
            }

        } else {
            return new StatusBean(false, "9999", "支付失败，请重试！", null);
        }


        return exSuccess;
    }

    /*
    开奖
     */
    private StatusBean lottery(int mount, String productId, String luckId, String payCode) {
        log.error("totalCount:"+totalCount);
        if (totalCount != 0) {
            int lotteryNumber = new Random().nextInt(totalCount) + 1;//开奖随机数
            LuckIndianaBuyrecord luckIndianaBuyrecord = new LuckIndianaBuyrecord();
            String sql = "SELECT * FROM luck_indiana_buyrecord WHERE luck_product_index='" + mount + "'AND luck_id='" + luckId + "'AND is_pay=1";
            List<LuckIndianaBuyrecord> list = JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA, sql, luckIndianaBuyrecord, DbUtil.getMod4DbRandom());
            for (int i = 0; i < list.size(); i++) {
                userNumber += list.get(i).getBuyNumber();
                if (userNumber >= lotteryNumber) {
                    String lotteryMember = list.get(i).getMemberId();
                    int lotteryMoney = list.get(i).getPayMoney();
                    Date lotteryDate = list.get(i).getPayDate();
                    String order_Id = StringUtil.getUUID();
                    String lotteryBuyId = list.get(i).getBuyId();
                    String sellRemark = "幸运夺宝" + pname + "第" + mount + "期";
                    final String order_code = "DB" + DbUtil.getNewOrderCode(lotteryMember);
                    StringBuilder sql2 = new StringBuilder();
                    sql2.append("insert into reissue_order ");
                    sql2.append(" (order_id,member_id,order_code,order_status,address,");
                    sql2.append(" total_money,freight,is_pay,pay_type,pay_money,pay_date,order_from,seller_remark,");
                    sql2.append(" express_id,is_profit,create_date,delete_flag) VALUES ");
                    sql2.append(" ('" + order_Id + "','" + lotteryMember + "','" + order_code + "',2,'奖品尚未领取',");
                    sql2.append(" " + lotteryMoney + ",0,1,'3'," + lotteryMoney + ",'" + lotteryDate + "',115,'" + sellRemark + "',");
                    sql2.append(" -4,0,now(),0)");
                    if (JdbcTemplateDaoSupport.updateOrAddOrDele( sql2.toString(),null)) {
                        String order1_id = StringUtil.getUUID();
                        String sql6 = "insert into reissue_order1 (order1_id,order_id,sort_index,product_id,purchase_quantity,shipped_quantity,price,line_total)" +
                                " values ('" + order1_id + "','" + order_Id + "','0','" + productId + "','1','1','" + lotteryMoney + "','" + lotteryMoney + "')";
                        JdbcTemplateDaoSupport.updateOrAddOrDele(sql6, null);
                        String sql3 = "UPDATE luck_indiana_buyrecord SET is_draw = 1,ref_order_code='" + order_code + "' WHERE buy_id='" + lotteryBuyId + "'";
                        if (JdbcTemplateDaoSupport.updateOrAddOrDele(sql3,null)) {
                            String sql10 = "update luck_indiana_buyrecord SET is_lottery = 1 where luck_product_index = '" + mount + "' and luck_id='" + luckId + "' AND is_pay='1'";
                            if (JdbcTemplateDaoSupport.updateOrAddOrDele( sql10, null)) {
                            } else {
                                return new StatusBean(false, "9999", "幸运夺宝购买记录修改开奖状态修改失败", null);
                            }
                            String sql5 = "UPDATE luck_indiana_product SET consume_quantity=consume_quantity+1,total_buy_number=0,total_pay_number=0 WHERE luck_id='" + luckId + "'";
                            if (JdbcTemplateDaoSupport.updateOrAddOrDele(sql5, null)) {
                                sql5 = "delete from luck_indiana_buyrecord where is_pay='0' and TIMESTAMPDIFF(HOUR,create_date,NOW())>1";
                                JdbcTemplateDaoSupport.updateOrAddOrDele(sql5, null);
                                /*
                           发送卡夫卡消息
                            */
                                MemberMessageBean bean = new MemberMessageBean();
                                bean.setInfoId(lotteryBuyId);
                                bean.setType(72);
                                bean.setMemberId(lotteryMember);
                                bean.setMsgId(StringUtil.getUUID());
                                memberMessageProducer = SpringUtils.getBean("memberMessageProducer");
                                memberMessageProducer.produce(JacksonUtil.toJson(bean));
                                break;

                            } else {
                                return new StatusBean(false, "9999", "幸运夺宝活动修改活动期数修改失败", null);
                            }

                        } else {
                            return new StatusBean(false, "9999", "幸运夺宝购买记录修改失败", null);
                        }

                    } else {
                        return new StatusBean(false, "9999", "中奖纪录插入失败", null);
                    }
                }

            }

        }
        return null;
    }


    /**
     * 补偿事务，记录支付信息(失败日志)，需要手工回滚支付金额
     *
     * @param logBean
     * @return
     */
    private void logPayMentFailureToMQ(TransferFailureLogBean logBean) {
        if (sysLogProducer == null) {
            sysLogProducer = SpringUtils.getBean("sysLogProducer");
        }
        try {
            sysLogProducer.produce(JacksonUtil.toJson(logBean));

        } catch (Exception ex) {
            Logger log = Logger.getLogger(this.getClass());
            log.error(ex);
        }
    }

    /*
     * 订单添加失败回滚余额
     *
     */
    private StatusBean rollbackMemberPay(Connection connection, String memberId, int totalMoney) throws Exception {
        List<Object> paramList = new ArrayList<Object>();
        //1.更新余额总表
        String sql = "UPDATE member_money_total SET available_money =available_money + ?,"
                + "pay_sum_money = pay_sum_money - ? where member_id = ? ";
        paramList.add(totalMoney);
        paramList.add(totalMoney);
        paramList.add(memberId);
        JdbcCommandInfo jd = new JdbcCommandInfo(sql, paramList, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "总收益余额表修改");
        int cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return new StatusBean(false, "9999", "回滚余额记录失败", null);
        }


        return new StatusBean(true, "0000", "回滚成功", null);
    }
    /*

    修改幸运夺宝购买记录

    */


    private StatusBean addPayOneOrderId(Connection connection, String buyId) {
        try {
            String sql8 = "UPDATE luck_indiana_buyrecord SET is_pay=1,pay_type=3,update_date=NOW(),pay_date=NOW() WHERE buy_id='" + buyId + "'";
            log.info("payDBOrder:sql89:" + sql8);
            boolean b = JdbcTemplateDaoSupport.updateOrAddOrDele(sql8, null);
            if (b) {
                return new StatusBean(true, "0000", "修改幸运夺宝购买记录成功", null);

            } else {
                return new StatusBean(false, "9999", "修改幸运夺宝购买记录失败", null);
            }
        } catch (Exception e) {
            try {
                connection.commit();
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            } finally {
                return new StatusBean(false, "9999", "修改幸运夺宝购买记录失败", null);
            }

        }

    }


    /*
  获取个人夺宝记录
   */
    @Override
    public Pager<LuckIndianaBuyrecord> getMyActivityRecord(String memberId, int pageOffset, int pageSize) {
        try {
            Pager<LuckIndianaBuyrecord> pager = new Pager<LuckIndianaBuyrecord>();
            String sql = "select * from luck_indiana_buyrecord where member_id = '" + memberId + "' and is_pay='1' order by create_date desc limit " + (pageOffset - 1) * pageSize + "," + pageSize;
            List<LuckIndianaBuyrecord> list = JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA, sql, new LuckIndianaBuyrecord(), DbUtil.getMod4DbRandom());
            if (StringUtil.isNull(list)) {
                pager.setDatas(new ArrayList<LuckIndianaBuyrecord>());
                pager.setPageOffset(pageOffset);
                pager.setPageSize(pageSize);
                pager.setTotalRecord(0);
                pager.setTotalPage(0);
                return pager;
            }
            for (int i = 0; i < list.size(); i++) {
                //产品详情
                LuckIndianaBuyrecord luckIndianaBuyrecord = list.get(i);
                StringBuffer sqlb = new StringBuffer();
                sqlb.append("select p.name,pi.thumb_url " +
                        "from product p left join product_image pi on p.product_id = pi.product_id where 1=1 AND p.delete_flag=0");
                sqlb.append(" and p.product_id = '" + luckIndianaBuyrecord.getProductId() + "'");
                ProductDetail productDetail = new ProductDetail();
                productDetail = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sqlb.toString(), productDetail, DbUtil.getMod4DbRandom());
                luckIndianaBuyrecord.setProductDetail(productDetail);
                if (luckIndianaBuyrecord.getIsLottery() == 0) {
                    luckIndianaBuyrecord.setStatStr("未开奖");
                    luckIndianaBuyrecord.setStat("0");
                } else if (luckIndianaBuyrecord.getIsLottery() == 1 && luckIndianaBuyrecord.getIsDraw() == 0) {
                    String sqlll = "select nick_name from member where member_id=(select member_id from luck_indiana_buyrecord where luck_product_index='" + luckIndianaBuyrecord.getLuckProductIndex() + "' " +
                            "and product_id='" + luckIndianaBuyrecord.getProductId() + "' and luck_id='" + luckIndianaBuyrecord.getLuckId() + "' and is_draw='1') limit 1";
                    Member member = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sqlll, new Member(), DbUtil.getMod4DbRandom());
                    luckIndianaBuyrecord.setLuckManName(member.getNickName());
                    luckIndianaBuyrecord.setStatStr("未中奖");
                    luckIndianaBuyrecord.setStat("1");
                } else if (luckIndianaBuyrecord.getIsLottery() == 1 && luckIndianaBuyrecord.getIsDraw() == 1 && luckIndianaBuyrecord.getIsSend() == 0) {
                    luckIndianaBuyrecord.setStatStr("未领取");
                    luckIndianaBuyrecord.setStat("2");
                } else if (luckIndianaBuyrecord.getIsLottery() == 1 && luckIndianaBuyrecord.getIsDraw() == 1 && luckIndianaBuyrecord.getIsSend() == -1) {
                    luckIndianaBuyrecord.setStatStr("已领取");
                    luckIndianaBuyrecord.setStat("3");
                }else if (luckIndianaBuyrecord.getIsLottery() == 1 && luckIndianaBuyrecord.getIsDraw() == 1 && luckIndianaBuyrecord.getIsSend() == 1) {
                    luckIndianaBuyrecord.setStatStr("已领取");
                    luckIndianaBuyrecord.setStat("3");
                }
                continue;
            }
            String sql2 = "select count(*) from luck_indiana_buyrecord where member_id='" + memberId + "'";
            int count = JdbcModuleDaoSupport2.count(DataBaseType.BASE_DATA, sql2, null, memberId);
            pager.setDatas(list);
            pager.setPageOffset(pageOffset);
            pager.setPageSize(pageSize);
            pager.setTotalPage(count);
            pager.setTotalRecord(count);
            return pager;
        } catch (Exception e) {
            Pager<LuckIndianaBuyrecord> pager = new Pager<LuckIndianaBuyrecord>();
            pager.setDatas(new ArrayList<LuckIndianaBuyrecord>());
            pager.setPageOffset(pageOffset);
            pager.setPageSize(pageSize);
            pager.setTotalRecord(0);
            pager.setTotalPage(0);
            return pager;
        }
    }


    /*

    判断是否可以开奖
    */
    private Boolean islottery(String buyId, int mount, String luckId) {
        log.error("判断是否可以开奖方法");

        String sql = "SELECT IFNULL(sum(buy_number),0) as totalPayNumber ,max(A.is_lottery) as isLottery,B.total_share_number AS totalShareNumber,B.pname, A.luck_product_index,B.consume_quantity FROM luck_indiana_buyrecord A JOIN luck_indiana_product  B  ON A.luck_id=B.luck_id"
                + "    where A.luck_id='" + luckId + "' and A.is_pay='1' group by luck_product_index,B.total_share_number," +
                "B.pname,B.consume_quantity  ORDER BY  luck_product_index desc LIMIT 1 ";
        log.error("是否可以开奖前："+sql);
        LuckIndianaProduct luck = JdbcTemplateDaoSupport.getObjectDateInfo( sql, new LuckIndianaProduct());


        isLottery = luck.getIsLottery();
        //已支付份数
        lotteryTAG = luck.getTotalPayNumber();
        log.error("lotteryTAG:"+lotteryTAG);
        int lotterymount = luck.getConsumeQuantity() ;
        //总份数
        totalCount = luck.getTotalShareNumber();
        log.error("totalCount:"+totalCount);
        pname = luck.getPname();
        log.error("是否可以开奖前："+isLottery);
        if (isLottery == 1) {//如果已经开奖
            String sql2 = "SELECT * FROM luck_indiana_buyrecord WHERE buy_id='" + buyId + "'";
            LuckIndianaBuyrecord luckIndianaBuyrecord = new LuckIndianaBuyrecord();
            LuckIndianaBuyrecord luck2 = JdbcTemplateDaoSupport.getObjectDateInfo(sql2, luckIndianaBuyrecord);
            if (luck2.getBuyNumber() == totalCount) {//满足全部购买
                String lotteryMember = luck2.getMemberId();
                int lotteryMoney = luck2.getPayMoney();
                Date lotteryDate = luck2.getPayDate();
                String order_Id = StringUtil.getUUID();
                String lotteryBuyId = luck.getBuyId();
                String lotteryproductId = luck.getProductId();
                int thismount = lotterymount + 1;
                String sellRemark = "幸运夺宝" + pname + "第" + thismount + "期";
                final String order_code = "DB" + DbUtil.getNewOrderCode(lotteryMember);
                StringBuilder sql4 = new StringBuilder();
                sql4.append("insert into reissue_order ");
                sql4.append(" (order_id,member_id,order_code,order_status,address,");
                sql4.append(" total_money,freight,is_pay,pay_type,pay_money,pay_date,order_from,seller_remark,");
                sql4.append(" express_id,is_profit,create_date,delete_flag) VALUES ");
                sql4.append(" ('" + order_Id + "','" + lotteryMember + "','" + order_code + "',2,'奖品尚未领取',");
                sql4.append(" " + lotteryMoney + ",0,1,'3'," + lotteryMoney + ",'" + lotteryDate + "',115,'" + sellRemark + "',");
                sql4.append(" -4,0,now(),0)");
                if (JdbcTemplateDaoSupport.updateOrAddOrDele( sql4.toString(), null)) {
                    String order1_id = StringUtil.getUUID();
                    String sql6 = "insert into reissue_order1 (order1_id,order_id,sort_index,product_id,purchase_quantity,shipped_quantity,price,line_total)" +
                            " values ('" + order1_id + "','" + order_Id + "','0','" + lotteryproductId + "','1','1','" + lotteryMoney + "','" + lotteryMoney + "')";
                    JdbcTemplateDaoSupport.updateOrAddOrDele(sql6, null);

                    String sql3 = "UPDATE luck_indiana_buyrecord SET is_lottery = 1,is_draw=1 ,ref_order_code='"+ order_code + "',luck_product_index='"+thismount+"' WHERE buy_id='" + buyId + "'";
                    log.error("1里面的："+sql3);
                    if (JdbcTemplateDaoSupport.updateOrAddOrDele( sql3, null)) {
                        String sql5 = "UPDATE luck_indiana_product SET consume_quantity=consume_quantity+1,total_buy_number=0,total_pay_number=0 WHERE luck_id='" + luckId + "'";
                        log.error("1里面的："+sql5);
                        if (JdbcTemplateDaoSupport.updateOrAddOrDele( sql5, null)) {
                            sql5 = "delete from luck_indiana_buyrecord where is_pay='0' and TIMESTAMPDIFF(HOUR,create_date,NOW())>1";
                            log.error("1里面的："+sql5);
                            JdbcTemplateDaoSupport.updateOrAddOrDele(sql5, null);
                                /*
                           发送卡夫卡消息
                            */
                            MemberMessageBean bean = new MemberMessageBean();
                            bean.setInfoId(lotteryBuyId);
                            bean.setType(72);
                            bean.setMemberId(lotteryMember);
                            bean.setMsgId(StringUtil.getUUID());
                            memberMessageProducer = SpringUtils.getBean("memberMessageProducer");
                            memberMessageProducer.produce(JacksonUtil.toJson(bean));
                        } else {
                            log.error("幸运夺宝活动修改活动期数修改失败" + sql5 + "");
                        }
                    } else {
                        log.error("幸运夺宝购买记录修改失败" + sql3 + "");
                    }
                } else {
                    log.error("中奖纪录插入失败" + sql4.toString() + "");
                }
                return false;//有全买的情况则不走开奖逻辑

            } else {//开过奖且未全部购买
                sql = "UPDATE luck_indiana_buyrecord SET  is_lottery = 1  WHERE buy_id='" + buyId + "'";
                boolean b = JdbcTemplateDaoSupport.updateOrAddOrDele(sql, null);
                return false;
            }
        } else {//当前期未开奖
            String sql2 = "SELECT * FROM luck_indiana_buyrecord WHERE buy_id='" + buyId + "'";
            LuckIndianaBuyrecord luckIndianaBuyrecord = new LuckIndianaBuyrecord();
            LuckIndianaBuyrecord luck2 = JdbcTemplateDaoSupport.getObjectDateInfo(sql2, luckIndianaBuyrecord);
            if (luck2.getBuyNumber() == totalCount) {//满足全部购买
                String lotteryMember = luck2.getMemberId();
                int lotteryMoney = luck2.getPayMoney();
                Date lotteryDate = luck2.getPayDate();
                String order_Id = StringUtil.getUUID();
                String lotteryproductId = luck.getProductId();

                String sellRemark = "幸运夺宝" + pname + "第" + lotterymount + "期";
                final String order_code = "DB" + DbUtil.getNewOrderCode(lotteryMember);
                StringBuilder sql4 = new StringBuilder();
                sql4.append("insert into reissue_order ");
                sql4.append(" (order_id,member_id,order_code,order_status,address,");
                sql4.append(" total_money,freight,is_pay,pay_type,pay_money,pay_date,order_from,seller_remark,");
                sql4.append(" express_id,is_profit,create_date,delete_flag) VALUES ");
                sql4.append(" ('" + order_Id + "','" + lotteryMember + "','" + order_code + "',2,'奖品尚未领取',");
                sql4.append(" " + lotteryMoney + ",0,1,'3'," + lotteryMoney + ",'" + lotteryDate + "',115,'" + sellRemark + "',");
                sql4.append(" -4,0,now(),0)");
                if (JdbcTemplateDaoSupport.updateOrAddOrDele(sql4.toString(), null)) {
                    String order1_id = StringUtil.getUUID();
                    String sql6 = "insert into reissue_order1 (order1_id,order_id,sort_index,product_id,purchase_quantity,shipped_quantity,price,line_total)" +
                            " values ('" + order1_id + "','" + order_Id + "','0','" + lotteryproductId + "','1','1','" + lotteryMoney + "','" + lotteryMoney + "')";
                    JdbcTemplateDaoSupport.updateOrAddOrDele(sql6, null);

                    String sql3 = "UPDATE luck_indiana_buyrecord SET is_lottery = 1  WHERE luck_id='" + luckId + "' and luck_product_index='"+mount+"';";
                    String sql100="   UPDATE luck_indiana_buyrecord SET  is_draw=1, ref_order_code='" + order_code + "' WHERE buy_id='" + buyId +"'";
                    log.error("2里面的："+sql3);
                    log.error("2里面的："+sql100);
                    if (JdbcTemplateDaoSupport.updateOrAddOrDele( sql3, null)&& JdbcTemplateDaoSupport.updateOrAddOrDele( sql100, null)) {

                        String sql5 = "UPDATE luck_indiana_product SET consume_quantity=consume_quantity+1,total_buy_number=0,total_pay_number=0 WHERE luck_id='" + luckId + "'";
                        log.error("2里面的："+sql5);
                        if (JdbcTemplateDaoSupport.updateOrAddOrDele( sql5, null)) {
                            sql5 = "delete from luck_indiana_buyrecord where is_pay='0' and TIMESTAMPDIFF(HOUR,create_date,NOW())>1";
                            JdbcTemplateDaoSupport.updateOrAddOrDele(sql5, null);
                                /*
                           发送卡夫卡消息
                            */
                            MemberMessageBean bean = new MemberMessageBean();
                            bean.setInfoId(buyId);
                            bean.setType(72);
                            bean.setMemberId(lotteryMember);
                            bean.setMsgId(StringUtil.getUUID());
                            memberMessageProducer = SpringUtils.getBean("memberMessageProducer");
                            memberMessageProducer.produce(JacksonUtil.toJson(bean));
                        } else {
                            log.error("幸运夺宝活动修改活动期数修改失败" + sql5 + "");
                        }
                    } else {
                        log.error("幸运夺宝购买记录修改失败" + sql3 + "");
                    }
                } else {
                    log.error("中奖纪录插入失败" + sql4.toString() + "");
                }
                return false;//有全买的情况则不走开奖逻辑
            } else {//没有全买
                if (lotteryTAG >= totalCount)
                    return true;
                else
                    return false;
            }
        }
    }


    /**
     * 判断是否足够余额支付
     */

    private StatusBean memberPay(Connection connection, String memberId, int totalMoney, String buyId) throws Exception {


        //更新收益信息
        //从会员收益信息表中取出可提现余额available_money和支付总余额pay_sum_money
        String sql = "SELECT available_money,prestored, pay_sum_money FROM member_money_total WHERE member_id=? LIMIT 1 FOR UPDATE";
        List<Object> params = new ArrayList<Object>();
        params.add(memberId);
        JdbcCommandInfo jd = new JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "查询收益表总余额记录");
        ResultSet rs = JdbcModuleDaoSupport.queryResultSet(connection, jd);
        long availableMoney = 0L;//可转账余额
        long prestored = 0L;//可用预存款
        long paySumMoney = 0L;//支付总余额
        if (rs.next()) {
            availableMoney = rs.getLong("available_money");
            paySumMoney = rs.getLong("pay_sum_money");
            prestored = rs.getLong("prestored");
        }
        rs.close();

        if ((availableMoney + prestored) < 1) {
            return new StatusBean(false, "9999", "您的余额为0", null);
        }
        if (totalMoney > (availableMoney + prestored)) {
            return new StatusBean(false, "9999", "您的余额不足", null);
        }
        long useAvailableMoney = 0L;//本次支付使用的余额
        long usePrestored = 0L;//本次支付使用的预存款金额
        if (totalMoney > prestored) {
            usePrestored = prestored;//可用预存款全部使用
            useAvailableMoney = totalMoney - usePrestored;//不足部分可用余额补足
        } else {
            usePrestored = totalMoney;
        }
        //2.更新余额总表（减去订单金额）
        sql = "UPDATE member_money_total SET available_money =available_money - ?,prestored=prestored - ?, "
                + "pay_sum_money = pay_sum_money + ? where member_id = ? ";
        params = new ArrayList<Object>();
        params.add(useAvailableMoney);
        params.add(usePrestored);
        params.add(totalMoney);
        params.add(memberId);
        jd = new JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "修改收益表余额记录");
        int cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return new StatusBean(false, "9999", "更新总收益余额记录失败", null);
        }

        //3.插入支付流水
        sql = "INSERT INTO " +
                DbUtil.getMemberPayTableName(memberId) +
                " (pay_id,sort_index,pay_code,member_id,type,order_id,order_member_id,order_sum_money,pay_money,pay_sum_money,available_money," +
                "use_available_money,use_prestored_money,prestored_money,status,create_time,update_date,delete_flag)" +
                " values (?,uuid_short(),?,?,?,?,?,?,?,?,?,?,?,?,1,now(),now(),0) ";
        params = new ArrayList<Object>();
        params.add(StringUtil.getUUID());
        params.add(DbUtil.getNewPayCode(memberId));//新生成一个支付号);//新生成一个支付号
        params.add(memberId);
        params.add(2);//1:系统代付；2:用户自己支付 //TODO 此处需要修改成枚举元素
        params.add(buyId);
        params.add(memberId);
        params.add(totalMoney);
        params.add(totalMoney);//支付金额就是订单的金额
        params.add(paySumMoney + totalMoney);
        params.add(availableMoney - useAvailableMoney);//可用金额减去使用余额支付部分
        params.add(useAvailableMoney);
        params.add(usePrestored);
        params.add(prestored - usePrestored);
        jd = new JdbcCommandInfo(sql, params, DataBaseType.PROFIT_DATA,
                DbUtil.getMod4Db(memberId), "插入支付流水");
        cnum = JdbcModuleDaoSupport.execTran(connection, jd);
        if (cnum < 1) {
            return new StatusBean(false, "9999", "插入支付流水记录失败", null);
        }


        return new StatusBean(true, "0000", "支付成功", null);

    }


}
