package com.adu.springboothelloworld.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author jintang
 * @date 2019-11-14
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ControllerWebLog {
    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";
}
