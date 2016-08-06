package com.bjedrzejewski.game;

import javax.servlet.http.HttpSession;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 * This is the utility class responsible for running the game.
 */
public final class GameRunner {

    private GameRunner(){
    }

    /**
     * Returns existing game, if none exists, creates new game
     * @param session
     * @return
     */
    public static GameState checkGameState(HttpSession session){
        if(session.getAttribute("game") == null){
            session.setAttribute("game", GameState.createGame());
        }
        return (GameState) session.getAttribute("game");
    }
}
