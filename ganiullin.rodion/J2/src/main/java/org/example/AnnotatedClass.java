package org.example;

public class AnnotatedClass {

    @Repeat(times = 1)
    private void firstPrivateMethod(int a) {
        System.out.printf("firstPrivateMethod called with a = %d%n", a);
    }

    @Repeat(times = 2)
    private void secondPrivateMethod(String b) {
        System.out.printf("secondPrivateMethod called with %s%n", b);
    }

    @Repeat(times = 3)
    private void thirdPrivateMethod(int a) {
        System.out.printf("thirdPrivateMethod called with a = %d%n", a);
    }

    @Repeat(times = 1)
    protected void firstProtectedMethod(int x, int y, int z) {
        System.out.printf("firstProtectedMethod called with {x, y, z} = {%d, %d, %d}%n", x, y, z);
    }

    @Repeat(times = 2)
    protected void secondProtectedMethod(String str) {
        System.out.printf("secondProtectedMethod called with %s%n", str );
    }

    @Repeat(times = 3)
    protected void thirdProtectedMethod(double num) {
        System.out.printf("thirdProtectedMethod called with %.4f%n", num);
    }

    @Repeat(times = 1)
    public void firstPublicMethod(int a) {
        System.out.printf("firstPublicMethod called with %d%n", a);
    }

    @Repeat(times = 2)
    public void secondPublicMethod() {
        System.out.println("secondPublicMethod called");
    }

    @Repeat(times = 3)
    public void thirdPublicMethod() {
        System.out.println("thirdPublicMethod called");
    }
}
