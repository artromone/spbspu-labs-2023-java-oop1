package org.example;

import moveStrategies.*;

import java.util.HashMap;

public class CommandHandler {
    private final HashMap<String, MoveStrategy> strategies = new HashMap<>();

    public CommandHandler() {
        strategies.put("walk", new Walk());
        strategies.put("horse", new HorseRiding());
        strategies.put("fly", new Fly());
        strategies.put("dragon", new FlyDragon());
        strategies.put("teleport", new Teleportation());
    }

    MoveStrategy getMoveStrategy(String str) throws RuntimeException {
        MoveStrategy strategy = strategies.get(str);
        if (strategy == null) {
            throw new RuntimeException("No such command");
        }
        return strategy;
    }
}
