package com.bjedrzejewski.action;

import com.bjedrzejewski.game.GameRunner;
import com.bjedrzejewski.game.GameState;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

import com.bjedrzejewski.game.GameController;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 *
 * This action represents player resting. It s a singleton.
 */
@Controller()
public final class RestAction implements PlayerAction{

    private static final Logger log = Logger.getLogger(RestAction.class);
    private static final String restUrl = "rest";
    private static final RestAction INSTANCE = new RestAction();
    private static final String actionDescription = "You rest for a while.";

    private RestAction() {
    }

    @Override
    public String getActionUrl() {
        return restUrl;
    }

    @Override
    public void invokeAction(HttpSession session, GameState gameState) {
        log.debug("Player is resting.");
    }

    @Override
    public String getActionLabel() {
        return "Take a rest";
    }

    @Override
    public String getActionDescription() { return actionDescription; };

    public static RestAction getInstance() {
        return INSTANCE;
    }

    public RestAction clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Cannot clone instance of this class");
    }
}
