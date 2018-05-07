package com.sky.dao.enums;

/**
 * Created by Administrator on 2015/11/12.
 */
public class WxpaymkttransfersType {

    /**
     * 不校验真实姓名 
     */
    public final static String NO_CHECK = "NO_CHECK";

    /**
     * 强校验真实姓名（未实名认证的用户会校验失败，无法转账） 
     */
    public final static String FORCE_CHECK = "FORCE_CHECK";

    /**
     * 针对已实名认证的用户才校验真实姓名（未实名认证用户不校验，可以转账成功）
     */
    public final static String OPTION_CHECK = "OPTION_CHECK";
}
