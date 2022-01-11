package com.chunkie.gdy.controller;

import com.alibaba.fastjson.JSONObject;
import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Game;
import com.chunkie.gdy.entity.Player;
import com.chunkie.gdy.entity.Room;
import com.chunkie.gdy.entity.User;
import com.chunkie.gdy.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/create")
    public ResponseObj createRoom(@RequestBody Room room, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        String token = request.getHeader("token");
        User user  = redisUtils.getObject(token, User.class);
        room.setHost(user);
        room.getUsers().add(user);
        redisUtils.set(room.getId(), room);
        responseObj.setMsg(Constants.Msgs.SUCCESS);
        responseObj.setCode(Constants.Code.NORMAL);
        return responseObj;
    }

    @RequestMapping("/join")
    public ResponseObj joinRoom(@RequestParam String id, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        Room room = redisUtils.getObject(id, Room.class);
        User user  = redisUtils.getObject(request.getHeader("token"), User.class);
        room.addUser(user);
        return responseObj;
    }

    @RequestMapping("/exit")
    public ResponseObj exitRoom(@RequestParam String id, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        Room room = redisUtils.getObject(id, Room.class);
        User user  = redisUtils.getObject(request.getHeader("token"), User.class);
        room.removeUser(user);
        return responseObj;
    }

    @RequestMapping("/start")
    public ResponseObj startGame(@RequestParam String id, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        Room room = redisUtils.getObject(id, Room.class);
        room.setOnGoing(true);
        List<Player> players = new ArrayList<>();
        for (User user : room.getUsers()){
            Player player = new Player(user.getUserName());
            players.add(player);
        }
        return responseObj;
    }
}
