package org.example;


import moveStrategies.MoveStrategy;

public class Hero {
    private MoveStrategy moveStrategy;
    private String name;

    public Hero(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void move(String destination) {
        this.moveStrategy.move(destination);
    }

    public void setMoveStrategy(MoveStrategy strategy) {
        this.moveStrategy = strategy;
    }
}
