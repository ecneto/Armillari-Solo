package com.armillari.solo.game;

import com.armillari.solo.grid.DirectionType;
import com.armillari.solo.player.Player;

public class InputAction {
    public enum ActionType { EXPLORE, WORK };;

    Player player;
    ActionType actionType;
    DirectionType directionType;

    public InputAction(Player player, ActionType actionType, DirectionType directionType) {
        this.player = player;
        this.actionType = actionType;
        this.directionType = directionType;
    }

    public Player getPlayer() {
        return player;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public DirectionType getDirectionType() {
        return directionType;
    }
}
