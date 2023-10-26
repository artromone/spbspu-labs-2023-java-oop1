package org.example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
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

  public static <T> T getLast(List<T> list) {
    return list.stream()
        .reduce((first, second) -> second)
        .orElseThrow(IllegalArgumentException::new);
  }

  public static int getEvenSum(int[] numbers) {
    return Arrays.stream(numbers)
        .filter(n -> n % 2 == 0)
        .sum();
  }

  public static Map<Character, String> toMap(List<String> strings) {
    return strings.stream()
        .filter(s -> !s.isEmpty())
        .collect(Collectors.toMap(
            s -> s.charAt(0),
            s -> {
//          if (s.length() > 1) {
              return s.substring(1);
//          } else {
//            throw new IllegalArgumentException("String length < 2");
//          }
            }
        ));
  }
}
