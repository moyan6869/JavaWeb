package com.sky.service.directsale.impl;


import com.sky.common.Constants;
import com.sky.common.piting.Pager;
import com.sky.common.util.*;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.vo.MemberMessageBean;
import com.sky.kafka.IKafkaProducer;
import com.sky.service.directsale.IMemberMessageService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Geoffrey
 * @Packager: com.dami.service.directsale.impl
 * @company: SIBU Kanger
 * @Description: 描述
 * @Date: 2016/6/15 9:27
 */
@Service("memberMessageService")
public class MemberMessageServiceImpl implements IMemberMessageService {

    private IKafkaProducer memberMessageProducer;
    @Override
    public void addMemberMessageBean(MemberMessageBean memberMessageBean){
        memberMessageProducer= SpringUtils.getBean("memberMessageProducer");
        memberMessageProducer.produce(JacksonUtil.toJson(memberMessageBean));
    }

    @Override
    public Pager<MemberMessageBean> getPagerList(String memberId, Pager<MemberMessageBean> pager) {
        String tableName= DbUtil.getMemberMessageTableName(memberId);
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM ");
        sql.append(tableName);
        sql.append(" where delete_flag=0 and member_id=:memberId  ");
        sql.append(" order by create_date desc  ");
        sql.append(" limit :pageOffset , :size ");
        Map<String ,Object> map = new HashMap<>();
        map.put("memberId",memberId);
        map.put("pageOffset",(pager.getPageOffset() - 1) * pager.getPageSize() );
        map.put("size",pager.getPageSize());
        List<MemberMessageBean> datas = JdbcModuleDaoSupport2.getBeanList(DataBaseType.MEMBER_DATA, sql.toString(), map, MemberMessageBean.class, memberId);
        pager.setDatas(datas);
        int totalRows = this.count(memberId);
        pager.setTotalRecord(totalRows);
        pager.setTotalPage(totalRows);
        //清楚未读记录
        String key= Constants.MEMBER_MESSAGE_NO_READ_COUNT+memberId;
        SessionUtil.setSessionLongValueInit(key, 0);
        return pager;
    }

    private int count(String memberId){
        String tableName= DbUtil.getMemberMessageTableName(memberId);
        String sql="select count(*) from "+tableName+" where delete_flag=0 and member_id='"+memberId+"'  ";
        return JdbcModuleDaoSupport2.count(DataBaseType.MEMBER_DATA,sql,null,memberId);
    }
    @Override
    public MemberMessageBean getMessageModel(String memberId, String messageId) {
        String tableName= DbUtil.getMemberMessageTableName(memberId);
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM ");
        sql.append(tableName);
        sql.append(" where delete_flag=0 and member_id=:memberId and msg_id=:msgId  ");
        sql.append(" limit 1");
        Map<String ,Object> map = new HashMap<>();
        map.put("memberId",memberId);
        map.put("msgId",messageId);
        return JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.MEMBER_DATA, sql.toString(), map, new MemberMessageBean(), memberId);
    }

    public boolean update(String memberId,String messageId){
        String tableName= DbUtil.getMemberMessageTableName(memberId);
        StringBuffer sql = new StringBuffer();
        sql.append("update ");
        sql.append(tableName);
        sql.append(" set is_read=1 where msg_id=:msgId ");
        Map<String,Object> map=new HashMap<>();
        map.put("msgId",messageId);
        return JdbcModuleDaoSupport2.updateOrAddOrDele(DataBaseType.MEMBER_DATA, sql.toString(), map, memberId);
    }

    public long getNotReacdCount(String memberId){
        String key= Constants.MEMBER_MESSAGE_NO_READ_COUNT+memberId;
        return SessionUtil.getSessionLongValue(key);
    }
}
