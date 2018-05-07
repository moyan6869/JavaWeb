package com.sky.service.directsale;

/**
 * 产品库存
 */
public interface ProductStockService {

    /**
     * 获取产品库存
     *
     * @param productId
     * @return
     */
    public long getProductStock(String productId);

    /**
     * 设置产品库存
     *
     * @param productId
     * @param stock
     * @return
     */
    public boolean setProductStock(String productId, long stock);


    /**
     * 增加产品库存
     *
     * @param productId
     * @param buyCount
     * @return
     */
    public boolean addProductStock(String productId, long buyCount);

    /**
     * 减少产品库存
     *
     * @param productId
     * @param buyCount
     * @return
     */
    public boolean delProductStock(String productId, long buyCount);
}
