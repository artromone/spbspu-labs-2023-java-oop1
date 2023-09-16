package org.example;

import org.example.exceptions.UnknownCommandException;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    CommandProcessor processor = new CommandProcessor();

    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      try {
        processor.useStrategy(scanner.nextLine());
      } catch (UnknownCommandException e) {
        System.out.println("Error occurred: " + e.getMessage());
      }
    }
  }
}
