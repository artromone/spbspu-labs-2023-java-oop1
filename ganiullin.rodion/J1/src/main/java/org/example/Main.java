package org.example;

import moveStrategies.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static final String DESTINATION = "WaterDeep";

    public static void main(String[] args) {

        Hero hero = new Hero("Bob", new Walk());
        hero.move(DESTINATION);
        System.out.println();

        hero.setMoveStrategy(new HorseRiding());
        hero.move(DESTINATION);
        System.out.println();

        hero.setMoveStrategy(new Fly());
        hero.move(DESTINATION);
        System.out.println();

        hero.setMoveStrategy(new HorseRiding());
        hero.move(DESTINATION);
        System.out.println();

        hero.setMoveStrategy(new FlyDragon());
        for (int i = 0; i < 5; i++) {
            hero.move(DESTINATION);
            System.out.println();
        }

        hero.setMoveStrategy(new Teleportation());
        hero.move(DESTINATION);
    }
}