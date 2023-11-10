package com.kumachev.j2;

import com.kumachev.j2.annotated.MyAnnotatedClass;

public class Main {

    public static void main(String[] args) {
        MyAnnotatedClass c = new MyAnnotatedClass();

        MethodCaller.callMethod(c, "annotatedPrivate", 1, "str");
        MethodCaller.callMethod(c, "notAnnotatedPrivate", 1, "str");
        MethodCaller.callMethod(c, "annotatedProtected", 1, "str");
        MethodCaller.callMethod(c, "annotatedProtected", 1.0F);
    }
}
