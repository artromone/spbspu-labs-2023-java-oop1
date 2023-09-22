package org.example.hero;

import org.example.strategies.MoveStrategy;

public class Hero {

  private String name;
  private MoveStrategy moveStrategy;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MoveStrategy getMoveStrategy() {
    return moveStrategy;
  }

  public void setMoveStrategy(MoveStrategy moveStrategy) {
    this.moveStrategy = moveStrategy;
  }

  public Hero(String name, MoveStrategy moveStrategy) {
    this.name = name;
    this.moveStrategy = moveStrategy;
  }

  public void move() {
    System.out.print(name + ": ");
    moveStrategy.move();
  }
}
