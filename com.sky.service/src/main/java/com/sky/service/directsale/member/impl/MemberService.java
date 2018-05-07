package com.sky.service.directsale.member.impl;

import com.sky.common.util.*;

import com.sky.dao.enums.SkyMemberType;

import com.sky.service.directsale.member.IMemberService;

import com.sky.service.user.impl.PasswordHelper;

import com.sky.web.model.Member;
import com.sky.web.model.MemberTree;

import com.sky.web.model.MemberWeb;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by 建帆 on 2015/11/10.
 */
@Service("webmemberService")
@Component
public class MemberService implements IMemberService {

    @Autowired
    private PasswordHelper passwordHelper;


    private static Logger log = Logger.getLogger(MemberService.class);
    /**
     * 我的团队接口
     */
    /*
     * 获取用户信息
     */
    @Override
    public MemberWeb getMemberInfoByphone(String phone) {
        String sql = "select * from member m where phone = '" + phone + "'";

        return JdbcTemplateDaoSupport.getObjectDateInfo(sql, new MemberWeb());
    }



    private int logCount(String memberIds, String starDt,String endDt){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT COUNT(*) FROM member_place_log ");
        sql.append("WHERE 1=1 ");
        if(!StringUtil.isNull(memberIds)){
            sql.append(" AND up_member_id IN ('"+memberIds+"')");
        }
        if (!StringUtil.isNull(starDt)){
            sql.append(" AND create_date >='"+starDt+"' ");
        }
        if (!StringUtil.isNull(endDt)){
            sql.append(" AND create_date <='"+endDt+"' ");
        }
        return  JdbcTemplateDaoSupport.count(sql.toString(), null);
    }
    @Override
    public MemberTree getMemberZtreeList(MemberTree memberTree){
        List<MemberTree> memberTreeList = new ArrayList<>();
        String leftSql = ("SELECT member_id AS id,CONCAT(nick_name,\"(\",phone,\")\",\"左区\") AS name,place_member_id AS parentId,left_member_id,right_member_id,member_type FROM member WHERE member_id=:leftMemberId");
        MemberTree leftMember = JdbcTemplateDaoSupport.getObjectDateInfo(leftSql, memberTree);
        if(!StringUtil.isNull(leftMember)){
            memberTreeList.add(leftMember);
        }

        String rightSql = ("SELECT member_id AS id,CONCAT(nick_name,\"(\",phone,\")\",\"右区\") AS name,place_member_id AS parentId,left_member_id,right_member_id,member_type FROM member WHERE member_id=:rightMemberId");
        MemberTree rightMember = JdbcTemplateDaoSupport.getObjectDateInfo(rightSql, memberTree);
        if(!StringUtil.isNull(rightMember)){
            memberTreeList.add(rightMember);
        }

        memberTree.setChildren(memberTreeList);
        return memberTree;
    }

