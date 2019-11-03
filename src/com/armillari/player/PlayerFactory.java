package com.armillari.player;

import com.armillari.http.HttpReader;

public class PlayerFactory {
    public static Player makePlayer() {
        String randomUser = null;
        Player newPlayer;
        try {
            randomUser = HttpReader.getHTML("https://randomuser.me/api/");

            newPlayer = new Player(randomUser);
        } catch (Exception e) {
            System.out.println("Failed to generate a user.");
            newPlayer = null;
        }
        return newPlayer;
    }

    public static void main(String[] args) {
        makePlayer();
    }
}
