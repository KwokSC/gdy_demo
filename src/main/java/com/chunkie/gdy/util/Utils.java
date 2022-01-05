package com.chunkie.gdy.util;

import com.chunkie.gdy.entity.Card;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @ClassName: Util
 * @Author: SichengGuo
 * @Date: 2021/12/30 9:42
 * @Version: 1.0
 */
public class Utils {

    public static List<Card> shuffle(){
        String[] colors = {"square", "heart", "spade", "club"};
        //J=11, Q=12, K=13, A=14, 2=15
        Integer[] points = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
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
        cardDeck.add(j,new Card("red", 16));
        j = random.nextInt(cardDeck.size());
        cardDeck.add(j,new Card("black", 16));
        return cardDeck;
    }

    public static List<Card> trim(List<Card> handCard){

        for(int i = 0; i < handCard.size()-1; i++) {
            for(int j = 0; j < handCard.size()-1-i; j++) {
                if(handCard.get(j).getPoint() > handCard.get(j+1).getPoint()) {
                    Card temp = handCard.get(j);
                    handCard.set(j, handCard.get(j+1));
                    handCard.set(j+1, temp);
                }
            }
        }

        return handCard;
    }

    public static Integer countJoker(List<Card> handCard) {
        Integer count = 0;
        for(Card card : handCard) {
            if(card.getPoint() == 16)
                count ++;
        }
        return count;
    }

    public static Boolean drawCheck(CardType lastType,List<Card> lastDraw,
                                    CardType discardType, List<Card> discardList) {

        if(discardType.equals(lastType)) {

            if(discardType.equals(CardType.SINGLE)) {
                if(discardList.get(0).getPoint() == lastDraw.get(0).getPoint()+1
                        || discardList.get(0).getPoint() == 15) {
                    return true;
                }
            }

            if(discardType.equals(CardType.PAIR)) {
                if(discardList.get(0).getPoint() == lastDraw.get(0).getPoint()+1
                        || discardList.get(0).getPoint() == 15) {
                    return true;
                }
            }

            if(discardType.equals(CardType.STRAIGHT)) {
                if(discardList.get(0).getPoint() == lastDraw.get(0).getPoint()+1) {
                    return true;
                }
            }

            if(discardType.equals(CardType.BOMB)) {
                if(discardList.get(0).getPoint() > lastDraw.get(0).getPoint()) {
                    return true;
                }
            }

        }
        return false;
    }

    @Test
    public void test() {
        List<Card> cardDeck = shuffle();
        System.out.println(cardDeck.toString());
    }
}
