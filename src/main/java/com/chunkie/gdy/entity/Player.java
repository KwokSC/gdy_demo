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

    private String id;

    private String name;

    private Boolean ready = Boolean.FALSE;

    private Integer score = 0;

    List<Card> handCard = new ArrayList<>();

    public void getReady(){
        this.setReady(Boolean.TRUE);
    }

    public void cancelReady(){
        this.setReady(Boolean.FALSE);
    }

    public void draw(Card card) {
        this.handCard.add(card);
    }

    public void discard(List<Card> discardList) {
        this.handCard.removeAll(discardList);
    }
    
    public Boolean checkHand() {
        if(this.getHandCard().isEmpty())
            return true;
        return false;
    }
}
