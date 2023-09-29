package org.example;

public class MethodKeeper {
  public static int methodCallCount = 1;

  @CallNumber(number = 2)
  public void publicMethodFirst() {
    System.out.println("Public method first: " + methodCallCount++);
  }
  public void publicMethodSecond() {
    System.out.println("Public method second: " + methodCallCount++);
  }
  public void publicMethodThird() {
    System.out.println("Public method third: " + methodCallCount++);
  }

  @CallNumber(number = 3)
  protected void protectedMethodFirst() {
    System.out.println("Protected method first: " + methodCallCount++);
  }
  protected void protectedMethodSecond() {
    System.out.println("Protected method second: " + methodCallCount++);
  }

  @CallNumber(number = 5)
  private void privateMethodFirst() {
    System.out.println("Private method first: " + methodCallCount++);
  }
  private void privateMethodSecond() {
    System.out.println("Private method second: " + methodCallCount++);
  }
}
