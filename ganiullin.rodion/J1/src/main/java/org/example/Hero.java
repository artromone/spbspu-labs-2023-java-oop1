package org.example;


import moveStrategies.MoveStrategy;

public class Hero {
    private MoveStrategy moveStrategy;
    private String name;

    public Hero(String name, MoveStrategy moveStrategy) {
        if (name == null || name.trim().isEmpty()){
            throw new RuntimeException("name is empty or null");
        }
        if( moveStrategy == null){
            throw new RuntimeException("strategy is null");
        }
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new RuntimeException("name is empty or null");
        }
        this.name = name;
    }

    public void move(String destination) {
        this.moveStrategy.move(destination);
    }

    public void setMoveStrategy(MoveStrategy strategy) {
        if( moveStrategy == null){
            throw new RuntimeException("strategy is null");
        }
        this.moveStrategy = strategy;
    }
    public MoveStrategy getMoveStrategy(){
        return this.moveStrategy;
    }
}
