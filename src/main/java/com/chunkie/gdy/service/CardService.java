package com.chunkie.gdy.service;

import com.chunkie.gdy.entity.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @ClassName: CardService
 * @Author: SichengGuo
 * @Date: 2021/12/14 16:17
 * @Version: 1.0
 */

@Service
public class CardService {

    public List<Card> shuffle(){
        String[] colors = {"square", "heart", "spade", "club"};
        String[] points = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        List<Card> cardDeck = new ArrayList<Card>();
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
