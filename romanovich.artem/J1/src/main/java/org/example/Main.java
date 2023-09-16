package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            CommandProcessor processor = new CommandProcessor();
            processor.useStrategy(line);
        }
    }
}
