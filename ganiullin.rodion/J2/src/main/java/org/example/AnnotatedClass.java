package org.example;

public class AnnotatedClass {

    @Repeat(times = 1)
    private void firstPrivateMethod() {
        System.out.println("firstPrivateMethod called");
    }

    @Repeat(times = 2)
    private void secondPrivateMethod() {
        System.out.println("secondPrivateMethod called");
    }

    @Repeat(times = 3)
    private void thirdPrivateMethod() {
        System.out.println("thirdPrivateMethod called");
    }

    @Repeat(times = 4)
    protected void firstProtectedMethod() {
        System.out.println("firstProtectedMethod called");
    }

    @Repeat(times = 5)
    protected void secondProtectedMethod() {
        System.out.println("secondProtectedMethod called");
    }

    @Repeat(times = 6)
    protected void thirdProtectedMethod() {
        System.out.println("thirdProtectedMethod called");
    }

    @Repeat(times = 7)
    public void firstPublicMethod() {
        System.out.println("firstPublicMethod called");
    }

    @Repeat(times = 8)
    public void secondPublicMethod() {
        System.out.println("secondPublicMethod called");
    }

    @Repeat(times = 9)
    public void thirdPublicMethod() {
        System.out.println("thirdPublicMethod called");
    }
}
