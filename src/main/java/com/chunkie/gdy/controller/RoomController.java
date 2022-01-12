package com.chunkie.gdy.controller;

import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.entity.Game;
import com.chunkie.gdy.entity.Player;
import com.chunkie.gdy.entity.Room;
import com.chunkie.gdy.entity.User;
import com.chunkie.gdy.service.RoomService;
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
    private RoomService roomService;

    @RequestMapping("/create")
    public ResponseObj createRoom(@RequestBody Room room, HttpServletRequest request){
        return roomService.createRoom(room, request);
    }

    @RequestMapping("/join")
    public ResponseObj joinRoom(@RequestParam String id, HttpServletRequest request){
        return roomService.joinRoom(id, request);
    }

    @RequestMapping("/exit")
    public ResponseObj exitRoom(@RequestParam String id, HttpServletRequest request){
        return roomService.exitRoom(id, request);
    }
}
