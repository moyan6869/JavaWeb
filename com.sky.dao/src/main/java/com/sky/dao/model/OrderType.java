package com.sky.dao.model;

/**
 * Created by weiyunliang on 2017/9/21.
 */
    //购买的订单类型(有产品确定)
    public class OrderType {

        /**
         * 零售
         */
        public final static int retail = 0;

        /**
         * 加盟
         */
        public final static int join = 1;
        /**
         * 升级
         */
        public final static int up = 2;

//        /**
//         * 覆盖升级
//         */
//        public final static int upCover = 3;
//
//        /**
//         * 业绩累积
//         */
//        public final static int achivementing=4;

        /**
         * 生鲜类型订单
        */
        public final static int food=10;

        /**
         * 金三角豪华礼包
         */
        public final static int goldenTriangle = 999;


        public static String getOrderTypeName(int type) {
            switch (type) {
                case retail:
                    return "零售";
                case join:
                    return "加盟";
                case up:
                    return "升级";
//                case upCover:
//                    return"覆盖升级";
//                case achivementing:
//                    return"业绩累计";
                case food:
                    return "生鲜";
                case goldenTriangle:
                    return "金三角豪华礼包";
                default:
                    return "零售";
            }
        }
    }

