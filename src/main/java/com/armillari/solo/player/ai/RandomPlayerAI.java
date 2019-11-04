package com.armillari.solo.player.ai;

import com.armillari.solo.game.InputAction;
import com.armillari.solo.grid.DirectionType;
import com.armillari.solo.player.Player;

import java.util.HashMap;
import java.util.Map;

public class RandomPlayerAI implements PlayerAI{
    Player player;
    static final Map<Integer, DirectionType> directionByNumber;
    static {
        directionByNumber = new HashMap<Integer, DirectionType>();
        directionByNumber.put(6, DirectionType.NEAST);
        directionByNumber.put(7, DirectionType.EAST);
        directionByNumber.put(8, DirectionType.SEAST);
        directionByNumber.put(9, DirectionType.SWEST);
        directionByNumber.put(10, DirectionType.WEST);
        directionByNumber.put(11, DirectionType.NWEST);
    }

    public RandomPlayerAI(Player player) {
        this.player = player;
    }

    public InputAction makeChoice() {
        // Decide what to do this turn.

        // 50% change Work, 50% chance move.
        int choice = (int) Math.floor(Math.random() * 12);
        if(choice < 6) {
            return new InputAction(player, InputAction.ActionType.WORK, null);
        } else {
            DirectionType direction = directionByNumber.get(choice);
            return new InputAction(player, InputAction.ActionType.EXPLORE, direction);
        }
    }
}