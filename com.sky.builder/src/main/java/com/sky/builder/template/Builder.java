package com.sky.builder.template;

import java.io.File;
import java.sql.Connection;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sky.common.builder.bean.BuilderBean;
import com.sky.common.builder.bean.FieldBean;
import com.sky.common.builder.bean.JavaCodeBean;
import com.sky.common.builder.util.AutoCompleteUtil;
import com.sky.common.util.BuidSpringUtil;

/**
 * 自动完成代码工具类<br>
 * 
 * 当前版本：1.15<br>
 * 主要对后台的代码文件进行自动生成。 下一版本：<br>
 * 对jsp页面的代码也会自动生成。
 * 
 * 最终实现功能：<br> 
 * 		1、要实现输入必要参数后，直接生成基本模块的增删改查代码文件并功能可用。<br>
 * 		2、代码需要设置模板化，调整生成的代码只需要调整模板就行了。<br>
 * 
 * Version 1.15 2013-07-11     <br>
 *      1、为了方面模块化生成代码，讲模板代码的主包名和生成代码存放的主包名进行了抽离配置。<br>
 *      
 * Version 1.15 2013-07-11     <br>
 *      1、代码耦合度调整，抽离工具类。方便多个项目应用时，统一进行修改<br>
 *          
 * Version 1.15 2013-07-11     <br>
 *      1、代码耦合度调整，抽离工具类。方便多个项目应用时，统一进行修改<br>
 * 
 * Version 1.14 2013-06-29     <br> 
 * 		1、重新调整了Builder参数<br>
 * 
 * Version 1.13 2013-06-29     <br> 
 * 		1、新增了自动生成ibatis配置文件功能；<br>
 * 
 * Version 1.12 2013-06-29     <br> 
 * 		1、新增了自动生成bean类功能；<br>
 * 
 * Version 1.11 2013-06-29     <br> 
 * 		1、新增了获取数据库连接功能；<br>
 *      2、新增了自动生成Fields类功能<br>
 *      3、新增了批量自动生成所有表的Fields类功能<br>
 *      4、新增了获取表的所有字段信息功能<br>
 * 
 * Version 1.10 2013-06-20     <br> 
 * 		1、分离了Bean类，让代码结构更加清晰
 * 
 * Version 1.9 2013-06-20     <br>
 *      1、分离代码工具类AutoCompleteUtil.java和代码逻辑处理类Builder.java
 * 
 * Version 1.8 2013-06-20     <br>
 *      1、增加模板功能，生成的代码可以通过编辑模板代码进行调整
 * 
 * Version 1.7 2013-06-18     <br> 
 * 		1、增加了是否创建java文件的控制变量
 * 
 * Version 1.6 2013-06-18     <br>
 *      1、调整Action生成的代码，解决保存和更新数据是记录当前操作用户信息的问题。
 * 
 * Version 1.5 2013-06-17     <br> 
 * 		1、解决java名字和属性名字冲突的问题
 * 
 * Version 1.4 2013-06-17     <br>
 *      1、增加List的查询和search的查询代码。list查询则返回beanList；search则返回hashMapList<br>
 * 
 * Version 1.3 2013-06-15     <br>
 *      1、增加了Ibatis配置文件的count和select语句的代码生成。<br>
 * 
 * Version 1.2 2013-06-15     <br> 
 * 		1、增加了自动生成java文件的功能。<br>
 *      2、可设置是否覆盖原有的java文件，是否在控制台输出生成过程，是否在控制台输出代码。<br>
 * 
 * Version 1.1 2013-06-13     <br> 
 * 		1、修改了批量删除的代码<br>
 * 
 * Version 1.0 2013-06-13     <br>
 *      目前可以在控制台输出生成的代码，可直接运行main方法在控制台查看效果。<br> 
 *      只输出到控制台，不会更改任何现有代码。<br>
 *      1、自动生成Ibatis配置文件的部分代码：insert,update,delete<br> 
 *      2、自动生成Cache代码<br>
 *      3、自动生成IDao代码<br> 
 *      4、自动生成DaoImpl代码<br> 
 *      5、自动生成IService代码<br>
 *      6、自动生成ServiceImpl代码<br> 
 *      7、自动生成Action代码<br>
 */
