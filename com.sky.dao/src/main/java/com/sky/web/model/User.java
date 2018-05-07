package com.sky.web.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User implements Serializable{
private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String username;
	private String passwd;
	private String email;
	private String realname;
	private String qq;
	private String phone;
	private Integer userType;
	private String userFlag;
	private Integer accessGroupId;
	private Date regDate;
	
	private List<MenuResource> accesses;

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public String getUsername(){
		return username;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getPasswd(){
		return passwd;
	}
	public void setPasswd(String passwd){
		this.passwd = passwd;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email = email;
	}
	public String getRealname(){
		return realname;
	}
	public void setRealname(String realname){
		this.realname = realname;
	}
	public String getQq(){
		return qq;
	}
	public void setQq(String qq){
		this.qq = qq;
	}
	public String getPhone(){
		return phone;
	}
	public void setPhone(String phone){
		this.phone = phone;
	}
	public Integer getUserType(){
		return userType;
	}
	public void setUserType(Integer userType){
		this.userType = userType;
	}
	public String getUserFlag(){
		return userFlag;
	}
	public void setUserFlag(String userFlag){
		this.userFlag = userFlag;
	}
	public Integer getAccessGroupId(){
		return accessGroupId;
	}
	public void setAccessGroupId(Integer accessGroupId){
		this.accessGroupId = accessGroupId;
	}
	public Date getRegDate(){
		return regDate;
	}
	public void setRegDate(Date regDate){
		this.regDate = regDate;
	}
	public List<MenuResource> getAccesses() {
		return accesses;
	}
	public void setAccesses(List<MenuResource> accesses) {
		this.accesses = accesses;
	}
}
