package com.sky.web.model;


import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;


public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String menuName;
	private String menuUrl;
	private Integer menuStort;
	private String menuState;
	private Integer parentId;
	private String menuBg;
	private String menuIcon;

	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	@NotEmpty(message="菜单名称不能为空")
	public String getMenuName(){
		return menuName;
	}
	public void setMenuName(String menuName){
		this.menuName = menuName;
	}
	@NotEmpty(message="菜单url不能为空")
	public String getMenuUrl(){
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl){
		this.menuUrl = menuUrl;
	}
	public Integer getMenuStort(){
		return menuStort;
	}
	public void setMenuStort(Integer menuStort){
		this.menuStort = menuStort;
	}
	public String getMenuState(){
		return menuState;
	}
	public void setMenuState(String menuState){
		this.menuState = menuState;
	}
	public Integer getParentId(){
		return parentId;
	}
	public void setParentId(Integer parentId){
		this.parentId = parentId;
	}
	public String getMenuBg() {
		return menuBg;
	}
	public void setMenuBg(String menuBg) {
		this.menuBg = menuBg;
	}
	public String getMenuIcon() {
		return menuIcon;
	}
	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

}
