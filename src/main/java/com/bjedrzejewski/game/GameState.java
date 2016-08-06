package com.bjedrzejewski.game;

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



        return availablePlayerActions;
    }


}
