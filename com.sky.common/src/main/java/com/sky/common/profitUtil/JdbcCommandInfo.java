package com.sky.common.profitUtil;

public class JdbcCommandInfo {

	public JdbcCommandInfo(String sql, Object data, Integer dataBaseType, String module, String memo) {
		this.sql = sql;
		this.data = data;
		this.dataBaseType = dataBaseType;
		this.module = module;
		this.memo = memo;
	}

	private String sql;

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	private Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	private String memo; // 备注信息

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	private String module; // 模

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	private Integer dataBaseType; // 分库类型

	public Integer getDataBaseType() {
		return dataBaseType;
	}

	public void setDataBaseType(Integer dataBaseType) {
		this.dataBaseType = dataBaseType;
	}

	private Integer succ; // 是否执行成功

	@Override
	public String toString() {
		return "JdbcCommandInfo [sql=" + sql + ", data=" + data + ", memo=" + memo + ", module=" + module
				+ ", dataBaseType=" + dataBaseType + ", succ=" + succ + "]";
	}

	public Integer getSucc() {
		return succ;
	}

	public void setSucc(Integer succ) {
		this.succ = succ;
	}

}
