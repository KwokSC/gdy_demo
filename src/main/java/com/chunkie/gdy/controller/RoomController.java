package com.chunkie.gdy.controller;

import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Room;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/create")
    public ResponseObj createRoom(Room room){
        ResponseObj responseObj = new ResponseObj();
        
        return responseObj;
    }

    @RequestMapping("/join")
    public ResponseObj joinRoom(){
        ResponseObj responseObj = new ResponseObj();

        return responseObj;
    }
}
