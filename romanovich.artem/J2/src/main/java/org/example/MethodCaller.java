package org.example;

import static org.example.MethodKeeper.methodCallCount;

import java.lang.reflect.InvocationTargetException;

public class MethodCaller {
  public void call() throws InvocationTargetException, IllegalAccessException {
    MethodKeeper methodKeeper = new MethodKeeper();
    Class<? extends MethodKeeper> methodKeeperClass = methodKeeper.getClass();

    for (java.lang.reflect.Method method : methodKeeperClass.getDeclaredMethods()) {
      CallNumber annotation = method.getAnnotation(CallNumber.class);
      method.setAccessible(true);

      System.out.println("-".repeat(34));

      if (annotation == null) {
        /*
         * @see CallNumber to learn about calling CallNumber.DEFAULT times opportunity
         */
        System.out.println("Cannot call: " + method.getName());
        continue;
      }

      int n = annotation.number();
      System.out.println("Call times: " + n);
      for (int i = 0; i < n; ++i) {
        method.invoke(methodKeeper);
      }
      methodCallCount = 1;
    }
    System.out.println("-".repeat(34));
  }
}
