package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<String, Integer> map = new HashMap<>();

        map.put("walk", 1);
        map.put("horse", 2);
        map.put("fly", 3);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Integer value = map.get(line);
            System.out.println(value);
        }
    }
}