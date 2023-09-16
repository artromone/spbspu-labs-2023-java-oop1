package org.example.strategies;

public class HorseStrategy implements MoveStrategy {
  @Override
  public void move() {
    System.out.println("horse");
  }
}