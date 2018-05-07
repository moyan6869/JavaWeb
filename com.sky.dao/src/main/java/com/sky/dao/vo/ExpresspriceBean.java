package com.sky.dao.vo;

import java.io.Serializable;

/**
 * ExpresspriceBean
 * @version 1.0
 * @author Geoffrey
 */ 
public class ExpresspriceBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer priceid;
	private Integer addressid;
	private Integer weightid;
	private Integer expressid;
	private String prices;

	public Integer getPriceid(){
		return priceid;
	}
	public void setPriceid(Integer priceid){
		this.priceid = priceid;
	}
	public Integer getAddressid(){
		return addressid;
	}
	public void setAddressid(Integer addressid){
		this.addressid = addressid;
	}
	public Integer getWeightid(){
		return weightid;
	}
	public void setWeightid(Integer weightid){
		this.weightid = weightid;
	}
	public Integer getExpressid(){
		return expressid;
	}
	public void setExpressid(Integer expressid){
		this.expressid = expressid;
	}
	public String getPrices(){
		return prices;
	}
	public void setPrices(String prices){
		this.prices = prices;
	}

}

