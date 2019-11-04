package com.armillari.solo.game.actions;

import com.armillari.solo.game.GameState;
import com.armillari.solo.game.InputAction;
import com.armillari.solo.player.Player;

public class MoveEventHandler implements ActionEventHandler {
    InputAction.DirectionType directionType;

    public MoveEventHandler(InputAction.DirectionType directionType) {
        this.directionType = directionType;
    }

    public void handleEvent(GameState gameState, Player activePlayer) {
        activePlayer.move(directionType);
    }
}
