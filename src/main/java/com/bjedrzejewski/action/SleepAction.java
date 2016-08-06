package com.bjedrzejewski.action;

import com.bjedrzejewski.game.GameController;
import com.bjedrzejewski.game.GameRunner;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 *
 * This action represents player sleeping. It is a singleton.
 */
@Controller()
public final class SleepAction implements PlayerAction{

    private static final Logger log = Logger.getLogger(SleepAction.class);
    private static final String restUrl = "/action/sleep";
    private static final SleepAction INSTANCE = new SleepAction();


    private SleepAction() {

    }

    @Override
    public String getActionUrl() {
        return restUrl;
    }

    @Override
    @GetMapping(restUrl)
    public String invokeAction(HttpSession session, Map<String, Object> model) {
        //Checks if player action is allowed
        if(!GameRunner.checkGameState(session).isPlayerActionAllowed(INSTANCE)){
            return "error";
        }
        log.debug("Player is sleeping.");
        return GameController.mainGameController(session, model);
    }

    @Override
    public String getActionLabel() {
        return "Go to sleep";
    }

    public static SleepAction getInstance() {
        return INSTANCE;
    }

    public SleepAction clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Cannot clone instance of this class");
    }
}
