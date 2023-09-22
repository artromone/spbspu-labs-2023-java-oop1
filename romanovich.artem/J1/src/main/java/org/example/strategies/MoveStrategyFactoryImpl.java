package org.example.strategies;

import org.example.exceptions.UnknownCommandException;

import java.util.HashMap;

public class MoveStrategyFactoryImpl implements MoveStrategyFactory {

  private final HashMap<String, MoveStrategy> strategies = new HashMap<>();

  public MoveStrategyFactoryImpl() {
    strategies.put("walk", new WalkStrategy());
    strategies.put("horse", new HorseStrategy());
    strategies.put("fly", new FlyStrategy());
  }

  @Override
  public MoveStrategy getStrategy(String command) throws UnknownCommandException {
    MoveStrategy strategy = strategies.get(command);
    if (strategy == null) {
      throw new UnknownCommandException("Unknown command: " + command);
    }
    return strategy;
  }
}
