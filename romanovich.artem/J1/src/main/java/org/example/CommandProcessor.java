package org.example;

import org.example.exceptions.UnknownCommandException;
import org.example.strategies.FlyStrategy;
import org.example.strategies.HorseStrategy;
import org.example.strategies.MoveStrategy;
import org.example.strategies.WalkStrategy;

import java.util.HashMap;

public class CommandProcessor {
  private final HashMap<String, MoveStrategy> strategies = new HashMap<>();

  public CommandProcessor() {
    strategies.put("walk", new WalkStrategy());
    strategies.put("horse", new HorseStrategy());
    strategies.put("fly", new FlyStrategy());
  }

  public void useStrategy(String command) throws UnknownCommandException {
    MoveStrategy strategy = strategies.get(command);
    if (strategy == null) {
      throw new UnknownCommandException("Unknown command: " + command);
    }
    strategy.move();
  }
}