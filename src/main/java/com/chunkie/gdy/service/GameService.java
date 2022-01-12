package com.chunkie.gdy.service;

import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

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

    public ResponseObj initialGame(String id, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();

        return responseObj;
    }
}
