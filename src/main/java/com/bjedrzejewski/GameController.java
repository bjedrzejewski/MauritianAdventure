package com.bjedrzejewski;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

/**
 * Created by bartoszjedrzejewski on 03/08/2016.
 */
@Controller
public class GameController {
    private static final Logger log = Logger.getLogger(GameController.class);

    @GetMapping("/game")
    public String mainGameController(HttpSession session, Map<String, Object> model) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        model.put("main_text", "Welcome to the Mauritian Adventure. This is a game where you will try to survive and explore\n" +
                "the magical island of Mauritius.");
        model.put("option_1", "this is option 1");
        return "game";
    }

    public String newGame(HttpSession session) {
        GameState gameState = GameState.createGame();
        session.setAttribute("game", gameState);
        return "Game Started";
    }

}
