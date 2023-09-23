package com.kumachev.j1.factories;

import com.kumachev.j1.exceptions.InvalidCommandException;
import com.kumachev.j1.strategies.MoveStrategy;

public interface MoveStrategyFactory {
    MoveStrategy createStrategy(String strategyName) throws InvalidCommandException;
}
