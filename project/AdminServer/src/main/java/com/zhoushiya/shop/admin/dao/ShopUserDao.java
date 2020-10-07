package com.zhoushiya.shop.admin.dao;


import com.zhoushiya.shop.admin.entity.ShopUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/6 14:35
 */
@Mapper
public interface ShopUserDao {

    //#p0表示第一个参数
    @Cacheable(value="user",key = "#p0")
    ShopUser getById(@Param("id") long id);

    @Caching(
            evict = {
                    @CacheEvict(value = "userAll",allEntries = true)
            }
    )
    void create(ShopUser user);

    @Caching(
            evict = {
                    @CacheEvict(value = "userAll",allEntries = true),
                    @CacheEvict(value = "user",key = "#p0.getId()")
            }
    )
    void update(ShopUser user);

    @Caching(
            evict = {
                    @CacheEvict(value = "userAll",allEntries = true),
                    @CacheEvict(value = "user",key = "#p0")
            }
    )
    void delete(@Param("id") long id);

    @Cacheable(value = "userAll")
    List<ShopUser> getAll();
}
