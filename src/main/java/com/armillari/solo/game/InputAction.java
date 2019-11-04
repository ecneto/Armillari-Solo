package com.armillari.solo.game;

import com.armillari.solo.player.Player;

public class InputAction {
    public enum ActionType { EXPLORE, WORK };
    public enum DirectionType { NEAST, EAST, SEAST, SWEST, WEST, NWEST };

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
