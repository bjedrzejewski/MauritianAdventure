package com.bjedrzejewski;

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


}
