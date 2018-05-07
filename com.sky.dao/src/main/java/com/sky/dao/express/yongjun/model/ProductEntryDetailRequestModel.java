package com.sky.dao.express.yongjun.model;

/**
 * @Author: Geoffrey
 * @Packager: com.sibu.dao.directsale.express.yongjun.model
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/5/6 11:29
 */
public class ProductEntryDetailRequestModel {
    /**
     * 入库产品条码
     */
    private String barCode;

    /**
     * 入库数量
     */
    private Integer entryQty;


    /**
     * 入库正品数量
     */
    private Integer entryGenuineQty;
    /**
     * 入库次品数量
     */
    private Integer entryDefectiveQty;
    /**
     * 报废数量
     */
    private Integer entryScrapQty;

    private String confirmEntryRemark;



    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Integer getEntryQty() {
        return entryQty;
    }

    public void setEntryQty(Integer entryQty) {
        this.entryQty = entryQty;
    }

    public Integer getEntryGenuineQty() {
        return entryGenuineQty;
    }

    public void setEntryGenuineQty(Integer entryGenuineQty) {
        this.entryGenuineQty = entryGenuineQty;
    }

    public Integer getEntryDefectiveQty() {
        return entryDefectiveQty;
    }

    public void setEntryDefectiveQty(Integer entryDefectiveQty) {
        this.entryDefectiveQty = entryDefectiveQty;
    }

    public Integer getEntryScrapQty() {
        return entryScrapQty;
    }

    public void setEntryScrapQty(Integer entryScrapQty) {
        this.entryScrapQty = entryScrapQty;
    }

    public String getConfirmEntryRemark() {
        return confirmEntryRemark;
    }

    public void setConfirmEntryRemark(String confirmEntryRemark) {
        this.confirmEntryRemark = confirmEntryRemark;
    }


}
