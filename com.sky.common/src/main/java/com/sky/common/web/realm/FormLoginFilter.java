package com.sky.common.web.realm;

import java.io.IOException;
import java.text.Normalizer;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sky.common.util.HttpUtil;
import com.sky.common.util.SpringUtils;
import com.sky.common.util.StringUtil;
import com.sky.dao.vo.FoodWareHouse;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.util.WebUtils;

import com.sky.common.util.SessionUtil;
import com.sky.dao.vo.MemberBean;
import com.sky.dao.vo.MemberBeanRedis;

public class FormLoginFilter extends FormAuthenticationFilter{
    Logger log = Logger.getLogger(FormLoginFilter.class);

    private String loginUrl = "/login.jsp";
    private String successUrl = "/";  
    
    private SimpleCookie  sessionIdCookie;
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
            ServletRequest request, ServletResponse response) throws Exception {
        log.info("FormLoginFilter/onLoginSuccess");
        log.info("FormLoginFilter/onLoginSuccess/subject:"+subject.getPrincipal());
        log.info("FormLoginFilter/onLoginSuccess/subject:"+subject.getPrincipals());
        log.info("FormLoginFilter/onLoginSuccess/subject:"+subject.getPreviousPrincipals());
        log.info("FormLoginFilter/onLoginSuccess/token:"+token.getPrincipal());
        log.info("FormLoginFilter/onLoginSuccess/token:"+token.getCredentials());
        String username = (String) token.getPrincipal();
    	String sid="";
    	String name="";
    	 if(request instanceof HttpServletRequest){
    		 HttpServletRequest requests = (HttpServletRequest) request;
    		 Cookie s[] = requests.getCookies();
    		 if(!StringUtil.isNull(s)){
	    		 name= s[0].getName();
	    		 sid = s[0].getValue();
    		 }
    	  }
    	 if(response instanceof HttpServletResponse){
 	       HttpServletResponse responses = (HttpServletResponse) response;
 	       SimpleCookie sessionIdCookie = SpringUtils.getBean("sessionIdCookie");
 	       String ll =  ((HttpServletResponse) response).getHeader("Set-Cookie");
 	       if(!StringUtil.isNull(sid)){
 	    	   responses.setHeader("Set-Cookie", "__outh="+sid+";"+ll);
 	       }
 	       System.out.println(ll);
 	  }

    	System.out.println(subject.getSession().getTimeout());
    	SecurityUtils.getSubject().getSession().setTimeout(604800000);
        FoodWareHouse mb = SessionUtil.getSessionByUserName(username);

    	HttpUtil.writeDDate(response, mb);
	return false;
	}
    private boolean redirectToSuccessUrl(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        log.info("FormLoginFilter/redirectToSuccessUrl:"+username+":::"+password);
        WebUtils.redirectToSavedRequest(req, resp, successUrl);  
        return false;  
    }  
    private void saveRequestAndRedirectToLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        log.info("FormLoginFilter/saveRequestAndRedirectToLogin:"+username+":::"+password);
        WebUtils.saveRequest(req);  
        WebUtils.issueRedirect(req, resp, loginUrl);  
    }  
  
    private boolean login(HttpServletRequest req) {  
        String username = req.getParameter("username");  
        String password = req.getParameter("password");
        log.info("FormLoginFilter/Login:"+username+":::"+password);
        try {  
            SecurityUtils.getSubject().login(new UsernamePasswordToken(username, password));  
        } catch (Exception e) {  
            req.setAttribute("shiroLoginFailure", e.getClass());  
            return false;  
        }  
        return true;  
    }  
    private boolean isLoginRequest(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        log.info("FormLoginFilter/isLoginRequest:"+username+":::"+password);
        return pathsMatch(loginUrl, WebUtils.getPathWithinApplication(req));  
    }
    
    
}
