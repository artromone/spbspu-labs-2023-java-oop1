package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CallCount {
  int value();
}

class MyClass {

  @CallCount(2)
  public void publicMethod1() {
    System.out.println("Public method 1");
  }
  public void publicMethod2() {
    System.out.println("Public method 2");
  }
  public void publicMethod3() {
    System.out.println("Public method 3");
  }

  @CallCount(3)
  protected void protectedMethod1() {
    System.out.println("Protected method 1");
  }
  protected void protectedMethod2() {
    System.out.println("Protected method 2");
  }

  @CallCount(5)
  private void privateMethod1() {
    System.out.println("Private method 1");
  }
  private void privateMethod2() {
    System.out.println("Private method 2");
  }
}

public class Main {
  public static void main(String[] args) throws Exception {

    MyClass myClass = new MyClass();
    Class<?> clazz = myClass.getClass();

    for (java.lang.reflect.Method method : clazz.getDeclaredMethods()) {
      CallCount annotation = method.getAnnotation(CallCount.class);

      if (annotation == null) {
        throw new Exception("f");
      }

      method.setAccessible(true);
      for (int i = 0; i < Objects.requireNonNull(annotation).value(); i++) {
        method.invoke(myClass);
      }
    }
  }
}
