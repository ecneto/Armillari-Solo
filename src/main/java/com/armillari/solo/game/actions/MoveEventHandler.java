package com.armillari.solo.game.actions;

import com.armillari.solo.game.GameState;
import com.armillari.solo.grid.DirectionType;
import com.armillari.solo.player.Player;

public class MoveEventHandler implements ActionEventHandler {
    DirectionType directionType;

    public MoveEventHandler(DirectionType directionType) {
        this.directionType = directionType;
    }

    public void handleEvent(GameState gameState, Player activePlayer) {
        activePlayer.move(directionType);
    }
}
