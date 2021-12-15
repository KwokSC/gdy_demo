package com.chunkie.gdy.controller;

import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Player;
import com.chunkie.gdy.entity.Room;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


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

    List<Room> roomList = new ArrayList<>();

    @RequestMapping("/create")
    public ResponseObj createRoom(@RequestBody Room room){
        ResponseObj responseObj = new ResponseObj();
        room.setId(UUID.randomUUID().toString());
        room.setOnGoing(Boolean.FALSE);
        room.addObserver(room.getHost());
        roomList.add(room);
        responseObj.setCode(Constants.Code.NORMAL);
        responseObj.setMsg(Constants.Msgs.SUCCESS);
        responseObj.setData(room);
        return responseObj;
    }

    @RequestMapping("/start")
    public void gameStart(@RequestParam String id) {

    }
}
