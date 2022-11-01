package com.chunkie.gdy.controller;

import com.chunkie.gdy.common.ResponseObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @ClassName: PlayerController
 * @Author: SichengGuo
 * @Date: 2022/1/12 9:47
 * @Version: 1.0
 */

@RestController
@RequestMapping("/player")
public class PlayerController {

    @RequestMapping("/ready")
    public ResponseObj setReady(){
        ResponseObj responseObj = new ResponseObj();

        return responseObj;
    }
}
