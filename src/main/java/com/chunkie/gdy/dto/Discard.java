package com.chunkie.gdy.dto;

import com.chunkie.gdy.entity.Card;
import com.chunkie.gdy.util.CardType;
import lombok.Data;

import java.util.List;

/**
 * @Description:
 * @ClassName: Draw
 * @Author: SichengGuo
 * @Date: 2022/1/13 17:15
 * @Version: 1.0
 */

@Data
public class Discard {

    private String id;

    private List<Card> discardList;

    private CardType cardType;
}
