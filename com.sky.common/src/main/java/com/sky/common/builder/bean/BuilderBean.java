package com.sky.common.builder.bean;

/**
 * BuilderBean</br>
 * @version 1.0
 */
public class BuilderBean {
	/** 作者 */
	public String author;
	/** 主名字 */
	public String myName;
	/** 表名 */
	public String tableName;
	/** ID名 */
	public String idName;
	/** 源码根目录 */
	private String srcPath;
	/** 模板代码存放的主包名 */
	public String templateMainPackageName;
	/** 生成代码存放的主包名 */
	public String targetMainPackageName;
	
	/** 是否创建代码文件：true表示创建；false表示不创建 */
	private boolean isCreate;
	/** 是否覆盖源文件：true表示覆盖；false表示不覆盖 */
	private boolean isCover = false;
	/** 是否debug模式 */
	private boolean isDebug;
	/** 是否在控制台显示生成的代码 */
	private boolean isShowCode;
	/** 是否用字段lable来代替字段name */
	private boolean isUseLable = false;
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
	public boolean isCreate() {
		return isCreate;
	}
	public void setCreate(boolean isCreate) {
		this.isCreate = isCreate;
	}
	public boolean isCover() {
		return isCover;
	}
	public void setCover(boolean isCover) {
		this.isCover = isCover;
	}
	public boolean isDebug() {
		return isDebug;
	}
	public void setDebug(boolean isDebug) {
		this.isDebug = isDebug;
	}
	public boolean isShowCode() {
		return isShowCode;
	}
	public void setShowCode(boolean isShowCode) {
		this.isShowCode = isShowCode;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getIdName() {
		return idName;
	}
	public void setIdName(String idName) {
		this.idName = idName;
	}
	public String getTargetMainPackageName() {
		return targetMainPackageName;
	}
	public void setTargetMainPackageName(String targetMainPackageName) {
		this.targetMainPackageName = targetMainPackageName;
	}
	public String getTemplateMainPackageName() {
		return templateMainPackageName;
	}
	public void setTemplateMainPackageName(String templateMainPackageName) {
		this.templateMainPackageName = templateMainPackageName;
	}
	public boolean isUseLable() {
		return isUseLable;
	}
	public void setUseLable(boolean isUseLable) {
		this.isUseLable = isUseLable;
	}
}
