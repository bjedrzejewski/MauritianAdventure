package com.bjedrzejewski.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by andrewbissette on 23/12/2016.
 *
 * This action represents player screaming. It is a singleton. This action will be removed and
 * was added as a learning process.
 */
@Controller()
public final class ScreamAction implements PlayerAction{

    private static final Logger log = Logger.getLogger(ScreamAction.class);
    private static final String screamUrl = "scream";
    private static final ScreamAction INSTANCE = new ScreamAction();
    private static final String actionDescription = "You scream into the horizon for some time.";

    private ScreamAction() {
    }

    @Override
    public String getActionUrl() {
        return screamUrl;
    }

    @Override
    public void invokeAction(HttpSession session, Map<String, Object> model) {
        log.debug("Player is screaming.");
    }

    @Override
    public String getActionLabel() {
        return "Scream futilely into the ocean.";
    }

    public String getActionDescription() { return actionDescription; }

    public static ScreamAction getInstance() {
        return INSTANCE;
    }

    public ScreamAction clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Cannot clone instance of this class");
    }
}
