package com.bjedrzejewski.location.beach;

import com.bjedrzejewski.action.PlayerAction;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by bartoszjedrzejewski on 22/12/2016.
 */
public class ExploreTheBeach implements PlayerAction{

    private static final Logger log = Logger.getLogger(ExploreTheBeach.class);

    public int exploredTimes = 0;

    @Override
    public String getActionUrl() {
        return "explore-the-beach";
    }

    @Override
    public void invokeAction(HttpSession session, Map<String, Object> model) {
        exploredTimes++;
        log.debug("Player explored the beach: "+exploredTimes +" times");
    }

    @Override
    public String getActionLabel() {
        return "Explore the Beach";
    }
}
