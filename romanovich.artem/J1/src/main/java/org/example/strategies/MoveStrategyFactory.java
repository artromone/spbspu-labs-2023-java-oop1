package org.example.strategies;

import org.example.exceptions.UnknownCommandException;

public interface MoveStrategyFactory {
  MoveStrategy getStrategy(String type) throws UnknownCommandException;
}
