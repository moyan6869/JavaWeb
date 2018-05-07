package com.sky.service.directsale;

import com.sky.common.bean.StatusBean;
import com.sky.common.piting.Pager;
import com.sky.dao.model.ProductDetail;
import com.sky.dao.vo.ProductBean;


/**
 * 功能：
 * 1、实现根据商品分类查询商品（分页）
 * 2、实现查询商品详情
 *
 * @author xiaoheliu
 * @version 1.0
 * @since 2015-10-20
 **/
public interface ProductService {
    /**
     * 获取某个商品分类下的产品数量
     *
     * @param
     * @return
     * @throws Exception
     */
    public int count(String categoryId) throws Exception;

    /**
     * 分页获取产品
     *
     * @param categoryId
     * @return
     * @throws Exception
     */
    public Pager<ProductBean> list(String categoryId, Pager<ProductBean> page, String phone) throws Exception;

    /**
     * 获取产品详情
     *
     * @param productId
     * @return
     * @throws Exception
     */
    public ProductDetail get(String productId);
    
    public ProductDetail getFromFW(String productId);

    /**
     * 获取产品详情(包括已删除商品)
     *
     * @param productId
     * @return
     * @throws Exception
     */
    public ProductBean getByProductId(String productId) throws Exception;

    public boolean InitProductStock(Integer stock);
    public StatusBean InitFWCode();

}
