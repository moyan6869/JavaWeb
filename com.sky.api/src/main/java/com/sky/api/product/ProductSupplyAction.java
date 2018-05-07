package com.sky.api.product;

import com.sky.common.MsgHelp;
import com.sky.common.massage.ResponseUtil;
import com.sky.common.piting.Pager;
import com.sky.common.util.StringUtil;
import com.sky.common.util.Version;
import com.sky.dao.vo.ProductBean;
import com.sky.dao.vo.ProductHotBean;
import com.sky.service.directsale.ProductHotService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * ProductHotAction
 *
 * @author
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/product", produces = "application/json")
public class ProductSupplyAction {

    /**
     * 用户服务接口
     */
    @Resource
    ProductHotService productHotService;

    /**
     * 查询分页（默认排序/销量排序）
     *
     * @param pageOffset    页码
     * @param pageSize    页数
     * @param version 接口版本号
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String list(String pageOffset, String pageSize, String version) throws Exception {
        if (StringUtil.isNull(pageOffset)) {
            pageOffset = "1";
        }
        if (StringUtil.isNull(pageSize)) {
            pageSize = "15";
        }
        if (StringUtil.isNumeric(pageOffset)) {
            return ResponseUtil.error(MsgHelp.PAGE_OFFSET_MUST_NUM);
        }
        if (Version.V10.equals(version)) {
            Pager<ProductBean> page = new Pager<ProductBean>();
            page.setPageOffset(Integer.parseInt(pageOffset));
            page.setPageSize(Integer.parseInt(pageSize));
            page = productHotService.listAll(page);
            return ResponseUtil.data(page);
        }
        return ResponseUtil.unknownVersion();
    }


}

