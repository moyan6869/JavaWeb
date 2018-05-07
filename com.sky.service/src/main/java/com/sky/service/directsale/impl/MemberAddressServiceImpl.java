package com.sky.service.directsale.impl;

import com.sky.common.bean.StatusBean;
import com.sky.common.piting.Pager;
import com.sky.common.service.impl.BaseServiceImpl;
import com.sky.common.util.DbUtil;
import com.sky.common.util.JdbcModuleDaoSupport2;
import com.sky.common.util.StringUtil;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.vo.MemberAddressBean;
import com.sky.service.directsale.MemberAddressService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * MemberAddressServiceImpl
 **/
@Service("MemberAddressService")
public class MemberAddressServiceImpl extends BaseServiceImpl implements MemberAddressService {

    @Override
    public MemberAddressBean getDefault(String memberId) throws Exception {
        String memberAddressTableName = DbUtil.getMemberAddressTableName(memberId);
        MemberAddressBean bean = new MemberAddressBean();
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("memberId", memberId);
        String sql = "select * from " + memberAddressTableName + " where member_Id=:memberId AND is_default=1";
        bean = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.MEMBER_DATA, sql, params, bean, memberId);
        return bean;
    }

    @Override
    public MemberAddressBean get(String addressId, String memberId) throws Exception {
        String memberAddressTableName = DbUtil.getMemberAddressTableName(memberId);
        MemberAddressBean bean = new MemberAddressBean();
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("memberId", memberId);
        params.put("addressId", addressId);
        String sql = "select * from " + memberAddressTableName + " where address_id=:addressId AND member_Id=:memberId";
        bean = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.MEMBER_DATA, sql, params, bean, memberId);
        log.error("运费获取开始：33333333333333333333333333");
        return bean;
    }

    @Override
    public MemberAddressBean getAddress(String memberId, String phone, String province,
                                        String city, String district, String detail ) throws Exception {
        String memberAddressTableName = DbUtil.getMemberAddressTableName(memberId);
        MemberAddressBean bean = new MemberAddressBean();
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("memberId", memberId);
        params.put("phone", phone);
        params.put("province", province);
        params.put("city", city);
        params.put("district", district);
        params.put("detail", detail);
        String sql = "select * from " + memberAddressTableName + " where member_Id=:memberId AND phone=:phone AND province=:province AND city=:city AND district=:district AND detail=:detail";
        bean = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.MEMBER_DATA, sql, params, bean, memberId);
        log.error("运费获取开始：33333333333333333333333333");
        return bean;
    }

    @Override
    public int count(String memberId) throws Exception {
        String memberAddressTableName = DbUtil.getMemberAddressTableName(memberId);
        StringBuffer sbSql = new StringBuffer();
        sbSql.append("select count(*) from " + memberAddressTableName + " where member_Id='" + memberId + "' ");
        return JdbcModuleDaoSupport2.count(DataBaseType.MEMBER_DATA, sbSql.toString(), null, memberId);
    }

    @Override
    public Pager<MemberAddressBean> list(String memberId, Pager<MemberAddressBean> pageData) throws Exception {
        String memberAddressTableName = DbUtil.getMemberAddressTableName(memberId);
        MemberAddressBean bean = new MemberAddressBean();
        bean.setMemberId(memberId);
        StringBuffer sbSql = new StringBuffer();
        sbSql.append("select * from " + memberAddressTableName + " where member_Id='" + memberId + "'  ORDER BY is_default DESC,create_date DESC ");
        sbSql.append(" limit " + (pageData.getPageOffset() - 1) * pageData.getPageSize() + "," + pageData.getPageSize() + "");
        List<MemberAddressBean> datas = JdbcModuleDaoSupport2.getList(DataBaseType.MEMBER_DATA, sbSql.toString(), bean, memberId);
        pageData.setDatas(datas);
        int totalRows = this.count(memberId);
        pageData.setTotalRecord(totalRows);
        pageData.setTotalPage(totalRows);
        return pageData;
    }

    @Override
    public StatusBean<?> save(MemberAddressBean bean) throws Exception {
        String memberAddressTableName = DbUtil.getMemberAddressTableName(bean.getMemberId());
        if (bean.getIsDefault() == 1) {
            UpdateDefaultAddress(bean.getMemberId());
        }
        Date currDate = new Date();
        String sql = "INSERT INTO " + memberAddressTableName + " " +
                "(address_id, member_Id, contact, phone, zipcode, province, city, district, detail, is_default, create_date, update_date) " +
                "VALUES " +
                "(:addressId, :memberId, :contact, :phone, :zipcode, :province, :city, :district, :detail, :isDefault, :createDate, :updateDate);";
        bean.setCreateDate(currDate);
        bean.setAddressId(StringUtil.getUUID());
        if (JdbcModuleDaoSupport2.updateOrAddOrDele(DataBaseType.MEMBER_DATA, sql, bean, bean.getMemberId())) {
            return success("操作成功");
        }
        return error("操作失败");
    }

    @Override
    public StatusBean<?> update(MemberAddressBean bean) throws Exception {
        String memberAddressTableName = DbUtil.getMemberAddressTableName(bean.getMemberId());
        if (bean.getIsDefault() == 1) {
            UpdateDefaultAddress(bean.getMemberId());
        }
        Date currDate = new Date();
        String sql = "UPDATE " + memberAddressTableName + " SET " +
                "contact=:contact, phone=:phone, zipcode=:zipcode, province=:province, city=:city, district=:district, detail=:detail, is_default=:isDefault,  update_date=:updateDate" +
                " WHERE address_id=:addressId AND member_Id=:memberId;";
        bean.setUpdateDate(currDate);
        if (JdbcModuleDaoSupport2.updateOrAddOrDele(DataBaseType.MEMBER_DATA, sql, bean, bean.getMemberId())) {
            return success("操作成功");
        } else {
            return error("操作失败");
        }
    }

    private void UpdateDefaultAddress(String memberId) {
        String memberAddressTableName = DbUtil.getMemberAddressTableName(memberId);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("memberId", memberId);
        params.put("isDefault", 1);
        String sql = "select  address_id from " + memberAddressTableName + " where member_Id=:memberId and is_default=:isDefault";
        params = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.MEMBER_DATA, memberId, sql, params);
        if (!StringUtil.isNull(params)) {
            sql = "UPDATE " + memberAddressTableName + " SET is_default=0 WHERE address_id=:address_id";
            JdbcModuleDaoSupport2.updateOrAddOrDele(DataBaseType.MEMBER_DATA, sql, params, memberId);
        }
    }

    @Override
    public StatusBean<?> deleteById(String addressId, String memberId) throws Exception {
        String memberAddressTableName = DbUtil.getMemberAddressTableName(memberId);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("memberId", memberId);
        params.put("addressId", addressId);
        String sql = "DELETE FROM " + memberAddressTableName + " WHERE address_id=:addressId AND member_Id=:memberId;";
        if (JdbcModuleDaoSupport2.updateOrAddOrDele(DataBaseType.MEMBER_DATA, sql, params, memberId)) {
            return success("操作成功");
        } else {
            return error("操作失败");
        }
    }

}
