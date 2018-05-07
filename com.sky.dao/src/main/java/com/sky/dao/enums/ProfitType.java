package com.sky.dao.enums;

/*
 * 收益表/冻结表 类别 type
 * 活动奖的退款对于为该类别的负数
 * 例如actSpring 的类别为11 则退款类别为-11
 */
public class ProfitType {
    /**
     * 推广奖
     */
    public final static int error = 0;
    public final static String errorName = "错误奖项";

    public final static int liang = 1;
    public final static String liangName = "LJ";//"量奖";

    public final static int liang_c =1001;
    public final static String liang_cName = "LJ(FX)";//"量奖(复销奖)";

    public final static int breed = 2;
    public final static String breedName = "PY";//"培育奖";

    public final static int breed_c = 1002;
    public final static String breed_cName = "PY(FX)";//"培育奖(复销奖)";

    public final static int month = 3;
    public final static String monthName = "LS";//"月结奖";

    public final static int replaceOrder = 4;
    public final static String replaceOrderName = "DB";//"代报单奖励(店补)";

    public final static int back = 5;
    public final static String backName = "ZT";//"直推奖";

    public final static int back_c =1005;
    public final static String back_cName = "ZT(FX)";//"直推奖(复销奖)";

    public final static int level = 6;
    public final static String levelName = "CJ";//"层奖";

    public final static int level_c =1006;
    public final static String level_cName = "CJ(FX)";//"层奖(复销奖)";

    public final static int lucky = 7;
    public final static String luckyName = "XY";//"幸运奖";

    public final static int lucky_c =1007;
    public final static String lucky_cName = "XY(FX)";//"幸运奖(复销奖)";

    public final static int manage =110;
    public final static String manageName = "综合管理费";

    public final static int UpdateAvailableMoney = 31;
    public final static String UpdateAvailableMoneyName = "奖金币维护";

    public final static int UpdateUseMoney = 32;
    public final static String UpdateUseMoneyName = "可提现余额维护";

    public final static int UpdateCompoundCoin = 33;
    public final static String UpdateCompoundCoinName = "复销币维护";

    public final static int UpdateChangeCoin = 34;
    public final static String UpdateChangeCoinName = "换货币维护";

    public final static int system = 99;
    public final static String systemName = "系统维护收益"; //系统级别维护


    public static String getName(int key) {
        String echoName = "";
        int absKey = key < 0 ? Math.abs(key) : key;

        switch (absKey) {
            case liang:
                echoName = liangName;
                break;
            case liang_c:
                echoName = liang_cName;
                break;
            case breed:
                echoName = breedName;
                break;
            case breed_c:
                echoName = breed_cName;
                break;
            case month:
                echoName = monthName;
                break;
            case replaceOrder:
                echoName = replaceOrderName;
                break;
            case back:
                echoName = backName;
                break;
            case back_c:
                echoName = back_cName;
                break;
            case level:
                echoName = levelName;
                break;
            case level_c:
                echoName = level_cName;
                break;
            case lucky:
                echoName = luckyName;
                break;
            case lucky_c:
                echoName = lucky_cName;
                break;
            case manage:
                echoName = manageName;
                break;
            case UpdateAvailableMoney:
                echoName = UpdateAvailableMoneyName;
                break;
            case UpdateUseMoney:
                echoName = UpdateUseMoneyName;
                break;
            case UpdateCompoundCoin:
                echoName = UpdateCompoundCoinName;
                break;
            case UpdateChangeCoin:
                echoName = UpdateChangeCoinName;
                break;
            case system:
                echoName=systemName;
                break;

            default:
                echoName =  "未知收益类型";
        }
        if(key < 0)
        {
            echoName = echoName+"(退款)";
        }
        return echoName;
    }

}
