package com.kumachev.j1.strategies;

public class RunStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("бежит...");
    }
}
