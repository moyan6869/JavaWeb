package com.sky.service.directsale.impl;

import com.sky.common.Constants;
import com.sky.common.MsgHelp;
import com.sky.common.bean.StatusBean;
import com.sky.common.piting.Pager;
import com.sky.common.profitUtil.ConnectionCallBack;
import com.sky.common.profitUtil.JdbcCommandInfo;
import com.sky.common.profitUtil.JdbcModuleDaoSupport;
import com.sky.common.service.impl.BaseServiceImpl;
import com.sky.common.util.*;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.enums.FreezeType;
import com.sky.dao.enums.MemberMessageTypeEnums;
import com.sky.dao.enums.TeamFlag;
import com.sky.dao.model.APIJoinAchivementDayBean;
import com.sky.dao.model.MQDashBoardBean;
import com.sky.dao.vo.*;
import com.sky.kafka.IKafkaProducer;
import com.sky.service.directsale.MemberService;
import com.sky.service.user.impl.PasswordHelper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.*;

/**
 * MemberServiceImpl
 *
 * @author dao
 **/
@Service("memberService")
public class MemberServiceImpl extends BaseServiceImpl implements MemberService {

    @Autowired
    private PasswordHelper passwordHelper;

    @Resource
    private MemberService memberService;

    private static Logger log = Logger.getLogger("MemberServiceImpl");
    private StatusBean statusBean;

    @Override
    public FoodWareHouse getByPhone(String phone) {
        String sql = "select * from food_warehouse where phone = '" + phone + "' limit 1";
        FoodWareHouse bean = JdbcTemplateDaoSupport.getObjectDateInfo(sql, new FoodWareHouse());
        return bean;
    }

    @Override
    public FoodWareHouse getByWarehouseCode(String warehouseCode ) {
        String sql = "select * from food_warehouse where warehouse_code = '" + warehouseCode + "' limit 1";
        FoodWareHouse bean = JdbcTemplateDaoSupport.getObjectDateInfo(sql, new FoodWareHouse());
        return bean;
    }



    @Override
    public FoodWareHouse getByInviteCode(String inviteCode) {
        String sql = "select * from food_warehouse where invite_code = '" + inviteCode + "' limit 1";
        FoodWareHouse bean = JdbcTemplateDaoSupport.getObjectDateInfo(sql, new FoodWareHouse());
        return bean;
    }

    @Override
    public StatusBean<?> saveProxy(MemberBean bean, int incidTAG) throws Exception {
        return null;
    }

    @Override
    public StatusBean<?> touchWechat() throws Exception {
        return null;
    }

    @Override
    public List<MemberBean> checkUser() throws Exception {
        return null;
    }

    @Override
    public StatusBean<?> updateUserInfo(Map<String, Object> parems, int status) throws Exception {
        return null;
    }

