package com.sky.service.directsale.impl;

import com.sky.common.util.JdbcTemplateDaoSupport;
import com.sky.dao.vo.ProductConnectBean;
import com.sky.service.directsale.IProductConnectService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 建帆 on 2015/12/28.
 */
@Service("productConnectService")
public class ProductConnectService implements IProductConnectService {
    @Override
    public List<ProductConnectBean> getList(String productId) {
        String sql = "SELECT * FROM product_connect where product_id='"+productId+"'";
        List<ProductConnectBean> productConnectBeanList = JdbcTemplateDaoSupport.getList(sql, new ProductConnectBean());
       return  productConnectBeanList;
    }
}
