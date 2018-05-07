package com.sky.common.util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Pattern;

/**
 * String工具类
 * @version 1.0
 */
public class StringUtil {

	//键盘上的所有字符
	private static Pattern pattern = Pattern.compile("[\\u4e00-\\u9fa5a-zA-z`~!@#$%^&*()_+-=\\[\\]\\{\\}\\|;:'\"<,>.?/]*");

	/**
	 * 是否为键盘上字符
	 * @param str
	 * @return
     */
	public static boolean isKeyboardCharacter(String str){
		return isNull(str) || pattern.matcher(str).matches();
	}
	
	/**
	 * 随机产生00-99字符串
	 * @return
	 */
	public static String randomTwo(){
		Random random = new Random();
		int ran = random.nextInt(100);
		return	 String.format("%02d", ran);
	}
	
	/**
	 * 获取随机生成8位数
	 * @return
	 */
	public static String rendomEignt(){
		StringBuffer sb = new StringBuffer();
		int ran=0;
		Random random = new Random();
		for(int i = 0; i < 8 ; i++ ){
			ran = random.nextInt(10);
			sb.append(ran);
		}
		return sb.toString();
	}
	
	/**
	 * 获取随机生成4位数
	 * @return
	 */
	public static String rendomFour(){
		StringBuffer sb = new StringBuffer();
		int ran=0;
		Random random = new Random();
		for(int i = 0; i < 4 ; i++ ){
			ran = random.nextInt(10);
			sb.append(ran);
		}
		return sb.toString();
	}
	
	/**
	 * 获取随机生成5位数
	 * @return
	 */
	public static String rendomFive(){
		StringBuffer sb = new StringBuffer();
		int ran=0;
		Random random = new Random();
		for(int i = 0; i < 5; i++ ){
			ran = random.nextInt(10);
			sb.append(ran);
		}
		return sb.toString();
	}
	