    /**
     * 根据 邀请码 获取 动态邀请码信息
     *
     * @param invitationCode
     * @return
     */
    public Map<String, Object> getDynamicInvitationCode(String invitationCode, String newMemberId) {
        String sql = " select member_id memberId,reference_member_id referenceMemberId from t_invitation_code_new where invitation_code=:invitationCode ";
        Map<String, Object> params = new HashMap<String, Object>();
        invitationCode = invitationCode.substring(0, invitationCode.length() - 5);
        params.put("invitationCode", invitationCode);
        Map<String, Object> paramDate = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, newMemberId,
                sql, params);
        return paramDate;
    }

    /**
     * 获取 系统录入的身份证 个数
     *
     * @param identityCard
     * @return
     */
    public int getIdentityCardUsersCount(String identityCard) {
        HashMap<String, Object> params = new HashMap<String, Object>();
        String sql = "SELECT COUNT(1) from member WHERE identity_card='" + identityCard + "' AND delete_flag=0";
        return JdbcTemplateDaoSupport.count(sql, params);
    }

    /**
     * 根据 memberId 获取当前用户注册的InvitationCode
     *
     * @param memberId
     * @return
     */
    public String getInvitationCode(String memberId) {
        String sql = " select invite_code  from member where member_id=:memberId AND delete_flag=0";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("memberId", memberId);
        params = JdbcTemplateDaoSupport.getObjectDateInfo(sql, params);
        memberId = "";
        if (!StringUtil.isNull(params))
            memberId = params.get("invite_code") + "";
        return memberId;
    }

    /**
     * 查询数据库 是否有 邀请码
     *
     * @param invitationCode
     * @return
     */
    public MemberBean getInvitationCodeObject(String invitationCode) {
        MemberBean mbs = new MemberBean();
        String sql = " select * from member where invite_code=:inviteCode AND delete_flag=0 ";
        Long codes = Long.parseLong(invitationCode);
        mbs.setInviteCode(codes);
        mbs = JdbcTemplateDaoSupport.getObjectDateInfo(sql, mbs);
        return mbs;
    }

    @Override
    public MemberBean checkInvitationCode(String invitationCode) {
        // TODO Auto-generated method stub
        MemberBean mbInvimb = null;
        mbInvimb = SessionUtil.getSessionMemberId(Constants.REDIS_INVITA + invitationCode);

        if (StringUtil.isNull(mbInvimb)) { // 继续校一下数据库是否存在
            mbInvimb = getInvitationCodeObject(invitationCode);
            if (!StringUtil.isNull(mbInvimb)) // 如果注册码不存在 就会有问题
                saveRedisMember(mbInvimb);
        }
        return mbInvimb;
    }

    @Override
    public StatusBean<?> updateUser(String nickName) throws Exception {
        return null;
    }

    @Override
    public StatusBean<?> updateReferrer(String referrer_member_id) throws Exception {
        return null;
    }

    @Override
    public StatusBean<?> updateIDcard(String identityCard) throws Exception {
        return null;
    }

    @Override
    public StatusBean<?> updateUserName(String userName) throws Exception {
        return null;
    }

    /**
     * 加入 当前用户的所有信息
     */
    public void saveRedisMember(MemberBean mbInvimb) {
        SessionUtil.setSessionString(Constants.REDIS_INVITA + mbInvimb.getInviteCode(), mbInvimb.getMemberId());

        SessionUtil.setSessionString(Constants.REDIS_PHONE + mbInvimb.getPhone(), mbInvimb.getMemberId());
        String stro = JacksonUtil.toJson(mbInvimb);
        SessionUtil.setSessionString(Constants.REDIS_MEMBER + mbInvimb.getMemberId(), stro);
    }

    @Override
    public StatusBean<FoodWareHouse> login(Map<String, Object> params) throws Exception {
        if (!StringUtil.isNull(params)) {
            FoodWareHouse user = new FoodWareHouse();
            String sql = "";
            String username = params.get("username") + "";


            if (!StringUtil.isNull(username)) {
                sql = " select * from food_warehouse where username=:username AND delete_flag=0 ";
                user.setUsername(params.get("username") + "");
                user = (FoodWareHouse) JdbcTemplateDaoSupport.getUserDate(sql, user);


            } else {
                user = null;
            }
            if (StringUtil.isNull(user)) {
                return error("登陆失败!");
            }
            return success("操作成功！", user);
        } else {
            log.error("doGetAuthenticationInfo/username52:");
            return error("参数不能为空");
        }
    }

    //    @Override
    public FoodWareHouse getBeanById(String memberId) throws Exception {
        FoodWareHouse memberBean = new FoodWareHouse();
        memberBean.setMemberId(memberId);
        String sql = "select * from food_warehouse where member_id = :memberId AND delete_flag=0";
        memberBean = JdbcTemplateDaoSupport.getObjectDateInfo(sql, memberBean);
        return memberBean;
    }

    @Override
    public FoodWareHouse getMemberByIdFromSalver(String memberId) throws Exception {
        return null;
    }

    @Override
    public FoodWareHouse get(Map<String, Object> params) throws Exception {
        return null;
    }

    @Override
    public StatusBean<?> updatePhone(FoodWareHouse bean) throws Exception {
        return null;
    }

    @Override
    public StatusBean<?> updateWachat(FoodWareHouse bean) throws Exception {
        return null;
    }

    @Override
    public StatusBean<?> resetRedis(boolean status, String phone) throws Exception {
        return null;
    }


    public static void main(String[] arg) {
        System.out.print(Long.parseLong(StringUtil.rendomFive()));
    }


    @Override
    public StatusBean<?> update(FoodWareHouse bean) throws Exception {
        String sql = "update food_warehouse set password=:password,update_date=:updateDate where username=:username";
//        MemberBean loMember = SessionUtil.getSessionUserInfo();
        Map<String, Object> parems = new HashMap<String, Object>();
        parems.put("password", bean.getPassword());
        parems.put("updateDate", new Date());
        parems.put("username", bean.getUsername());
        try {
            if (JdbcTemplateDaoSupport.updateOrAddOrDele(sql, parems)) {
                // 更新 redis
                FoodWareHouse user = getBeanByUsername(bean.getUsername());
                if (null != user) {
                    SessionUtil.saveOrUpadteFoodWareHouse(user);
                    return success("修改密码成功！");
                } else {
                    return error("修改缓存失败");
                }

            } else {
                return error("修改失败");
            }
        } catch (Exception e) {
            return error("修改失败");

        }
    }

    @Override
    public StatusBean<?> issecondpwd(String membersecondpwd, String secondpwd) throws Exception {
        return null;
    }

    @Override
    public StatusBean<?> updateHead(String url) throws Exception {
        return null;
    }

    @Override
    public StatusBean<?> updatePhone(String phone, String wechatOpenId, String password, MemberBean bean) throws Exception {
        return null;
    }

    @Override
    public FoodWareHouse checkPhone(String phone) throws Exception {
        return null;
    }

    /**
     * 每次修改 bean 时 调用此方法 保存 Session
     *
     * @param username
     * @return
     */
    public FoodWareHouse getBeanByUsername(String username) throws Exception {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("username", username);
        String username2 = param.get("username") + "";


        FoodWareHouse user = new FoodWareHouse();
        if (!StringUtil.isNull(username2)) {
            String sql = " select * from food_warehouse where username=:username AND delete_flag=0 ";
            user.setUsername(param.get("username") + "");
            user = (FoodWareHouse) JdbcTemplateDaoSupport.getUserDate(sql, user);
            if (StringUtil.isNull(user)) {
                return null;
            } else {
                return user;
            }

        }
        return user;
    }
}
