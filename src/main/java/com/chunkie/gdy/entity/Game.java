package com.chunkie.gdy.entity;

import com.chunkie.gdy.util.CardType;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Description:
 * @ClassName: Game
 * @Author: SichengGuo
 * @Date: 2021/12/15 16:28
 * @Version: 1.0
 */

@Data
public class Game {

    private String id;

    private Integer playerNum;

    private Integer multiple;

    private Integer bonus;

    private List<Card> cardDeck;

    private List<Player> players;

    private List<Card> lastDraw;

    private CardType lastType;

    private Player lastDrawer;

    private Player currentDrawer;

    public Game(String id, List<Player> players, Player lastDrawer){
        this.id = id;
        this.players = players;
        this.multiple = 1;
        this.bonus = 0;
        this.playerNum = players.size();
        this.lastDraw = new ArrayList<>();
        this.setLastDrawer(lastDrawer);
        this.setCurrentDrawer(lastDrawer);
    }
}