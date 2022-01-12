package com.chunkie.gdy.controller;

import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.service.GameService;
import com.chunkie.gdy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private GameService gameService;

    @RequestMapping("/on")
    public ResponseObj gameOn(String id, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        gameService.initialGame(id, request);
        return responseObj;
    }
}
