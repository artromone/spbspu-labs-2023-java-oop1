package com.kumachev.j2.annotated;

import com.kumachev.j2.annotations.MyAnnotation;

public class MyAnnotatedClass {
    @MyAnnotation(count = 3)
    private void annotatedPrivate(Integer a, String b) {
        System.out.println("annotatedPrivate " + a + " " + b);
    }

    private void notAnnotatedPrivate(Integer a, String b) {
        System.out.println("annotatedPrivate " + a + " " + b);
    }

    @MyAnnotation(count = 1)
    protected void annotatedProtected(Float c) {
        System.out.println("annotatedProtected " + c);
    }

    protected void notAnnotatedProtected(Float c) {
        System.out.println("annotatedProtected " + c);
    }

    @MyAnnotation(count = 2)
    public void annotatedPublic(Double e) {
        System.out.println("annotatedPublic " + e);
    }

    public void notAnnotatedPublic(Double e) {
        System.out.println("annotatedPublic " + e);
    }
}
