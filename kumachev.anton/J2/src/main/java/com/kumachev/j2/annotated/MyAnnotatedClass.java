package com.kumachev.j2.annotated;

import com.kumachev.j2.annotations.MyAnnotation;

public class MyAnnotatedClass {
    @MyAnnotation(count = 3)
    private void annotatedPrivate() {
        System.out.println("annotatedPrivate");
    }

    private void notAnnotatedPrivate() {
        System.out.println("notAnnotatedPrivate");
    }

    @MyAnnotation(count = 1)
    protected void annotatedProtected() {
        System.out.println("annotatedProtected");
    }

    protected void notAnnotatedProtected() {
        System.out.println("notAnnotatedProtected");
    }

    @MyAnnotation(count = 2)
    public void annotatedPublic() {
        System.out.println("annotatedPublic");
    }

    public void notAnnotatedPublic() {
        System.out.println("notAnnotatedPublic");
    }
}
