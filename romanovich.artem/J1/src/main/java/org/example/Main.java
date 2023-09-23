package org.example;

import org.example.exceptions.UnknownCommandException;
import org.example.hero.HeroFactory;
import org.example.hero.HeroFactoryImpl;
import org.example.hero.HeroSender;
import org.example.hero.HeroSenderImpl;
import org.example.strategies.MoveStrategyFactory;
import org.example.strategies.MoveStrategyFactoryImpl;

import java.util.Scanner;

public class Main {

  private static HeroSender heroSender;

  public static void main(String[] args) {

    MoveStrategyFactory moveStrategyFactory = new MoveStrategyFactoryImpl();
    HeroFactory heroFactory = new HeroFactoryImpl();
    heroSender = new HeroSenderImpl(moveStrategyFactory, heroFactory);

    try (Scanner scanner = new Scanner(System.in); scanner) {
      while (scanner.hasNextLine()) {
        processInput(scanner.nextLine());
      }
    }
  }

  public static void processInput(String string) {
    try {
      heroSender.sendHero(string);
    } catch (UnknownCommandException e) {
      System.out.println("Error occurred: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Unknown error occurred.");
    }
  }
}
