package com.sky.api.user;

import com.sky.common.Constants;
import com.sky.common.util.*;
import com.sky.dao.vo.FoodWareHouse;
import com.sky.dao.vo.MemberBean;
import com.sky.service.directsale.MemberService;
import com.sky.service.user.impl.PasswordHelper;
import com.sky.service.user.impl.ResourceUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>User: dao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
public class UserRealm extends AuthorizingRealm {
	Logger log = Logger.getLogger(UserRealm.class);
	/** 用户服务接口 */
	@Resource
        MemberService memberService;
	@Autowired
    	private PasswordHelper passwordHelper;
	@Autowired
	private ResourceUtil resourceUtil;

	@Autowired
	JedisCluster jedisCluster;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //System.out.println(username);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //用户名
        String username = (String) token.getPrincipal();
        //密码
//        String pas = new String((char[])token.getCredentials());
        String password = new String((char[])token.getCredentials());
    	String pas = MD5Util.MD5(password.toString());


        FoodWareHouse user = null;

        Map<String, Object> param = new HashMap<String, Object>();
        //登录
        param.put("username", username);
        if (StringUtil.isNull(user)) {
            try {
                user = memberService.login(param).getData();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (StringUtil.isNull(user)) {
                //没有该用户名
                throw new UnknownAccountException();
            } else {
                if (pas.equals(user.getPassword())){
                    SessionUtil.saveOrUpadteFoodWareHouse(user);
                } else {
                    //清除缓存的账号
                    SessionUtil.deleSession(Constants.REDIS_FOOD_WARE_HOUSE+username);

                    //密码错误
                    throw new IncorrectCredentialsException();
                }
            }
        }

        //身份验证通过,返回一个身份信息
        SimpleAuthenticationInfo aInfo=new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),"realm");
//        aInfo.setCredentialsSalt(ByteSource.Util.bytes(user.getUsername()+user.getSalt()));
        return aInfo;

    }













//	    UsernamePasswordToken usertoken=(UsernamePasswordToken) token;//获取令牌(里面存放new UsernamePasswordToken放入的账号和密码)
//
//	    //得到账号和密码
//	    String username = usertoken.getUsername();
//
//
////    	String username = (String)token.getPrincipal();
//
//		log.error("doGetAuthenticationInfo1:"+username);
////    	char[] password = (char[]) token.getCredentials();
//        String password = (String) token.getCredentials();
//    	String pas = MD5Util.MD5(password.toString());
//    	String msg = "";
//       // System.out.println(username+"=="+password.toString());
//	    FoodWareHouse user= new FoodWareHouse();
//	    if (!username.equals("")) {
//			user = (FoodWareHouse) SessionUtil.getSessionByUserName(Constants.REDIS_FOOD_WARE_HOUSE + username);
//		    try {
//
//			Map<String, Object> param = new HashMap<String, Object>();
//			//手机号登录
//			param.put("username", username);
//			if (StringUtil.isNull(user)) {
//				try {
//					user = memberService.login(param).getData();
//					System.out.println("1111"+user);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				if (!StringUtil.isNull(user)) {
//					log.error(">>>>>pas>>>>>"+pas);
//					log.error(">>>>>user.getPassword()>>>>>"+pas);
//					if (pas.equals(user.getPassword())){
//						SessionUtil.saveOrUpadteFoodWareHouse(user);
//					} else {
//						msg = "密码错误";
//					}
//
//				} else {
//					msg = "数据校验出错！";
//				}
//			}
//
////			if (!StringUtil.isNull(user) && !StringUtil.isNull(user.getUsername())) {  //密码盐二次迭代
////			//					user.setPhone(username);
////				password = MD5Util.MD5(username);
////				user.setPassword(password);
////				passwordHelper.encryptPassword(user);
////			} else {
////				user = null;
////			}
//			//*添加 冻结账户
//			if (user != null) {
//				if (!StringUtil.isNull(user.getFreezeType()) && user.getFreezeType().equals("1")) {
//					if (!StringUtil.isNull(user.getFreezeDate()) && user.getFreezeDate().after(new Date())) {//冻结
//						user = null;
//					} else if (StringUtil.isNull(user.getFreezeDate())) {//无期限冻结
//						user = null;
//					}
//				}
//			}
//		} catch(Exception e){
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			if (e.getMessage() != null && e.getMessage().indexOf("尊敬的客户您好") >= 0) {
//				throw new UnknownAccountException(e.getMessage());
//			}
//		}
//	    }
//         if(user == null) {
//             throw new UnknownAccountException(msg);//没找到帐号
//         }
//		log.error("doGetAuthenticationInfo2:"+user.getPhone()+":"+user.getPassword());
//         //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以自定义实现
//           SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//				user.getUsername(), //用户名
//				user.getPassword(), //密码
////				ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=phone+salt
//				getName()  //realm name
//		);
//		log.error("doGetAuthenticationInfo3:"+user.getPhone()+":"+user.getPassword());
//         return authenticationInfo;
//    }

    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
		log.info("clearAllCachedAuthorizationInfo/username:");
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
		log.info("clearAllCachedAuthenticationInfo/username:");
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

}
