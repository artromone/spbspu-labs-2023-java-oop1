package com.kumachev.j2;

import com.kumachev.j2.annotated.MyAnnotatedClass;

public class Main {

    public static void main(String[] args) {
        MyAnnotatedClass c = new MyAnnotatedClass();
        MethodCaller.callAnnotatedMethods(c);
    }
}
