package com.armillari.solo.player;

import com.armillari.solo.http.HttpReader;
import com.armillari.solo.http.RandomUserResult;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory {
    public static List<Player> makePlayers(int numPlayers) throws Exception {
        Player newPlayer;

        String randomUserResponseBody = null;
        randomUserResponseBody = HttpReader.getHTML("https://randomuser.me/api/?inc=gender,name&nat=us&results=" + String.valueOf(numPlayers));

        RandomUserResult randomUserResult = new ObjectMapper().readValue(randomUserResponseBody, RandomUserResult.class);

        List<Player> newPlayers = new ArrayList<Player>();
        for(RandomUserResult.ResultJackson result : randomUserResult.getResults()) {
            newPlayer = new Player(result.getFirstName());
            newPlayers.add(newPlayer);
        }

        return newPlayers;
    }
}
