package com.zhoushiya.shop.auth.config;

/**
 * @author zhoushiya
 * @date 2020/10/7 13:59
 */
public class JWTConfig {
    public final static String USER_TOKEN_ENCRYPT_KEY="#H$AS^XCZAEFo3p5";

    public final static String ADMIN_TOKEN_ENCRYPT_KEY="^j%!@43#%GHKSE24SADVFRE54jfg";

    /**
     * 常量，用户Token中保存信息的前缀
     */
    public final static String USER_TOKEN_PREFIX="USER_";
    /**
     * 常量，管理员Token中保存信息的前缀
     */
    public final static String ADMIN_TOKEN_PREFIX="ADMIN_";
}
