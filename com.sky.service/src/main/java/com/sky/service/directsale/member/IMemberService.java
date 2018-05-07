package com.sky.service.directsale.member;



import com.sky.web.model.Member;
import com.sky.web.model.MemberTree;
import com.sky.web.model.MemberWeb;


/**
 * Created by 建帆 on 2015/11/10.
 */
public interface IMemberService {

    public MemberWeb getMemberInfoByphone(String phone);

    //获取用户安置树
    public MemberTree getMemberZtree(MemberTree memberTree, int index);

    //获取用户安置左区右区信息
    public MemberTree getMemberZtreeList(MemberTree memberTree);


}
