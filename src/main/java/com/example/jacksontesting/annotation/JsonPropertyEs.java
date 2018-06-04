package com.example.jacksontesting.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonPropertyEs {

    String USE_DEFAULT_NAME = "";

    String value() default USE_DEFAULT_NAME;
}
