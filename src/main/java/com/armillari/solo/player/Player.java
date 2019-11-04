package com.armillari.solo.player;

import com.armillari.solo.grid.DirectionType;
import com.armillari.solo.grid.Tile;

public class Player {
    int number;
    String name;
    int points;
    int coins;

    Tile currentTile;

    public Player(int number, String name, Tile startTile) {
        this.name = name;
        this.points = 0;
        this.coins = 3;
        this.number = number;
        this.currentTile = startTile;
        System.out.println(String.format("Player %s has entered the game!", name));
    }

    public void move(DirectionType directionType) {
        // Explore the given direction.
        Tile destinationTile = this.currentTile.getNextTile(directionType);
        this.currentTile = destinationTile;
    }

    public void work() {
        // Something about the tile determines how much money is made.
        coins++;
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return points;
    }

    public int getCoins() {
        return coins;
    }
}
