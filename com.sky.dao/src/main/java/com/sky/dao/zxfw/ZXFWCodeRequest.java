package com.sky.dao.zxfw;
import java.util.*;
/**
 * @Author: Geoffrey
 * @Packager: com.sky.dao.zxfw
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/7/13 14:43
 */
public class ZXFWCodeRequest {
    private String productCode;
    public String EAN13;
    public String OrderCode;
    public List<ZXFWXBCodeRequest> QrcodeWL;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getEAN13() {
        return EAN13;
    }

    public void setEAN13(String EAN13) {
        this.EAN13 = EAN13;
    }

    public String getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(String orderCode) {
        OrderCode = orderCode;
    }

    public List<ZXFWXBCodeRequest> getQrcodeWL() {
        return QrcodeWL;
    }

    public void setQrcodeWL(List<ZXFWXBCodeRequest> qrcodeWL) {
        QrcodeWL = qrcodeWL;
    }
}
