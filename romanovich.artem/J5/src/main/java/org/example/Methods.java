package org.example;

import java.util.List;

public class Methods {
  public static double getAverage(List<Integer> numbers) {
    return numbers.stream()
        .mapToInt(i -> i)
        .average()
        .orElse(0.0);
  }
}
