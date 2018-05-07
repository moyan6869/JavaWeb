package com.sky.dao.enums;

/**
 * Created by chuhui on 2017/11/29.
 *
 * 店铺级别枚举
 */
public class ShopType {

    /**
     * 非店铺
     */
    public final static int notMember = 0;
    /**
     * 报单中心
     */
    public final static int firstCenter = 1;
    /**
     * 体验中心
     */
    public final static int secondCenter = 2;
    /**
     * 体验店
     */
    public final static int thirdCenter = 3;




    public static String getShopTypeName(int shopType) {
        switch (shopType) {
            case notMember:
                return "非店铺";
            case firstCenter:
                return "报单中心";
            case secondCenter:
                return "体验中心";
            case thirdCenter:
                return "体验店";
            default:
                return "非店铺";
        }
    }
}
