package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Caller {
  public static void getAverage() {
    List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    double average = Methods.getAverage(numbers);
    System.out.println(average);
  }

  public static void addUpperPrefix() {
    List<String> strings = Arrays.asList("Fsda", "AsF", "ds", "SdFSad", "fF", "ZFAsefwe");
    List<String> result = Methods.addUpperPrefix(strings);
    System.out.println(result);
  }

  public static void getUniqueSquares() {
    List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 9);
    List<Integer> result = Methods.getUniqueSquares(numbers);
    System.out.println(result);
  }

  public static void filterByFirstLetter() {
    List<String> strings = Arrays.asList("Fsda", "fascFb", "ds", "rdFSad", "fzyx", "FFAsefwe");
    List<String> result = Methods.filterByFirstLetter(strings, 'f');
    System.out.println(result);
  }

  public static void getLast() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    int result1 = Methods.getLast(list);
    System.out.print(result1);
    System.out.print(", ");

    List<Integer> emptyList = List.of();
    try {
      int result2 = Methods.getLast(emptyList);
    } catch (IllegalArgumentException e) {
      System.out.println(e);
    }
  }

  public static void getEvenSum() {
    int[] numbers = {1, 2, 3, 4};
    int result1 = Methods.getEvenSum(numbers);
    System.out.print(result1);
    System.out.print(", ");

    int[] emptyNumbers = {};
    int result2 = Methods.getEvenSum(emptyNumbers);
    System.out.println(result2);
  }

  public static void toMap() {
    List<String> strings = Arrays.asList("kkkkkkk", "lll", "y", "");

    Map<Character, String> result = Methods.toMap(strings);
    System.out.println(result);
  }
}
