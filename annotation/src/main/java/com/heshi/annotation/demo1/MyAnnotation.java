package com.heshi.annotation.demo1;

import java.lang.annotation.*;

/**
 * @author by fukun
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
}