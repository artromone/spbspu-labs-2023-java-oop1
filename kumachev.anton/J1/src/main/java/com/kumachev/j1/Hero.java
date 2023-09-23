package com.kumachev.j1;

import com.kumachev.j1.strategies.MoveStrategy;
import com.kumachev.j1.strategies.WalkStrategy;

public class Hero {
    private final String name;
    private MoveStrategy strategy;

    public Hero(String name) {
        this.name = name;
        this.strategy = new WalkStrategy();
    }

    public void setStrategy(MoveStrategy strategy) {
        this.strategy = strategy;
    }

    public void move() {
        System.out.print(name + " ");
        strategy.move();
    }
}
