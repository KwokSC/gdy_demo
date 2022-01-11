package com.chunkie.gdy.entity;

import com.chunkie.gdy.util.CardType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName: Game
 * @Author: SichengGuo
 * @Date: 2021/12/15 16:28
 * @Version: 1.0
 */

@Data
public class Game {

    private List<Player> players;

    private List<Card> lastDraw;

    private CardType lastType;

    private Player lastDrawer;

    public Game(){
        this.players = new ArrayList<>();
        this.lastDraw = new ArrayList<>();
    }
}