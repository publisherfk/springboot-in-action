package com.heshi.annotation.interitable;

/**
 * @author by fukun
 */
@MyAnnotation
public class Base {
    public Base() {
        System.out.println("Base:" + Base.class.isAnnotationPresent(MyAnnotation.class));
    }
}
