package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;

import java.io.IOException;
import java.util.*;

/**
 * Created by Geoffrey on 2017/4/24
 */
public class PrestorePayEvienceOrderBean {

    private String orderId;
    private String orderCode;
    @JsonIgnore
    private String memberId;
    private Integer payMoney;
    private Integer orderStatus = 0;
    private String orderStatusStr;
    @JsonIgnore
    private Integer payType = 0;
    @JsonIgnore
    private Date payDate;
    @JsonIgnore
    private String payNumber;

    private Date createDate;
    @JsonIgnore
    private Date updateDate;
    @JsonIgnore
    private Integer deleteFlag;
    @JsonIgnore
    private String payEvidenceImages;
    private List<String> images = new ArrayList<>();
    private String checkResult;

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public Integer getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Integer payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public String getPayNumber() {
        return payNumber;
    }

    public void setPayNumber(String payNumber) {
        this.payNumber = payNumber;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getOrderStatusStr() {
        if (orderStatus==0){
            return "审核中";
        }else if (orderStatus==1){
            return "审核通过";
        }else if (orderStatus==2){
            return "审核失败";
        }else {
            return "未知状态";
        }
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getPayEvidenceImages() {
        return payEvidenceImages;
    }

    public void setPayEvidenceImages(String payEvidenceImages) {
        this.payEvidenceImages = payEvidenceImages;
    }

    public List<String> getImages() {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> arrayListimages = new ArrayList<>();
        if (payEvidenceImages != null && payEvidenceImages != "") {
            try {
                arrayListimages = mapper.readValue(payEvidenceImages, TypeFactory.defaultInstance().constructCollectionType(List.class, String.class));
            } catch (IOException e) {

            }
        }
        return arrayListimages;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}
