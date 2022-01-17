package com.chunkie.gdy.service;

import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Card;
import com.chunkie.gdy.entity.Game;
import com.chunkie.gdy.entity.Player;
import com.chunkie.gdy.entity.Room;
import com.chunkie.gdy.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Description:
 * @ClassName: GameService
 * @Author: SichengGuo
 * @Date: 2022/1/12 10:45
 * @Version: 1.0
 */

@Service
public class GameService {

    private List<Game> gameList = new ArrayList<>();

    @Autowired
    private RoomService roomService;

    public ResponseObj initialGame(String id){
        ResponseObj responseObj = new ResponseObj();
        Room room = roomService.findRoomById(id);
        room.setOnGoing(true);
        Game game = new Game(id, room.getPlayers(), room.getHost());
        game.setCardDeck(Utils.shuffle());
        Map<String, List<Card>> handCardList = new HashMap<>();
        for (Player player : game.getPlayers()) {
            for (int i = 0; i < 5; i++) {
                player.getHandCard().add(game.getCardDeck().get(game.getCardDeck().size() - 1));
                game.getCardDeck().remove(game.getCardDeck().size() - 1);
            }
            player.setHandCard(Utils.trim(player.getHandCard()));
            handCardList.put(player.getName(), player.getHandCard());
        }
        gameList.add(game);
        responseObj.setData(handCardList);
        responseObj.setCode(Constants.Code.NORMAL);
        responseObj.setMsg(Constants.Msgs.SUCCESS);
        return responseObj;
    }

    public ResponseObj gameProcess(){
        ResponseObj responseObj = new ResponseObj();
        responseObj.setCode(Constants.Code.NORMAL);
        responseObj.setMsg(Constants.Msgs.SUCCESS);
        return responseObj;
    }

    public Game findGameById(String id){
        for(Game game : gameList){
            if(game.getId().equals(id))
                return game;
        }
        return null;
    }
}
