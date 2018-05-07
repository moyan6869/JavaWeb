package com.sky.common.web.realm;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>User: dao
 * <p>Date: 14-2-15
 * <p>Version: 1.0
 */
public class SysUserFilter extends PathMatchingFilter {
    Logger log = Logger.getLogger(SysUserFilter.class);

//    @Autowired
//    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        log.info("SysUserFilter/onPreHandle");
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        if(username==null){
        	return false;
        }
        request.setAttribute(Constants.CURRENT_USER, username);
        return true;
    }
}