	/**
	 * 判断一个字符串的首字母是不是大写
	 * @param s 被判断的字符串
	 * @return boolean 返回true表示是，返回false表示否
	 */
	public static boolean isCapitalize(String s){
		if(s.charAt(0)>='A'  &&  s.charAt(0)<='Z'){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 判断一个对象是否是空，如果是空则返回true，否则返回false
	 * @param obj
	 * @return boolean
	 */
	public static boolean isNull(Object obj){
		if(null==obj){
			return true;
		} else if(obj instanceof String){
			if("".equals(((String)obj).trim()) || "null".equals(((String)obj).trim().toLowerCase()) || "NULL".equals(((String)obj).trim().toLowerCase()))
				return true;
			return false;
		} else if(obj instanceof List){
			if(((List<?>)obj).isEmpty())
				return true;
			return false;
		} else if(obj instanceof HashSet){
			if(((HashSet<?>)obj).isEmpty())
				return true;
			return false;
		} else if(obj instanceof HashMap){
			if(((HashMap<?,?>)obj).isEmpty())
				return true;
			return false;
		} else if(obj instanceof Set){
			if(((Set<?>)obj).isEmpty())
				return true;
			return false;
		} else {
			return false;
		}
	}

    /**
     * 判断输入的字符串是否是UUID(包含32位和36位的验证)
     *
     * @param str
     * @return
     */
    public static boolean isUUID(String str) {
        try {
            if (str.length() == 32) {
                StringBuffer sb = new StringBuffer(64);
                sb.append(str.substring(0, 8));
                sb.append("-");
                sb.append(str.substring(8, 12));
                sb.append("-");
                sb.append(str.substring(12, 16));
                sb.append("-");
                sb.append(str.substring(16, 20));
                sb.append("-");
                sb.append(str.substring(20));
                UUID.fromString(sb.toString());
                return true;
            } else if (str.length() == 36) {
                UUID.fromString(str);
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

	/**
	 * 排除null字符串
	 * @data 2015年1月13日
	 * @version 1.0
	 * @param s 字符串
	 * @return String 排除了null的字符串
	 */
	public static String excludeNullStr(String s){
		if(null==s || "".equals(s.trim()) || "null".equals(s.trim().toLowerCase())){
			return null;
		} else {
			return s;
		}
	}
	/**
	 * 获取字符串
	 * @param obj 所有对象
	 * @return String 字符串
	 */
	public static String getString(Object obj){
		if(null!=obj)
			return obj.toString().trim();
		return "";
	}
	
	/**
	 * 获取整型
	 * @param obj
	 * @return int
	 */
	public static int getInt(Object obj){
		if(null==obj || "".equals(obj.toString().trim())){
			return 0;
		} else {
			return Integer.valueOf(obj.toString().trim());
		}
	}
	
	/**
	 * 获取浮点小数
	 * @param obj
	 * @return double
	 */
	public static double getDouble(Object obj){
		if(null==obj || "".equals(obj.toString().trim())){
			return 0d;
		} else {
			return Double.valueOf(obj.toString().trim()).doubleValue();
		}
	}
	
	/**
     * 判断字符串是否表示ture,如果是则返回true,如果不是则返回false
     * @param s 待判断字符串
     * @return boolean 结果
     */
    public static boolean isTrue(String s){
    	if(!isNull(s)){
    		if(("true".equals(s.trim().toLowerCase()))){
    			return true;
    		} else if(("false".equals(s.trim().toLowerCase()))){
    			return false;
    		} else {
    			try {
					throw new Exception("字符串：" + s + "，并不是boolean类型！" );
				} catch (Exception e) {
					e.printStackTrace();
				}
    		}
    	}
    	return false;
    }
    
    /**
	 * 获取长整型
	 * @param s 字符串
	 * @return Long
	 */
	public static Long getLong(String s){
		if(null!=s && !"".equals(s)){
			return Long.valueOf(s.trim());
		}
		return 0L;
	}
	
	/**
	 * 判断一个字符串是否存在一个数组当中
	 * @param str 字符串
	 * @param ss 数组
	 * @return boolean 返回true表示存在；返回false表示不存在
	 */
	public static boolean isExist(String str, String[] ss){
		boolean isExit = false;
		for(String s : ss){
			if(str.equals(s)){
				isExit = true;
				break;
			}
		}
		return isExit;
	}
	
	/**
     * double类型取小数点后面几位
     * @param val 指定double型数字
     * @param precision 取前几位
     * @return 转换后的double数字
     */
    public static Double roundDouble(double val, int precision) {   
        Double ret = null;   
        try {   
            double factor = Math.pow(10, precision);   
            ret = Math.floor(val * factor + 0.5) / factor;   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
  
        return ret;   
    }
	/**
	 * 获得class的绝对路径
	 * @return String class的绝对路径
	 */
	public static String getClassRootPath(){
		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
		rootPath = rootPath.substring(1, rootPath.length()).replaceAll("%20", " ");
		return rootPath;
	}
    
	/**
	 * 将整数转换成字符串
	 * @param n 整数
	 * @param leng 指定字符串长度
	 * @return String 字符串
	 */
	public static String intToString(int n, int leng){
		String s = Integer.valueOf(n).toString();
		while(s.length()<leng){
			s = "0"+s;
		}
		return s;
	}
	/**
	 * 将空字符串变成null
	 * @param s
	 * @return String
	 */
	public static String setEmptyToNull(String s) {
		if("".equals(s)){
			return null;
		}else{
			return s;
		}
	}
	
	/**
	 * 将null变成空字符串
	 * @param s
	 * @return String
	 */
	public static String setNullToEmpty(String s) {
		if(s == null){
			return "";
		}else{
			return s;
		}
	}
	
	/**
	 * 去前后空格，排除null的字符串
	 * @param s 字符串
	 * @return String 字符串
	 */
	public static String trimNull(String s){
		if(null==s){
			return null;
		}
		return setEmptyToNull(s.trim());
	}
	/**
	 * 将数组转换成字符串
	 * @param obj
	 * @return String
	 */
	public static String ArrayToStr(char[] obj){
		StringBuffer sb = new StringBuffer();
		if(null!=obj && obj.length>0){
			for(int i=0;i<obj.length;i++){
				sb.append(String.valueOf(obj[i]));
			}
		}
		return sb.toString();
	}
	/**
	 * 验证是否输入数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str){
		  for (int i = str.length();--i>=0;){   
		   if (!Character.isDigit(str.charAt(i))){
		    return true;
		   }
		  }
		  return false;
		 }
	
	/**
	 * 获取UUID
	 * @return
	 */ 
	public static String getUUID(){
        
//		return UUID.randomUUID().toString().replace("-", "").toUpperCase();  //大写
		return UUID.randomUUID().toString().replace("-", "");
	}
	/* 
	 * 两个字符串数字相加
	 */
	public static String numberAdd(String num1,String num2,int decimal_num)
	{
		return  new BigDecimal(num1).add(new BigDecimal(num2)).setScale(decimal_num).toString();
	}
	/*
	 * 两个字符串数字相减
	 */
	public static String numberSub(String num1,String num2,int decimal_num)
	{
		return  new BigDecimal(num1).subtract(new BigDecimal(num2)).setScale(decimal_num).toString();
	}
	/*
	 * 两个字符串数字相乘
	 */
	public static String numberMul(String num1,String num2,int decimal_num)
	{
		return  new BigDecimal(num1).multiply(new BigDecimal(num2)).setScale(decimal_num).toString();
	}
	public static long numberMul(String num1,String num2)
	{
		return  new BigDecimal(num1).multiply(new BigDecimal(num2)).longValue();
	}
	/*
	 * 两个字符串数字相除
	 */
	public static String numberDiv(String num1,String num2,int decimal_num)
	{
		return  new BigDecimal(num1).divide(new BigDecimal(num2),decimal_num,BigDecimal.ROUND_HALF_DOWN).toString();
	}
	/*
	 * 两个字符串数字比较大小
	 * 
	 */
	public static int numberCom(String num1,String num2)
	{
		return  new BigDecimal(num1).compareTo(new BigDecimal(num2));
	}
	
	
	/**
     *  相同对象之间 的更新 赋值     ： 也就是   该方法 会把  newBean 的值 覆盖掉 oldBean 的值  当然  如果 newBean 为空的话 保留 oldBean的原先值
      * @param oldBean  需要更新的对象  
      * @param newBean  该对象有新值
     * @throws NoSuchFieldException 
     * @throws SecurityException 
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    @SuppressWarnings({ "rawtypes", "unused" })
	public static void copyProperty(Object oldBean,Object newBean) throws Exception{
        //新的class
        Class newClass = newBean.getClass();
        //老的class
        Class oldClass = oldBean.getClass();
        //该类所有的属性
        Field[] newFields = newClass.getDeclaredFields();
        //新的属性
        Field newField = null;
        //老的属性
        Field oldField = null;
        for(Field f : newFields){
            //类中的属性名称
            String fieldName = f.getName();
            //通过属性名称获取属性
            newField = newClass.getDeclaredField(fieldName);
            //获取属性的值时需要设置为 true 则指示反射的对象在使用时应该取消 Java 语言访问检查。
            //值为 false 则指示反射的对象应该实施 Java 语言访问检查。 
            newField.setAccessible(true);
            //根据属性获取对象上的值
            Object newObject = newField.get(newBean);
            //过滤空的属性或者一些默认值
            if (isContinue(newObject)) {
                continue;
            }
            //过去序列化标识
            if(fieldName.equals("serialVersionUID")) 
            	continue;
            oldField = oldClass.getDeclaredField(fieldName);
            oldField.setAccessible(true);
            oldField.set(oldBean, newObject);
        }
    }
     
    /**
     *  是否跳出本次循环
      * @param object
      * @return true 是 有null或者默认值
      *         false 否 有默认值
     */
    private static boolean isContinue(Object object){
        if (object == null || "".equals(object)) {
            return true;
        }
        String valueStr = object.toString();
        if ("0".equals(valueStr) || "0.0".equals(valueStr)) {
            return true;
        }
        return false;
    }
    
    /**
     * 投个字母转成大写，必须是小写才能转换
     * @param value
     * @return
     */
    public static String toUpperCase(String value){
    	char[] cs=value.toCharArray();
        cs[0]-=32;
        return String.valueOf(cs);
    }

	/**
	 * 包名截取
	 * @param othderName
	 * @return
	 */
	private static String beanKey(String othderName){
		int v = othderName.lastIndexOf(".");
		String keys = othderName.substring(v+1, othderName.length());
		return toUpperCase(keys);
	}

	/**
	 * @return
	 */
	public static String toString(List<String> strings){
		if(strings == null || strings.isEmpty()){
			return "[]";
		}
		StringBuilder stringBuilder = new StringBuilder(50);
		stringBuilder.append("[");
		for (String s: strings){
			stringBuilder.append(s);
			stringBuilder.append(",");
		}
		return stringBuilder.substring(0, stringBuilder.length()-1) + "]";
	}
	
	public static void main( String[] args ){
		
//		HashMap<String, String> a = new HashMap<String, String>();
//		HashMap<String, Integer> b = new HashMap<String, Integer>();
//		for(int i =0;i< 100;i++)
//		{
//			String string = StringUtil.getUUID();
//			String ak = DbUtil.getMod4Db(string);
//			String bk =  (Math.abs(string.hashCode()) % 256 )+"";
//
//			if(a.containsKey(ak))
//			{
//				//a.put(ak,ak);
//			}else
//			{
//				a.put(ak, ak);
//			}
//			if(b.containsKey(bk))
//			{
//				b.put(bk, b.get(bk)+1);
//			}else
//			{
//				b.put(bk, 1);
//			}
//		}
//		for(String s : a.values())
//		{
//			System.out.println(s);
//		}
//		System.out.println(a.values().size());
//		System.out.println(b.values().size());
		for (int i=0;i<100;i++) {
			//System.out.println(randomTwo());
		}
	}
}
