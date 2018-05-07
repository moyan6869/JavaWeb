package com.sky.common.util;

import com.sky.common.bean.StatusBean;
import com.sky.common.massage.Status;
import com.sky.common.redis.RedisClusterServer;
import com.sky.common.Constants;
import com.sky.dao.vo.FoodWareHouse;
import com.sky.web.model.SystemException;
import com.sky.web.model.UserException;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;

import com.sky.dao.vo.MemberBean;

import javax.security.auth.login.LoginException;

public class SessionUtil {

    @Autowired
    RedisClusterServer redisClusterService;
    public static final String REDIS_JDBC_DATE_MODULE = "jdbc_module_";
    public static final String REDIS_MSG_PHONE = "msg_phone_";
    public static final int REDIS_MSG_TIME_OUT = 1800;  //秒为单位
    private static Logger log = Logger.getLogger("SessionUtil");

    
    public static RedisClusterServer getRedisClusterServers(){
    	return  SpringUtils.getBean("redisClusterService");
    }
    
//	public static String getUserName() {// by wgf
//        String username = (String) SecurityUtils.getSubject().getPrincipal();
//         log.info("Subject username1:"+username);
//
//        return username;
//    }


    /**
     * 新增 或者更新 默认的对象
     *
     * @param user
     */
    public static void saveOrUpadte(FoodWareHouse user) {
    	String memberId = user.getMemberId();
        setSessionString(Constants.REDIS_MEMBER+memberId, JacksonUtil.toJson(user));
    }


    /**
     * by wgf
     * 新增 或者更新 默认的对象
     *
     * @param user
     */
    public static void saveOrUpadteFoodWareHouse(FoodWareHouse user) {
        String username = user.getUsername();
        System.out.println("username>>>>"+username);
        System.out.println("JacksonUtil.toJson(user>>>>"+JacksonUtil.toJson(user));
        setSessionString(Constants.REDIS_FOOD_WARE_HOUSE+username, JacksonUtil.toJson(user));
    }
    
   /**
    * 根据 登录的 信息 获取 用户对象 
    * @param key phone 或者 微信账号
    * @return
    */
//    public static FoodWareHouse getSessionUserName(String key) {
//        FoodWareHouse ub = null;
//        String username = null;
//        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
//        if (!StringUtil.isNull(key)) {
//            username = redisClusterServer.get(key) + "";
//            if (StringUtil.isNull(username)) {
//                log.info("没有发现缓存UserName");
//            } else {
//            	String geto = redisClusterServer.get(Constants.REDIS_FOOD_WARE_HOUSE+username);
//            	ub = JacksonUtil.fromJson(geto, FoodWareHouse.class);
//                if (StringUtil.isNull(ub)) {
//                    log.info("没有发现缓存对象！");
//                }
//            }
//        } else {
//            log.info("用户登录失效或者没有登录");
//        }
//        return ub;
//    }
    




    /**
     *by wgf
     * @Title: getSessionByMemberId
     * @Description: 根据memberId获取用户
     * @param @param memberId
     * @param @return    设定文件
     * @return MemberBean    返回类型
     * @throws
     */
    public static FoodWareHouse getSessionByUserName(String username) {
        FoodWareHouse ub = null;
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        if (!StringUtil.isNull(username)) {
            String geto = redisClusterServer.get(Constants.REDIS_FOOD_WARE_HOUSE+username);
            if(StringUtil.isNull(geto)){
                log.info("没有发现缓存对象！");
            }else{
                ub = JacksonUtil.fromJson(geto, FoodWareHouse.class);
                if (StringUtil.isNull(ub)) {
                    log.info("没有发现缓存对象！");
                }
            }
        } else {
            log.info("用户登录失效或者没有登录");
        }
        return ub;
    }


    /**
     * by wgf
     * 获取session 中的默认用户对象
     *
     * @return 用户对象
     */
//    public static FoodWareHouse getSessionFoodWareHouseInfo() {
//        FoodWareHouse ub = null;
//        String username = null;
//        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
////        if (!StringUtil.isNull(getUserName())) {
//            String geto = redisClusterServer.get(Constants.REDIS_FOOD_WARE_HOUSE+username);
//            log.info("geto:"+geto);
//            ub = JacksonUtil.fromJson(geto, FoodWareHouse.class);
//            log.info("ub:"+ub.getPhone());
//            if (StringUtil.isNull(ub)) {
//                log.info("没有发现缓存对象！");
//                throw new AuthenticationException();
//            }
//        } else {
//            log.info("用户登录失效或者没有登录");
//            throw new AuthenticationException();
//
//        }
//        return ub;
//    }

