package com.armillari.solo.view;

import com.armillari.solo.game.GameState;
import com.armillari.solo.grid.Grid;
import com.armillari.solo.player.Player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapReport {
    Grid grid;
    List<Player> players;

    public MapReport(GameState gameState) {
        this.grid = gameState.getGrid();
        this.players = gameState.getPlayers();

        Map<Integer, List<Integer>> columnsByRow = new HashMap<Integer, List<Integer>>();
    }

    public void showResults() {

    }
}