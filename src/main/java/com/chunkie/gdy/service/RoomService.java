package com.chunkie.gdy.service;

import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Game;
import com.chunkie.gdy.entity.Player;
import com.chunkie.gdy.entity.Room;
import com.chunkie.gdy.entity.User;
import com.chunkie.gdy.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName: RoomService
 * @Author: SichengGuo
 * @Date: 2022/1/12 10:45
 * @Version: 1.0
 */

@Service
public class RoomService {

    private List<Room> roomList = new ArrayList<>();

    @Autowired
    private RedisUtils redisUtils;

    public ResponseObj createRoom(Room room, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        String token = request.getHeader("token");
        User user  = redisUtils.getObject(token, User.class);
        Player player = new Player(user.getUserName());
        room.setHost(player);
        room.getPlayers().add(player);
        roomList.add(room);
        responseObj.setMsg(Constants.Msgs.SUCCESS);
        responseObj.setCode(Constants.Code.NORMAL);
        return responseObj;
    }

    public ResponseObj joinRoom(String id, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        User user  = redisUtils.getObject(request.getHeader("token"), User.class);
        Player player = new Player(user.getUserName());
        for (Room room : roomList){
            if (room.getId().equals(id)) {
                room.getPlayers().add(player);
                break;
            }
        }
        return responseObj;
    }

    public ResponseObj exitRoom(String id, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        User user  = redisUtils.getObject(request.getHeader("token"), User.class);
        Player player = new Player(user.getUserName());
        for (Room room : roomList) {
            if (room.getId().equals(id)) {
                room.getPlayers().remove(player);
                break;
            }
        }
        return responseObj;
    }
}
