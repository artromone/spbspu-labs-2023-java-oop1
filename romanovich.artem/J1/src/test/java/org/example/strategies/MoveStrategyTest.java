package org.example.strategies;

import org.example.CommandProcessor;
import org.example.exceptions.UnknownCommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

class MoveStrategyTest {
  private MoveStrategy walkStrategy;
  private CommandProcessor processor;

  @BeforeEach
  void setUp() throws UnknownCommandException {
    walkStrategy = new WalkStrategy();
    processor = new CommandProcessor();
  }

  private void testUseStrategyWithCommand(String command, MoveStrategy strategy) throws UnknownCommandException {
    processor.useStrategy(command);
    assertTrue(strategy instanceof MoveStrategy);
    strategy.move();
  }

  @Test
  @DisplayName("Test using 'walk' command")
  void testUseStrategyWithValidCommand() throws UnknownCommandException {
    testUseStrategyWithCommand("walk", walkStrategy);
  }

  @Test
  @DisplayName("Test using 'nonexistent' command")
  void testUseStrategyWithInvalidCommand() {
    assertThrows(UnknownCommandException.class, () -> {
      processor.useStrategy("nonexistent");
    });
  }
}
