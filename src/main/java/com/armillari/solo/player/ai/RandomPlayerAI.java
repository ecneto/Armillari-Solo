package com.armillari.solo.player.ai;

import com.armillari.solo.game.InputAction;
import com.armillari.solo.player.Player;

import java.util.HashMap;
import java.util.Map;

public class RandomPlayerAI implements PlayerAI{
    Player player;
    static final Map<Integer, InputAction.DirectionType> directionByNumber;
    static {
        directionByNumber = new HashMap<Integer, InputAction.DirectionType>();
        directionByNumber.put(6, InputAction.DirectionType.NEAST);
        directionByNumber.put(7, InputAction.DirectionType.EAST);
        directionByNumber.put(8, InputAction.DirectionType.SEAST);
        directionByNumber.put(9, InputAction.DirectionType.SWEST);
        directionByNumber.put(10, InputAction.DirectionType.WEST);
        directionByNumber.put(11, InputAction.DirectionType.NWEST);
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
            InputAction.DirectionType direction = directionByNumber.get(choice);
            return new InputAction(player, InputAction.ActionType.EXPLORE, direction);
        }
    }
}