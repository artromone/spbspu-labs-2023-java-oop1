package com.kumachev.j1.strategies;

public class TeleportStrategy implements MoveStrategy {
    @Override
    public void move() {
        System.out.println("открывает портал...");
    }
}
