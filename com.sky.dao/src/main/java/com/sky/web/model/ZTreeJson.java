package com.sky.web.model;

/**
 * ZTree树状json结构
 * @author Administrator
 *
 */
public class ZTreeJson {
	private int id;
	private int pId;
	private String name;
	private boolean open;
	private boolean checked;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ZTreeJson(int id, int pId, String name, boolean open, boolean checked) {
		super();
		this.id = id;
		this.pId = pId;
		this.open = open;
		this.checked = checked;
		this.name = name;
	}
	public ZTreeJson() {
		super();
	}
	
}
