package com.chunkie.gdy.vo;

import com.chunkie.gdy.entity.Card;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @ClassName: GameCondition
 * @Author: SichengGuo
 * @Date: 2022/1/17 16:39
 * @Version: 1.0
 */

@Data
public class GameVO {

    private String nextPlayer;

    private Map<String, Integer> handCardCondition;

    private Map<String, Integer> scoreCondition;

    private List<Card> previousDiscard;
}
