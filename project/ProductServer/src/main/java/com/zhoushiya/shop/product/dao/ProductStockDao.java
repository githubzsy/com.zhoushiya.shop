package com.zhoushiya.shop.product.dao;

import com.zhoushiya.shop.common.dao.BaseDao;
import com.zhoushiya.shop.product.entity.ProductStock;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhoushiya
 * @date 2020/10/8 11:23
 */
@Mapper
public interface ProductStockDao extends BaseDao<ProductStock> {

    /**
     * 增加库存
     * @param productId 产品Id
     * @param count 增加数量
     */
    void increase(@Param("product_id") long productId,@Param("count") int count);

    /**
     * 减少库存
     * @param productId 产品Id
     * @param count 减少数量
     */
    void decrease(@Param("product_id") long productId,@Param("count") int count);
}
