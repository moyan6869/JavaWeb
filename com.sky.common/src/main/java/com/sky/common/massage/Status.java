package com.sky.common.massage;

/**
 * 接口调用响应码
 *
 * @author linwh
 */
public interface Status {

    final int SUCCESS = 0;//成功

    final int NotLogin = 1; //错误，未登录

    final int OtherError = 2;//错误，其他错误
}
