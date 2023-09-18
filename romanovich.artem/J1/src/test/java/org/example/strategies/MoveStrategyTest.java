package org.example.strategies;

import org.example.CommandProcessor;
import org.example.exceptions.UnknownCommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MoveStrategyTest {
  private CommandProcessor processor;

  @BeforeEach
  void setUp() {
    processor = new CommandProcessor();
  }

  private void testUseStrategyWithCommand(String command, MoveStrategy strategy) throws UnknownCommandException {
    processor.useStrategy(command);
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
    assertThrows(UnknownCommandException.class, () -> processor.useStrategy("nonexistent"));
  }
}
