package org.example.hero;

import org.example.strategies.MoveStrategy;

public interface HeroFactory {
  Hero createHero(String name, MoveStrategy strategy);
}
