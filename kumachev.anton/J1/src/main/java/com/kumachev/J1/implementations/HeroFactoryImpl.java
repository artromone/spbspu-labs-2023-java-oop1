package com.kumachev.J1.implementations;

import com.kumachev.J1.Hero;
import com.kumachev.J1.exceptions.InvalidCommandException;
import com.kumachev.J1.factories.HeroFactory;
import com.kumachev.J1.factories.MoveStrategyFactory;
import com.kumachev.J1.strategies.MoveStrategy;

public class HeroFactoryImpl implements HeroFactory {
    private final MoveStrategyFactory moveStrategyFactory;

    public HeroFactoryImpl(MoveStrategyFactory moveStrategyFactory) {
        this.moveStrategyFactory = moveStrategyFactory;
    }

    @Override
    public Hero createFromCmd(String cmd) throws InvalidCommandException {
        String[] args = cmd.split("\\s", 2);

        if (args.length != 2) {
            throw new InvalidCommandException();
        }

        String name = args[0];
        String strategyName = args[1];
        MoveStrategy strategy = moveStrategyFactory.createStrategy(strategyName);
        return new Hero(name, strategy);
    }
}
