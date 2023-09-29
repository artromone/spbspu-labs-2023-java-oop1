package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class AnnotatedMethodsCaller {
    public void callAll() {
        AnnotatedClass annotatedObj = new AnnotatedClass();
        Class<? extends AnnotatedClass> objClass = annotatedObj.getClass();
        Method[] methods = objClass.getDeclaredMethods();

        for (Method method : methods) {
            if (!method.isAnnotationPresent(Repeat.class)) {
                continue;
            }
            int times = method.getDeclaredAnnotation(Repeat.class).times();
            Parameter[] parameters = method.getParameters();
            Object[] args = new Object[parameters.length];

            for (int j = 0; j < parameters.length; j++) {
                args[j] = switch (parameters[j].getParameterizedType().getTypeName()) {
                    case "int" -> 42;
                    case "java.lang.String" -> "foo";
                    case "double" -> Math.PI;

                    default -> null;
                };
            }
            for (int i = 0; i < times; i++) {
                try {
                    method.invoke(annotatedObj, args);
                } catch (IllegalAccessException | InvocationTargetException exeption) {
                    System.out.println(exeption.getLocalizedMessage());
                    System.out.println("********TRYING TO RECOVER********");
                    try {
                        method.trySetAccessible();
                        method.invoke(annotatedObj, args);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.out.println("****** " + method.getName() + " is not possible to call *********");
                    }
                }
            }
        }

    }
}
