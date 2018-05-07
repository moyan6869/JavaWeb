package com.sky.dao.vo;

import org.codehaus.jackson.annotate.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * MemberAddressBean
 *
 * @author dao
 * @version 1.0
 */
public class MemberAddressBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String addressId;
    @JsonIgnore()
    private String memberId;
    private String contact;
    private String phone;
    private String zipcode;
    private String province;
    private String city;
    private String district;
    private String detail;
    private Integer isDefault;
    @JsonIgnore()
    private Date createDate;
    @JsonIgnore()
    private Date updateDate;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getProvince() {
        return province.replace("@", "");
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city.replace("@", "");
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district.replace("@", "");
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

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
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

}

