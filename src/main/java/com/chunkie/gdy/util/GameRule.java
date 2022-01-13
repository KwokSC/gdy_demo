package com.chunkie.gdy.util;

import com.chunkie.gdy.entity.Card;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @ClassName: GameRulr
 * @Author: SichengGuo
 * @Date: 2021/12/15 16:38
 * @Version: 1.0
 */
public class GameRule {
    public static CardType rule(List<Card> cards) {

        // 单张
        if (cards.size() == 1)
            return CardType.SINGLE;

        // 对子
        if (cards.size() == 2 && cards.get(1).getPoint().equals(cards.get(0).getPoint())
                || cards.size() == 2 && cards.get(1).getPoint() == 16)
            return CardType.PAIR;

        if (cards.size() >= 3) {

            CardType result = null;
            Integer count = Utils.countJoker(cards);

            switch (count) {

                case 0:
                    // 顺子
                    if (result == null) {
                        for (int i = 0; i < cards.size() - 1; i++) {
                            if (cards.get(i).getPoint() + 1 == cards.get(i + 1).getPoint())
                                result = CardType.STRAIGHT;
                            else {
                                result = null;
                                break;
                            }
                        }
                    }

                    // 炸弹
                    if (result == null) {
                        for (int i = 0; i < cards.size() - 1; i++) {
                            if (cards.get(i).getPoint() == cards.get(i + 1).getPoint())
                                result = CardType.BOMB;
                            else {
                                result = null;
                                break;
                            }
                        }
                    }

                    break;

                case 1:

                    // 顺子
                    if (result == null) {
                        for (int i = 0; i < cards.size() - 2; i++) {
                            if (cards.get(i).getPoint() + 1 == cards.get(i + 1).getPoint())
                                result = CardType.STRAIGHT;
                            else if (cards.get(i).getPoint() + 2 == cards.get(i + 1).getPoint() && count != 0) {
                                result = CardType.STRAIGHT;
                                count--;
                                continue;
                            } else {
                                result = null;
                                break;
                            }
                        }
                    }

                    // 炸弹
                    if (result == null) {
                        for (int i = 0; i < cards.size() - 2; i++) {
                            if (cards.get(i).getPoint() == cards.get(i + 1).getPoint())
                                result = CardType.BOMB;
                            else {
                                result = null;
                                break;
                            }
                        }
                    }

                    break;

                case 2:

                    if (cards.size() == 3)
                        return CardType.BOMB;

                    // 顺子
                    if (result == null) {
                        for (int i = 0; i < cards.size() - 3; i++) {
                            if (cards.get(i).getPoint() + 1 == cards.get(i + 1).getPoint())
                                result = CardType.STRAIGHT;
                            else if (cards.get(i + 1).getPoint() != cards.get(i).getPoint()
                                    && cards.get(i + 1).getPoint() - cards.get(i).getPoint() <= count + 1) {
                                result = CardType.STRAIGHT;
                                count--;
                                continue;
                            } else {
                                result = null;
                                break;
                            }
                        }
                    }

                    // 炸弹
                    if (result == null) {
                        for (int i = 0; i < cards.size() - 3; i++) {
                            if (cards.get(i).getPoint() == cards.get(i + 1).getPoint())
                                result = CardType.BOMB;
                            else {
                                result = null;
                                break;
                            }
                        }
                    }

                    break;
            }

            return result;
        }
        return null;
    }

    @Test
    public void test() {
        Card card1 = new Card("square", 16);
        Card card2 = new Card("spade", 16);
        Card card3 = new Card("club", 10);
        Card card4 = new Card("club", 10);
        Card card5 = new Card("club", 10);
        List<Card> cards = Utils.trim(Arrays.asList(card1, card2, card3, card4, card5));
        System.out.println(rule(cards));
    }
}
