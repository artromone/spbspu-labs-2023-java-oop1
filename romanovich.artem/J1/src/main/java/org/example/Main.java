package org.example;

import org.example.exceptions.UnknownCommandException;

import java.util.Scanner;

public class Main {

  private static final CommandProcessor processor = new CommandProcessor();

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      processInput(scanner.nextLine());
    }
  }

  public static <ConsoleWriter> void processInput(String s) {
    try {
      processor.useStrategy(s);
    } catch (UnknownCommandException e) {
      System.out.println("Error occurred: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Unknown error occurred.");
    }
  }
}
