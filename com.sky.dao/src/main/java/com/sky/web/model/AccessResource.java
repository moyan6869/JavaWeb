package com.sky.web.model;

import java.io.Serializable;

/**
 * AccessResourceBean
 * @version 1.0
 * @author xiaoheliu
 */
public class AccessResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer groupId;
	private Integer accessResourceId;
	private Integer resourceParentId;

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getGroupId(){
		return groupId;
	}
	public void setGroupId(Integer groupId){
		this.groupId = groupId;
	}
	public Integer getAccessResourceId(){
		return accessResourceId;
	}
	public void setAccessResourceId(Integer accessResourceId){
		this.accessResourceId = accessResourceId;
	}
	public Integer getResourceParentId(){
		return resourceParentId;
	}
	public void setResourceParentId(Integer resourceParentId){
		this.resourceParentId = resourceParentId;
	}

}

