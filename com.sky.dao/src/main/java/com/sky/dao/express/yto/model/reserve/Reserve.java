package com.sky.dao.express.yto.model.reserve;

import java.util.List;

/**
 * 入库单
 * Created by wangyun on 2015/12/10.
 */
public class Reserve {

    //入库单号	字符	32	要求唯一		是
    private String reserveNo;

    //入库类型	枚举数字				是  ReserveType
    private int reserveType;

    //仓库编码	字符	32			是
    private String storageNo;

    //预计到货起始时间	字符		yyyy-MM-dd		是
    private String startTimeStr;

    //预计到货结束时间	字符		yyyy-MM-dd		是
    private String endTimeStr;

    //联系人	字符	32			是
    private String consigneeName;

    //手机号	字符	16	13689705421		是
    private String consigneePhone;

    //车牌号	字符	16
    private String plateCode;

    //驾驶证号	字符	32
    private String driveLicenceCode;

    //入库单明细
    private List<ReserveDetail> dataList;

    public String getReserveNo() {
        return reserveNo;
    }

    public void setReserveNo(String reserveNo) {
        this.reserveNo = reserveNo;
    }

    public int getReserveType() {
        return reserveType;
    }

    public void setReserveType(int reserveType) {
        this.reserveType = reserveType;
    }

    public String getStorageNo() {
        return storageNo;
    }

    public void setStorageNo(String storageNo) {
        this.storageNo = storageNo;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }

    public String getDriveLicenceCode() {
        return driveLicenceCode;
    }

    public void setDriveLicenceCode(String driveLicenceCode) {
        this.driveLicenceCode = driveLicenceCode;
    }

    public List<ReserveDetail> getDataList() {
        return dataList;
    }

    public void setDataList(List<ReserveDetail> dataList) {
        this.dataList = dataList;
    }
}


