package com.sky.common.web.realm;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class ShiroDbRealm extends AuthorizingRealm{
	Logger log = Logger.getLogger(ShiroDbRealm.class);


	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//获取当前登录的用户名
		/*User account = (User) super.getAvailablePrincipal(principals);
		
		List<String> roles = new ArrayList<String>();  
		List<String> permissions = new ArrayList<String>();
		User user = userService.findByAccount(account.getUser_name());
		if(user != null){
			if (user.getRoles() != null && user.getRoles().size() > 0) {
				for (Role role : user.getRoles()) {
					roles.add(role.getRole_name());
					if (role.getPmss() != null && role.getPmss().size() > 0) {
						for (Permission pmss : role.getPmss()) {
							if(!StringUtils.isEmpty(pmss.getPermission())){
								permissions.add(pmss.getPermission());
							}
						}
					}
				}
			}
		}else{
			throw new AuthorizationException();
		}
		//给当前用户设置角色
		info.addRoles(roles);
		//给当前用户设置权限
        info.addStringPermissions(permissions); */
		return info;
		
	}

	/**
	 *  认证回调函数,登录时调用.
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		/*User user = userService.findByAccount(token.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user, user
					.getPassword(), user.getFullname());
		} else {
			return null;
		}*/
		
		return null;
	}
}

