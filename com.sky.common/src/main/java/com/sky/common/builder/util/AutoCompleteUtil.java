package com.sky.common.builder.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.sky.common.builder.bean.FieldBean;
import com.sky.common.builder.bean.BuilderBean;
import com.sky.common.builder.bean.JavaCodeBean;

/**
 * 代码生成工具类</br>
 * 注意：如果需要修改，请联系 进行修改，联系电话： ，联系QQ：100992995，联系邮箱： </br>
 * @version 1.0
 * @author  
 */
public class AutoCompleteUtil {
	private BuilderBean builderBean;
	
	@SuppressWarnings("unused")
	private AutoCompleteUtil(){} 
	
	public AutoCompleteUtil(BuilderBean builderBean) {
		this.builderBean = builderBean;
	}
	/**
	 * 获取代码
	 * @param bean JavaCodeBean
	 * @return String
	 * @throws Exception
	 * @version 1.0
	 * @author    
	 * @data 2013-8-27 下午2:09:02
	 */
	public String getCode(JavaCodeBean bean) throws Exception{
		String filePath = new StringBuffer(getSrcPath(bean))
				.append(File.separator)
				.append(bean.getTemplatePackageName().replace(".", File.separator))
				.append(File.separator)
				.append(bean.getTemplateName())
				.append(bean.getTemplateFileSuffix()).toString();
		if(!new File(filePath).exists()){
			throw new FileNotFoundException( "指定文件不存在！文件路径：" + filePath );
		} else {
			return readFile(filePath);
		}
	}
	/**
	 * 获取src源码根路径
	 * @return
	 */
	public String getSrcPath(JavaCodeBean bean){
		StringBuffer srcPath = new StringBuffer(null==builderBean.getSrcPath()?"":builderBean.getSrcPath());
		return srcPath.toString();
	}
	/**
	 * 创建java类
	 * @param packageName 包名
	 * @param myName 主名字
	 * @param code 代码
	 */
	public void createJava(JavaCodeBean bean, String code){
		PrintWriter pw = null;
		String folderPath = getSrcPath(bean) + File.separator + bean.getTargetPackageName().replace(".", File.separator); //文件夹目录
		String fileName = bean.getTargetNamePrefix() + bean.getTargetName() + bean.getTargetNameSuffix() + bean.getTargetFileSuffix();
		String fileAllPath = folderPath + File.separator + fileName; //文件目录
		
		File f = new File(fileAllPath); //目标文件
		debug("==================== begin to create " + fileName + " ====================");
		debug("packageName: " + bean.getTargetPackageName());
		debug("fileName: " + fileName);
		debug("fileAllPath: " + fileAllPath);
		debug("exists: " + f.exists());
		debug("isCreate: " + builderBean.isCreate());
		debug("isCover: " + builderBean.isCover());
		if(builderBean.isShowCode()){
			debug( new StringBuffer("code: ").append("\n")
					.append("--------------------").append(" ")
					.append(fileName).append(" code start ")
					.append("--------------------").append("\n")
					.append(code).append("\n")
					.append("--------------------").append(" ")
					.append(fileName).append(" code end ")
					.append("--------------------")
					.toString()
					);
		}
		
		if(!builderBean.isCreate()){
			debug("Cancel to create " + fileName + ", isCreate is false!");
		} else if( !f.exists() //目标文件不存在
				|| builderBean.isCover() //或者允许覆盖目标文件 
				){ 
			f = new File(folderPath);
			if(!f.exists()){
				f.mkdirs();
			}
			FileWriter fw = null;
			try {
				fw = new FileWriter(fileAllPath);
				pw = new PrintWriter(fw);
				pw.println(code);
				pw.flush();
				
				debug("Create " + fileName + " success!");
			} catch (IOException e) {
				debug("Create " + fileName + " error!");
				e.printStackTrace();
			} finally {
				if(null!=pw){
					pw.close();
				}
				if(null!=fw){
					try {
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			debug("Cancel to create " + fileName + ". It's already exist!");
		}
		debug("==================== end to create " + fileName + " ====================");
	}
	/**
	 * 读取文件,并把文件内容以字符串的形式返回.
	 * 
	 * @param filePath
	 *            文件绝对路径+文件名
	 * @return String
	 * @throws Exception 
	 */
	public String readFile(String filePath) throws Exception {
		StringBuffer fileContent = null;
		try {
			BufferedInputStream stream = new BufferedInputStream(
					new FileInputStream(filePath));
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			fileContent = new StringBuffer(8192);
			while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
				fileContent.append(new String(buffer, 0, bytesRead));
			}

			stream.close();
			return fileContent.toString();
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * 获取JAVA名字
	 * @param str SQL名字
	 * @return String JAVA名字
	 */
	public String getJavaName(String str){
		StringBuffer name = new StringBuffer();
		String[] ss = str.split("_");
		for(int i=0;i<ss.length;i++){
			name.append(initCapital(ss[i]));
		}
		return name.toString();
	}
	/**
	 * 获取property名字
	 * @param str SQL名字
	 * @return String JAVA名字
	 */
	public String getPropertyName(String str){
		StringBuffer name = new StringBuffer();
		String[] ss = str.split("_");
		for(int i=0;i<ss.length;i++){
			if(0<i){
				name.append(initCapital(ss[i]));
			} else {
				name.append(ss[i]);
			}
		}
		return name.toString();
	}
	/**
	 * 将第一个字母大写
	 * @param str 需要首字母大写的字符串
	 * @return String 首字母大写后的字符串
	 */
	public String initCapital(String str) {
		char[] ch = str.toCharArray();
		if (ch[0] >= 'a' && ch[0] <= 'z') {
			ch[0] = (char) (ch[0] - 32);
		}
		return new String(ch);
	}
	/**
	 * 在控制台输出信息
	 * @param msg 信息
	 */
	public void debug(String msg){
		if(builderBean.isDebug())
			System.out.println("debug：" + msg);
	}
	
	/**
	 * 获取字段代码
	 * @param bean
	 * @param tableName
	 * @param conn
	 * @return
	 * @throws SQLException
	 * @author  
	 * @data 2013-7-11 上午10:40:54
	 */
	public String getFieldCode(JavaCodeBean bean, String tableName, Connection conn) throws SQLException{
		List<FieldBean> list = DataBaseUtil.getTableField(tableName, conn);
		StringBuffer sb = new StringBuffer();
		sb.append("package ").append(bean.getTargetPackageName()).append(";").append("\n\n");
		sb.append("public enum ").append(bean.getTargetName()).append(bean.getTargetNameSuffix()).append(" {").append("\n");
		for(int i=0;i<list.size();i++){
			sb.append("\t").append(getPropertyName(getFieldName(list.get(i))));
			if((i+1)<list.size()){
				sb.append(",");
			}
			sb.append("\n");
		}
		sb.append("}");
		return sb.toString();
	}
	/**
	 * 获取所有表的集合
	 * @param conn 数据库连接
	 * @return List<String> 数据库中所有表的集合
	 * @throws SQLException
	 * @author  
	 * @data 2013-7-11 上午10:39:11
	 */
	public List<String> getTableList(Connection conn) throws SQLException{
		return DataBaseUtil.getTableList(conn);
	}
	/**
	 * 获取ibatis配置文件中的ResultMap代码
	 * @param bean JavaCodeBean
	 * @param beanList List<FieldBean>
	 * @return String code
	 */
	public String getResultMapCode(JavaCodeBean bean, List<FieldBean> beanList){
		StringBuffer sb = new StringBuffer();
		if(null!=beanList && !beanList.isEmpty()){
			FieldBean b = null;
			for(int i=0;i<beanList.size();i++){
				b = beanList.get(i);
				sb.append("\t\t").append("<result property=\"").append(getPropertyName(getFieldName(b)))
						.append("\" column=\"").append(bean.isColumnToUpperCase?getFieldName(b).toUpperCase():getFieldName(b))
						.append("\" javaType=\"").append(93==b.getType()?"java.util.":"java.lang.").append(getJavaType(b.getType()))
						.append("\" jdbcType=\"").append(getJdbcType(b.getTypeName())).append("\"/>");
				if(i+1<beanList.size()){
					sb.append("\n");
				}
			}
		}
		return sb.toString();
	}
	
	/**
	 * 获取bean中字段代码
	 * @param bean 
	 * @return String
	 */
	public String getBeanFieldCode(FieldBean bean){
		StringBuffer sb = new StringBuffer();
		sb.append("\t").append("private ").append(getJavaType(bean.getType())).append(" ").append(getPropertyName(getFieldName(bean))).append(";\n");
		return sb.toString();
	}
	/**
	 * 获取数据库字段名
	 * @param bean
	 * @return
	 */
	public String getFieldName(FieldBean bean){
		return this.builderBean.isUseLable()?bean.getLabel():bean.getName();
	}
	/**
	 * 获取bean中字段的get和set方法代码
	 * @param bean 
	 * @return String
	 */
	public String getBeanFieldGetAndSetCode(FieldBean bean){
		String javaName = getJavaName(getFieldName(bean));
		String propertyName = getPropertyName(getFieldName(bean));
		String javaTypeName = getJavaType(bean.getType());
		StringBuffer sb = new StringBuffer();
		sb.append("\t").append("public ").append(javaTypeName).append(" get").append(javaName).append("(){").append("\n");
		sb.append("\t\t").append("return ").append(propertyName).append(";").append("\n");
		sb.append("\t").append("}").append("\n");
		sb.append("\t").append("public void set").append(javaName).append("(").append(javaTypeName).append(" ").append(propertyName).append("){").append("\n");
		sb.append("\t\t").append("this.").append(propertyName).append(" = ").append(propertyName).append(";").append("\n");
		sb.append("\t").append("}").append("\n");
		return sb.toString();
	}
	/**
	 * 获取Bean中的fields代码
	 * @param tableName 表明
	 * @param conn 数据库连接
	 * @return String code
	 * @throws SQLException
	 */
	public String getBeanFieldsCode(String tableName, Connection conn) throws SQLException{
		StringBuffer sb = new StringBuffer();
		List<FieldBean> beanList = DataBaseUtil.getTableField(tableName, conn);
		for(int i=0;i<beanList.size();i++){
			sb.append(getBeanFieldCode(beanList.get(i)));
		}
		sb.append("\n");
		for(int i=0;i<beanList.size();i++){
			sb.append(getBeanFieldGetAndSetCode(beanList.get(i)));
		}
		return sb.toString();
	}
	
	/**
	 * 获取数据库字段类型对应的java类型
	 * @param type 数据库字段类型
	 * @return String java字段类型
	 */
	public String getJavaType(int type){
		String typeName = null;
		switch (type) {
		case 4: //INTEGER、MEDIUMINT
			typeName = "Integer";
			break;
		case -6: //TINYINT
			typeName = "Integer";
			break;
		case -12: //UNKNOWN
			typeName = "String";
			break;
		case -7: //TINYINT
			typeName = "Boolean";
			break;
		case 5: //SMALLINT
			typeName = "Integer";
			break;
		case -5: //BIGINT
			typeName = "Long";
			break;
		case 8: //DOUBLE
			typeName = "Double";
			break;
		case 7: //FLOAT
			typeName = "Double";
			break;
		case 1: //CHAR
			typeName = "String";
			break;
		case 12: //VARCHAR、TINYBLOB
			typeName = "String";
			break;
		case 91: //DATE、YEAR
			typeName = "String";
			break;
		case 92: //TIME
			typeName = "String";
			break;
		case 93: //TIMESTAMP、DATETIME
//			typeName = "String";
			typeName = "Date";
			break;
		case -3: //TINYBLOB
			typeName = "String";
			break;
		case -4: //BLOB、MEDIUMBLOB
			typeName = "String";
			break;
		case -1: //TEXT、MEDIUMBLOB
			typeName = "String";
			break;
		default:
			typeName = "String";
			break;
		}
		return typeName;
	}
	
	/**
	 * 获取表的字段集合
	 * @param tableName 表名
	 * @param conn 数据库连接
	 * @return List<FieldBean> 字段集合
	 * @throws SQLException
	 */
	public List<FieldBean> getFieldBeanList(String tableName, Connection conn) throws SQLException{
		return DataBaseUtil.getTableField(tableName, conn);
	}
	
	/**
	 * 获取ibatis配置文件中的insert语句中的字段代码
	 * @param bean JavaCodeBean
	 * @param beanList 字段集合
	 * @return String code
	 */
	public String getIbatisInsertFieldsCode(JavaCodeBean bean, List<FieldBean> beanList) {
		StringBuffer sb = new StringBuffer("\t\t\t");
		if(null!=beanList && !beanList.isEmpty()){
			for(int i=0;i<beanList.size();i++){
				sb.append(bean.isColumnToUpperCase()?getFieldName(beanList.get(i)).toUpperCase():getFieldName(beanList.get(i)));
				if((i+1)<beanList.size()){
					sb.append(",");
				}
			}
		}
		return sb.toString();
	}
	/**
	 * 获取ibatis配置文件中的insert语句中的values代码
	 * @param beanList 字段集合
	 * @return String code
	 */
	public String getIbatisInsertValuesCode(List<FieldBean> beanList) {
		StringBuffer sb = new StringBuffer("\t\t\t");
		if(null!=beanList && !beanList.isEmpty()){
			for(int i=0;i<beanList.size();i++){
				sb.append("#{").append(getPropertyName(getFieldName(beanList.get(i)))).append("}");
				if((i+1)<beanList.size()){
					sb.append(",");
				}
			}
		}
		return sb.toString();
	}
	/**
	 * 获取ibatis配置文件中的update语句中的set代码
	 * @param bean JavaCodeBean
	 * @param beanList 字段集合
	 * @param idName ID名字
	 * @return String code
	 */
	public String getIbatisUpdateSetCode(JavaCodeBean bean, List<FieldBean> beanList, String idName) {
		StringBuffer sb = new StringBuffer();
		String propertyName = null;
		if(null!=beanList && !beanList.isEmpty()){
			FieldBean b = null;
			for(int i=0;i<beanList.size();i++){
				b = beanList.get(i);
				if(null==idName || "".equals(idName.trim()) || !idName.toLowerCase().equals(getFieldName(b).toLowerCase())){
					propertyName = getPropertyName(getFieldName(b));
					
					sb.append("\t\t\t").append("<if test=\"null != ").append(propertyName).append("\">").append("\n");
					sb.append("\t\t\t\t").append(bean.isColumnToUpperCase()?getFieldName(b).toUpperCase():getFieldName(b)).append("=#{").append(propertyName).append("},").append("\n");
					sb.append("\t\t\t").append("</if>").append("\n");
				}
			}
		}
		return sb.toString();
	}
	/**
	 * 获取MyBatis的JdbcType
	 * @param type 数据库类型
	 * @return String MyBatis的JdbcType
	 */
	public String getJdbcType(String type){
		if(null==type || "".equals(type.trim())){
			return "VARCHAR";
		} else if("INT".equals(type)){
			return "INTEGER";
		} else if("DATETIME".equals(type)){
			return "TIMESTAMP";
		} else {
			return "VARCHAR";
		}
	}
	
	
}
