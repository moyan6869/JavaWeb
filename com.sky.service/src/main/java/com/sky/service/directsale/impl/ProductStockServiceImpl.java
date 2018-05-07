package com.sky.service.directsale.impl;

import com.sky.common.util.SessionUtil;
import com.sky.service.directsale.ProductStockService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/11/18.
 */
@Service("productStockService")
public class ProductStockServiceImpl implements ProductStockService {
    Logger log = Logger.getLogger(ProductStockServiceImpl.class);
    private final String ProductStockKey = "product:%s:stock";

    @Override
    public long getProductStock(String productId) {
        String key = String.format(ProductStockKey, productId);

        return SessionUtil.getSessionLongValue(key);
    }

    @Override
    public boolean setProductStock(String productId, long stock) {
        String key = String.format(ProductStockKey, productId);

        SessionUtil.setSessionLongValueInit(key, stock);
        log.fatal("刷新了产品库存redis2;现库存："+ SessionUtil.getSessionString(key));

        return true;
    }

    @Override
    public boolean addProductStock(String productId, long buyCount) {
        String key = String.format(ProductStockKey, productId);

        SessionUtil.setSessionLongValue(key, buyCount);
        return true;
    }

    @Override
    public boolean delProductStock(String productId, long buyCount) {
        String key = String.format(ProductStockKey, productId);

        if (getProductStock(productId) == 0) {
            return false;
        }
        //重置库存数量
        if (getProductStock(productId) < 0) {
            SessionUtil.setSessionLongValueInit(key, 0);
            return false;
        }

        SessionUtil.setSessionLongValue(key, -buyCount);
        return true;
    }
}
