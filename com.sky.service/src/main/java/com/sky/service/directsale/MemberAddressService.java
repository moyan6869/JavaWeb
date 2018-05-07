package com.sky.service.directsale;

import com.sky.common.bean.StatusBean;
import com.sky.common.piting.Pager;
import com.sky.dao.vo.MemberAddressBean;

/**
 * MemberAddressService
 *
 * @author dao
 **/
public interface MemberAddressService {

    /**
     * 根据默认收货地址
     *
     * @param memberId 用户ID
     * @return MemberAddressBean 数据bean对象
     * @throws Exception
     **/
    public MemberAddressBean getDefault(String memberId) throws Exception;

    /**
     * 根据给定的条件获取对象
     *
     * @param addressId 地址ID
     * @param memberId 用户ID
     * @return MemberAddressBean 数据bean对象
     * @throws Exception
     **/
    public MemberAddressBean get(String addressId, String memberId) throws Exception;

    /**
     * 根据给定的条件获取对象
     *
     * @param phone province city
     * @param memberId 用户ID
     * @return MemberAddressBean 数据bean对象
     * @throws Exception
     **/
    public MemberAddressBean getAddress( String memberId, String phone, String province,
                                         String city, String district, String detail ) throws Exception;

    /**
     * 查询总数量
     *
     * @param memberId
     * @return
     * @throws Exception
     */
    public int count(String memberId) throws Exception;

    /**
     * 查询所有数据
     *
     * @param memberId 查询条件
     * @return List<MemberBean> 查询后返回的结果集
     * @throws Exception
     **/
    public Pager<MemberAddressBean> list(String memberId, Pager<MemberAddressBean> page) throws Exception;

    /**
     * 保存
     *
     * @param bean 需要保存的bean对象
     * @return StatusBean 操作状态
     * @throws Exception
     **/
    public StatusBean<?> save(MemberAddressBean bean) throws Exception;

    /**
     * 更新
     *
     * @param bean 需要更新的bean对象
     * @return boolean 返回true表示更新成功；返回false表示更新失败；
     * @throws Exception
     **/
    public StatusBean<?> update(MemberAddressBean bean) throws Exception;

    /**
     * 删除
     *
     * @param addressId 地址ID
     * @param memberId 用户ID
     * @return boolean 返回true表示删除成功；返回false表示删除失败；
     * @throws Exception
     **/
    public StatusBean<?> deleteById(String addressId, String memberId) throws Exception;
}
