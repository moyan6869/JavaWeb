package com.sky.web.param;

import java.io.Serializable;

/**
 * FinanceDetailBean
 *
 * @author dao
 * @version 1.0
 */
public class FinanceDetailBean implements Serializable {
    private static final long serialVersionUID = 1L;

    // TODO
    private Integer id;
    private String financeId;
    private String financeName;
    private String financePhone;
    private String financeCode;
    private String financeTotal;
    private String financeDepartment;
    private String financeDate;
    private String financeRemark;
    private String referenceName;
    private String referencePhone;
    private String financeOrderCode;
    private String financeStatus;
    private String importName;
    private String importDate;
    private String examineName;
    private String examineDate;


    private int financePaytype;


    public FinanceDetailBean() {
        // TODO Auto-generated constructor stub
    }

    public FinanceDetailBean(Integer id, String financeId, String financeName, String financePhone, String financeCode,
                             String financeTotal, String financeDepartment, String financeDate, String financeRemark,
                             String referenceName, String referencePhone, String financeOrderCode, String financeStatus, int financePaytype,
                             String importName, String importDate, String examineName, String examineDate) {
        super();
        this.id = id;
        this.financeId = financeId;
        this.financeName = financeName;
        this.financePhone = financePhone;
        this.financeCode = financeCode;
        this.financeTotal = financeTotal;
        this.financeDepartment = financeDepartment;
        this.financeDate = financeDate;
        this.financeRemark = financeRemark;
        this.referenceName = referenceName;
        this.referencePhone = referencePhone;
        this.financeOrderCode = financeOrderCode;
        this.financeStatus = financeStatus;
        this.financePaytype = financePaytype;
        this.importName = importName;
        this.importDate = importDate;
        this.examineName = examineName;
        this.examineDate = examineDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFinanceId() {
        return financeId;
    }

    public void setFinanceId(String financeId) {
        this.financeId = financeId;
    }

    public String getFinanceName() {
        return financeName;
    }

    public void setFinanceName(String financeName) {
        this.financeName = financeName;
    }

    public String getFinancePhone() {
        return financePhone;
    }

    public void setFinancePhone(String financePhone) {
        this.financePhone = financePhone;
    }

    public String getFinanceCode() {
        return financeCode;
    }

    public void setFinanceCode(String financeCode) {
        this.financeCode = financeCode;
    }

    public String getFinanceTotal() {
        return financeTotal;
    }

    public void setFinanceTotal(String financeTotal) {
        this.financeTotal = financeTotal;
    }

    public String getFinanceDepartment() {
        return financeDepartment;
    }

    public void setFinanceDepartment(String financeDepartment) {
        this.financeDepartment = financeDepartment;
    }

    public String getFinanceDate() {
        return financeDate;
    }

    public void setFinanceDate(String financeDate) {
        this.financeDate = financeDate;
    }

    public String getFinanceRemark() {
        return financeRemark;
    }

    public void setFinanceRemark(String financeRemark) {
        this.financeRemark = financeRemark;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getReferencePhone() {
        return referencePhone;
    }

    public void setReferencePhone(String referencePhone) {
        this.referencePhone = referencePhone;
    }

    public String getFinanceOrderCode() {
        return financeOrderCode;
    }

    public void setFinanceOrderCode(String financeOrderCode) {
        this.financeOrderCode = financeOrderCode;
    }

    public String getFinanceStatus() {
        return financeStatus;
    }

    public void setFinanceStatus(String financeStatus) {
        this.financeStatus = financeStatus;
    }

    public int getFinancePaytype() {
        return financePaytype;
    }

    public void setFinancePaytype(int financePaytype) {
        this.financePaytype = financePaytype;
    }

    public String getImportName() {
        return importName;
    }

    public void setImportName(String importName) {
        this.importName = importName;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getExamineName() {
        return examineName;
    }

    public void setExamineName(String examineName) {
        this.examineName = examineName;
    }

    public String getExamineDate() {
        return examineDate;
    }

    public void setExamineDate(String examineDate) {
        this.examineDate = examineDate;
    }

}

