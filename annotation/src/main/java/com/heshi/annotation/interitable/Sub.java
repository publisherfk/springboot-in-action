package com.heshi.annotation.interitable;

/**
 * @author by fukun
 */
public class Sub extends Base {
    public Sub() {
        System.out.println("sub:" + Sub.class.isAnnotationPresent(MyAnnotation.class));
    }
}
