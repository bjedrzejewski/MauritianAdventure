package com.bjedrzejewski.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 *
 * This interaface represents actions that the player of the game can take.
 */
@Controller("/action")
public interface PlayerAction {

    /**
     * Url required for invoking the particular action.
     * @return
     */
    abstract String getActionUrl();

    /**
     * Controller mapped to the action
     * @return
     */
    abstract String invokeAction(HttpSession session, Map<String, Object> model);

}
