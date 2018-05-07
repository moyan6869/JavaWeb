package com.sky.common.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zenglinhua
 * @version V1.0
 * @Package com.sibu.common.util
 * @company: SI Bu kanger
 * @Description: 提现工具类
 * @date 2016/3/31
 */
public class DealUtil {

    public static final String CNY_NAME = "人民币";
    public static final String COMPANY_BANK_ADDRESS = "工行广州花都雅居乐支行";
    public static final String COMPANY_BANK_ACCOUNT = "3602202109100250901";
    public static final String COMPANY_NAME = "深圳康尔云商信息科技有限公司";
    public static final String DEAL_PAY = "代付款";
    public static final String BILL_PAY = "发票提现";
    public static final String DEDUCTTAX_PAY = "付代扣个税提现";
    public static final String PAY_TYPE = "加急";
    public static final String PAY_TOTAL_MONEY = "打款总金额:";
    public static final String ICBC_AREACODE = "0200";
    public static final String OTHER_AREACODE = "0000";
    public static final int ICBC_BANK_ID = 3;
    public static final String MONEY_FORMAT = "######0.00";
    public static final double DEFAULT_RATE = 0.01;
    public static final int[] WIDTHS = {6, 12, 12, 30, 25, 30, 35, 20, 20, 30, 30, 35,15, 15, 16, 16, 16, 13, 35, 14};
    public static final String[] TITLES = {"序号", "币种", "金额", "收款人账号", "收款人名称", "收款账号开户行名称", "收款省份/收款银行", "收款地市", "地区代码", "付款账号开户行名称", "付款人账号/卡号",
            "付款人名称/卡名称", "汇款用途", "备注", "预约付款日期", "汇款方式", "收款账户短信通知手机号码", "自定义序号", "协议编号"};
    public static final int[] WIDTHS_DEDUCT_TAX = {6, 12, 12, 30, 25,30,12, 30, 35, 20, 20, 30, 30, 35,15, 15, 16, 16, 16, 13, 35, 14};
    public static final String[] TITLES_DEDUCT_TAX = {"序号", "币种", "金额", "收款人账号", "收款人名称","收款人证件号","代扣个税", "收款账号开户行名称", "收款省份/收款银行", "收款地市", "地区代码", "付款账号开户行名称", "付款人账号/卡号",
            "付款人名称/卡名称", "汇款用途", "备注", "预约付款日期", "汇款方式", "收款账户短信通知手机号码", "自定义序号", "协议编号"};
    public static final Map<String,String> BANK_TYPE = new HashMap<String,String>(){
        {
            put("1","建行");
            put("2","农行");
            put("3","工行");
            put("4","中行");
        }
    };

    public static final long ZERO = 0;

    /**
     * 支行信息需过滤的字符串集合
     */
    public static final String ADDRESS_EXP = "中国工商银行|中国建设银行|中国农业银行|中国银行|工商银行|建设银行|农业银行|工行|建行|农行|中行|股份有限公司|有限股份公司";
    
    /**
     * 直辖市集合
     */
    public static final String MUNICIPALITY = "北京|天津|上海|重庆";

    /**
     * 提现需扣保证金下限金额(小于等于3500，不需要扣留保证金，大于3500小于10000扣留10%保证金)
     */
    public static final long LOW_MONEY = 350000;

    /**
     * 提现需扣25%保证金金额（大于等于10000扣留25%保证金）
     */
    public static final long UP_MONEY = 1000000;

    /**
     * 10%保证金利率
     */
    public static final double LOW_RATE = 0.1;

    /**
     * 25%保证金利率
     */
    public static final double UP_RATE = 0.25;

    /*****************************************************************************************
     * 个人所得税的起征点是3500元，计算公式是：个人所得税 = (收入 - 个税起征点) * 税率 - 速算扣除数      *
     * ***************************************************************************************
     *    级数   *       含税级距                      *     税率       *        速算扣除        *
     *    1     *       不超过1500元的                 *      3        *           0           *
     *    2     *       超过1500元至4500的部分         *      10       *           105          *
     *    3     *       超过4500元至9000的部分         *      20       *           555          *
     *    4     *       超过9000元至35000的部分        *      25       *           1005         *
     *    5     *       超过35000元至55000的部分       *      30       *           2755         *
     *    6     *       超过55000元至80000的部分       *      35       *           5505         *
     *    7     *       超过80000元的                 *      45       *           13505        *
     *****************************************************************************************
     */

    /**
     * 未提交发票代扣个税的天数
     */
    public static final int OVER_DAYS = -90;

    //税距
    public static final long LEVEL_ONE_MONEY = 150000;
    public static final long LEVEL_TWO_MONEY = 450000;
    public static final long LEVEL_THREE_MONEY = 900000;
    public static final long LEVEL_FOUR_MONEY = 3500000;
    public static final long LEVEL_FIVE_MONEY = 5500000;
    public static final long LEVEL_SIX_MONEY = 8000000;
    //税率
    public static final double LEVEL_ONE_RATE = 0.03;
    public static final double LEVEL_TWO_RATE = 0.1;
    public static final double LEVEL_THREE_RATE = 0.2;
    public static final double LEVEL_FOUR_RATE = 0.25;
    public static final double LEVEL_FIVE_RATE = 0.3;
    public static final double LEVEL_SIX_RATE = 0.35;
    public static final double LEVEL_SEVEN_RATE = 0.45;
    //速算扣除
    public static final long LEVEL_ONE_DEDUCT = 0;
    public static final long LEVEL_TWO_DEDUCT = 10500;
    public static final long LEVEL_THREE_DEDUCT = 55500;
    public static final long LEVEL_FOUR_DEDUCT = 100500;
    public static final long LEVEL_FIVE_DEDUCT = 275500;
    public static final long LEVEL_SIX_DEDUCT = 550500;
    public static final long LEVEL_SEVEN_DEDUCT = 1350500;

