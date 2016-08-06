package com.bjedrzejewski.game;

import com.bjedrzejewski.action.RestAction;
import com.bjedrzejewski.player.Player;
import com.bjedrzejewski.action.PlayerAction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartoszjedrzejewski on 04/08/2016.
 */
public class GameState implements Serializable{

    private final Player player;

    /**
     * Days passed since the game started
     */
    private int daysPassed = 0;

    private DayTime currentDayTime = DayTime.MORNING;

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

    public void advanceTime(){
        switch(currentDayTime) {
            case MORNING:
                currentDayTime = DayTime.AFTERNOON;
                break;
            case AFTERNOON:
                currentDayTime = DayTime.EVENING;
                break;
            case EVENING:
                currentDayTime = DayTime.NIGHT;
                break;
            case NIGHT:
                currentDayTime = DayTime.MORNING;
                daysPassed++;
                break;
        }
    }

    /**
     * These are the actions that the player can always take.
     * @return
     */
    private List<PlayerAction> getBasicActions(){
        List<PlayerAction> basicPlayerActions = new ArrayList<>();

        basicPlayerActions.addAll(currentDayTime.getBasicActions());

        return basicPlayerActions;
    }

    public boolean isPlayerActionAllowed(PlayerAction action){
        if(getAvailablePlayerActions().contains(action)){
            return true;
        } else
            return false;
    }


}
