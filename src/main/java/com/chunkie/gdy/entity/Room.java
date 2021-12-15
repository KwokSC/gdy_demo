package com.chunkie.gdy.entity;

import lombok.Data;

import java.util.List;
import java.util.Observable;

/**
 * @Description:
 * @ClassName: Room
 * @Author: SichengGuo
 * @Date: 2021/12/14 16:04
 * @Version: 1.0
 */

@Data
public class Room extends Observable {

    private String id;

    private Integer playerNum;

    private Integer password;

    private Boolean onGoing;

    private List<Player> playerList;

}
