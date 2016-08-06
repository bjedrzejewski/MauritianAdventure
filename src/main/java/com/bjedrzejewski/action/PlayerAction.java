package com.bjedrzejewski.action;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 *
 * This interaface represents actions that the player of the game can take.
 */
public interface PlayerAction {
    /**
     * Url required for invoking the particular action.
     * @return
     */
    String getActionUrl();

    /**
     * Controller mapped to the action
     * @return
     */
    String invokeAction();

}
