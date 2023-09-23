package com.kumachev.j2;

import com.kumachev.j2.annotations.MyAnnotation;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodCaller {
    public static <T> void callAnnotatedMethods(T obj) {
        Class<?> cls = obj.getClass();

        for (final Method method : cls.getDeclaredMethods()) {
            int mod = method.getModifiers();
            MyAnnotation a = method.getDeclaredAnnotation(MyAnnotation.class);
            if ((Modifier.isPrivate(mod) || Modifier.isProtected(mod)) && a != null) {
                for (int i = 0; i < a.count(); ++i) {
                    try {
                        method.setAccessible(true);
                        method.invoke(obj);
                    } catch (Exception ignored) {
                        System.out.println("E");
                    }
                }
            }
        }
    }
}
