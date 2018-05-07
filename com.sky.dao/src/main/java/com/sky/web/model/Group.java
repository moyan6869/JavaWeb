package com.sky.web.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * GroupBean
 * @version 1.0
 * @author xiaoheliu
 */
public class Group implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String groupName;
	private Integer groupSort;
	private String groupSate;

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	@NotEmpty(message="组名不能为空")
	public String getGroupName(){
		return groupName;
	}
	public void setGroupName(String groupName){
		this.groupName = groupName;
	}
	public Integer getGroupSort(){
		return groupSort;
	}
	public void setGroupSort(Integer groupSort){
		this.groupSort = groupSort;
	}
	public String getGroupSate(){
		return groupSate;
	}
	public void setGroupSate(String groupSate){
		this.groupSate = groupSate;
	}

}

