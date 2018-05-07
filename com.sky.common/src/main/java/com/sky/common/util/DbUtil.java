package com.sky.common.util;

import com.sky.dao.vo.MemberBean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class DbUtil {

    //public static final List<String> LASTCHAR1 = Arrays.asList(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"});
    public static final List<String> LASTCHAR2 = Arrays.asList(new String[]{"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "0a", "0b", "0c", "0d", "0e", "0f", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "1a", "1b", "1c", "1d", "1e", "1f", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "2a", "2b", "2c", "2d", "2e", "2f", "30", "31", "32", "33", "34", "35", "36", "37",
            "38", "39", "3a", "3b", "3c", "3d", "3e", "3f", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "4a", "4b", "4c", "4d", "4e", "4f", "50", "51", "52", "53", "54", "55", "56",
            "57", "58", "59", "5a", "5b", "5c", "5d", "5e", "5f", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "6a", "6b", "6c", "6d", "6e", "6f", "70", "71", "72", "73", "74", "75",
            "76", "77", "78", "79", "7a", "7b", "7c", "7d", "7e", "7f", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "8a", "8b", "8c", "8d", "8e", "8f", "90", "91", "92", "93", "94",
            "95", "96", "97", "98", "99", "9a", "9b", "9c", "9d", "9e", "9f", "a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9", "aa", "ab", "ac", "ad", "ae", "af", "b0", "b1", "b2", "b3",
            "b4", "b5", "b6", "b7", "b8", "b9", "ba", "bb", "bc", "bd", "be", "bf", "c0", "c1", "c2", "c3", "c4", "c5", "c6", "c7", "c8", "c9", "ca", "cb", "cc", "cd", "ce", "cf", "d0", "d1", "d2",
            "d3", "d4", "d5", "d6", "d7", "d8", "d9", "da", "db", "dc", "dd", "de", "df", "e0", "e1", "e2", "e3", "e4", "e5", "e6", "e7", "e8", "e9", "ea", "eb", "ec", "ed", "ee", "ef", "f0", "f1",
            "f2", "f3", "f4", "f5", "f6", "f7", "f8", "f9", "fa", "fb", "fc", "fd", "fe", "ff"});
    /*
     * 分库数量
     */
    public static final int DB_COUNT = 4;
    /**
     * 分表个数
     */
    public static final int TABLE_COUNT = 8;

    public static String getBaseModule(){
        return "00";
    }

    private static int getMod(String string)
    {
        String lastChar = string.substring(string.length() - 2, string.length()).toLowerCase();
        return LASTCHAR2.indexOf(lastChar) % 32;
    }

    /*
    * 获取fund表
    * */
    public static String getMemberFund(String memberId){
        return "member_fund_" + getMod8Table(memberId);
    }


    /*
     * 取模4(根据会员ID)
     */
    public static String getMod4Db(String memberId) {
        String lastChar = memberId.substring(memberId.length() - 2, memberId.length()).toLowerCase();
        Integer index = getMod(memberId) / TABLE_COUNT;
        return index < 10 ? "0" + index.toString() : index.toString();
    }
    
    /*
     * 取模8(根据会员ID)
     */
    public static String getMod8Table(String memberId) {
        String lastChar = memberId.substring(memberId.length() - 2, memberId.length()).toLowerCase();
        Integer index = getMod(memberId) % TABLE_COUNT;
        return index < 10 ? "0" + index.toString() : index.toString();
    }
    
    /*
     * 遍历所有数据库的时候需要
     */
    public static String getMod4DbByNum(int number)
    {
    	return LASTCHAR2.get(number * TABLE_COUNT);
    }
    
    /**
     * 取模4(随机)
     */
    public static String getMod4DbRandom() {
        long currentSecond = System.currentTimeMillis();
        return getMod4DbByNum((int) (currentSecond % DB_COUNT));
    }

    /*
    * 生成一个新的订单号（订单号规则：会员ID尾数的序号+时间戳）
    * */
    public static String getNewOrderCode(String memberId) {
        Integer index = LASTCHAR2.indexOf(memberId.substring(memberId.length() - 2, memberId.length()).toLowerCase());
        return String.format("%03d%d", index, RandomUtil.random());
    }

    /*
     * 生成一个新的收益号（收益号规则：会员ID尾数的序号+时间戳）
     * */
    public static String getNewProfitCode(String memberId) {
        Integer index = LASTCHAR2.indexOf(memberId.substring(memberId.length() - 2, memberId.length()).toLowerCase());
        return String.format("%03d%d", index, RandomUtil.random());
    }

    /*
     * 生成一个新的冻结号（冻结号规则）
     * */
    public static String getNewFreezeCode(String memberId) {
        Integer index = LASTCHAR2.indexOf(memberId.substring(memberId.length() - 2, memberId.length()).toLowerCase());
        return String.format("%03d%d", index, RandomUtil.random());
    }

    /*
     * 生成一个新的业绩号（业绩号规则）
     * */
    public static String getNewAchivementCode(String memberId) {
        Integer index = LASTCHAR2.indexOf(memberId.substring(memberId.length() - 2, memberId.length()).toLowerCase());
        return String.format("%03d%d", index, RandomUtil.random());
    }

    /*
    * 生成一个新的提现号（提现号规则：会员ID尾数的序号+时间戳）
    * */
    public static String getNewDealCode(String memberId) {
        Integer index = LASTCHAR2.indexOf(memberId.substring(memberId.length() - 2, memberId.length()).toLowerCase());
        return String.format("%03d%d", index, RandomUtil.random());
    }
    
    /*
     * 生成一个新的支付号（提现号规则：会员ID尾数的序号+时间戳）
     * */
    public static String getNewPayCode(String memberId) {
        Integer index = LASTCHAR2.indexOf(memberId.substring(memberId.length() - 2, memberId.length()).toLowerCase());
        return String.format("%03d%d", index, RandomUtil.random());
    }
    
    /**
     * 
    * @Title: getNewBalanceCode 
    * @Description: 新生成一个余额流水号
    * @author zenglinhua
    * @date 2016年1月19日 上午10:24:50
    * @param @param memberId
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public static String getNewBalanceCode(String memberId) {
        Integer index = LASTCHAR2.indexOf(memberId.substring(memberId.length() - 2, memberId.length()).toLowerCase());
        return String.format("%03d%d", index, RandomUtil.random());
    }

    /*
    * 生成一个新的退货号（提现号规则：会员ID尾数的序号+时间戳）
    * */
    public static String getNewRefundCode(String memberId) {
        Integer index = LASTCHAR2.indexOf(memberId.substring(memberId.length() - 2, memberId.length()).toLowerCase());
        return String.format("%03d%d", index, RandomUtil.random());
    }

    /**
     * 获取一个通用流水号
     * @param head 区分用途 P、快递推送号 C、采购订单号 E、入库订单号
     * @param module 数据库module
     * @return
     */
    public static String getNewSerialCode(String head,Integer module){
        return String.format("%S%02d%d", head, module, RandomUtil.random());
    }

    /**
     * 从通用流水号获取库module
     * @param serialCode 通用流水号
     * @return
     */
    public static String getSerialCodeModule(String serialCode){
        if (serialCode.length()<3){
            return "10";//失败默认取仓储库
        }
        return  serialCode.substring(1, 3);
    }

    /**
     * 根据订单号取得会员ID的尾数2位
     *
     * @param orderCode 订单号
     * @return
     */
    public static String getMemberIdByOrderCode(String orderCode) {
        String prefix = orderCode.substring(0, 3);
        return LASTCHAR2.get(Integer.parseInt(prefix));
    }

    /**
     * 获取会员收货地址表名称
     *
     * @param memberId
     * @return
     */
    public static String getMemberAddressTableName(String memberId) {
        String module = DbUtil.getMod8Table(memberId);
        return "member_address_" + module;
    }


    /**
     * 获取会员获得收益的表名称
     *
     * @param memberId
     * @return
     */
    public static String getMemberProfitTableName(String memberId) {
        return "member_profit_" + getMod8Table(memberId);
    }

    public static String getMemberLevelTableName(String memberId) {
        return "member_level_" + getMod8Table(memberId);
    }
    
    /**
     * 
    * @Title: getMemberPayTableName 
    * @Description: 获得会员支付表名称
    * @author zenglinhua
    * @date 2016年1月14日 下午1:17:53
    * @param @param memberId
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public static String getMemberPayTableName(String memberId){
    	return "member_pay_" + getMod8Table(memberId);
    }
    /**
     *
     * @Title: getMemberPayTableName
     * @Description: 获得会员支付表名称
     * @author zenglinhua
     * @date 2016年1月14日 下午1:17:53
     * @param @param memberId
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String getBonusSendRecordTableName(String memberId){
        return "bonus_send_record_" + getMod8Table(memberId);
    }
    
    /**
     * 
    * @Title: getMemberBalanceTableName 
    * @Description: 获得会员可用余额流出表名称
    * @author zenglinhua
    * @date 2016年1月19日 上午10:22:05
    * @param @param memberId
    * @param @return    设定文件 
    * @return String    返回类型 
    * @throws
     */
    public static String getMemberBalanceTableName(String memberId){
    	return "member_balance_" + getMod8Table(memberId);
    }

    //加盟业绩表
    public static String getJoinStatisticsTableName(String memberId){
        return "join_statistics_day_" + getMod8Table(memberId);
    }
    // 昨天之前的加盟业绩表
    public static String getJoinAchivementdayTableName(String memberId){
        return "join_achivement_day_" + getMod8Table(memberId);
    }

    // 零售月业绩表
    public static String getRetailAchivementMonthTableName(String memberId){
        return "retail_achivement_month_" + getMod8Table(memberId);
    }

    public static String getMemberCurrentTableName(String memberId){
        return "member_current_" + getMod8Table(memberId);
    }

    // 零售月业绩日志表
    public static String getRetailAchivementLogTableName(String memberId){
        return "retail_achivement_log_" + getMod8Table(memberId);
    }

    // 销售月业绩表
    public static String getSaleAchivementMonthTableName(String memberId){
        return "sale_achivement_month_" + getMod8Table(memberId);
    }

    // 销售月业绩日志表
    public static String getSaleAchivementLogTableName(String memberId){
        return "sale_achivement_log_" + getMod8Table(memberId);
    }
    /**
     *
    * @Title: getMemberTransferTableName
    * @Description: 获得会员转账业务表名称
    * @author qiujingwang
    * @date 2016年2月23日 上午16:22:05
    * @param @param memberId
    * @param @return    设定文件
    * @return String    返回类型
    * @throws
     */
    public static String getMemberTransferTableName(String memberId){
    	return "member_transfer_" + getMod8Table(memberId);
    }

    /**
     * 获取会员冻结表名称
     *
     * @param memberId
     * @return
     */
    public static String getMemberFreezeTableName(String memberId) {
        return "member_freeze_" + getMod8Table(memberId);
    }



    /**
     * 获取补货币流水表名称
     *
     * @param memberId
     * @return
     */
    public static String getCoinBalanceTableName(String memberId) {
        return "coin_balance_" + getMod8Table(memberId);
    }





    /**
     * 获取会员绩效详情表
     *
     * @param memberId
     * @return
     */
    public static String getMemberAchivementLogTableName(String memberId) {
        return "member_achivement_log_" + getMod8Table(memberId);
    }

    /**
     * 获取订单主表的名称
     *
     * @param memberId
     * @return
     */
    public static String getDoingOrderTableName(String memberId) {
        return "doing_order_" + getMod8Table(memberId);
    }

    /**
     * 获取折扣表的名称
     *
     * @param memberId
     * @return
     */
    public static String getMemberDiscountTableName(String memberId) {
        return "member_discount_" + getMod8Table(memberId);
    }
    /**
     * 获取主库折扣详情表的名称
     *
     * @param memberId
     * @return
     */
    public static String getDiscountRateTableName(String memberId) {
        return "discount_rate_" + getMod8Table(memberId);
    }

    // 折扣日志表
    public static String getMemberDiscountLogTableName(String memberId){
        return "member_discount_log_" + getMod8Table(memberId);
    }
    /**
     * 获取订单子表的名称
     *
     * @param memberId
     * @return
     */
    public static String getDoingOrder1TableName(String memberId) {
        return "doing_order1_" + getMod8Table(memberId);
    }

    /**
     * 获取订单退货的名称
     *
     * @param memberId
     * @return
     */
    public static String getRefundOrderTableName(String memberId) {
        return "refund_order_" + getMod8Table(memberId);
    }

    /**
     * 根据订单号获取所在的数据库
     *
     * @param orderCode
     * @return
     */
    public static String getOrderInWhichDataBase(String orderCode) {
        String prefix = orderCode.substring(0, 3);
        String memberIdSuffer = LASTCHAR2.get(Integer.parseInt(prefix));
        Integer index = getMod(memberIdSuffer)/ TABLE_COUNT;
        return String.format("%02d", index);
    }


    /**
     * 根据订单号获取所在的表
     *
     * @param orderCode
     * @return
     */
    public static String getOrderInWhichTable(String orderCode) {
        String prefix = orderCode.substring(0, 3);
        String memberIdSuffix = LASTCHAR2.get(Integer.parseInt(prefix));
        Integer index = getMod(memberIdSuffix) % TABLE_COUNT;
        return String.format("%02d", index);
    }


    /**
     * 获取系统日志表的名称
     *
     * @param curDate
     * @return
     */
    public static String getSysLogTableName(Date curDate) {
        return "sys_log_" + DateUtil.convertDateToStr(curDate, "yyMM");
    }

    /**
     * 获取快递发货记录日志表的名称
     *
     * @param curDate
     * @return
     */
    public static String getSendExpressLogTableName(Date curDate) {
        return "send_express_log_" + DateUtil.convertDateToStr(curDate, "yyMM");
    }
    /**
     * 获取提现日志表的名称
     *
     * @param memberId
     * @return
     */
    public static String getDealLogTableName(String memberId) {
        return "deal_log_" + getMod8Table(memberId);
    }


    /**
     * 获取消息表的名称
     *
     * @param memberId
     * @return
     */
    public static String getMemberMessageTableName(String memberId) {
        return "member_message_" + getMod8Table(memberId);
    }
    /**
     * 获取收益日志表的名称
     *
     * @param memberId
     * @return
     */
    public static String getProfitLogTableName(String memberId) {
        return "profit_log_" + getMod8Table(memberId);
    }
    /**
     * 获取ordergem的名称
     *
     * @param memberId
     * @return
     */
    public static String getOrderGemTableName(String memberId) {
        return "order_gem_" + getMod8Table(memberId);
    }
    /**
     * 获取交易日志表的名称
     *
     * @param memberId
     * @return
     */
    public static String getTradeLogTableName(String memberId) {
        return "trade_log_" + getMod8Table(memberId);
    }

    /**
     * 获取产品防伪码的表的名称
     *
     * @param memberId
     * @return
     */
    public static String getProductSafeTableName(String memberId) {
        return "product_safe_" + getMod8Table(memberId);
    }
    
    /**
     * 获取意向用户的表的名称
     *
     * @param memberId
     * @return
     */
    public static String getVideoIntentionUserTableName(String memberId) {
    	return "video_intention_user_" + getMod8Table(memberId);
    }

    /**
     * 获取表的名称
     *
     * @param memberId
     * @return
     */
    public static String getOrderTradeTableName(String memberId) {
        return "order_trade_" + getMod8Table(memberId);
    }

    /**
     * 获取表的名称
     *
     * @param memberId
     * @return
     */
    public static String getFWCodeTableName(String memberId) {
        return "fw_code_" + getMod8Table(memberId);
    }

    public static String getMemberShopDayLogTableName(String memberId) {
        return "member_shop_day_log_" + getMod8Table(memberId);
    }

    public static String getCommentTableName(String courseId) {
        return "comment_" + getMod8Table(courseId);
    }

    public static String getMemberLuckDrawTableName(String memberId) {
        return "member_luck_draw_" + getMod8Table(memberId);
    }

    public static String getMemberScoreLogTableName(String memberId) {
        return "member_score_log_" + getMod8Table(memberId);
    }

    //生成GUID
    public static String getGUID(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }


    public static boolean checkPhoneLower(String phone){
        String previous = phone;
        String lower = phone.substring(phone.length()-1);//abc后缀
        phone = phone.substring(0,phone.length()-1);//纯手机号
        if(!CheckStrUtil.checkLowerABC(lower)){
            return false;
        }

        String sql = "select * from member where phone='"+previous+"' limit 1";
        MemberBean bean = JdbcTemplateDaoSupport.getObjectDateInfo(sql,new MemberBean());
        if(!StringUtil.isNull(bean)){return false;}

        switch (lower){
            case "b":
                sql = "select * from member where phone='"+phone+"a"+"' limit 1";
                bean = JdbcTemplateDaoSupport.getObjectDateInfo(sql,new MemberBean());
                if(StringUtil.isNull(bean)){return false;}
                break;
            case "c":
                sql = "select * from member where phone='"+phone+"a"+"' limit 1";
                bean = JdbcTemplateDaoSupport.getObjectDateInfo(sql,new MemberBean());
                if(StringUtil.isNull(bean)){return false;}
                sql = "select * from member where phone='"+phone+"b"+"' limit 1";
                bean = JdbcTemplateDaoSupport.getObjectDateInfo(sql,new MemberBean());
                if(StringUtil.isNull(bean)){return false;}
                break;
        }
        return true;
    }
    /**
     *
     * @Title: getUnionSql
     * @Description: 根据表名前缀生成所有分表的联合查询语句
     * @author zenglinhua
     * @date 2015年12月14日 上午10:48:00
     * @param @param preFixTableName
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String getUnionSql(String preFixTableName){
        StringBuilder sql = new StringBuilder();
        for(int i=0;i<TABLE_COUNT;i++){
            if(i>0){
                sql.append(" union all");
            }
            sql.append(" select *");
            sql.append(" from ");
            sql.append(preFixTableName);

            sql.append("_");
            if(i<10){
                sql.append("0");
            }
            sql.append(String.valueOf(i));
        }
        return sql.toString();
    }


    public static void main(String[] args) {
       
    	
    }
}
