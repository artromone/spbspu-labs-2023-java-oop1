package com.kumachev.J1.implementations;

import com.kumachev.J1.exceptions.InvalidCommandException;
import com.kumachev.J1.factories.MoveStrategyFactory;
import com.kumachev.J1.strategies.*;

public class MoveStrategyFactoryImpl implements MoveStrategyFactory {
    @Override
    public MoveStrategy createStrategy(String strategyName) throws InvalidCommandException {
        return switch (strategyName) {
            case "walk" -> new WalkStrategy();
            case "run" -> new RunStrategy();
            case "ride" -> new RideStrategy();
            case "fly" -> new FlyStrategy();
            case "teleport" -> new TeleportStrategy();
            default -> throw new InvalidCommandException();
        };
    }
}
