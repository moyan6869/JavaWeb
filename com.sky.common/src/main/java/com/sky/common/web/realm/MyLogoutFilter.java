package com.sky.common.web.realm;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.sky.common.util.HttpUtil;
import org.apache.log4j.Logger;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.util.WebUtils;

public class MyLogoutFilter extends LogoutFilter {
    Logger log = Logger.getLogger(MyLogoutFilter.class);

    /**
     * Issues an HTTP redirect to the specified URL after subject logout.  This implementation simply calls
     * {@code WebUtils.}{@link WebUtils#issueRedirect(javax.servlet.ServletRequest, javax.servlet.ServletResponse, String) issueRedirect(request,response,redirectUrl)}.
     *
     * @param request  the incoming Servlet request
     * @param response the outgoing Servlet response
     * @param redirectUrl the URL to where the browser will be redirected immediately after Subject logout.
     * @throws Exception if there is any error.
     */
    protected void issueRedirect(ServletRequest request, ServletResponse response, String redirectUrl) throws Exception {
//        WebUtils.issueRedirect(request, response, redirectUrl);
        log.info("MyLogoutFilter");
    	HttpUtil.writeSuccess(response, "退出成功!");
    }
}
