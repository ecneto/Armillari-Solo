package com.armillari.solo.player;

import com.armillari.solo.game.InputAction;
import com.armillari.solo.player.ai.PlayerAI;
import com.armillari.solo.player.ai.RandomPlayerAI;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class InputManager {
    Queue<InputAction> actions;

    public InputManager() {
        this.actions = new LinkedList<InputAction>();
    }

    public void waitForInputs(List<Player> players) {
        // TODO: Set up listeners to hear out user choices within a time period.

        // PlayerAI v1: Make a random choice for each player.
        for(Player player : players) {
            PlayerAI playerAi = new RandomPlayerAI(player);
            InputAction action = playerAi.makeChoice();
            addAction(action);
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // Continue if thread is interrupted.
        }
    }

    private void addAction(InputAction action) {
        this.actions.add(action);
    }

    public InputAction getNextAction() {
        if(actions.isEmpty())
            return null;
        return actions.remove();
    }
}
