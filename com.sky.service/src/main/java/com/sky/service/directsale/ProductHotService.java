package com.sky.service.directsale;

import com.sky.common.piting.Pager;
import com.sky.dao.vo.ProductBean;
import com.sky.dao.vo.ProductHotBean;

/**
 * ProductHotService
 *
 * @author
 **/
public interface ProductHotService {
    /**
     * 查询所有数据（默认/销量）
     *
     * @return List<ProductHotBean>
     * @throws Exception
     */
    public Pager<ProductBean> listAll(Pager<ProductBean> pageData) throws Exception;


}
