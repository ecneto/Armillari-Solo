package com.armillari.solo.game;

import com.armillari.solo.grid.Grid;
import com.armillari.solo.grid.Tile;
import com.armillari.solo.player.Player;
import com.armillari.solo.player.PlayerFactory;

import java.util.ArrayList;
import java.util.List;

public class GameState {
    final static int NUM_PLAYERS = 3;

    Grid grid;
    List<Player> players;

    public GameState() {
        players = new ArrayList<Player>();
        initialize();
    }

    public void initialize() {
        grid = new Grid();

        try {
            initializePlayers(NUM_PLAYERS, grid.getStartTile());
        } catch (Exception e) {
            System.out.println("Failed to generate users. Exiting game. ");
            System.out.println(e.getMessage());
            return;
        }
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public Grid getGrid() {
        return this.grid;
    }

    private void initializePlayers(int numPlayers, Tile startTile) throws Exception {
        List<Player> newPlayers = PlayerFactory.makePlayers(numPlayers, startTile);
        players.addAll(newPlayers);
    }
}
