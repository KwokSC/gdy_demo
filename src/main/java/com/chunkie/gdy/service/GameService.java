package com.chunkie.gdy.service;

import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Game;
import com.chunkie.gdy.entity.Room;
import com.chunkie.gdy.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description:
 * @ClassName: GameService
 * @Author: SichengGuo
 * @Date: 2022/1/12 10:45
 * @Version: 1.0
 */

@Service
public class GameService {

    @Autowired
    private RoomService roomService;

    public ResponseObj initialGame(String id){
        ResponseObj responseObj = new ResponseObj();
        Room room = roomService.findRoomById(id);
        room.setOnGoing(true);
        Game game = new Game(room.getPlayers(), room.getHost());
        game.setCardDeck(Utils.shuffle());
        responseObj.setCode(Constants.Code.NORMAL);
        responseObj.setMsg(Constants.Msgs.SUCCESS);
        return responseObj;
    }
}
