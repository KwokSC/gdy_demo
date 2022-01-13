package com.chunkie.gdy.service;

import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Card;
import com.chunkie.gdy.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description:
 * @ClassName: PlayerService
 * @Author: SichengGuo
 * @Date: 2022/1/13 16:27
 * @Version: 1.0
 */
public class PlayerService {

    @Autowired
    private GameService gameService;

    public ResponseObj playerDraw(String id, List<Card> drawList){
        ResponseObj responseObj = new ResponseObj();
        Game game = gameService.findGameById(id);

        responseObj.setCode(Constants.Code.NORMAL);
        responseObj.setMsg(Constants.Msgs.SUCCESS);
        return responseObj;
    }

}
