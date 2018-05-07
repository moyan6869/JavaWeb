package com.sky.api.user;

import com.sky.common.Constants;
import com.sky.common.massage.ResponseUtil;
import com.sky.common.util.MD5Util;
import com.sky.common.util.SessionUtil;
import com.sky.common.util.StringUtil;
import com.sky.common.util.Version;
import com.sky.dao.vo.FoodWareHouse;
import com.sky.service.directsale.MemberService;
import com.sky.service.user.impl.ResourceUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping(value = "/",produces="application/json")
public class UserLoginAction {

    /**
     * 用户服务接口
     */
    @Resource
    MemberService memberService;
    @Autowired
    private SessionDAO sessionDAO;
    @Autowired
    private DefaultWebSessionManager sessionIdCookie;
    @Autowired
    private ResourceUtil resourceUtil;

    private static Logger log = Logger.getLogger(UserLoginAction.class);

    /**
     * 登陆
     *
     * @return String
     * @throws Exception
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(String username, String password, String version,
                        HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (Version.V10.equals(version)) {

            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
                String msg = null;
                try {
//                    subject.login(token);
                    Session session = subject.getSession();
                    FoodWareHouse user = SessionUtil.getSessionByUserName(username.trim());
                    String pas = MD5Util.MD5(password.trim());

                    Map<String, Object> param = new HashMap<String, Object>();
                    param.put("username", username);
                    if (StringUtil.isNull(user)) {
                        user = memberService.login(param).getData();
                        if (StringUtil.isNull(user)) {
                            msg = "用户名错误" ;
                        } else {
                            if (pas.equals(user.getPassword())){
                                SessionUtil.saveOrUpadteFoodWareHouse(user);
                            } else {
                                msg = "密码错误" ;
                            }
                        }
                    }
                    //添加 冻结账户
                    if (null != user) {
                            if (!StringUtil.isNull(user.getFreezeType()) && user.getFreezeType().equals("1")) {
                                    if (!StringUtil.isNull(user.getFreezeDate()) && user.getFreezeDate().after(new Date())) {//冻结
                                            user = null;
                                        msg = "此账户已冻结，解冻日期为："+user.getFreezeDate()+"" ;
                                    } else if (StringUtil.isNull(user.getFreezeDate())) {//无期限冻结
                                            user = null;
                                        msg = "此账户已冻结" ;
                                    }
                            }
                    }
                    if (msg != null ) {
                        return ResponseUtil.error(msg);
                    }

                    return ResponseUtil.data(user, Constants.MSG_LOGIN);

                } catch (UnknownAccountException uae) {
                    msg = "用户名错误";
                } catch (IncorrectCredentialsException ice) {
                    msg = "密码错误";

                } catch (AuthenticationException ae) {
                    msg = "用户名/密码错误";
                }
                if (msg != null ) {
                    return ResponseUtil.error(msg);
                }
        }
        return ResponseUtil.unknownVersion();
    }
}















//        log.error("密码:" + password + "帐号：" + username);
//
//        if (Version.V10.equals(version)) {
//
//            Subject subject = SecurityUtils.getSubject();//获取当前用户对象
//            Session session = subject.getSession();
//
//            //生成令牌(传入用户输入的账号和密码)
//            UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Util.MD5(password));
//
//            String error = null;
            //认证登录
//            try {
                //这里会加载自定义的realm
//                subject.login(token);//把令牌放到login里面进行查询,如果查询账号和密码时候匹配,如果匹配就把user对象获取出来,失败就抛异常
//                FoodWareHouse user = (FoodWareHouse) subject.getPrincipal();//获取登录成功的用户对象(以前是直接去service里面查)



//            } catch (Exception e){
//                error = "用户名/密码错误";
//            }
//            if (error != null) {
//                return ResponseUtil.error(error);
//            } else {
//               //这里 保存session
//                FoodWareHouse mbs = SessionUtil.getSessionFoodWareHouseInfo();
//
//            }

//    String msg = "";
//            String pas = MD5Util.MD5(password);
//            Map<String, Object> param = new HashMap<String, Object>();
//            //手机号登录
//            param.put("username", username);
//            FoodWareHouse  user = memberService.login(param).getData();
//            log.error(">>>>>>>user>>>"+user);
//            if (!StringUtil.isNull(user)) {
//                log.error(">>>>>pas>>>>>"+pas);
//                log.error(">>>>>user.getPassword()>>>>>"+user.getPassword());
//                if (pas.equals(user.getPassword())){
//                    SessionUtil.saveOrUpadteFoodWareHouse(user);
//                } else {
//                    msg = "密码错误";
//                }
//
//            }
//            if (error != null) {
//                return ResponseUtil.error(error);
//            }
//
//            FoodWareHouse mb = SessionUtil.getSessionFoodWareHouseInfo();
//            return ResponseUtil.data(mb, Constants.MSG_LOGIN);
//
//
//
//        }
//
//            return ResponseUtil.unknownVersion();
//
//
//    }
//}
//











//            log.error("session>>>>>>>>" + session);
//            long timeout = session.getTimeout();
//            log.error("密码:" + password + "帐号：" + username);
//            if (Version.V10.equals(version)) {
//                String exceptionClassName = (String) req
//                        .getAttribute("shiroLoginFailure");
//                String error = null;
//                if (UnknownAccountException.class.getName().equals(
//                        exceptionClassName)) {
//                    FoodWareHouse mbs = SessionUtil.getSessionByUserName(Constants.REDIS_FOOD_WARE_HOUSE + username);
//                    Map<String, Object> params = new HashMap<>();
//                    params.put("username", username);
////				StatusBean<FoodWareHouse> mbs4 = memberService.login(params);
////				System.out.println("mbs4" +mbs4.getData());
//                    if (null == mbs) {
//                        FoodWareHouse mbs2 = SessionUtil.getSessionFoodWareHouseInfo();
//                        System.out.println("mbs2" + mbs2);
//                        if (null == mbs2) {
//                            Map<String, Object> params2 = new HashMap<>();
//                            params.put("username", username);
//                            StatusBean<FoodWareHouse> mbs42 = memberService.login(params2);
//                            System.out.println("mbs42" + mbs42.getData());
//                        }
//                    }
//
//                    log.error("账号:" + username);
//                    String msg = MemberFreezeUtil.checkFreezeMember(mbs);
//                    if (StringUtil.isNull(msg)) {
//                        error = "用户名/密码错误";
//                        String exceptionMessage = resourceUtil.getExceptionMessage(username);
//                        if (!StringUtil.isNull(exceptionMessage)) {
//                            error = exceptionMessage;
//                        }
//                    } else {
//                        error = msg;
//                    }
//                } else if (IncorrectCredentialsException.class.getName().equals(
//                        exceptionClassName)) {
//                    error = "用户名/密码错误";
//                } else if (exceptionClassName != null) {//其他异常
//                    error = "用户名/密码错误";
//                }
//                if (error != null) {
//                    log.error(exceptionClassName);
//                    return ResponseUtil.error(error);
//                } else {
//                    FoodWareHouse mbs = SessionUtil.getSessionFoodWareHouseInfo();
//
//                }
//                FoodWareHouse mb = SessionUtil.getSessionFoodWareHouseInfo();
//                return ResponseUtil.data(mb, Constants.MSG_LOGIN);
//            }
//        }


	/**
	 * 登陆
	 * 
	 * @return String
	 * @throws Exception
	 */
//	@RequestMapping(value = "/loginPhone", method = RequestMethod.POST)
//	@ResponseBody
//	public String loginPhone(String username, String password, String version,
//                                 HttpServletRequest req, HttpServletResponse res) throws Exception {
//		if (Version.V10.equals(version)) {
//			String exceptionClassName = (String) req
//					.getAttribute("shiroLoginFailure");
//			String error = null;
//			if (UnknownAccountException.class.getName().equals(
//					exceptionClassName)) {
//				error = "用户名/密码错误";
//			} else if (IncorrectCredentialsException.class.getName().equals(
//					exceptionClassName)) {
//				error = "用户名/密码错误";
//			} else if (exceptionClassName != null) {
//				error = "其他错误：" + exceptionClassName;
//			}
//			if(error!=null)
//				return ResponseUtil.error(error+"=="+exceptionClassName);
//			else{
//				return ResponseUtil.data(SessionUtil.getSessionUserInfo(),"已经登录!");
//			}
//		}
//		return ResponseUtil.unknownVersion();
//	}



