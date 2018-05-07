package com.sky.dao.enums;

public class OrderMemberType {
	/**对应 订单表member_type 字段
     * 订单为宝石报单类型 (对应gemtype ENUMS)
     */
    public final static int signGem = 1;
    
    /**对应 订单表member_type 字段
     * 订单为钻石报单类型 (对应gemtype ENUMS)
     */
    public final static int signCrown = 2;
    
    /**对应 订单表member_type 字段
     * 订单为金钻报单类型 (对应gemtype ENUMS)
     */
    public final static int signGold = 3;
    
   
    
    /**
     * 对应 订单表shop_type 字段
     * 月复消订单
     */
    public final static int shopMonth = 11;
    
    /**
     * 对应 订单表shop_type 字段
     * 年复消订单
     */
    public final static int shopYear = 12;
    
    /*
     * 对应 订单表shop_type 字段
     * 无复消日期
     */
    public final static int shopNormal = 13;
}
