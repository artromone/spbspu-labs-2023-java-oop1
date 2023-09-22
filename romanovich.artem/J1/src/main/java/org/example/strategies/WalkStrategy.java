package org.example.strategies;

public class WalkStrategy implements MoveStrategy {
  @Override
  public void move() {
    System.out.println("Walking... You walked 30 meters.");
  }
}
