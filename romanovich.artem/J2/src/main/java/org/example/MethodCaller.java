package org.example;

import static org.example.MethodKeeper.methodCallCount;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

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

      int annotationNumber = annotation.number();
      System.out.println("Call times: " + annotationNumber);

      for (int i = 0; i < annotationNumber; ++i) {
        method.invoke(methodKeeper, fillParameters(method));
      }
      methodCallCount = 1;
    }
    System.out.println("-".repeat(34));
  }

  public Object[] fillParameters(java.lang.reflect.Method method) {
    Parameter[] parameters = method.getParameters();
    int numParams = method.getParameterCount();
    Object[] args = new Object[numParams];

    for (int i = 0; i < parameters.length; ++i) {
      if (int.class == parameters[i].getType()) {
        args[i] = 1;
      }
      if (double.class == parameters[i].getType()) {
        args[i] = 1.0;
      }
      if (MyClass.class == parameters[i].getType()) {
        args[i] = new MyClass();
      }
    }

    return args;
  }
}
