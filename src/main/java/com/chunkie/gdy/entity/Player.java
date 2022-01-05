package com.chunkie.gdy.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @ClassName: Player
 * @Author: SichengGuo
 * @Date: 2021/12/14 15:43
 * @Version: 1.0
 */

@Data
public class Player {

    private String name;

    private Boolean ready;

    private Integer score;

    private List<Card> handCard;

    public Player(String name){
        this.name = name;
        this.ready = false;
        this.score = 0;
        this.handCard = new ArrayList<>();
    }

    public Boolean draw(Card card) {
        return this.handCard.add(card);
    }

    public Boolean discard(List<Card> discardList) {
        return this.handCard.removeAll(discardList);
    }

    public Boolean checkHand() {
        return this.getHandCard().isEmpty();
    }
}