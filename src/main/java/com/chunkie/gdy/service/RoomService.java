package com.chunkie.gdy.service;

import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Room;
import com.chunkie.gdy.entity.User;
import com.chunkie.gdy.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @ClassName: RoomService
 * @Author: SichengGuo
 * @Date: 2022/1/12 10:45
 * @Version: 1.0
 */

@Service
public class RoomService {

    @Autowired
    private RedisUtils redisUtils;

    public ResponseObj createRoom(Room room, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        String token = request.getHeader("token");
        User user  = redisUtils.getObject(token, User.class);
        room.setHost(user);
        room.getUsers().add(user);
        roomList.add(room);
        responseObj.setMsg(Constants.Msgs.SUCCESS);
        responseObj.setCode(Constants.Code.NORMAL);
        return responseObj;
    }

    public ResponseObj joinRoom(String id, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        User user  = redisUtils.getObject(request.getHeader("token"), User.class);
        for (Room room : roomList){
            if (room.getId().equals(id)) {
                room.addUser(user);
                break;
            }
        }
        return responseObj;
    }

    public ResponseObj exitRoom(String id, HttpServletRequest request){
        ResponseObj responseObj = new ResponseObj();
        User user  = redisUtils.getObject(request.getHeader("token"), User.class);
        for (Room room : roomList) {
            if (room.getId().equals(id)) {
                room.removeUser(user);
                break;
            }
        }
        return responseObj;
    }


}