public class Builder {
	/** 生成器参数Bean类 */
	private static BuilderBean builderBean;
	/** 生成器工具类 */
	private static AutoCompleteUtil util;
	/** 数据库连接 */
	private static Connection conn;
	/** 数据库连接beanID */
	private static String dateSourceBeanId = "dataSource";
	//private static String dateSourceBeanId = "data2Source";
	static {
		/** 构造生成器参数类 */
		builderBean = new BuilderBean();
		
		/** 源码根目录 */
		builderBean.setSrcPath(System.getProperty("user.dir") + File.separator +"com.sky.builder"+ File.separator + "src"  + File.separator + "main"+ File.separator + "java");
		/** 设置使用标签作为字段名 */
		builderBean.setUseLable(true);
		/** 是否debug模式 */
		builderBean.setDebug(true);
		/** 是否在控制台显示生成的代码 */
		builderBean.setShowCode(true);
		/** 是否创建代码文件：true表示创建；false表示不创建 */
		builderBean.setCreate(true);
		/** 是否覆盖源文件：true表示覆盖；false表示不覆盖； */
		builderBean.setCover(false);//注意：慎重使用，别把原来自己添加的额外代码给覆盖了。
		/** 模板代码存放的主包名 */
		builderBean.setTemplateMainPackageName("com.sky.builder.template");
		/** 生成代码存放的主包名 */
		builderBean.setTargetMainPackageName("com.skydao.directsale.vo");
		
		// TODO 在这里修改必要参数  
		/** 作者 */ 
		builderBean.setAuthor("Geoffrey");
		/** 主名字 */
		builderBean.setMyName("memberLuckDraw");
		/** 表名 */
		builderBean.setTableName("member_luck_draw");
		/** ID名 */
		builderBean.setIdName("draw_id");
		
		/** 构造生成器工具类 */
		util = new AutoCompleteUtil(builderBean);
	}

	/**
	 * 运行方法
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		createBeanJava(); // 创建数据库表对应的bean类
//		createIServiceJava(); // 创建service接口类
//		createServiceImplJava(); // 创建service实现类
//		createActionJava(); // 创建action类
//		createIbatisXml(); // 创建ibatis配置文件
//		createFieldJava(); // 创建数据库表对应的字段枚举类
//		createIDaoJava(); // 创建dao接口类
//		createAllFieldJava(); //创建数据库中所有表的字段枚举类
	}

	/**
	 * 获取数据库连接
	 * 
	 * @return Connection 数据库连接
	 * @author  
	 * @throws Exception
	 * @data 2013-7-11 上午11:16:52
	 */
	public static Connection getConnection() throws Exception {
		if (null == conn) {
			conn = ((ComboPooledDataSource) BuidSpringUtil.getBeanById(dateSourceBeanId)).getConnection();
		}
		return conn;
	}

