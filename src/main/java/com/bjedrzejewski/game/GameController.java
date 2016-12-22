package com.bjedrzejewski.game;

import com.bjedrzejewski.action.PlayerAction;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

/**
 * Created by bartoszjedrzejewski on 03/08/2016.
 */
@Controller
public class GameController {
    private static final Logger log = Logger.getLogger(GameController.class);

    /**
     * This is the main game controller. All actions and events should go through this one.
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/game")
    public static String mainGameController(HttpSession session, Map<String, Object> model) {
        setUUID(session);

        //First the game state for the session is retrieved or created
        GameState gameState = GameRunner.checkGameState(session);

        //Based on that player actions are presented
        setAvailableActions(model, gameState);

        //Based on that player location is made available
        setCurrentLocation(model, gameState);

        //The rest of UI gets rendered
        setPlayerUI(model, gameState);

        //Saving the gameState for session
        session.setAttribute("game", gameState);

        //Make the whole state available when needed
        model.put("gameState", gameState);

        return "game";
    }

    private static void setCurrentLocation(Map<String, Object> model, GameState gameState) {
        model.put("location", gameState.getPlayerLocation());
    }

    private static void setPlayerUI(Map<String, Object> model, GameState gameState) {
        String description = "";

        //Only show the general description during the first day.
        if(gameState.getDaysPassed() == 0) {
            description += "Welcome to the Mauritian Adventure. This is a game where you will try to survive and explore\n" +
                    "the magical island of Mauritius.";
            description += "<br>";
        }

        description += gameState.getCurrentDayTime().getDescription();
        description += "You have been on this adventure for: " +gameState.getDaysPassed()+ " days.";
        description += "<br>";

        description += gameState.getDescription();

        model.put("main_text", description);
    }

    private static void setAvailableActions(Map<String, Object> model, GameState gameState) {
        model.put("actions", gameState.getAvailablePlayerActions());
    }

    private static void setUUID(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
    }

}
