package com.fhp.usercenter.log;


import java.lang.annotation.*;


/**
 * 自定义注解类，拦截Service
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServiceLogAccessor {
    String description()  default "";
}
