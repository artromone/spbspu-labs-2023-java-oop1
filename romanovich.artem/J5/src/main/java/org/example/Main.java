package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
    List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    Class<?> clazz = Methods.class;
    for (Method method : clazz.getDeclaredMethods()) {
      method.setAccessible(true);
      Object result = method.invoke(null, numbers);

      System.out.println(method.getName());
      System.out.println(result + "\n");
    }
  }
}