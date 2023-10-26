package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) /*throws InvocationTargetException, IllegalAccessException */ {
    Class<?> cls = Caller.class;
    Method[] methods = cls.getDeclaredMethods();

    int n = getTheLongestMethodName(methods);

    Arrays.stream(methods)
        .sorted(Comparator.comparingInt(method -> /*-*/method.getName().length()))//.reversed()
        .forEach(method -> {
          System.out.print(String.format("%-" + n + "s", method.getName()) + " | ");
          method.setAccessible(true);
          try {
            method.invoke(null);
          } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
          }
        });

//    for (Method method : methods) {
//      System.out.print(String.format("%-" + n + "s", method.getName()) + " | ");
//      method.setAccessible(true);
//      method.invoke(null);
//    }
  }

  private static int getTheLongestMethodName(Method[] methods) {
    int longestMethodSize = 0;
    for (Method method : methods) {
      longestMethodSize = Math.max(longestMethodSize, method.getName().length());
    }
    return longestMethodSize;
  }
}