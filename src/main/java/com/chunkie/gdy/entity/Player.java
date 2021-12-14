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

    private Boolean ready;

    private Integer score;

    List<Card> handCard = new ArrayList<Card>();

    public void discard() {

    }

    public void drawCard(Card card) {

    }

}
