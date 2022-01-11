package com.chunkie.gdy.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @ClassName: Room
 * @Author: SichengGuo
 * @Date: 2021/12/14 16:04
 * @Version: 1.0
 */

@Data
public class Room {

    private String id;

    private Integer playerNum;

    private Boolean onGoing;

    private User host;

    private List<User> users;

    public Room(){
        this.id = UUID.randomUUID().toString().substring(6);
        this.onGoing = false;
        this.users = new ArrayList<>();
    }

    public Boolean addUser(User user){
        return this.users.add(user);
    }

    public Boolean removeUser(User user){
        return this.users.remove(user);
    }
}