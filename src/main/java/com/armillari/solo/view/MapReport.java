/*
 * Converts a Grid into a ASCII hex display.
 *
 *  /1\ / \     / \ / \
 * |RG | G |   | G | G |
 *  \ / \ / \ / \ / \ / \
 *       | G |SG | G |IG |
 *      / \ / \ /2\ / \ /
 *     | G | G | G3| G |
 *      \ / \ / \ / \ /
 *
 * Key:       1: 1st present player
 *      /1\   2: 2nd present player
 *     |ST2|  3: 3rd present player
 *      \3/   T: Terrain type
 *            S: Special Space (S=Start)
 */

package com.armillari.solo.view;

import com.armillari.solo.game.GameState;
import com.armillari.solo.grid.Grid;
import com.armillari.solo.grid.Tile;
import com.armillari.solo.player.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapReport {

    public static void show(GameState gameState) {
        Grid grid = gameState.getGrid();
        Rectangle gridBox = grid.getDimensions();

        for(int row = gridBox.x - 5; row <= gridBox.x + gridBox.width + 5; row++) {
            StringBuilder rowReport1 = new StringBuilder();
            StringBuilder rowReport2 = new StringBuilder();
            StringBuilder rowReport3 = new StringBuilder();

            for(int col = gridBox.y  - 5; col <= gridBox.y + gridBox.height + 5; col++) {
                Tile currentTile = grid.getTileByPosition(col, row);
                if(currentTile == null) {
                    rowReport1.append("     ");
                    rowReport2.append("     ");
                    rowReport3.append("     ");
                } else {
                    rowReport1.append(" / \\ ");
                    rowReport2.append("|"+Math.abs(col)+","+Math.abs(row)+"|");
                    rowReport3.append(" \\ / ");
                }
            }
            System.out.println(rowReport1);
            System.out.println(rowReport2);
            System.out.println(rowReport3);
        }
    }
}