package com.sky.service.directsale;

import java.util.List;
import java.util.Map;

import com.sky.common.bean.StatusBean;
import com.sky.common.piting.Pager;
import com.sky.dao.vo.*;

/**
 * MemberService
 *
 * @author dao
 **/
public interface MemberService {


    public FoodWareHouse getByPhone(String phone);

    public FoodWareHouse getByWarehouseCode(String warehouseCode );

    public FoodWareHouse getByInviteCode(String inviteCode);

    /**
     * 推荐人报单注册
     *
     * @param @param  bean
     * @param @return
     * @return StatusBean<?>
     * @throws
     * @Title: saveProxy
     * @Description: TODO
     */

    public StatusBean<?> saveProxy(MemberBean bean, int incidTAG) throws Exception;


    /**
     * 微信 解除绑定
     *
     * @return
     * @throws Exception
     */
    public StatusBean<?> touchWechat() throws Exception;

    /**
     * 检查 是否有重复的用户
     *
     * @return
     * @throws Exception
     */
    public List<MemberBean> checkUser() throws Exception;

    /**
     * 更新
     *
     * @param parems phone 当前用户手机号码，  newPhone, 需要更改手机号码(password 修改手机号码，需要提供密码如果不提供就默认8个6)    referrerPhone 需要 挂钩的 推荐人手机号    nickName  昵称    userName 用户名  identityCard   身份证号
     * @param status 1.修改手机号码  2 更改推荐人  3.删除非会员信息。 4 修改昵称, 5，修改 身份证名字 ， 6 修改 身份证号
     * @return
     * @throws Exception
     */

    public StatusBean<?> updateUserInfo(Map<String, Object> parems, int status) throws Exception;

    /**
     * 获取上一级的 对象
     *
     * @param invitationCode 邀请码
     * @return
     */
    public MemberBean checkInvitationCode(String invitationCode);

    /**
     * 更新用户信息  昵称
     *
     * @return
     * @throws Exception
     */
    public StatusBean<?> updateUser(String nickName) throws Exception;

    /**
     * 更新用户信息  推荐人
     *
     * @return
     * @throws Exception
     */
    public StatusBean<?> updateReferrer(String referrer_member_id) throws Exception;

    /**
     * 更新用户信息  身份证
     *
     * @return
     * @throws Exception
     */
    public StatusBean<?> updateIDcard(String identityCard) throws Exception;

    /**
     * 更新用户信息  姓名
     *
     * @return
     * @throws Exception
     */
    public StatusBean<?> updateUserName(String userName) throws Exception;



    /**
     * 修改用户密码
     */

    public StatusBean<?> update(FoodWareHouse bean) throws Exception;


    /**
     * 验证用户二级密码
     */

    public StatusBean<?> issecondpwd(String membersecondpwd, String secondpwd) throws Exception;

    /**
     * 更新头像
     *
     * @param url
     * @return
     * @throws Exception
     */
    public StatusBean<?> updateHead(String url) throws Exception;

    /**
     * 更新 或者绑定手机号码
     *
     * @param phone        手机号码
     * @param wechatOpenId 微信号
     * @return
     */

    public StatusBean<?> updatePhone(String phone, String wechatOpenId, String password, MemberBean bean) throws Exception;

    /**
     * 验证手机号码或者通过手机号码获取对象
     *
     * @param phone
     * @return
     * @throws Exception
     */
    public FoodWareHouse checkPhone(String phone) throws Exception;



    /**
     * 登陆接口
     *
     * @param params
     * @return
     * @throws Exception
     */
    public StatusBean<FoodWareHouse> login(Map<String, Object> params) throws Exception;


    /**
     * 根据ID获取类别信息
     *
     * @param id 数据ID
     * @return MemberBean 数据bean对象
     * @throws Exception
     **/
    public FoodWareHouse getBeanById(String id) throws Exception;



    /**
     * @param @param  memberId
     * @param @return
     * @param @throws Exception    设定文件
     * @return MemberBean    返回类型
     * @throws
     * @Title: getMemberByIdFromSalver
     * @Description: 从从库中查询用户信息
     * @author xiaoheliu
     * @date 2016年1月5日 下午5:50:04
     */
    public FoodWareHouse getMemberByIdFromSalver(String memberId) throws Exception;

    /**
     * 根据给定的条件获取对象
     *
     * @param params 参数
     * @return MemberBean 数据bean对象
     * @throws Exception
     **/
    public FoodWareHouse get(Map<String, Object> params) throws Exception;


    /**
     * 手机注册使用
     *
     * @param bean
     * @return
     * @throws Exception
     */
    public StatusBean<?> updatePhone(FoodWareHouse bean) throws Exception;

    /**
     * 微信更新==针对注册使用
     *
     * @param bean
     * @return
     * @throws Exception
     */
    public StatusBean<?> updateWachat(FoodWareHouse bean) throws Exception;




    /**
     * 更新
     *
     * @param
     * @param  //当前操作人
     * @return boolean 返回true表示更新成功；返回false表示更新失败；
     * @throws Exception
     **/
    public StatusBean<?> resetRedis(boolean status, String phone) throws Exception;


}
