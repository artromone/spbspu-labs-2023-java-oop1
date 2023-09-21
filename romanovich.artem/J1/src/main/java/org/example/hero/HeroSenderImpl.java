package org.example.hero;

import org.example.exceptions.UnknownCommandException;
import org.example.strategies.MoveStrategy;
import org.example.strategies.MoveStrategyFactory;

public class HeroSenderImpl implements HeroSender {
  private final MoveStrategyFactory moveStrategyFactory;
  private final HeroFactory heroFactory;
  private static int heroCount = 0;

  public HeroSenderImpl(MoveStrategyFactory moveStrategyFactory, HeroFactory heroFactory) {
    this.moveStrategyFactory = moveStrategyFactory;
    this.heroFactory = heroFactory;
  }

  @Override
  public void sendHero(String command) throws UnknownCommandException {

    MoveStrategy strategy = moveStrategyFactory.getStrategy(command);
    Hero hero = heroFactory.createHero("Hero number " + ++heroCount, strategy);

    hero.move();
  }
}
