package org.example.hero;

import org.example.strategies.MoveStrategy;

public class HeroFactoryImpl implements HeroFactory {
  @Override
  public Hero createHero(String name, MoveStrategy strategy) {
    return new Hero(name, strategy);
  }
}
