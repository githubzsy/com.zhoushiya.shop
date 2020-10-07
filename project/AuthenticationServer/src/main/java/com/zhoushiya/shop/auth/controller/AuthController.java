package com.zhoushiya.shop.auth.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.zhoushiya.shop.auth.annotation.AdminLoginToken;
import com.zhoushiya.shop.auth.config.JWTConfig;
import com.zhoushiya.shop.auth.service.AdminService;
import com.zhoushiya.shop.auth.service.TokenService;
import com.zhoushiya.shop.auth.service.UserService;
import com.zhoushiya.shop.auth.vo.AdminVO;
import com.zhoushiya.shop.auth.vo.LoginResult;
import com.zhoushiya.shop.auth.vo.RegisterInfo;
import com.zhoushiya.shop.auth.vo.UserVO;
import com.zhoushiya.shop.common.vo.CommonResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhoushiya
 * @date 2020/10/7 11:17
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    private final AdminService adminService;

    private final TokenService tokenService;

    public AuthController(UserService userService, AdminService adminService, TokenService tokenService) {
        this.userService = userService;
        this.adminService = adminService;
        this.tokenService = tokenService;
    }

    /**
     * 创建用户
     *
     * @param registerInfo 注册信息
     * @return
     */
    @PostMapping("/user/create")
    @SentinelResource
    public ResponseEntity<CommonResult> userCreate(@RequestBody RegisterInfo registerInfo) {
        long id=userService.create(registerInfo);
        return new ResponseEntity<>(CommonResult.getOKResult(id), HttpStatus.OK);
    }

    @GetMapping("/user/login/{account}/{password}")
    @SentinelResource
    public ResponseEntity<CommonResult> userLogin(@PathVariable("account") String account, @PathVariable("password") String password) {
        UserVO userVO = userService.selectByAccountAndPassword(account, password);
        if (userVO == null) {
            return new ResponseEntity<>(new CommonResult(HttpStatus.NOT_FOUND, "登录失败"), HttpStatus.NOT_FOUND);
        } else {
            String userToken = tokenService.getUserToken(userVO.getId());
            return new ResponseEntity<>(new CommonResult(HttpStatus.OK, "登录成功", new LoginResult(userVO.getId(), userVO.getAccount(), userToken)), HttpStatus.OK);
        }
    }

    @GetMapping("/user/verify/{id}/{token}")
    @SentinelResource
    public ResponseEntity<CommonResult> userVerify(@PathVariable("id") long id, @PathVariable("token") String token) {
        return verify(JWTConfig.USER_TOKEN_ENCRYPT_KEY,JWTConfig.USER_TOKEN_PREFIX, id, token);
    }

    @AdminLoginToken
    @PostMapping("/admin/create")
    @SentinelResource
    public ResponseEntity<CommonResult> adminCreate(@RequestBody RegisterInfo registerInfo) {
        long id = adminService.create(registerInfo);
        return new ResponseEntity<>(CommonResult.getOKResult(id), HttpStatus.OK);
    }

    @GetMapping("/admin/login/{account}/{password}")
    @SentinelResource
    public ResponseEntity<CommonResult> adminLogin(@PathVariable("account") String account, @PathVariable("password") String password) {
        AdminVO adminVO = adminService.selectByAccountAndPassword(account, password);
        if (adminVO == null) {
            return new ResponseEntity<>(new CommonResult(HttpStatus.NOT_FOUND, "登录失败"), HttpStatus.NOT_FOUND);
        } else {
            String token = tokenService.getAdminToken(adminVO.getId());
            return new ResponseEntity<>(new CommonResult(HttpStatus.OK, "登录成功", new LoginResult(adminVO.getId(), adminVO.getAccount(), token)), HttpStatus.OK);
        }
    }

    @GetMapping("/admin/verify/{id}/{token}")
    @SentinelResource
    public ResponseEntity<CommonResult> adminVerify(@PathVariable("id") long id, @PathVariable("token") String token) {
        return verify(JWTConfig.ADMIN_TOKEN_ENCRYPT_KEY,JWTConfig.ADMIN_TOKEN_PREFIX, id, token);
    }

    /**
     * 验证token是否合法
     *
     * @param encryptKey 当前密钥
     * @param id         用户id
     * @param token      当前token
     * @param prefix     audience前缀
     * @return
     */
    static ResponseEntity<CommonResult> verify(String encryptKey,String prefix, long id, String token) {
        boolean valid = false;
        try {
            JWT.decode(token);
        } catch (JWTDecodeException j) {

        }

        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(encryptKey)).build();
        try {
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            if (decodedJWT.getAudience().contains(String.valueOf(id)) && decodedJWT.getAudience().contains(prefix) ) {
                valid = true;
            }
        } catch (JWTVerificationException e) {

        }
        if (valid) {
            return new ResponseEntity<>(new CommonResult(HttpStatus.OK, "验证成功"), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new CommonResult(HttpStatus.UNAUTHORIZED, "验证失败"), HttpStatus.UNAUTHORIZED);
        }
    }
}
