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

        @Override
        public String getDescription() {
            return "It is Morning.";
        }

        @Override
        public int getBrightness() {
            return 100;
        }
    },
    AFTERNOON {
        @Override
        public List<PlayerAction> getBasicActions() {
            List<PlayerAction> basicPlayerActions = new ArrayList<>();
            basicPlayerActions.add(RestAction.getInstance());
            return basicPlayerActions;
        }

        @Override
        public String getDescription() {
            return "It is Afternoon.";
        }

        @Override
        public int getBrightness() {
            return 90;
        }
    },
    EVENING {
        @Override
        public List<PlayerAction> getBasicActions() {
            List<PlayerAction> basicPlayerActions = new ArrayList<>();
            basicPlayerActions.add(RestAction.getInstance());
            return basicPlayerActions;
        }

        @Override
        public String getDescription() {
            return "It is Evening.";
        }

        @Override
        public int getBrightness() {
            return 40;
        }
    },
    NIGHT {
        @Override
        public List<PlayerAction> getBasicActions() {
            List<PlayerAction> basicPlayerActions = new ArrayList<>();
            basicPlayerActions.add(SleepAction.getInstance());
            return basicPlayerActions;
        }

        @Override
        public String getDescription() {
            return "It is Night.";
        }

        @Override
        public int getBrightness() {
            return 20;
        }
    };

    public abstract List<PlayerAction> getBasicActions();

    public abstract String getDescription();

    public abstract int getBrightness();
}