	/**
	 * 创建ibatis配置文件
	 * 
	 * @throws Exception
	 */
	public static void createIbatisXml() throws Exception {
		JavaCodeBean bean = new JavaCodeBean();
		bean.setColumnToUpperCase(false);//是否将数据库字段转换成大写
		
		bean.setTemplatePackageName(builderBean.getTemplateMainPackageName()+".dao");//代码模板所在的包路径
		bean.setTemplateName("MyName_Mapper");//代码模板的名称
		bean.setTemplateFileSuffix(".xml");//代码模板的后缀名

		bean.setTargetPackageName(builderBean.getTargetMainPackageName()+".dao");//需要生成的代码的包路径
		bean.setTargetName(util.getJavaName(builderBean.getMyName()));//生成代码文件的文件名
		bean.setTargetNameSuffix("Mapper");//生成代码文件的文件名后追加名字
		bean.setTargetFileSuffix(".xml");//生成代码文件的文件名后缀

		String code = util.getCode(bean);

		List<FieldBean> beanList = util.getFieldBeanList(builderBean.getTableName(), getConnection());
		code = code.replace("myName_", util.getPropertyName(builderBean.getMyName()))
				.replace(builderBean.getTemplateMainPackageName()+".dao", bean.getTargetPackageName())
				.replace(builderBean.getTemplateMainPackageName()+".bean", builderBean.getTargetMainPackageName()+".bean")
				.replace("MyName_", util.getJavaName(builderBean.getMyName())).replace("id_", builderBean.getIdName())
				.replace("idName_", util.getPropertyName(builderBean.getIdName()))
				.replace("tableName_", builderBean.getTableName());
		code = code.replace("<!--resultMapCode-->", util.getResultMapCode(bean, beanList));
		code = code.replace("<!--insertFieldsCode-->", util.getIbatisInsertFieldsCode(bean,beanList));
		code = code.replace("<!--insertValuesCode-->", util.getIbatisInsertValuesCode(beanList));
		code = code.replace("<!--updateSetCode-->", util.getIbatisUpdateSetCode(bean,beanList, builderBean.getIdName()));
		util.createJava(bean, code);
	}

	/**
	 * 创建所有表的字段对应类
	 * 
	 * @throws Exception
	 */
	public static void createAllFieldJava() throws Exception {
		List<String> list = util.getTableList(getConnection());
		if (null != list && !list.isEmpty()) {
			JavaCodeBean bean = null;
			for (String name : list) {
				bean = new JavaCodeBean();
				bean.setTargetPackageName(builderBean.getTargetMainPackageName()+".field");
				bean.setTargetName(util.getJavaName(name.substring(name.indexOf("_") + 1, name.length())));
				bean.setTargetNameSuffix("Fields");
				bean.setTargetFileSuffix(".java");

				util.createJava(bean, util.getFieldCode(bean, name, getConnection()));
			}
		}
	}

	/**
	 * 创建字段类
	 * 
	 * @throws Exception
	 */
	public static void createFieldJava() throws Exception {
		JavaCodeBean bean = new JavaCodeBean();
		
		bean.setTargetPackageName(builderBean.getTargetMainPackageName()+".field");
		bean.setTargetName(util.getJavaName(builderBean.getMyName()));
		bean.setTargetNameSuffix("Fields");
		bean.setTargetFileSuffix(".java");

		util.createJava(bean, util.getFieldCode(bean, builderBean.getTableName(), getConnection()));
	}

	/**
	 * 转换代码
	 * 
	 * @param code
	 * @return String
	 */
	public static String replace(String code) {
		code = code.replace(builderBean.getTemplateMainPackageName()+".cache", builderBean.getTargetMainPackageName()+".cache.business")
				.replace(builderBean.getTemplateMainPackageName()+".fields", builderBean.getTargetMainPackageName()+".field")
				.replace(builderBean.getTemplateMainPackageName()+".bean", builderBean.getTargetMainPackageName()+".bean")
				.replace(builderBean.getTemplateMainPackageName()+".dao", builderBean.getTargetMainPackageName()+".dao")
				.replace(builderBean.getTemplateMainPackageName()+".service", builderBean.getTargetMainPackageName()+".service")
				.replace(builderBean.getTemplateMainPackageName()+".web", builderBean.getTargetMainPackageName()+".web")
				.replace("作者_", builderBean.getAuthor()).replace("MyName_", util.getJavaName(builderBean.getMyName()))
				.replace("myName_", util.getPropertyName(builderBean.getMyName()))
				.replace("idName_", util.getPropertyName(builderBean.getIdName().toLowerCase()));
		return code;
	}

