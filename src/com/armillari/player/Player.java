package com.armillari.player;

public class Player {
    String name;
    int points;
    int coins;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.coins = 3;
        System.out.println(String.format("Player %s has entered the game!", name));
    }
}
