package com.chunkie.gdy.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * @Description:
 * @ClassName: Player
 * @Author: SichengGuo
 * @Date: 2021/12/14 15:43
 * @Version: 1.0
 */

@Data
public class Player implements Observer {

    private Boolean ready;

    private Boolean capableDiscard;

    private Integer score;

    List<Card> handCard = new ArrayList<>();

    @Override
    public void update(Observable observable, Object arg) {

    }
}
