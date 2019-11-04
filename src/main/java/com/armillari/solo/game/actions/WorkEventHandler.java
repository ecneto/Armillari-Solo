package com.armillari.solo.game.actions;

import com.armillari.solo.game.GameState;
import com.armillari.solo.player.Player;

public class WorkEventHandler implements ActionEventHandler {
    public void handleEvent(GameState gameState, Player activePlayer) {
        activePlayer.work();
    }
}
