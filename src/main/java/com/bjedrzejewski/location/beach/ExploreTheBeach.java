package com.bjedrzejewski.location.beach;

import com.bjedrzejewski.action.PlayerAction;
import com.bjedrzejewski.game.GameState;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by bartoszjedrzejewski on 22/12/2016.
 */
public class ExploreTheBeach implements PlayerAction{

    private static final Logger log = Logger.getLogger(ExploreTheBeach.class);

    public int exploredTimes = 0;

    private BeachLocation beach;

    public ExploreTheBeach(BeachLocation beach){
        this.beach = beach;
    }

    @Override
    public String getActionUrl() {
        return "explore-the-beach";
    }

    @Override
    public void invokeAction(HttpSession session, GameState gameState) {
        exploredTimes++;
        log.debug("Player explored the beach: "+exploredTimes +" times");
        if(exploredTimes==2){
            beach.addAction(new GoToTheForest());
        }
    }

    @Override
    public String getActionLabel() {
        return "Explore the Beach";
    }
}
