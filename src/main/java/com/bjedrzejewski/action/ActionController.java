package com.bjedrzejewski.action;

import com.bjedrzejewski.game.GameController;
import com.bjedrzejewski.game.GameRunner;
import com.bjedrzejewski.game.GameState;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * This controller is responsible for resolving player actions.
 */
@Controller
public class ActionController {

    private static final Logger log = Logger.getLogger(ActionController.class);

    @GetMapping("/action/{type}")
    public String invokeAction(HttpSession session, Map<String, Object> model, @PathVariable String type) {
        PlayerAction action = null;
        GameState gameState = GameRunner.checkGameState(session);
        Map<String, PlayerAction> availableActions = gameState.getAvailablePlayerActions();
        if(availableActions.containsKey(type)){
            action = availableActions.get(type);
        } else {
            log.warn("Unknown or unavailable action requested: "+type);
            return "error";
        }

        action.invokeAction(session, gameState);

        //Advance the time
        gameState = GameRunner.checkGameState(session);
        gameState.advanceTime();

        return GameController.mainGameController(session, model);
    }
}