	/**
	 * 创建Bean类
	 * 
	 * @throws Exception
	 */
	public static void createBeanJava() throws Exception {
		JavaCodeBean bean = new JavaCodeBean();
		
		bean.setTemplatePackageName(builderBean.getTemplateMainPackageName()+".bean");
		bean.setTemplateName("MyName_Bean");
		bean.setTemplateFileSuffix(".java");

		bean.setTargetPackageName(builderBean.getTargetMainPackageName()+".bean");
		bean.setTargetName(util.getJavaName(builderBean.getMyName()));
		bean.setTargetNameSuffix("Bean");
		bean.setTargetFileSuffix(".java");

		String code = util.getCode(bean);
		code = replace(code);
		String fieldsCode = util.getBeanFieldsCode(builderBean.getTableName(), getConnection());
		code = code.replace("//TODO", fieldsCode);

		util.createJava(bean, code);
	}

	/**
	 * 创建IDao类
	 * 
	 * @throws Exception
	 */
	public static void createIDaoJava() throws Exception {
		JavaCodeBean bean = new JavaCodeBean();
		
		bean.setTemplatePackageName(builderBean.getTemplateMainPackageName()+".dao");
		bean.setTemplateName("MyName_Mapper");
		bean.setTemplateFileSuffix(".java");

		bean.setTargetPackageName(builderBean.getTargetMainPackageName()+".dao");
		bean.setTargetName(util.getJavaName(builderBean.getMyName()));
		bean.setTargetNameSuffix("Mapper");
		bean.setTargetFileSuffix(".java");

		String code = util.getCode(bean);
		code = replace(code);
		util.createJava(bean, code);
	}

	/**
	 * 创建IService类
	 * 
	 * @throws Exception
	 */
	public static void createIServiceJava() throws Exception {
		JavaCodeBean bean = new JavaCodeBean();
		bean.setTemplatePackageName(builderBean.getTemplateMainPackageName()+".service");
		bean.setTemplateName("MyName_Service");
		bean.setTemplateFileSuffix(".java");
		bean.setTargetPackageName(builderBean.getTargetMainPackageName()+".service");
		bean.setTargetName(util.getJavaName(builderBean.getMyName()));
		bean.setTargetNameSuffix("Service");
		bean.setTargetFileSuffix(".java");

		String code = util.getCode(bean);
		code = replace(code);
		util.createJava(bean, code);
	}

	/**
	 * 创建ServiceImpl类
	 * 
	 * @throws Exception
	 */
	public static void createServiceImplJava() throws Exception {
		JavaCodeBean bean = new JavaCodeBean();
		
		bean.setTemplatePackageName(builderBean.getTemplateMainPackageName()+".service.impl");
		bean.setTemplateName("MyName_ServiceImpl");
		bean.setTemplateFileSuffix(".java");

		bean.setTargetPackageName(builderBean.getTargetMainPackageName()+".service.impl");
		bean.setTargetName(util.getJavaName(builderBean.getMyName()));
		bean.setTargetNameSuffix("ServiceImpl");
		bean.setTargetFileSuffix(".java");

		String code = util.getCode(bean);
		code = replace(code);
		util.createJava(bean, code);
	}

	/**
	 * 创建Action类
	 * 
	 * @throws Exception
	 */
	public static void createActionJava() throws Exception {
		JavaCodeBean bean = new JavaCodeBean();
		
		bean.setTemplatePackageName(builderBean.getTemplateMainPackageName()+".web");
		bean.setTemplateName("MyName_Action");
		bean.setTemplateFileSuffix(".java");

		bean.setTargetPackageName(builderBean.getTargetMainPackageName()+".web");
		bean.setTargetName(util.getJavaName(builderBean.getMyName()));
		bean.setTargetNameSuffix("Action");
		bean.setTargetFileSuffix(".java");

		String code = util.getCode(bean);
		code = replace(code);
		util.createJava(bean, code);
	}

}
