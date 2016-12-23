package com.bjedrzejewski.location.beach;

import com.bjedrzejewski.action.PlayerAction;
import com.bjedrzejewski.game.GameState;
import com.bjedrzejewski.location.forest.ForestLocation;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by bartoszjedrzejewski on 22/12/2016.
 */
public class GoToTheForest implements PlayerAction {
    @Override
    public String getActionUrl() {
        return "go-to-forest";
    }

    @Override
    public void invokeAction(HttpSession session, GameState gameState) {
        gameState.visitLocation(new ForestLocation());
    }

    @Override
    public String getActionLabel() {
        return "Go to the forest";
    }
}
