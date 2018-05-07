package com.sky.common.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import com.google.common.base.Preconditions;

public class ShiorPassUtil {
	
	
	
	
	/** 
     * 通过username,password,salt,校验密文是否匹配 ，校验规则其实在配置文件中，这里为了清晰，写下来 
     * @param username 用户名 
     * @param password 原密码 
     * @param salt  盐 
     * @param md5cipherText 密文   也就是密码
     * @return 
     */ 
	public static  boolean checkMd5Password(String username,String password,String salt,String md5cipherText) 
    { 
        Preconditions.checkArgument(!StringUtil.isNull(username),"username不能为空"); 
        Preconditions.checkArgument(!StringUtil.isNull(password),"password不能为空"); 
        Preconditions.checkArgument(!StringUtil.isNull(md5cipherText),"md5cipherText不能为空"); 
        //组合username,两次迭代，对密码进行加密 
        String password_cipherText= new Md5Hash(password,username+salt,2).toHex(); 
        return md5cipherText.equals(password_cipherText); 
    }
	
	
	public static void main( String[] age ){
		boolean ss = checkMd5Password("18502007012","12345"
				,"","22b3988fd086266090cc5ddfc546d2fb");
		System.out.println(ss);
	}
	
}
