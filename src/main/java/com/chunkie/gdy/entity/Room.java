package com.chunkie.gdy.entity;

import lombok.Data;

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
public class Room {
    private String id;

    private Integer playerNum;

    private Integer password;

    private Boolean onGoing = Boolean.FALSE;

    private Player host;

    private List<Player> players = new ArrayList<>(playerNum);

    public Room(){

    }

    public Room(Integer playerNum, Integer password, Player host) {
        this.playerNum = playerNum;
        this.password = password;
        this.host = host;
        this.players.add(host);
    }

    public Boolean addPlayer(Player player) {
        return this.players.add(player);
    }

}