    /**
     * 传入一个支行地址，进行过来返回过滤替换后的支行地址
     * @param address
     * @return
     */
    public static String getNewBankAddress(String address){
        StringBuffer newAddress = new StringBuffer();
        Pattern p = Pattern.compile(ADDRESS_EXP);
        Matcher m = p.matcher(address);
        while (m.find()) {
            m.appendReplacement(newAddress, "");
        }
        m.appendTail(newAddress);
        return newAddress.toString();
    }

    /**
     * 根据提现金额和月累计提现金额计算需要抵扣的保证金金额
     * @param applyMoney 本次提现金额
     * @param monthApplyMoney 当月累计提现额
     * @return
     */
    public static long calcProxyTaxMoney(long applyMoney,long monthApplyMoney){
        long proxyTaxMoney = ZERO;
        if(monthApplyMoney<=LOW_MONEY){
            //月累计提现金额小于等于3500，打款金额等于提醒金额减去手续费
            proxyTaxMoney = ZERO;
        }else if(monthApplyMoney>=UP_MONEY){
            //月累计提现金额大于等于一万，需扣留25%
            if(monthApplyMoney-applyMoney<=LOW_MONEY){
                //月累计减去当前申请小于等于3500，用月累计提醒金额扣留百分之25
                proxyTaxMoney = new Double(monthApplyMoney * UP_RATE).longValue();
            }else if(monthApplyMoney-applyMoney>=UP_MONEY){
                //月累计减去当前申请大于等于10000,再扣留当次申请金额的百分之25
                proxyTaxMoney = new Double(applyMoney * UP_RATE).longValue();
            }else{
                //月累计减去当前申请在3500至10000之间的，先计算出总共应该扣留的数量（月累计乘以百分之25）,再减去除去当月累计扣的百分之10
                proxyTaxMoney = new Double((monthApplyMoney * UP_RATE - (monthApplyMoney - applyMoney) * LOW_RATE)).longValue();
            }
        }else{
            //月累计提现金额大于等于一万，需扣留10%
            if(monthApplyMoney-applyMoney<=LOW_MONEY){
                //月累计减去当前申请小于等于3500，扣留月累计的百分之10
                proxyTaxMoney = new Double(monthApplyMoney * LOW_RATE).longValue();
            }else{
                //月累计减去当前申请大于3500小于10000，扣留当前申请金额的百分之10
                proxyTaxMoney = new Double(applyMoney * LOW_RATE).longValue();
            }
        }
        return proxyTaxMoney;
    }

    /**
     * 根据提现金额和月累计提现金额计算需要扣除的个人所得税
     * @param applyMoney 本次提现金额
     * @param monthApplyMoney 当月累计提现额
     * @return
     */
    public static long calcIncomeTaxMoney(long applyMoney,long monthApplyMoney){
        //累计应扣个税 - 除去本次提现之前累计应扣个税
        return calcIncomeTaxMoney(monthApplyMoney) - calcIncomeTaxMoney(monthApplyMoney - applyMoney);
    }

    /**
     * 输入收入计算应该扣的个税
     * @param income 收入金额
     * @return
     */
    public static long calcIncomeTaxMoney(long income){
        long deductTaxMoney = ZERO;
        //除去本次提现金额，之前到达了哪个等级
        long base = income - LOW_MONEY;
        if(base <= ZERO) {
            deductTaxMoney = ZERO;
        }else if(base <= LEVEL_ONE_MONEY) {
            deductTaxMoney = new Double(base * LEVEL_ONE_RATE - LEVEL_ONE_DEDUCT).longValue();
        }else if(base <= LEVEL_TWO_MONEY) {
            deductTaxMoney = new Double(base * LEVEL_TWO_RATE - LEVEL_TWO_DEDUCT).longValue();
        }else if(base <= LEVEL_THREE_MONEY) {
            deductTaxMoney = new Double(base * LEVEL_THREE_RATE - LEVEL_THREE_DEDUCT).longValue();
        }else if(base <= LEVEL_FOUR_MONEY) {
            deductTaxMoney = new Double(base * LEVEL_FOUR_RATE - LEVEL_FOUR_DEDUCT).longValue();
        }else if(base <= LEVEL_FIVE_MONEY) {
            deductTaxMoney = new Double(base * LEVEL_FIVE_RATE - LEVEL_FIVE_DEDUCT).longValue();
        }else if(base <= LEVEL_SIX_MONEY) {
            deductTaxMoney = new Double(base * LEVEL_SIX_RATE - LEVEL_SIX_DEDUCT).longValue();
        }else {
            deductTaxMoney = new Double(base * LEVEL_SEVEN_RATE - LEVEL_SEVEN_DEDUCT).longValue();
        }
        return deductTaxMoney;
    }

}
