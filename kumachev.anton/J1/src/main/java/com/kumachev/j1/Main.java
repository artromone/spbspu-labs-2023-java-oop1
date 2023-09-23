package com.kumachev.j1;

import com.kumachev.j1.exceptions.InvalidCommandException;
import com.kumachev.j1.factories.MoveStrategyFactory;
import com.kumachev.j1.implementations.MoveStrategyFactoryImpl;
import com.kumachev.j1.strategies.MoveStrategy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MoveStrategyFactory moveStrategyFactory = new MoveStrategyFactoryImpl();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Имя героя: ");
            String name = scanner.nextLine();
            Hero hero = new Hero(name);
            System.out.print("Стратегия перемещения: ");

            while (scanner.hasNextLine()) {
                try {
                    String line = scanner.nextLine();

                    if (!line.isEmpty()) {
                        MoveStrategy strategy = moveStrategyFactory.createStrategy(line);
                        hero.setStrategy(strategy);
                    }

                    hero.move();
                    System.out.print("Стратегия перемещения: ");
                } catch (InvalidCommandException e) {
                    System.err.println("Неверно введена стратегия");
                }
            }
        }
    }
}
