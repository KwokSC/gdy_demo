package com.chunkie.gdy.controller;

import com.alibaba.fastjson.JSONObject;
import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Player;
import com.chunkie.gdy.entity.Room;
import com.chunkie.gdy.entity.User;
import com.chunkie.gdy.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/create")
    public ResponseObj createRoom(@RequestBody Room room, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        String token = request.getHeader("token");
        User user  = redisUtils.getObject(token, User.class);
        Player host = new Player(user.getUserName());
        room.setHost(host);
        room.getPlayers().add(host);
        redisUtils.set(room.getId(), room);
        responseObj.setMsg(Constants.Msgs.SUCCESS);
        responseObj.setCode(Constants.Code.NORMAL);
        responseObj.setData(room.getId());
        return responseObj;
    }

    @RequestMapping("/join")
    public ResponseObj joinRoom(){
        ResponseObj responseObj = new ResponseObj();

        return responseObj;
    }
}
