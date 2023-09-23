package com.kumachev.j1.strategies;

public class RideStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("едет на лошади...");
    }
}
