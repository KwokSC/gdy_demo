package com.chunkie.gdy.controller;

import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Card;
import com.chunkie.gdy.entity.Player;
import com.chunkie.gdy.entity.Room;
import com.chunkie.gdy.service.CardService;
import com.chunkie.gdy.service.PlayerService;
import com.chunkie.gdy.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @ClassName: RoomController
 * @Author: SichengGuo
 * @Date: 2021/12/14 16:19
 * @Version: 1.0
 */

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    CardService cardService;

    @Autowired
    PlayerService playerService;

    @Autowired
    RoomService roomService;

    @RequestMapping("/create")
    public void createRoom(){

    }

    @RequestMapping("/join")
    public void joinRoom(){

    }

    @RequestMapping("/start")
    public ResponseObj gameStart(){
        ResponseObj responseObj = new ResponseObj();
        try{
            List<Card> cardDeck = cardService.shuffle();
            responseObj.setData(cardDeck);
            responseObj.setCode(Constants.Code.NORMAL);
            responseObj.setMsg(Constants.Msgs.SUCCESS);
            return responseObj;
        }
        catch (Exception e){
            e.printStackTrace();
            responseObj.setMsg(Constants.Msgs.FAIL);
            responseObj.setCode(Constants.Code.EXCEPTION);
            return responseObj;
        }
    }
}
