package org.example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Methods {
  public static double getAverage(List<Integer> numbers) {
    return numbers.stream()
        .mapToInt(i -> i)
        .average()
        .orElse(0.0);
  }

  public static List<String> addUpperPrefix(List<String> strings) {
    return strings.stream()
        .map(s -> "_new_" + s.toUpperCase())
        .collect(Collectors.toList());
  }

  public static List<Integer> getUniqueSquares(List<Integer> numbers) {
    return numbers.stream()
        .filter(n -> Collections.frequency(numbers, n) == 1)
        .map(n -> n * n)
        .collect(Collectors.toList());
  }

  public static List<String> filterByFirstLetter(List<String> strings, char letter) {
    return strings.stream()
        .filter(s -> s.startsWith(String.valueOf(letter)))
        .sorted(String.CASE_INSENSITIVE_ORDER)
        .collect(Collectors.toList());
  }
}
