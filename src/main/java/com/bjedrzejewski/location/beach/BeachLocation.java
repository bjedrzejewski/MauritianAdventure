package com.bjedrzejewski.location.beach;

import com.bjedrzejewski.action.PlayerAction;
import com.bjedrzejewski.action.ScreamAction;
import com.bjedrzejewski.location.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartoszjedrzejewski on 22/12/2016.
 */
public class BeachLocation implements Location {

    private List<PlayerAction> playerActions = new ArrayList<>();

    public BeachLocation(){

        playerActions.add(new ExploreTheBeach());
        playerActions.add(ScreamAction.getInstance());

    }

    /**
     * Returns copy of te players actions list.
     * @return
     */
    @Override
    public List<PlayerAction> getAvailableActions() {
        return new ArrayList<>(playerActions);
    }

    @Override
    public String getDescription() {
        return "You are on a beautiful beach. The water is clear blue and you can see forest and some mountains in the distance. ";
    }

    @Override
    public String getLocationCode() {
        return "beach";
    }

    public void addAction(PlayerAction action){
        playerActions.add(action);
    }

    @Override
    public String getImage() {
        return "beach.jpg";
    }
}
