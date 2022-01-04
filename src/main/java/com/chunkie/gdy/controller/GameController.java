package com.chunkie.gdy.controller;

import com.chunkie.gdy.common.ResponseObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @ClassName: GameController
 * @Author: SichengGuo
 * @Date: 2021/12/30 11:31
 * @Version: 1.0
 */

@RestController
@RequestMapping("/game")
public class GameController {

    @RequestMapping("/start")
    public ResponseObj initialGame(){
        ResponseObj responseObj = new ResponseObj();

        return responseObj;
    }
}
