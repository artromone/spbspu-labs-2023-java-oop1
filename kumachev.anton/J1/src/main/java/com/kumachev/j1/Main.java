package com.kumachev.j1;

import com.kumachev.j1.exceptions.InvalidCommandException;
import com.kumachev.j1.factories.HeroFactory;
import com.kumachev.j1.implementations.HeroFactoryImpl;
import com.kumachev.j1.implementations.MoveStrategyFactoryImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HeroFactory heroFactory = new HeroFactoryImpl(new MoveStrategyFactoryImpl());
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            try {
                Hero hero = heroFactory.createFromCmd(scanner.nextLine());
                hero.move();
            }
            catch (InvalidCommandException e) {
                System.err.println("Неверно введена команда");
            }
        }
    }
}
