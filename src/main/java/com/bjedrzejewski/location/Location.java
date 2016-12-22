package com.bjedrzejewski.location;

import com.bjedrzejewski.action.PlayerAction;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bartoszjedrzejewski on 07/08/2016.
 *
 * This is a concept of a game location.
 */
public interface Location extends Serializable {

    List<PlayerAction> getAvailableActions();

    String getDescription();

    String getImage();

}
