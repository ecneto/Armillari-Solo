package com.armillari.solo.view;

import com.armillari.solo.game.GameState;
import com.armillari.solo.player.Player;

public class ScoreReport {
    GameState gameState;

    public ScoreReport(GameState gameState) {
        this.gameState = gameState;
    }

    public void showResults() {
        System.out.println("Score:");

        for(Player player : gameState.getPlayers()) {
            System.out.println("Player " + player.getName());
            System.out.println("\tCoins: " + player.getCoins());
            System.out.println("\tPoints: " + player.getPoints());
        }
    }
}
