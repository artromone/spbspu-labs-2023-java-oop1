package com.kumachev.J1.strategies;

public class FlyStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("летит на неведанном звере...");
    }
}
