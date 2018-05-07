package com.sky.service.directsale.impl;

import com.sky.common.service.impl.BaseServiceImpl;
import com.sky.common.util.DbUtil;
import com.sky.common.util.JdbcModuleDaoSupport2;
import com.sky.common.util.StringUtil;
import com.sky.dao.enums.DataBaseType;
import com.sky.dao.model.APIBankBranch;
import com.sky.dao.model.APIBankBranchInfo;
import com.sky.dao.vo.BankBean;
import com.sky.dao.vo.BankBranchBean;
import com.sky.service.directsale.BankService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * BankServiceImpl
 **/
@Service("bankService")
public class BankServiceImpl extends BaseServiceImpl implements BankService {
    @Override
    public List<BankBean> listAll() throws Exception {
        BankBean bean = new BankBean();
        String sql = " SELECT * FROM bank WHERE is_enable=1";
        return JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA, sql, bean, DbUtil.getMod4DbRandom());
    }

    @Override
    public APIBankBranchInfo getBankBranch(APIBankBranch bankBranch) {
        APIBankBranchInfo info = new APIBankBranchInfo();

        List<String> addresses = new ArrayList<String>();

        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("bankId", bankBranch.getBankId());
        params.put("province", bankBranch.getProvince());
        params.put("city", bankBranch.getCity());

        BankBranchBean bankBranchBean = new BankBranchBean();
        String sql = "SELECT * FROM bank_branch WHERE bank_id=:bankId AND province=:province AND city=:city LIMIT 1";
        bankBranchBean = JdbcModuleDaoSupport2.getObjectDateInfo(DataBaseType.BASE_DATA, sql, params, bankBranchBean, DbUtil.getMod4DbRandom());
        if (StringUtil.isNull(bankBranchBean)) {
            info.setAreaCode("");
            info.setAddresses(addresses);
        } else {
            sql = "SELECT address FROM bank_branch WHERE bank_id=:bankId AND province=:province AND city=:city AND LENGTH(address)>0";
            addresses = JdbcModuleDaoSupport2.getList(DataBaseType.BASE_DATA, sql, params, new String(), DbUtil.getMod4DbRandom());

            info.setAreaCode(bankBranchBean.getCode());
            info.setAddresses(addresses);
        }
        return info;
    }

}
