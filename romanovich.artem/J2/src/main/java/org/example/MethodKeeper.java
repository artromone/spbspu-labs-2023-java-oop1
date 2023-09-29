package org.example;

import org.example.CallNumber;

public class MethodKeeper {
  @CallNumber(number = 2)
  public void publicMethodFirst() {
    System.out.println("Public method first");
  }
  public void publicMethodSecond() {
    System.out.println("Public method second");
  }
  public void publicMethodThird() {
    System.out.println("Public method third");
  }

  @CallNumber(number = 3)
  protected void protectedMethodFirst() {
    System.out.println("Protected method first");
  }
  protected void protectedMethodSecond() {
    System.out.println("Protected method second");
  }

  @CallNumber(number = 5)
  private void privateMethodFirst() {
    System.out.println("Private method first");
  }
  private void privateMethodSecond() {
    System.out.println("Private method second");
  }
}
