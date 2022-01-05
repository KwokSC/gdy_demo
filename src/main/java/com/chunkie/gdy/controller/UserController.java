package com.chunkie.gdy.controller;

import com.chunkie.gdy.common.ResponseObj;
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

    @RequestMapping("/login")
    public ResponseObj login(String id, String password){
        ResponseObj responseObj = new ResponseObj();

        return responseObj;
    }
}
