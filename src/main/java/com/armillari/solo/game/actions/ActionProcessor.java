package com.armillari.solo.game.actions;

import com.armillari.solo.game.GameState;
import com.armillari.solo.game.InputAction;
import com.armillari.solo.player.InputManager;

public class ActionProcessor {
    GameState gameState;

    public ActionProcessor(GameState gameState) {
        this.gameState = gameState;
    }

    public void processActions(InputManager input) {
        InputAction nextAction;
        while((nextAction = input.getNextAction()) != null) {
            applyAction(nextAction, gameState);
        }
    }

    private static void applyAction(InputAction nextAction, GameState gameState) {
        ActionEventHandler handler;
        if(nextAction.getActionType() == InputAction.ActionType.WORK) {
            handler = new WorkEventHandler();
        } else if(nextAction.getActionType() == InputAction.ActionType.EXPLORE) {
            handler = new MoveEventHandler(nextAction.getDirectionType());
        } else {
            handler = new IdleEventHandler();
        }
        handler.handleEvent(gameState, nextAction.getPlayer());
    }
}
