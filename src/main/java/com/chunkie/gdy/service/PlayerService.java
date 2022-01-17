package com.chunkie.gdy.service;


import com.chunkie.gdy.common.Constants;
import com.chunkie.gdy.common.ResponseObj;
import com.chunkie.gdy.dto.Discard;
import com.chunkie.gdy.entity.Game;
import com.chunkie.gdy.entity.Player;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Description:
 * @ClassName: PlayerService
 * @Author: SichengGuo
 * @Date: 2022/1/13 16:27
 * @Version: 1.0
 */
public class PlayerService {

    @Autowired
    private GameService gameService;

    public ResponseObj playerDiscard(Discard discard){
        ResponseObj responseObj = new ResponseObj();
        Game game = gameService.findGameById(discard.getId());
        Player player = game.getCurrentDrawer();
        if (player == game.getLastDrawer()){
            player.draw(game.getCardDeck().get(game.getCardDeck().size()-1));
            game.getCardDeck().remove(game.getCardDeck().size() - 1);
        }
        player.discard(discard.getDiscardList());
        game.setLastDrawer(game.getCurrentDrawer());
        game.setLastType(discard.getCardType());
        game.setCurrentDrawer(getNextPlayer(game));
        if (discard.getDiscardList().size() ==3 )
            game.setMultiple(game.getMultiple() * 2);
        else
            game.setMultiple(game.getMultiple() * 4);
        if (player.checkHand()) {
            for (Player p : game.getPlayers()) {
                if (p != game.getCurrentDrawer()) {
                    p.setScore(p.getScore() - game.getMultiple() * p.getHandCard().size());
                    game.setBonus(game.getBonus() + game.getMultiple() * p.getHandCard().size());
                }
            }
            player.setScore(player.getScore() + game.getBonus());
        }
        responseObj.setCode(Constants.Code.NORMAL);
        responseObj.setMsg(Constants.Msgs.SUCCESS);
        return responseObj;
    }

    public ResponseObj playerSkip(String id){
        ResponseObj responseObj = new ResponseObj();
        Game game = gameService.findGameById(id);
        game.setCurrentDrawer(getNextPlayer(game));
        responseObj.setCode(Constants.Code.NORMAL);
        responseObj.setMsg(Constants.Msgs.SUCCESS);
        return responseObj;
    }

    public Player getNextPlayer(Game game){
        if(game.getPlayers().indexOf(game.getCurrentDrawer())==game.getPlayerNum())
            return game.getPlayers().get(0);
        else
            return game.getPlayers().get(game.getPlayers().indexOf(game.getCurrentDrawer())+1);
    }

}
