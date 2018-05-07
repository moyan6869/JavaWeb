package com.sky.dao.vo;

import java.io.Serializable;

/**
 * AddressBean
 * @version 1.0
 * @author Geoffrey
 */ 
public class AddressBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer addressid;
	private String addressname;

	public Integer getAddressid(){
		return addressid;
	}
	public void setAddressid(Integer addressid){
		this.addressid = addressid;
	}
	public String getAddressname(){
		return addressname;
	}
	public void setAddressname(String addressname){
		this.addressname = addressname;
	}

}

