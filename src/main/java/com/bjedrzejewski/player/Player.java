package com.bjedrzejewski.player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 *
 * This is the class representing the Player in the game.
 */
public class Player {

    private int life = 100;
    private List<Item> playerItems = new ArrayList<>();
    private List<PlayerStatus> playerStatuses = new ArrayList<>();

    private Player(){

    }

    public static Player createPlayer(){
        return new Player();
    }

}
