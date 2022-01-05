package com.chunkie.gdy.controller;

import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Player;
import com.chunkie.gdy.entity.Room;
import com.chunkie.gdy.util.RedisUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @ClassName: RoomController
 * @Author: SichengGuo
 * @Date: 2021/12/30 11:49
 * @Version: 1.0
 */

@RestController
@RequestMapping("/room")
public class RoomController {

    RedisUtils redisUtils = new RedisUtils();

    @RequestMapping("/create")
    public ResponseObj createRoom(Integer playerNum, Integer password, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        Room room = new Room(playerNum, password);
        Player host = (Player) redisUtils.get(request.getHeader("token"));
        room.setHost(host);
        room.getPlayers().add(host);
        return responseObj;
    }

    @RequestMapping("/join")
    public ResponseObj joinRoom(){
        ResponseObj responseObj = new ResponseObj();

        return responseObj;
    }
}
