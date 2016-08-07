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
 * Created by bartoszjedrzejewski on 07/08/2016.
 */
@Controller()
public class ActionController {

    private static final Logger log = Logger.getLogger(ActionController.class);

    @GetMapping("/action/{type}")
    public String invokeAction(HttpSession session, Map<String, Object> model, @PathVariable String type) {
        PlayerAction action = null;
        switch(type) {
            case "rest":
                action = RestAction.getInstance();
                break;
            case "sleep":
                action = SleepAction.getInstance();
                break;
            default:
                log.warn("Unknown action requested: "+type);
                return "error";
        }
        //Checks if player action is allowed
        if(!GameRunner.checkGameState(session).isPlayerActionAllowed(action)){
            return "error";
        }
        action.invokeAction(session, model);

        GameState gameState = GameRunner.checkGameState(session);

        //Advance the time
        gameState.advanceTime();

        return GameController.mainGameController(session, model);
    }
}
