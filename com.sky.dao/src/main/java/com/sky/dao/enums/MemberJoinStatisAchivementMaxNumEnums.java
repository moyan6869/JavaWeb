package com.sky.dao.enums;

import java.math.BigInteger;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.enums
 * @company: SIBU Kanger
 * @Description: 会员每天左右区剩余金额封顶
 * @Date: 2016/10/21 9:24
 */
public enum MemberJoinStatisAchivementMaxNumEnums {
    Unknow(0, 0),
    GemMemberMax(1,  30000000),
    CrownMemberMax(2,  60000000),
    GoldMemberMax(3, 100000000),
    CloudMemberMax(100,100000000),
    BusinessMemberMax(105,100000000);
    private int memberType; //会员等级
    private long maxPrice; //最大金额

    public int getCode() {
        return memberType;
    }

    public long getMaxPrice() {
        return maxPrice;
    }

    private MemberJoinStatisAchivementMaxNumEnums(int memberType, long maxPrice) {
        this.memberType = memberType;
        this.maxPrice = maxPrice;
    }

    public static MemberJoinStatisAchivementMaxNumEnums valueOf(Integer value) {    //    手写的从int到enum的转换函数
        switch (value) {
            case 1:
                return GemMemberMax;
            case 2:
                return CrownMemberMax;
            case 3:
                return GoldMemberMax;
            case 100:
                return CloudMemberMax;
            case 105:
                return BusinessMemberMax;
            default:
                return Unknow;
        }
    }
}
