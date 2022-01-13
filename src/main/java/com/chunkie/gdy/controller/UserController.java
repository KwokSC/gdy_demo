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
    public ResponseObj login(@RequestBody JSONObject jsonObject){
        ResponseObj responseObj = new ResponseObj();
        Set<String> keySet = jsonObject.keySet();
        Map<String, Object> loginInfo = new HashMap<>();
        for (String key : keySet) {
            loginInfo.put(key, jsonObject.get(key));
        }
        String userName = (String) loginInfo.get("userName");
        String password = (String) loginInfo.get("password");
        User user =  userService.findByUserName(userName);
        if(user==null || !user.getPassword().equals(password)){
            responseObj.setMsg(Constants.Msgs.FAIL);
            responseObj.setCode(Constants.Code.EXCEPTION);
        }else{
            String token = jwtUtils.generateToken(loginInfo);
            String s = JSONObject.toJSONString(user);
            redisUtils.set(token, s);
            responseObj.setData(token);
            responseObj.setCode(Constants.Code.NORMAL);
            responseObj.setMsg(Constants.Msgs.SUCCESS);
        }
        return responseObj;
    }
}
