package com.bjedrzejewski.game;

import com.bjedrzejewski.action.PlayerAction;
import com.bjedrzejewski.action.RestAction;
import com.bjedrzejewski.action.SleepAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartoszjedrzejewski on 06/08/2016.
 */
public enum DayTime {
    MORNING {
        @Override
        public List<PlayerAction> getBasicActions() {
            List<PlayerAction> basicPlayerActions = new ArrayList<>();
            basicPlayerActions.add(RestAction.getInstance());
            return basicPlayerActions;
        }
    },
    AFTERNOON {
        @Override
        public List<PlayerAction> getBasicActions() {
            List<PlayerAction> basicPlayerActions = new ArrayList<>();
            basicPlayerActions.add(RestAction.getInstance());
            return basicPlayerActions;
        }
    },
    EVENING {
        @Override
        public List<PlayerAction> getBasicActions() {
            List<PlayerAction> basicPlayerActions = new ArrayList<>();
            basicPlayerActions.add(RestAction.getInstance());
            return basicPlayerActions;
        }
    },
    NIGHT {
        @Override
        public List<PlayerAction> getBasicActions() {
            List<PlayerAction> basicPlayerActions = new ArrayList<>();
            basicPlayerActions.add(SleepAction.getInstance());
            return basicPlayerActions;
        }
    };

    public abstract List<PlayerAction> getBasicActions();
}
