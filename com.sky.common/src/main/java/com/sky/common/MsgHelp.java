package com.sky.common;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.common
 * @company: SIBU Kanger
 * @Description: 返回提示语帮助类
 * @Date: 2016/9/27 20:45
 */
public class MsgHelp {

    public final static String NOT_LOGIN="请登录";
    public final static String PAGE_OFFSET_MUST_NUM ="分页起始页为数字";
    public final static String PAGE_SIZE_MUST_NUM ="分页大小为数字";

    public final static String SUCCESS_OPERATION="操作成功";
    public final static String FAIL_OPERATION="操作失败";
    public final static String NOT_FLUND_MEMBER="不存在该用户";
    public final static String MEMBER_ID_NOT_NULL="会员id不能为空";
    public final static String MEMBER_ID_NOT_RIGHT="会员id不正确";
    public final static String NOT_PLACE_MEMBER="您的推荐人未被安置";
    public final static String NOT_LT_INVITE_CODE="临时邀请码不存在";
    public final static String ERROR_INVITE_CODE="输入邀请码有误";
    public final static String NOT_INVITE_CODE="邀请码不存在";
    public final static String INVITE_CODE_INVALID ="邀请码无效";
    public final static String NOT_PHONE="手机号码不存在";
    public final static String NOT_NULL_PHONE="手机号码不能为空";
    public final static String ERROR_FORMAT_PHONE ="手机号码格式不正确";
    public final static String ERROR_ORDER_PHONE ="请您按顺序注册";
    public static final String MGS_BIDING = "绑定成功!";

    public final static String ERROR_MSG="数据不合法";
    public final static String ERROR_MSG_2="数据异常";
    public final static String ERROR_PHONE="手机号码错误";
    public final static String ERROR_LT_INVITE_CODE="临时邀请码数据出错";
    public final static String NICKNAME_FORMAT_ERROR="昵称格式不对";
    public final static String USERNAME_NOT_NULL="名字不能为空";
    public final static String USERNAME_LENGTH_MAX="名字长度过长";

    public final static String WECHAT_IS_USER="此号已经绑定微信请注册";
    public final static String WECHAT_IS_USER_2="该微信号已经绑定";
    public final static String PHONE_IS_USER="此号已经被注册";
    public final static String PHONE_IS_BANGDING_1="手机号码已绑定";
    public final static String PHONE_IS_BANGDING_2 ="手机号码已绑定，请更换手机号";
    public final static String INVITATION_NOT_MEMBER="推荐人非会员";
    public final static String PLACE_CHOSE_MSG="请选择左区或者右区安置人";
    public final static String PLACE_INPUT_CHECK_SUCCESS_ID="请输入正确安置人ID";
    public final static String PLACE_CHOSE_LOCATION_MSG="请选择安置位置";
    public final static String PLACE_CHOSE_MEMBER_NOTFOUND="选择的安置人不存在";
    public final static String PLACE_CHOSE_NOT_MEMBER="选择的安置人非会员";
    public final static String PLACE_CHOSE_AREA_NOT_MEMBER="安置区的安置人非会员";
    public final static String PLACE_CHOSE_AREA_IS_PLACE="安置区的安置人已被安置";
    public final static String PLACE_LEFT_ISEXIST="安置人左区已经存在";
    public final static String PLACE_RIGHT_ISEXIST="安置人右区已经存在";
    public final static String PLACE_MEMBER_ISNOTEXIST="安置区的安置人不存在";

    public final static String NOT_MEMBER_NOT_INVITATIONCODE="非会员，无法获取邀请码";
    public final static String NOT_PLACE_NOT_INVITATIONCODE="未安置，无法获取邀请码";

    public final static String TOUCH_SUCCESS="解除绑定成功";
    public final static String TOUCH_FAIL="解除绑定失败";

    public final static String UPLOAD_HEAD_IMAGE_SUCCESS="上传头像成功";
    public final static String UPLOAD_HEAD_IMAGE_FAIL="上传头像失败";

    public final static String PASSWORD_NOT_NULL="密码不能为空";
    public final static String SECONDPWD_NOT_NULL="二级密码不能为空";
    public final static String PASSWORD_ERROR ="用户密码输入有误";
    public final static String OLD_PASSWORD_ERROR ="旧密码不正确";
    public final static String OLD_SECONDPWD_ERROR ="旧二级密码不正确";
    public final static String PASSWORD_CHANGE_SUCCESS ="密码修改成功";
    public final static String PASSWORD_LENGTH_MAX ="密码长度过长";
    public final static String SECONDPWD_LENGTH_MAX ="二级密码长度过长";

    public final static String TOKRN_ERROR ="token错误";
    public final static String CHECK_NUM_SEND_SUCCESS ="验证码发送成功";
    public final static String CHECK_NUM_ERROR ="验证码不正确";
    public final static String CHECK_NUM_NOT_NULL="验证码不能为空";
    public final static String CHECK_NUM_TIME_OUT ="验证码已经超时";

    public final static String ID_CARD_INVALID="身份证无效";

    public final static String ERROR_GET_UPGRADE_PRICE="获取最低升级金额失败";
    public final static String NO_MEMBER_NOT_UPGRADE="报单后才能升级";
    public final static String LEVEL_MAX_MEMBER_NOT_UPGRADE="当前会员已是最高级别";
    public final static String UPGRADE_ORDER_PRICE_MUST_BIGGER="升级订单金额必须大于等于最低升级金额";


    public final static String  ERROR_CATEGORY_ID="课程分类ID错误";
    public final static String  ERROR_COURSE_ID="课程ID错误";
    public final static String  ERROR_COURSE_TYPE="课程类型错误";
    public final static String  MEMBER_HASH_SIGN_IN="今天已经签到";

    public final static  String CONTACT_NOT_NULL="收货人不能为空";
    public final static  String ADDRESS_NOT_NULL="收货地址不能为空";
    public final static  String DRAW_ID_NOT_UUID="ID格式错误";
    public final static  String LUCK_DRAW_IS_NOT_FUND="中奖记录不存在";

    public final static  String OUT_WAREHOUSR_IS_NOT_FUND="转出账号不存在";

}
