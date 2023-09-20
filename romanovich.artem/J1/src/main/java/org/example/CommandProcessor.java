package org.example;

import org.example.exceptions.UnknownCommandException;
import org.example.strategies.FlyStrategy;
import org.example.strategies.HorseStrategy;
import org.example.strategies.MoveStrategy;
import org.example.strategies.WalkStrategy;

import java.util.HashMap;

public class CommandProcessor {
  private final HashMap<String, MoveStrategy> strategies = new HashMap<>();
  private static int heroCount = 0;

  public CommandProcessor() {
    strategies.put("walk", new WalkStrategy());
    strategies.put("horse", new HorseStrategy());
    strategies.put("fly", new FlyStrategy());
  }

  public void sendHero(String command) throws UnknownCommandException {
    MoveStrategy strategy = strategies.get(command);
    if (strategy == null) {
      throw new UnknownCommandException("Unknown command: " + command);
    }
    Hero hero = new Hero("Hero number " + ++heroCount, strategy);
    hero.move();
  }
}