    /**
     * 获取session 中的默认用户对象
     *
     * @return 用户对象
     */
    public static MemberBean getSessionUserInfo() {
        MemberBean ub = null;
        String memberId = null;
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        if (!StringUtil.isNull(null)) {
//            memberId = redisClusterServer.get(getUserId()) + "";
            log.info("memberID:"+memberId);
            if (StringUtil.isNull(memberId)) {
                log.info("没有发现缓存MemeberId");
            } else {
                String geto = redisClusterServer.get(Constants.REDIS_MEMBER+memberId);
                log.info("geto:"+geto);
                ub = JacksonUtil.fromJson(geto, MemberBean.class);
                log.info("ub:"+ub.getPhone());
                if (StringUtil.isNull(ub)) {
                    log.info("没有发现缓存对象！");
                    throw new AuthenticationException();
                }
            }
        } else {
            log.info("用户登录失效或者没有登录");
//            throw new AuthenticationException();

        }
        return ub;
    }


/***********************************ReidsServer----start******************************************/
    /**
     * 设置一个数据的缓存时间  默认5分钟
     *
     * @param key   key
     * @param value 值
     */
    public static void setSessionTime(String key, String value) {
        //这里已经配置好,属于一个redis的服务接口
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        //redisClusterServer.set(key, value, REDIS_MSG_TIME_OUT);
        redisClusterServer.set(key, value, 10);
    }

    /**
     * 获取 一个数据的值
     *
     * @param key
     * @return
     */
    public static String getSessionCheckTime(String key) {
        String value = "";
        //这里已经配置好,属于一个redis的服务接口
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        value = redisClusterServer.get(key);
        return value;
    }

    /**
     * 删除 key
     *
     * @param key
     * @return
     */
    public static boolean deleSession(String key) {
        //这里已经配置好,属于一个redis的服务接口
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        redisClusterServer.del(key);
        return true;
    }
/***********************************ReidsServer----end******************************************/

    /**
     * 根据key 获取 redis里面的缓存数据
     *
     * @param key    缓存的key
     * @return 字符串类型
     */
    public static String getSessionString(String key) {
        String values = "";
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        values = redisClusterServer.get(key) + "";
        if (StringUtil.isNull(values)) {
            log.info("没有发现缓存");
        }
        return values;
    }
    



    public static void setSessionString(String key, String value) {
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        redisClusterServer.set(key, value);
    }



    
    /**
     * 原子性操作数字
     *
     * @param key
     * @param value
     */
    public static void setSessionLongValueInit(String key, long value) {
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        redisClusterServer.del(key);
        redisClusterServer.increment(key, value);
    }

    /**
     * 原子性取出数字
     *
     * @param key
     * @return
     */
    public static long getSessionLongValue(String key) {
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        return redisClusterServer.increment(key, 0);
    }

    /**
     * 原子性操作数字
     *
     * @param key
     * @param value
     */
    public static void setSessionLongValue(String key, long value) {
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        redisClusterServer.increment(key, value);
    }
    
    /**
     * 意向用户 减 数量
    * @Title: setAddSessionIntention    
    * @Description: TODO    
    * @param @param invitationCode
    * @param @param videoId 
    * @return void
    * @throws
     */
    public static void setSubtractSessionIntention(String invitationCode,int videoId){
    	 RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
    	 redisClusterServer.increment(Constants.REDIS_INTENTION_COUNT+invitationCode+"_"+videoId,-1);
    }
    
    /**
     * 获取 二维码的url
    * @Title: getEqUrl    
    * @Description: TODO    
    * @param @param invitationCode
    * @param @param videoId
    * @param @return 
    * @return String
    * @throws
     */
    public static String getEqUrl(String invitationCode,int videoId){
    	return  getSessionString(Constants.REDIS_USER_EQCODE+invitationCode+"_"+videoId);
    }
    
    /**
     * 设置 二维码的url
    * @Title: setEqUtl    
    * @Description: TODO    
    * @param @param invitationCode
    * @param @param videoId
    * @param @param url 
    * @return void
    * @throws
     */
    public static void setEqUtl(String invitationCode,int videoId,String url){
    	setSessionString(Constants.REDIS_USER_EQCODE + invitationCode + "_" + videoId, url);
    }


    /**
     * 获取 二维码的url
     * @Title: getEqUrl
     * @Description: TODO
     * @param @param invitationCode
     * @param @param videoId
     * @param @return
     * @return String
     * @throws
     */
    public static String getMemberEqCodeUrl(String invitationCode){
        return  getSessionString(Constants.MEMBER_QRCODE_URL+invitationCode);
    }

