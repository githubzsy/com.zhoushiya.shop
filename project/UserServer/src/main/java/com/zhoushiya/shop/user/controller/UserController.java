package com.zhoushiya.shop.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.zhoushiya.shop.common.entity.CommonResult;
import com.zhoushiya.shop.user.entity.User;
import com.zhoushiya.shop.user.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhoushiya
 * @date 2020/10/6 14:40
 */
@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${config.info}")
    public String info;

    @GetMapping("/info")
    public String getInfo(){
        return info;
    }


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @SentinelResource
    public ResponseEntity<CommonResult> create(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<>(CommonResult.getOKResult(user), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @SentinelResource(value = "/user/{id}")
    public ResponseEntity<CommonResult> getById(@PathVariable long id) {
        User user = userService.getById(id);
        return new ResponseEntity<>(CommonResult.getOKResult(user), HttpStatus.OK);
    }

    @PutMapping
    @SentinelResource
    public ResponseEntity<CommonResult> update(@RequestBody User user) {
        userService.update(user);
        return new ResponseEntity<>(CommonResult.getOKResult(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @SentinelResource
    public ResponseEntity<CommonResult> delete(@PathVariable long id) {
        userService.delete(id);
        return new ResponseEntity<>(CommonResult.getOKResult(null), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    @SentinelResource
    public ResponseEntity<CommonResult> getAll() {
        List<User> users = userService.getAll();
        return new ResponseEntity<>(CommonResult.getOKResult(users), HttpStatus.OK);
    }
}
