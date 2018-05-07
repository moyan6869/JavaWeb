package com.sky.dao.vo;

import java.io.Serializable;

/**
 * ServerConfigBean
 * @version 1.0
 * @author dao
 */
public class ServerConfigBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String databaseId;
	private Integer modules;
	private String databaseDriver;
	private String databaseUrl;
	private String databaseUsername;
	private Integer databaseType;
	private String databasePassword;

	
	
	
	public Integer getDatabaseType() {
		return databaseType;
	}
	public void setDatabaseType(Integer databaseType) {
		this.databaseType = databaseType;
	}
	public String getDatabaseId(){
		return databaseId;
	}
	public void setDatabaseId(String databaseId){
		this.databaseId = databaseId;
	}
	public Integer getModules(){
		return modules;
	}
	public void setModules(Integer modules){
		this.modules = modules;
	}
	public String getDatabaseDriver(){
		return databaseDriver;
	}
	public void setDatabaseDriver(String databaseDriver){
		this.databaseDriver = databaseDriver;
	}
	public String getDatabaseUrl(){
		return databaseUrl;
	}
	public void setDatabaseUrl(String databaseUrl){
		this.databaseUrl = databaseUrl;
	}
	public String getDatabaseUsername(){
		return databaseUsername;
	}
	public void setDatabaseUsername(String databaseUsername){
		this.databaseUsername = databaseUsername;
	}
	public String getDatabasePassword(){
		return databasePassword;
	}
	public void setDatabasePassword(String databasePassword){
		this.databasePassword = databasePassword;
	}
	@Override
	public String toString() {
		return "ServerConfigBean [databaseId=" + databaseId + ", modules=" + modules + ", databaseDriver="
				+ databaseDriver + ", databaseUrl=" + databaseUrl + ", databaseUsername=" + databaseUsername
				+ ", databasePassword=" + databasePassword + "]";
	}

}

