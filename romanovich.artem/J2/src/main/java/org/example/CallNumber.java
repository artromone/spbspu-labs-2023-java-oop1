package org.example;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jdk.jfr.Description;

@Description("Annotation for calling method specific number of times.")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CallNumber {
  int DEFAULT = 1;
  int number() default DEFAULT;
}
