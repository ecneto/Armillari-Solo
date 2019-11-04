package com.armillari.solo.grid;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid {
    TileFactory tileFactory;

    Tile centralTile;

    // The grid indexes all tiles. The Factory needs to know if a tile has already been explored form another direction.
    Map<Integer, Map<Integer, Tile>> tilesByPosition;

    public Grid(TileFactory factory) {
        tilesByPosition = new HashMap<Integer, Map<Integer, Tile>>();
        factory.registerTileMap(tilesByPosition);
        centralTile = factory.makeStartTile();
    }

    public Tile getCentralTile() {
        return this.centralTile;
    }

    public Rectangle getDimensions() {
        return centralTile.getDimensions();
    }

    public Tile getTileByPosition(int x, int y) {
        if(!tilesByPosition.containsKey(x)) {
            return null;
        }
        Map<Integer, Tile> tilesOfXPosition = tilesByPosition.get(x);
        if(!tilesOfXPosition.containsKey(y)) {
            return null;
        }
        Tile tileOfXYPosition = tilesOfXPosition.get(y);
        return tileOfXYPosition;
    }

    public static void registerTile(Map<Integer, Map<Integer, Tile>> tilesByPosition, Tile tile) {
        if(!tilesByPosition.containsKey(tile.getX())) {
            tilesByPosition.put(tile.getX(), new HashMap<Integer, Tile> ());
        }
        Map<Integer, Tile> tilesOfPositionX = tilesByPosition.get(tile.getX());
        tilesOfPositionX.put(tile.getY(), tile);
        System.out.println("Explored " + tile.getX() + "," + tile.getY());
    }
}
