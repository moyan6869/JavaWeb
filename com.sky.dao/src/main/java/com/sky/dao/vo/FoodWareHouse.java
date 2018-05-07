package com.sky.dao.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * MemberBean
 *
 * @version 1.0
 * @author Geoffrey
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FoodWareHouse  implements Serializable{
    private static final long serialVersionUID = 1L;
    private String warehouseId;
    private String warehouseCode;
    private String memberId;
    private String username;

    private String password;
    @JsonIgnore
    private String secondPwd;
    @JsonIgnore
    private String salt;
    private String headImage;
    private String phone;

    private int foodWarehouseType;
    private String warehouseName;
    private String address;
    private BigDecimal longitude;
    private BigDecimal latitude;

    private String freezeType;
    private Date freezeDate;
    private String freezeReason;
    private String contact;

    private String province;
    private String city;
    private String district;
    private String detail;

    @JsonIgnore
    private Date createDate;
    @JsonIgnore
    private Date updateDate;
    private int deleteFlag;


    @JsonIgnore()
    public String getCredentialsSalt()
    {
        return username+salt;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getFreezeReason() {
        return freezeReason;
    }

    public void setFreezeReason(String freezeReason) {
        this.freezeReason = freezeReason;
    }

    public Date getFreezeDate() {
        return freezeDate;
    }

    public void setFreezeDate(Date freezeDate) {
        this.freezeDate = freezeDate;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondPwd() {
        return secondPwd;
    }

    public void setSecondPwd(String secondPwd) {
        this.secondPwd = secondPwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getFoodWarehouseType() {
        return foodWarehouseType;
    }

    public void setFoodWarehouseType(int foodWarehouseType) {
        this.foodWarehouseType = foodWarehouseType;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFreezeType() {
        return freezeType;
    }

    public void setFreezeType(String freezeType) {
        this.freezeType = freezeType;
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

    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "FoodWareHouse{" +
                "warehouseId='" + warehouseId + '\'' +
                ", warehouseCode='" + warehouseCode + '\'' +
                ", memberId='" + memberId + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", secondPwd='" + secondPwd + '\'' +
                ", salt='" + salt + '\'' +
                ", headImage='" + headImage + '\'' +
                ", phone='" + phone + '\'' +
                ", foodWarehouseType=" + foodWarehouseType +
                ", warehouseName='" + warehouseName + '\'' +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", freezeType='" + freezeType + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}
