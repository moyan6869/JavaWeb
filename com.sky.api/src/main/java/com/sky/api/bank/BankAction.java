package com.sky.api.bank;

import com.sky.common.massage.ResponseUtil;
import com.sky.common.util.JacksonUtil;
import com.sky.common.util.StringUtil;
import com.sky.common.util.Version;
import com.sky.dao.model.APIBankBranch;
import com.sky.dao.model.APIBankBranchInfo;
import com.sky.service.directsale.BankService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能：银行列表
 *
 * @author xiaoheliu
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/bank", produces = "application/json")
public class BankAction {

    /**
     * 提现服务接口
     */
    @Resource
    BankService bankService;

    /**
     * 查询提现列表
     *
     * @param version 接口版本号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String list(String version) throws Exception {
        if (Version.V10.equals(version)) {
            return ResponseUtil.data(bankService.listAll());
        }
        return ResponseUtil.unknownVersion();
    }

    /**
     * 按条件查找运费数据
     */
    @RequestMapping(value = "/getBankBranch", method = RequestMethod.POST)
    @ResponseBody
    @RequiresAuthentication
    public String getBankBranch(@RequestBody String json, HttpServletRequest req, HttpServletResponse res) throws Exception {
        APIBankBranch bankBranch = JacksonUtil.fromJson(json, APIBankBranch.class);
        if (StringUtil.isNull(bankBranch)) {
            return ResponseUtil.error("传入的参数错误");
        }

        if (bankBranch.getBankId() <= 0) {
            return ResponseUtil.error("请传入银行类型");
        }

        if (StringUtil.isNull(bankBranch.getProvince())) {
            return ResponseUtil.error("请传入省");
        }

        if (StringUtil.isNull(bankBranch.getCity())) {
            return ResponseUtil.error("请传入市");
        }

        APIBankBranchInfo bankBranchs = bankService.getBankBranch(bankBranch);
        return ResponseUtil.data(bankBranchs);
    }
}

