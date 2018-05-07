package com.sky.service.directsale;

import com.sky.dao.vo.ProductConnectBean;

import java.util.List;

/**
 * Created by 建帆 on 2015/12/28.
 */
public interface IProductConnectService {
    public List<ProductConnectBean> getList(String productId);
}
