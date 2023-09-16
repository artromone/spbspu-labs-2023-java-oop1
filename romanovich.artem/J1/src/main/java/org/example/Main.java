package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Runnable> map = createCommandsMap();

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Runnable command = map.getOrDefault(line, Commands::errorCommand);
            command.run();
        }
    }

    static HashMap<String, Runnable> createCommandsMap() {
        HashMap<String, Runnable> map = new HashMap<>();
        map.put("walk", Commands::walkCommand);
        map.put("horse", Commands::horseCommand);
        map.put("fly", Commands::flyCommand);
        return map;
    }
}