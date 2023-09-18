package org.example.strategies;

public class FlyStrategy implements MoveStrategy {
  @Override
  public void move() {
    System.out.println("You managed to fly 300 km by plane.");
  }
}
