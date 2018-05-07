package com.sky.web.inter;

import java.util.Arrays;
import java.util.List;

public interface MessageCode {
	public static final int SUCCESS_CODE = 0;  
	public static final int FAIL_CODE = 1;
	public static final int USER_ROLE_TYPE = 1; //超级管理员
	public static final int USER_ROLE_COMMON_TYPE = 0; //普通管理员
	public static final List<String> FILTER_ACCESS_RESOURCE = Arrays.asList(new String[]{"user/login", "adminIndex/header", "adminIndex/leftMenu", "adminIndex/right", "user/logout"});
}
