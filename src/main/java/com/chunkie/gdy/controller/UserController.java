package com.chunkie.gdy.controller;

import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.User;
import com.chunkie.gdy.service.UserService;
import com.chunkie.gdy.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/login")
    public ResponseObj login(String userName, String password){
        ResponseObj responseObj = new ResponseObj();
        User user =  userService.findByUserName(userName);
        if(user==null || !user.getPassword().equals(password)){
            responseObj.setMsg(Constants.Msgs.FAIL);
            responseObj.setCode(Constants.Code.EXCEPTION);
        }else{
            String JWT = JwtUtils.createJWT(user.getId(), userName, Constants.JWT_TTL);
            responseObj.setData(JWT);
            responseObj.setCode(Constants.Code.NORMAL);
            responseObj.setMsg(Constants.Msgs.SUCCESS);
        }
        return responseObj;
    }
}
