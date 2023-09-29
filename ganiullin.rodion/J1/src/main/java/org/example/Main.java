package org.example;

import moveStrategies.*;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    static final String DESTINATION = "WaterDeep";

    public static void main(String[] args) {

        //  Scanner input = new Scanner(System.in);
        try (Scanner input = new Scanner(System.in)) {

            CommandHandler commandHandler = new CommandHandler();

            Hero hero = new Hero("Freeman", new Walk());

            while (input.hasNext()) {

                try {
                    hero.setMoveStrategy(commandHandler.getMoveStrategy(input.nextLine()));
                    hero.move(DESTINATION);
                } catch (Exception e) {
                    System.out.println(e.getLocalizedMessage());
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}