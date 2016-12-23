package com.bjedrzejewski.action;

import com.bjedrzejewski.game.GameState;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 *
 * This interaface represents actions that the player of the game can take.
 */
public interface PlayerAction extends Serializable{

    /**
     * Url required for invoking the particular action.
     * @return
     */
    abstract String getActionUrl();

    /**
     * Controller mapped to the action
     * @return
     */
    abstract void invokeAction(HttpSession session, GameState gameState);

    /**
     * Action label to be displayed int he UI
     * @return
     */
    abstract String getActionLabel();

}
