package com.armillari.solo.grid;

public class Grid {
    final static String CENTRAL_TERRAIN = "Green";
    Tile centralTile;

    public Grid() {
        centralTile = new Tile(CENTRAL_TERRAIN);
    }

    public Tile getStartTile() {
        return this.centralTile ;
    }
}