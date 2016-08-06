package com.bjedrzejewski.game;

import com.bjedrzejewski.action.RestAction;
import com.bjedrzejewski.player.Player;
import com.bjedrzejewski.action.PlayerAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartoszjedrzejewski on 04/08/2016.
 */
public class GameState {

    private final Player player;

    public static GameState createGame() {
        return new GameState();
    }

    /**
     * Initialising new gameState. This method:
     *
     * Sets the player
     *
     */
    private GameState(){
        player = Player.createPlayer();
    }

    /**
     * This method returns vurrently available player actions
     * @return
     */
    public List<PlayerAction> getAvailablePlayerActions(){
        List<PlayerAction> availablePlayerActions = new ArrayList<>();

        //Add the basic actions that are always available
        availablePlayerActions.addAll(getBasicActions());

        return availablePlayerActions;
    }

    /**
     * These are the actions that the player can always take.
     * @return
     */
    private List<PlayerAction> getBasicActions(){
        List<PlayerAction> basicPlayerActions = new ArrayList<>();
        basicPlayerActions.add(RestAction.getInstance());
        return basicPlayerActions;

    }


}
