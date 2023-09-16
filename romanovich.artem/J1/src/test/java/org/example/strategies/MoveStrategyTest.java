package org.example.strategies;

import org.example.CommandProcessor;
import org.example.exceptions.UnknownCommandException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertThrows;

class MoveStrategyTest {
  private MoveStrategy walkStrategy;
  private CommandProcessor processor;

  @BeforeEach
  void setUp() throws UnknownCommandException {
    walkStrategy = Mockito.mock(WalkStrategy.class);
    MoveStrategy horseStrategy = Mockito.mock(HorseStrategy.class);
    MoveStrategy flyStrategy = Mockito.mock(FlyStrategy.class);

    processor = new CommandProcessor();
    processor.useStrategy("walk");
    processor.useStrategy("horse");
    processor.useStrategy("fly");
  }

  private void testUseStrategyWithCommand(String command, MoveStrategy strategy) throws UnknownCommandException {
    processor.useStrategy(command);
    Mockito.verify(strategy).move();
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
