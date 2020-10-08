package com.zhoushiya.shop.product.service.impl;

import com.zhoushiya.shop.common.service.impl.BaseServiceImpl;
import com.zhoushiya.shop.product.dao.ProductStockDao;
import com.zhoushiya.shop.product.entity.ProductStock;
import com.zhoushiya.shop.product.vo.ProductVO;
import com.zhoushiya.shop.product.dao.ProductDao;
import com.zhoushiya.shop.product.entity.Product;
import com.zhoushiya.shop.product.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/8 11:11
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product,ProductVO> implements ProductService {
    private final ProductDao productDao;

    private final ProductStockDao productStockDao;

    public ProductServiceImpl(ProductDao productDao, ProductStockDao productStockDao) {
        this.productDao = productDao;
        this.productStockDao = productStockDao;
    }

    /**
     * 获取当前使用的实际Dao
     *
     * @return 实际Dao
     */
    @Override
    public ProductDao getCurrentDao() {
        return productDao;
    }

    /**
     * 删除产品
     * @param id
     */
    @Transactional
    @Override
    public void deleteById(long id) {
        super.deleteById(id);
        productStockDao.deleteByPrimaryKey(id);
    }


    /**
     * 创建一个产品
     */
    @Transactional
    @Override
    public void create(ProductVO vo) {
        super.create(vo);
        productStockDao.create(new ProductStock(vo.getId(),vo.getStock()));
    }

    @Override
    public ProductVO getById(long id) {
        return productDao.selectVOByPrimaryKey(id);
    }

    @Override
    public List<ProductVO> list() {
        return productDao.listVO();
    }
}
