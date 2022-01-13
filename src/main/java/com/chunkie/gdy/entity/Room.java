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

    private Player host;

    private List<Player> players;

    public Room(){
        this.id = UUID.randomUUID().toString().substring(6);
        this.onGoing = false;
        this.players = new ArrayList<>();
    }

    public Boolean addUser(Player player){
        return this.players.add(player);
    }

    public Boolean removeUser(Player player){
        return this.players.remove(player);
    }
}