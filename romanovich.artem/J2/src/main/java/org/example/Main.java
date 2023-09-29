package org.example;

import static org.example.MethodKeeper.methodCallCount;

public class Main {
  public static void main(String[] args) throws Exception {

    MethodKeeper myClass = new MethodKeeper();
    Class<?> clazz = myClass.getClass();

    for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
      CallNumber annotation = method.getAnnotation(CallNumber.class);
      method.setAccessible(true);

      if (annotation == null) {
        continue;
      }

      int n = annotation.number();
      System.out.println("Call times: " + n);
      for (int i = 0; i < n; ++i) {
      //for (int i = 0; i < Objects.requireNonNull(annotation).number(); ++i) {
        method.invoke(myClass);
      }
      methodCallCount = 1;
    }
  }
}
