package org.example;

import java.util.Objects;
import org.example.CallNumber;

public class Main {
  public static void main(String[] args) throws Exception {

    MethodKeeper myClass = new MethodKeeper();
    Class<?> clazz = myClass.getClass();

    for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
      CallNumber annotation = method.getAnnotation(CallNumber.class);
      method.setAccessible(true);

      for (int i = 0; i < Objects.requireNonNull(annotation).number(); ++i) {
        method.invoke(myClass);
      }
    }
  }
}
