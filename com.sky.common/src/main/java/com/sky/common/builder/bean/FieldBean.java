package com.sky.common.builder.bean;

/**
 * 字段Bean</br>
 * @version 1.0
 * @author  
 */
public class FieldBean {
	/** 字段名称 */
	public String name;
	/** 数据类型对应类 */
	public String className;
	/** 数据类型 */
	public int type;
	/** 数据类型名称 */
	public String typeName;
	/** 所在的Catalog名字 */
	public String catalogName;
	/** 最大个数 */
	public long size;
	/** 字段标题 */
	public String label;
	/** 字段模式 */
	public String schemaName;
	/** 类型精确度 */
	public int precision;
	/** 小数点后的位数 */
	public int scale;
	/** 表名 */
	public String tableName;
	/** 是否自动递增 */
	public boolean isAutoIncrement;
	/** 是否货币类型 */
	public boolean isCurrency;
	/** 是否为空 */
	public int isNullable;
	/** 是否为只读 */
	public boolean isReadOnly;
	/** 能否出现在where中 */
	public boolean isSearchable;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getSchemaName() {
		return schemaName;
	}
	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}
	public int getPrecision() {
		return precision;
	}
	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public boolean isCurrency() {
		return isCurrency;
	}
	public void setCurrency(boolean isCurrency) {
		this.isCurrency = isCurrency;
	}
	public int isNullable() {
		return isNullable;
	}
	public void setNullable(int isNullable) {
		this.isNullable = isNullable;
	}
	public boolean isReadOnly() {
		return isReadOnly;
	}
	public void setReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}
	public boolean isSearchable() {
		return isSearchable;
	}
	public void setSearchable(boolean isSearchable) {
		this.isSearchable = isSearchable;
	}
	public boolean isAutoIncrement() {
		return isAutoIncrement;
	}
	public void setAutoIncrement(boolean isAutoIncrement) {
		this.isAutoIncrement = isAutoIncrement;
	}
	public String getCatalogName() {
		return catalogName;
	}
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
}
