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

    private Integer point;

    public Card(String color, Integer point) {
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


}
