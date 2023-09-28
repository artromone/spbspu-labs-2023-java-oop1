package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotatedMethodsCaller {
    public void callAll() {
        AnnotatedClass annotatedObj = new AnnotatedClass();
        Class<? extends AnnotatedClass> objClass = annotatedObj.getClass();
        Method[] methods = objClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Repeat.class)) {
                int times = method.getDeclaredAnnotation(Repeat.class).times();
                for (int i = 0; i < times; i++) {
                    try {
                        method.invoke(annotatedObj);
                    } catch (IllegalAccessException | InvocationTargetException exeption) {
                        System.out.println(exeption.getLocalizedMessage());
                        System.out.println("********TRYING TO RECOVER********");
                        try {
                            method.trySetAccessible();
                            method.invoke(annotatedObj);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            System.out.println("****** " + method.getName() + " is not possible to call *********");
                        }
                    }
                }
            }
        }
    }
}
