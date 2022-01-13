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

    private List<Card> cardDeck;

    private List<Player> players;

    private List<Card> lastDraw;

    private CardType lastType;

    private Player lastDrawer;

    private Player currentDrawer;

    public Game(List<Player> players, Player lastDrawer){
        this.id = UUID.randomUUID().toString().substring(6);
        this.players = players;
        this.lastDraw = new ArrayList<>();
        this.setLastDrawer(lastDrawer);
        this.setCurrentDrawer(lastDrawer);
    }
}