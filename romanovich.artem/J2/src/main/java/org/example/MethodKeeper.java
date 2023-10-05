package org.example;

public class MethodKeeper {
  public static int methodCallCount = 1;

  @CallNumber(number = 2)
  public void publicMethodFirst(int i) {
    System.out.println("Public method first: " + methodCallCount++);
  }
  @CallNumber() // default = 1
  public void publicMethodSecond(double d1, double d2) {
    System.out.println("Public method second: " + methodCallCount++);
  }
  public void publicMethodThird(MyClass myClass) {
    System.out.println("Public method third: " + methodCallCount++);
  }

  @CallNumber(number = 3)
  protected void protectedMethodFirst(int i1, int i2) {
    System.out.println("Protected method first: " + methodCallCount++);
  }
  protected void protectedMethodSecond(MyClass myClass){
    System.out.println("Protected method second: " + methodCallCount++);
  }

  @CallNumber(number = 5)
  private void privateMethodFirst(double d) {
    System.out.println("Private method first: " + methodCallCount++);
  }
  private void privateMethodSecond(MyClass myClass) {
    System.out.println("Private method second: " + methodCallCount++);
  }
}
