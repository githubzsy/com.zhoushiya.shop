package com.zhoushiya.shop.product.dao;

import com.zhoushiya.shop.common.dao.BaseDao;
import com.zhoushiya.shop.product.entity.Product;
import com.zhoushiya.shop.product.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/8 10:56
 */
@Mapper
public interface ProductDao extends BaseDao<Product> {

    ProductVO selectVOByPrimaryKey(long id);

    List<ProductVO> listVO();
}
