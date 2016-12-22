package com.bjedrzejewski.location.beach;

import com.bjedrzejewski.action.PlayerAction;

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
    public void invokeAction(HttpSession session, Map<String, Object> model) {

    }

    @Override
    public String getActionLabel() {
        return "Go to the forest";
    }
}
