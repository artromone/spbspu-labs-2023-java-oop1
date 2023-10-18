package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
    Class<?> clazz = Caller.class;
    Method[] methods = clazz.getDeclaredMethods();

    int n = getTheLongestMethodName(methods);

    for (Method method : methods) {
      System.out.print(String.format("%-" + n + "s", method.getName()) + " | ");
      method.setAccessible(true);
      method.invoke(null);
    }
  }

  private static int getTheLongestMethodName(Method[] methods) {
    int longestMethodSize = 0;
    for (Method method : methods) {
      longestMethodSize = Math.max(longestMethodSize, method.getName().length());
    }
    return longestMethodSize;
  }
}