package com.heshi.auto.configuration.annotation;

import java.lang.annotation.*;

/**
 * @author kun
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}
