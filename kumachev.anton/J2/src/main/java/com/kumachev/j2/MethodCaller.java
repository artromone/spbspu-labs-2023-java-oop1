package com.kumachev.j2;

import com.kumachev.j2.annotations.MyAnnotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MethodCaller {
    public static <T> void callMethod(T obj, String methodName, Object... args) {
        Class<?> cls = obj.getClass();
        Class<?>[] argsTypes = Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new);

        try {
            Method method = cls.getDeclaredMethod(methodName, argsTypes);
            int mod = method.getModifiers();
            MyAnnotation a = method.getDeclaredAnnotation(MyAnnotation.class);

            if ((Modifier.isPrivate(mod) || Modifier.isProtected(mod)) && a != null) {
                method.setAccessible(true);

                for (int i = 0; i < a.count(); ++i) {
                    method.invoke(obj, args);
                }
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ignored) {
            System.err.println("Error");
        }
    }
}
