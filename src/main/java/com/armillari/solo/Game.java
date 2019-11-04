package com.armillari.solo;

import com.armillari.solo.view.MapReport;
import com.armillari.solo.view.ScoreReport;
import com.armillari.solo.game.actions.ActionProcessor;
import com.armillari.solo.game.GameState;
import com.armillari.solo.player.InputManager;

public class Game {
    final static int MAX_GAME_COUNTER = 10;

    GameState gameState;

    int turnCounter;

    public Game() {
        System.out.println("Welcome to Armillari! Starting a new game.");
    }

    public void start() {
        gameState = new GameState();

        MapReport.show(gameState);

        enterGameLoop();

        finish();
    }

    private void enterGameLoop() {
        turnCounter = 0;
        InputManager input = new InputManager();

        while(!isEndCondition()) {
            System.out.println(
                    String.format("Start Turn %d", (turnCounter+1))
            );

            // Open input period to accept actions.
            input.waitForInputs(gameState.getPlayers());

            // Close input period, and block input until actions process.
            ActionProcessor processor = new ActionProcessor(gameState);
            processor.processActions(input);

            MapReport.show(gameState);

            turnCounter++;
        }
    }

    private void finish() {
        System.out.println("The game is over.");
        ScoreReport report = new ScoreReport(gameState);
        report.showResults();
    }

    private Boolean isEndCondition() {
        if(turnCounter >= MAX_GAME_COUNTER) {
            return true;
        }
        return false;
    }
}