    @Override
    public MemberTree getMemberZtree(MemberTree memberTree, int index){
        index++;
        if(index<=8) {//实际为9层，最多查询9层的树
            MemberTree thisTree = getMemberZtreeList(memberTree);
            for (MemberTree tree : thisTree.getChildren()) {
                if(!StringUtil.isNull(tree)){
                    getMemberZtree(tree,index);
                    tree.setName(tree.getName()+ SkyMemberType.valueOf(tree.getMemberType()).getMsg());
                }else {
                    index--;
                }
            }
        }

        return  memberTree;
    }
//    //更新会员级别
//    @Override
//    public boolean updateMemberType(String memberId,Integer memberType){
//        MemberBean bean = getMemberBean(memberId);
//        if (StringUtil.isNull(bean)) {
//            return false;
//        }
//        Integer oldMemberType = bean.getMemberType();
//        String sql = "update sky.member set member_type=:memberType, update_date=:updateDate where member_id=:memberId";
//        bean.setMemberType(memberType);
//        bean.setUpdateDate(new Date());
//        if (JdbcTemplateDaoSupport.updateOrAddOrDele(sql, bean)) {
//            MemberBean newBean = getMemberBean(memberId);
//            SessionUtil.saveOrUpadte(newBean);
//            String status =
//                    InterfaceUtil.update(
//                        InterfaceUtil.getInterfaceParams(
//                            UpdateTypeEnums.memberType.getCode(),oldMemberType,memberId,memberType));
//            log.error("同步云猫级别-- 会员为:"+bean.getPhone()+" 原级别:"+oldMemberType+",现级别:"+memberType+",状态:"+status);
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//
//    private boolean insetMemberLimitLog(String memberId , Integer score,Integer sumScore,Integer type){
//        MemberLimitLog memberLimitLog = new MemberLimitLog();
//        memberLimitLog.setMemberId(memberId);
//        memberLimitLog.setType(type);
//        memberLimitLog.setOrderId(DateUtil.formateDate(new Date(), DateUtil.DEFAULT_DATE_TIME_FORMAT));
//        memberLimitLog.setScore(score);
//        memberLimitLog.setSumScore(sumScore);
//        memberLimitLog.setCreateDate(new Date());
//        String sql = "INSERT INTO member_limit_log (member_id,type,order_id,score,sum_score,create_date) VALUES (:memberId, :type, :orderId, :score, :sumScore, :createDate);";
//        return JdbcModuleDaoSupport2.updateOrAddOrDele(DataBaseType.PROFIT_DATA,sql,memberLimitLog,memberId);
//    }



//    /**
//     * 更新下级关联表
//     * @param memberId
//     * @param referrerMemberId
//     */
//    @Override
//    public void updateLowerRelationDay(String memberId,String referrerMemberId) {
//        List<MemberLowerBean> childBeanList = new ArrayList<>();
//        MemberLowerBean bean = new MemberLowerBean();
//        bean.setMemberId(memberId);
//        //取出当前用户的推荐书
//        String firstsql = "SELECT inc_id,member_id,referrer_member_id FROM member WHERE member_id=:memberId";
//        bean = JdbcTemplateDaoSupport.getObjectDateInfo(firstsql,bean);
//        String incIds = "";
//
//        MemberLowerBean firstOwnBean = new MemberLowerBean();
//        firstOwnBean.setLowerIncId(bean.getIncId());
//        childBeanList.add(firstOwnBean);
//
//        String lowerRelationSql = "SELECT inc_id,lower_inc_id,level FROM lower_relation WHERE inc_id=:incId";
//        childBeanList.addAll(JdbcTemplateDaoSupport.getList(lowerRelationSql,bean));
//
//        for (MemberLowerBean currentMemberBean:childBeanList) {
//            incIds+=currentMemberBean.getLowerIncId()+",";
//        }
//        boolean flag = false;
//        incIds = incIds.substring(0,incIds.length()-1);
//        if (childBeanList.size()!=0){
//            String delSql = "DELETE FROM lower_relation WHERE inc_id NOT IN  ("+incIds+") AND lower_inc_id IN ("+incIds+")";
//            flag = JdbcTemplateDaoSupport.updateOrAddOrDele(delSql,null);
//
//            //修改整个推荐关系树
//            delSql = "DELETE FROM lower_relation_all WHERE inc_id NOT IN  ("+incIds+") AND lower_inc_id IN ("+incIds+")";
//            flag = JdbcTemplateDaoSupport.updateOrAddOrDele(delSql,null);
//        }
//
//        //新的上级
//        MemberLowerBean newReferrerBean = new MemberLowerBean();
//        newReferrerBean.setMemberId(referrerMemberId);
//        String newSql = "SELECT inc_id,member_id,referrer_member_id FROM member WHERE member_id=:memberId";
//        newReferrerBean = JdbcTemplateDaoSupport.getObjectDateInfo(newSql,newReferrerBean);
//
//        //利用笛卡儿积去更新新的关系树
//        StringBuffer insertSql = new StringBuffer();
//        insertSql.append("INSERT IGNORE INTO lower_relation (SELECT m1.inc_id,m2.lower_inc_id,(m1.`level`+m2.`level`+1) AS `level` ");
//        insertSql.append("FROM (SELECT inc_id,`level` FROM lower_relation WHERE lower_inc_id='"+newReferrerBean.getIncId()+"' UNION ALL SELECT '"+newReferrerBean.getIncId()+"',0)m1,");
//        insertSql.append("(SELECT lower_inc_id,`level` FROM lower_relation WHERE inc_id='"+bean.getIncId()+"' UNION ALL SELECT '"+bean.getIncId()+"',0)m2 )");
//        flag = JdbcTemplateDaoSupport.updateOrAddOrDele(insertSql.toString(),null);
//
//        //利用笛卡儿积去更新新的关系树
//        insertSql.setLength(0);
//        insertSql.append("INSERT IGNORE INTO lower_relation_all (SELECT m1.inc_id,m2.lower_inc_id,(m1.`level`+m2.`level`+1) AS `level` ");
//        insertSql.append("FROM (SELECT inc_id,`level` FROM lower_relation WHERE lower_inc_id='"+newReferrerBean.getIncId()+"' UNION ALL SELECT '"+newReferrerBean.getIncId()+"',0)m1,");
//        insertSql.append("(SELECT lower_inc_id,`level` FROM lower_relation WHERE inc_id='"+bean.getIncId()+"' UNION ALL SELECT '"+bean.getIncId()+"',0)m2 )");
//        flag = JdbcTemplateDaoSupport.updateOrAddOrDele(insertSql.toString(),null);
//        System.out.println(flag);
//    }
//
//    @Override
//    public void updatePlaceRelationDay(String memberId, String placeMemberId, Integer type){
//        List<MemberLowerBean> childBeanList = new ArrayList<>();
//        MemberLowerBean bean = new MemberLowerBean();
//        bean.setMemberId(memberId);
//        String firstsql = "SELECT inc_id,member_id,place_member_id FROM member WHERE member_id=:memberId";
//        bean = JdbcTemplateDaoSupport.getObjectDateInfo(firstsql,bean);
//
//        MemberLowerBean firstOwnBean = new MemberLowerBean();
//        firstOwnBean.setLowerIncId(bean.getIncId());
//        childBeanList.add(firstOwnBean);
//        //取出用户当前安置关系自己的安置树
//        String placeOwnSql = "SELECT inc_id,lower_inc_id,place_type,level FROM lower_place WHERE inc_id=:incId";
//        childBeanList.addAll(JdbcTemplateDaoSupport.getList(placeOwnSql, bean));
//
//        String incIds = "";
//        for (MemberLowerBean currentMemberBean:childBeanList) {
//            incIds += currentMemberBean.getLowerIncId() + ",";
//        }
//        incIds = incIds.substring(0,incIds.length()-1);
//        String deleteSql = "DELETE FROM lower_place WHERE inc_id NOT IN  ("+incIds+") AND lower_inc_id IN ("+incIds+")";
//        JdbcTemplateDaoSupport.updateOrAddOrDele(deleteSql, null);
//
//        MemberLowerBean placeBean = new MemberLowerBean();
//        String firstSql = "SELECT inc_id,member_id,place_member_id FROM member WHERE member_id=:placeMemberId";
//        placeBean = JdbcTemplateDaoSupport.getObjectDateInfo(firstSql, bean);
//
//        //利用笛卡儿积去更新新的安置树
//        StringBuffer insertSql = new StringBuffer();
//        insertSql.append("INSERT IGNORE INTO lower_place ");
//        insertSql.append("SELECT m1.inc_id,m2.lower_inc_id," + type + " AS place_type,(m1.`level`+m2.`level`+1) AS `level` ");
//        insertSql.append("FROM (SELECT inc_id,`level` FROM lower_place WHERE lower_inc_id='" + placeBean.getIncId() + "' UNION ALL SELECT '" + placeBean.getIncId() + "',0)m1,");
//        insertSql.append("(SELECT lower_inc_id,`level` FROM lower_place WHERE inc_id='" + bean.getIncId() + "' UNION ALL SELECT '" + bean.getIncId() + "',0)m2 ");
//
//        System.out.println("zj---笛卡尔更新安置树sql:"+insertSql);
//        JdbcTemplateDaoSupport.updateOrAddOrDele(insertSql.toString(), null);
//    }
//
//    private int getOutOfTreeCount(String phone){
//        StringBuffer sql = new StringBuffer();
//        sql.append("SELECT COUNT(*) FROM lower_relation a WHERE a.`level` = 1 ");
//        sql.append("AND NOT EXISTS (SELECT * FROM lower_place b WHERE a.inc_id = b.inc_id AND a.lower_inc_id = b.lower_inc_id) ");
//        if (!StringUtil.isNull(phone)){
//            Member memberBean = getMemberInfoByphone(phone.trim());
//            sql.append("AND a.lower_inc_id IN (SELECT lower_inc_id FROM lower_relation a2 WHERE a2.inc_id="+memberBean.getIncId()+") ");
//        }
//        sql.append("AND EXISTS (SELECT * FROM lower_place c WHERE c.lower_inc_id = a.lower_inc_id )");
//        return  JdbcTemplateDaoSupport.count(sql.toString(),null);
//    }
//
//    @Override
//    public Pager<Member> getOutOfTreeList(String phone){
//        int size =SystemContext.getSize();
//        int offset = SystemContext.getOffset();
//        List<Member> datas = new ArrayList<>();
//        StringBuffer sql = new StringBuffer();
//        sql.append("SELECT e.head_image,e.identity_card,e.phone,e.user_name,e.nick_name,e.member_type,e.yws_member_type,CONCAT(d.nick_name,\"(\",d.phone,\")\") AS referrerUserName,CONCAT(f.nick_name,\"(\",f.phone,\")\") AS placeUserName,e.create_date ");
//        sql.append("FROM lower_relation a,member d,member e,member f WHERE a.`level` = 1 AND a.inc_id = d.inc_id AND a.lower_inc_id = e.inc_id AND e.place_member_id = f.member_id ");
//        sql.append("AND NOT EXISTS (SELECT * FROM lower_place b WHERE a.inc_id = b.inc_id AND a.lower_inc_id = b.lower_inc_id) ");
//        if (!StringUtil.isNull(phone)){
//            Member memberBean = getMemberInfoByphone(phone.trim());
//            if (memberBean != null){
//                sql.append("AND a.lower_inc_id IN (SELECT lower_inc_id FROM lower_relation a2 WHERE a2.inc_id="+memberBean.getIncId()+") ");
//            }
//        }
//        sql.append("AND EXISTS (SELECT * FROM lower_place c WHERE c.lower_inc_id = a.lower_inc_id )");
//        sql.append(" limit " + offset + "," + size + "");
//        datas = JdbcTemplateDaoSupport.getList(sql.toString(),new Member());
//        int count = getOutOfTreeCount(phone);
//
//        Pager<Member> pager=new Pager<Member>();
//        pager.setPageOffset(offset);
//        pager.setPageSize(size);
//        pager.setTotalPage(count);
//        pager.setTotalRecord(count);
//        pager.setDatas(datas);
//        return pager;
//    }
//    @Override
//    public Member getTopMember(){
//        StringBuffer sql = new StringBuffer();
//        sql.append("SELECT  m.inc_id,m.phone,m.member_id,m.member_type,m.referrer_member_id,m.place_member_id,");
//        sql.append("m.head_image,m.nick_name,m.user_name,m.create_date,m.identity_card ");
//        sql.append(" FROM member m WHERE m.referrer_member_id='" +0+"'");
//        Member member = new Member();
//        member = JdbcTemplateDaoSupport.getObjectDateInfo(sql.toString(),member);
//        return member;
//    }


}