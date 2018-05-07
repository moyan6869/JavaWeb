package com.sky.service.directsale;

import com.sky.dao.model.APIBankBranch;
import com.sky.dao.model.APIBankBranchInfo;
import com.sky.dao.vo.BankBean;

import java.util.List;

/**
 * BankService
 *
 * @author Geoffrey
 **/
public interface BankService {


    /**
     * 查询所有数据
     *
     * @return List<BankBean>
     * @throws Exception
     */
    public List<BankBean> listAll() throws Exception;


    /**
     * 获取银行的营业网点
     */
    public APIBankBranchInfo getBankBranch(APIBankBranch bankBranch);
}
