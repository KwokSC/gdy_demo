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

    private Integer password;

    private Boolean onGoing;

    private Player host;

    private List<Player> players;

    public Room(){
        this.id = UUID.randomUUID().toString().substring(16);
        this.onGoing = false;
        this.players = new ArrayList<>();
    }

    public Room(Integer playerNum, Integer password) {
        this.id = UUID.randomUUID().toString().substring(16);
        this.playerNum = playerNum;
        this.password = password;
        this.onGoing = false;
        this.players = new ArrayList<>(playerNum);
    }

    public Boolean addPlayer(Player player){
        return this.players.add(player);
    }

    public Boolean removePlayer(Player player){
        return this.players.remove(player);
    }
}