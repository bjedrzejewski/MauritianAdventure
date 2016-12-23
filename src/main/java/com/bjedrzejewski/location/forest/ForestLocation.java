package com.bjedrzejewski.location.forest;

import com.bjedrzejewski.action.PlayerAction;
import com.bjedrzejewski.location.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartoszjedrzejewski on 22/12/2016.
 */
public class ForestLocation implements Location {


    @Override
    public List<PlayerAction> getAvailableActions() {
        return new ArrayList<>();
    }

    @Override
    public String getDescription() {
        return "You are in a deep tropical forrest. You can see many plants and small animals.";
    }

    @Override
    public String getImage() {
        return "forest.jpg";
    }
}
