package com.armillari.grid;

public class Tile {
    String terrain;

    Tile neast, east, seast, swest, west, nwest;

    public Tile(String terrain) {
        this.terrain = terrain;
        neast=east=seast=swest=west=nwest=null;
    }
}
