package com.chunkie.gdy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName: Room
 * @Author: SichengGuo
 * @Date: 2021/12/14 16:04
 * @Version: 1.0
 */

@Data
public class Room implements Serializable {

    private String id;

    private Integer playerNum;

    private Integer password;

    private Boolean onGoing;

    private Player host;

    private List<Player> players;

    public Room(){
        this.onGoing = false;
        this.players = new ArrayList<>();
    }

    public Room(Integer playerNum, Integer password, Player host) {
        this.playerNum = playerNum;
        this.password = password;
        this.onGoing = false;
        this.host = host;
        this.players = new ArrayList<>(playerNum);
        this.players.add(host);
    }

    public Boolean addPlayer(Player player){
        return this.players.add(player);
    }

    public Boolean removePlayer(Player player){
        return this.players.remove(player);
    }
}