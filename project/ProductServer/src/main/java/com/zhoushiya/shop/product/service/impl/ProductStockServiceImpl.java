package com.zhoushiya.shop.product.service.impl;

import com.zhoushiya.shop.common.dao.BaseDao;
import com.zhoushiya.shop.common.service.impl.BaseServiceImpl;
import com.zhoushiya.shop.product.dao.ProductDao;
import com.zhoushiya.shop.product.dao.ProductStockDao;
import com.zhoushiya.shop.product.entity.ProductStock;
import com.zhoushiya.shop.product.service.ProductStockService;
import com.zhoushiya.shop.product.vo.ProductStockVO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author zhoushiya
 * @date 2020/10/8 11:25
 */
@Service
public class ProductStockServiceImpl extends BaseServiceImpl<ProductStock, ProductStockVO> implements ProductStockService {

    private final ProductStockDao productStockDao;

    private final ProductDao productDao;

    public ProductStockServiceImpl(ProductStockDao productStockDao, ProductDao productDao) {
        this.productStockDao = productStockDao;
        this.productDao = productDao;
    }


    /**
     * 获取当前使用的实际Dao
     *
     * @return 实际Dao
     */
    @Override
    public BaseDao<ProductStock> getCurrentDao() {
        return productStockDao;
    }

    /**
     * 减少库存
     *
     * @param productId 产品Id
     * @param count     减少的数量
     */
    @Override
    public BigDecimal decrease(long productId, int count) {
        int stock = productStockDao.selectByPrimaryKey(productId).getStock();
        if (count > stock) {
            throw new RuntimeException("库存只剩:" + stock);
        }
        productStockDao.decrease(productId, count);
        return productDao.selectByPrimaryKey(productId).getPrice().multiply(BigDecimal.valueOf(count));
    }
}
