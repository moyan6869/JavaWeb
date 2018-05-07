package com.sky.service.directsale;

import com.sky.common.piting.Pager;
import com.sky.dao.vo.MemberMessageBean;

/**
 * @Author: Geoffrey
 * @Packager: com.sky.service.directsale
 * @company: SIBU Kanger
 * @Description: 消息服务接口
 * @Date: 2016/9/29 9:24
 */
public interface IMemberMessageService {

    public void addMemberMessageBean(MemberMessageBean memberMessageBean);

    public Pager<MemberMessageBean> getPagerList(String memberId, Pager<MemberMessageBean> pager);

    public MemberMessageBean getMessageModel(String memberId, String messageId);

    public boolean update(String memberId, String messageId);

    public long getNotReacdCount(String memberId);

}
