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
public class Player extends User implements Observer {

    private Boolean ready;

    private Integer score;

    List<Card> handCard = new ArrayList<>();

    @Override
    public void update(Observable observable, Object arg) {

    }

    public void getReady(){
        this.setReady(Boolean.TRUE);
    }

    public void cancelReady(){
        this.setReady(Boolean.FALSE);
    }

    public void display(){

    }

    public void draw(){

    }

    public void discard(){

    }

    public void win(){

    }
}
