package com.armillari;

import com.armillari.grid.Grid;
import com.armillari.player.Player;
import com.armillari.player.PlayerFactory;

import java.util.ArrayList;
import java.util.List;

public class Game {
    final static int MAX_GAME_COUNTER = 10;

    Grid grid;
    List<Player> players;
    int turnCounter;

    public Game() {
        System.out.println("Welcome to Armillari! Starting a new game.");
        grid = new Grid();
        players = new ArrayList<Player>();
    }

    public void start() {
        Player player1 = PlayerFactory.makePlayer();
        Player player2 = PlayerFactory.makePlayer();
        addPlayer(player1);
        addPlayer(player2);

        enterGameLoop();

        finish();
    }

    private void enterGameLoop() {
        turnCounter = 0;
        while(!isEndCondition()) {
            System.out.println(
                    String.format("Start Turn %d", (turnCounter+1))
            );



            System.out.println(
                    String.format("End Turn %d", (turnCounter+1))
            );
            turnCounter++;
        }
    }

    private void finish() {
        System.out.println("The game is over.");
    }

    private Boolean isEndCondition() {
        if(turnCounter >= MAX_GAME_COUNTER) {
            return true;
        }
        return false;
    }

    private void addPlayer(Player player) {
        players.add(player);
    }
}
