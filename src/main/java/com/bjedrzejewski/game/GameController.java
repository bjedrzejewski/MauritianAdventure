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
        GameState gameState = GameRunner.checkGameState(session);

        model.put("main_text", "Welcome to the Mauritian Adventure. This is a game where you will try to survive and explore\n" +
                "the magical island of Mauritius.");
        model.put("option_1", "this is option 1");
        return "game";
    }

    private static void setUUID(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
    }

}
