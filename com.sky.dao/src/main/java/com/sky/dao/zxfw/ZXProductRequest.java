package com.sky.dao.zxfw;

import java.io.Serializable;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.zxfw
 * @company: SIBU Kanger
 * @Description: 推送产品信息
 * @Date: 2016/7/12 9:33
 */
public class ZXProductRequest extends ZXBaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    /*商品唯一GUID编码*/
    private String productCode;

    /*商品13位编码（69码）*/
    public String EAN13;

    /*商品名称*/
    private String productName;

    /*内包装数量*/
    private String boxcase;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }


    public void setEAN13(String EAN13) {
        this.EAN13 = EAN13;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBoxcase() {
        return boxcase;
    }

    public void setBoxcase(String boxcase) {
        this.boxcase = boxcase;
    }
}
