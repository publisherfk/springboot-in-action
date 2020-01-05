package com.heshi.auto.configuration.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @author kun
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {
    String value() default "";
}
