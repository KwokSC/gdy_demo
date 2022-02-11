package com.chunkie.gdy.controller;

import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.User;
import com.chunkie.gdy.service.UserService;
import com.chunkie.gdy.util.JwtUtils;
import com.chunkie.gdy.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description:
 * @ClassName: UserController
 * @Author: SichengGuo
 * @Date: 2022/1/5 9:56
 * @Version: 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/login")
    public ResponseObj login(@RequestBody User user){
        return userService.login(user);
    }
}
