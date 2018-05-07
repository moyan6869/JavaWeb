package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/10/22.
 */
public class OrderFrom {
    /*安卓*/
    public final static int Android = 1;

    /*苹果*/
    public final static int IOS = 2;

    /*微信*/
    public final static int Wechat = 3;
    
    public static String getOrderForm(int orderForm) {
    	String orderFormStr = null;
    	if(orderForm == OrderFrom.Android) {
    		orderFormStr = "安卓";
    	} else if(orderForm == OrderFrom.Wechat) {
    		orderFormStr = "微信公众号";
    	} else if(orderForm == OrderFrom.IOS) {
    		orderFormStr = "苹果";
    	}
    	return orderFormStr;
    }
    
}