    /**
     * 设置 二维码的url
     * @Title: setEqUtl
     * @Description: TODO
     * @param @param invitationCode
     * @param @param videoId
     * @param @param url
     * @return void
     * @throws
     */
    public static void setMemberEqCodeUrl(String invitationCode,String url){
        setSessionString(Constants.MEMBER_QRCODE_URL+invitationCode, url);
    }

    /**
     * 意向用户 添加 数量
    * @Title: setAddSessionIntention    
    * @Description: TODO    
    * @param @param invitationCode
    * @param @param videoId 
    * @return void
    * @throws
     */
    public static void setAddSessionIntention(String invitationCode,int videoId){
    	 RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
    	 redisClusterServer.increment(Constants.REDIS_INTENTION_COUNT + invitationCode + "_" + videoId);
    }
    
    /**
     * 获取意向用户数量
    * @Title: getSessionIntention    
    * @Description: TODO    
    * @param @param invitationCode   邀请码
    * @param @param videoId			 视频ID
    * @param @return 
    * @return long
    * @throws
     */
    public static long getSessionIntention(String invitationCode,int videoId){
    	return getSessionLongValue(Constants.REDIS_INTENTION_COUNT+invitationCode+"_"+videoId);
    }
    
    /**
     * 添加当前用户点击量
    * @Title: setAddSessionIntention    
    * @Description: TODO    
    * @param @param invitationCode
    * @param @param videoId 
    * @return void
    * @throws
     */
    public static void setAddShareClick(String invitationCode,int videoId){
    	RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
    	redisClusterServer.increment(Constants.REDIS_USER_CLICK_COUNT+invitationCode+"_"+videoId);
    }
    /**
     * 获取当前用户点击量
    * @Title: setAddSessionIntention    
    * @Description: TODO    
    * @param @param invitationCode
    * @param @param videoId 
    * @return void
    * @throws
     */
    public static long getAddShareClick(String invitationCode,int videoId){
    	return getSessionLongValue(Constants.REDIS_USER_CLICK_COUNT+invitationCode+"_"+videoId);
    }




    /**
     *value =0  取出当前key数字
     * value!=0 当前key下的值原子性加减操作
     * @param key
     * @return
     */
    public static long incrementLongValue(String key,long value) {
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        return redisClusterServer.incrementNotPreKey(key, value);
    }

    public static void setSessionStringNotPreKey(String key, String value) {
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        redisClusterServer.setNotPreKey(key, value);
    }
    /**
     * 原子性操作数字
     *
     * @param key
     * @param value
     */
    public static void incrementLongValueInit(String key, long value) {
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        redisClusterServer.delNotPreKey(key);
        redisClusterServer.incrementNotPreKey(key, value);
    }

    /**
     * 根据 登录的 信息 获取 用户对象
     * @param key phone 或者 微信账号
     * @return
     */
    public static MemberBean getSessionMemberId(String key) {
        MemberBean ub = null;
        String memberId = null;
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        if (!StringUtil.isNull(key)) {
            memberId = redisClusterServer.get(key) + "";
            if (StringUtil.isNull(memberId)) {
                log.info("没有发现缓存MemeberId");
            } else {
                String geto = redisClusterServer.get(Constants.REDIS_MEMBER+memberId);
                ub = JacksonUtil.fromJson(geto, MemberBean.class);
                if (StringUtil.isNull(ub)) {
                    log.info("没有发现缓存对象！");
                }
            }
        } else {
            log.info("用户登录失效或者没有登录");
        }
        return ub;
    }

    /**
     *
     * @Title: getSessionByMemberId
     * @Description: 根据memberId获取用户
     * @param @param memberId
     * @param @return    设定文件
     * @return MemberBean    返回类型
     * @throws
     */
    public static MemberBean getSessionByMemberId(String memberId) {
        MemberBean ub = null;
        RedisClusterServer redisClusterServer = SpringUtils.getBean("redisClusterService");
        if (!StringUtil.isNull(memberId)) {
            String geto = redisClusterServer.get(Constants.REDIS_MEMBER+memberId);
            if(StringUtil.isNull(geto)){
                log.info("没有发现缓存对象！");
            }else{
                ub = JacksonUtil.fromJson(geto, MemberBean.class);
                if (StringUtil.isNull(ub)) {
                    log.info("没有发现缓存对象！");
                }
            }
        } else {
            log.info("用户登录失效或者没有登录");
        }
        return ub;
    }



}
