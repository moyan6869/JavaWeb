package com.sky.common.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sky.common.util.HttpUtil;
import com.sky.common.util.StringUtil;
import com.sky.common.Constants;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

/**
 * SpringMVC异常处理，页面请求返回view, 其他请求返回json
 * 
 */
public class CustomSimpleMappingExceptionResolver extends
		SimpleMappingExceptionResolver  {
	private static Logger logger = Logger.getLogger(CustomSimpleMappingExceptionResolver.class);
	public final String GEUST_EXCPTION="Attempting to perform a guest-only operation.  The current Subject is not a guest (they have been authenticated or remembered from a previous login).  Access denied.";
	public final String AUTH_EXCPTION="The current Subject is not authenticated.  Access denied.";
	public final String AUTH_EXCPTION_E="org.apache.shiro.authc.UsernamePasswordToken";
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {
		String viewName = determineViewName(e, request);
		String exmsg = e.getMessage();
		String msg = Constants.MSG_LOGIN_E;
		//根据异常 判断是否权限问题
		if(!StringUtil.isNull(exmsg)&&!GEUST_EXCPTION.equals(exmsg)&&!AUTH_EXCPTION.equals(exmsg)){
			logger.error(e);
			msg=Constants.MSG_LOGIN_ESG;
		}
		if(!StringUtil.isNull(exmsg)&&exmsg.indexOf(AUTH_EXCPTION_E)>0){
			msg=Constants.MSG_LOGIN_E_U;
		}
		// Apply HTTP status code for error views, if specified.
		// Only apply it if we're processing a top-level request.
		if (!StringUtil.isNull(viewName)) {
			Integer statusCode = determineStatusCode(request, viewName);
			if (statusCode != null) {
				applyStatusCodeIfPossible(request, response, statusCode);
			}
			return getModelAndView(viewName, e, request);
		} else {
			ModelAndView mv = new ModelAndView();
			HttpUtil.writeError(response, msg, e);
			return mv;
		}

	}
}
