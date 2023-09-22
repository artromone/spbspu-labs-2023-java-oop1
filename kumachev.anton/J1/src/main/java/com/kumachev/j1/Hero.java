package com.kumachev.j1;

import com.kumachev.j1.strategies.MoveStrategy;

public class Hero {
    private final String name;
    private final MoveStrategy strategy;

    public Hero(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.strategy = moveStrategy;
    }

    public void move() {
        System.out.print(name + " ");
        strategy.move();
    }
}
