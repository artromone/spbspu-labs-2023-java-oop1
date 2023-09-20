package org.example;

import org.example.strategies.MoveStrategy;

public class Hero {

  private final String name;
  private final MoveStrategy movestrategy;

  public Hero(String name, MoveStrategy movestrategy) {
    this.name = name;
    this.movestrategy = movestrategy;
  }

  void move() {
    System.out.print(name + ": ");
    movestrategy.move();
  }
}
