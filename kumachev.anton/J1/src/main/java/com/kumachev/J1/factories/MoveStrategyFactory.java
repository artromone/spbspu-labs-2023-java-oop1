package com.kumachev.J1.factories;

import com.kumachev.J1.exceptions.InvalidCommandException;
import com.kumachev.J1.strategies.MoveStrategy;

public interface MoveStrategyFactory {
    MoveStrategy createStrategy(String strategyName) throws InvalidCommandException;
}
