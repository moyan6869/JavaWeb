package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/11/19.
 */
public enum DealStatus {
    Unknow(0, "状态异常"),
    Appling(1, "等待审核"),
    CheckSuccess(2, "审核成功"),//等待打款
    CheckFail(3, "审核失败"),//审核不通过
    WaitBill(4, "打款成功，待提交发票"),//无需发票部分已经打款
    GiveFail(5, "打款失败"),//所有款项都没有打款
    BillCheckSuccess(6, "发票审核通过"),//等待发票部分打款
    BillCheckFail(7, "发票审核失败"),
    BillGiveSuccess(8, "已全部打款"),
    BillGivekFail(9, "发票打款失败");

    private int code; //错误代码
    private String msg; //错误消息

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private DealStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static DealStatus valueOf(int value) {
        switch (value) {
            case 1:
                return Appling;
            case 2:
                return CheckSuccess;
            case 3:
                return CheckFail;
            case 4:
                return WaitBill;
            case 5:
                return GiveFail;
            case 6:
                return BillCheckSuccess;
            case 7:
                return BillCheckFail;
            case 8:
                return BillGiveSuccess;
            case 9:
                return BillGivekFail;
            default:
                return Unknow;
        }
    }
}
