package com.chunkie.gdy.entity;

import lombok.Data;

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

    private Player host;

    private List<Player> players;

    private Boolean onGoing;
}
