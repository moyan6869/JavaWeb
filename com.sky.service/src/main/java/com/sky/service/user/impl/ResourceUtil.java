package com.sky.service.user.impl;

import com.sky.dao.vo.MemberBean;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


/**
 * 资源加载类
 * @author Administrator
 */
@Service
public class ResourceUtil {

    /**
     *异常信息集合
     */
    private Map<String,String> messageMap=new HashMap<>();


    public String getExceptionMessage(String inviteCode){
        return messageMap.get(inviteCode);
    }
    public String setExceptionMessage(String inviteCode,String message){
        return messageMap.put(inviteCode,message);
    }


}
