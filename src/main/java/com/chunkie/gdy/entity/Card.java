package com.chunkie.gdy.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @ClassName: Card
 * @Author: SichengGuo
 * @Date: 2021/12/14 16:04
 * @Version: 1.0
 */

@Data
public class Card {

    private String color;

    private String point;

    public Card(String color, String point) {
        this.color = color;
        this.point = point;
    }

    public boolean equals(Object o) {
        if(o==null) {
            return true;
        }
        Card obj = (Card)o;
        if (color.equals(obj.color) && point.equals(obj.point)) {
            return true;
        }
        else
            return false;
    }

    public String toString() {
        return this.color + this.point;
    }

    public List<Card> shuffle(){
        String[] colors = {"square", "heart", "spade", "club"};
        String[] points = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        List<Card> cardDeck = new ArrayList<>();
        Random random = new Random();
        for(int i = 0; i < 52; i++) {
            int c = random.nextInt(4);
            int p = random.nextInt(13);
            Card card = new Card(colors[c],points[p]);
            while(cardDeck.contains(card)) {
                c = random.nextInt(4);
                p = random.nextInt(13);
                card.setColor(colors[c]);
                card.setPoint(points[p]);
            }
            cardDeck.add(card);
        }
        int j = random.nextInt(cardDeck.size());
        cardDeck.add(j,new Card("red", "Joker"));
        j = random.nextInt(cardDeck.size());
        cardDeck.add(j,new Card("black", "Joker"));
        return cardDeck;
    }
}
