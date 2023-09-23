package com.kumachev.j1.strategies;

public class WalkStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("идет...");
    }
}
