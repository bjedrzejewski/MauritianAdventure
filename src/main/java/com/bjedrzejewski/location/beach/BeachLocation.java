package com.bjedrzejewski.location.beach;

import com.bjedrzejewski.action.PlayerAction;
import com.bjedrzejewski.location.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartoszjedrzejewski on 22/12/2016.
 */
public class BeachLocation implements Location {

    @Override
    public List<PlayerAction> getAvailableActions() {
        return new ArrayList<>();
    }

    @Override
    public String getDescription() {
        return "You are on a beautiful beach. The water is clear blue and you can see forrest and some mountains in the distance. ";
    }
}
