package org.example.strategies;

import org.example.exceptions.UnknownCommandException;
import org.example.hero.HeroFactory;
import org.example.hero.HeroFactoryImpl;
import org.example.hero.HeroSender;
import org.example.hero.HeroSenderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoveStrategyTest {
  private HeroSender heroSender;

  @BeforeEach
  void setUp() {
    MoveStrategyFactory moveStrategyFactory = new MoveStrategyFactoryImpl();
    HeroFactory heroFactory = new HeroFactoryImpl();
    heroSender = new HeroSenderImpl(moveStrategyFactory, heroFactory);
  }

  private void testUseStrategyWithCommand(String command, MoveStrategy strategy) throws UnknownCommandException {
    heroSender.sendHero(command);
    assertNotNull(strategy);
    strategy.move();
  }

  @Test
  @DisplayName("Test using 'walk' command")
  void testUseStrategyWithValidCommand() throws UnknownCommandException {
    MoveStrategy walkStrategy = new WalkStrategy();
    testUseStrategyWithCommand("walk", walkStrategy);
  }

  @Test
  @DisplayName("Test using 'horse' command")
  void testUseStrategyWithHorseCommand() throws UnknownCommandException {
    MoveStrategy horseStrategy = new HorseStrategy();
    testUseStrategyWithCommand("horse", horseStrategy);
  }

  @Test
  @DisplayName("Test using 'fly' command")
  void testUseStrategyWithFlyCommand() throws UnknownCommandException {
    MoveStrategy flyStrategy = new FlyStrategy();
    testUseStrategyWithCommand("fly", flyStrategy);
  }

  @Test
  @DisplayName("Test using 'nonexistent' command")
  void testUseStrategyWithInvalidCommand() {
    assertThrows(UnknownCommandException.class, () -> heroSender.sendHero("nonexistent"));
  }
}
