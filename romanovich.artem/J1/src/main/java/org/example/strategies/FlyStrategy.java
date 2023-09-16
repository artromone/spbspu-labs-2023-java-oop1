package org.example.strategies;

public class FlyStrategy implements MoveStrategy {
  @Override
  public void move() {
    System.out.println("fly");
  }
}
