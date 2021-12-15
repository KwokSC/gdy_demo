package com.chunkie.gdy.controller;

import com.chunkie.gdy.entity.Room;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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

    @RequestMapping("/create")
    public void createRoom(@RequestBody Room room){

    }

    @RequestMapping("/join")
    public void joinRoom(@RequestParam Integer password){

    }

    @RequestMapping("/start")
    public void gameStart() {
    }
}
