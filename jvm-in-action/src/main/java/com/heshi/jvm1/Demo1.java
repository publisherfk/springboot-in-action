package com.heshi.jvm1;

/**
 * @Author: fukun
 * @Date: 2020/6/10 20:51
 * @since
 */
public class Demo1 {
    public static void main(String[] args) {
        String str = "a,b,c,,,,,,,,,,,,,,,,,,";
        String[] ary = str.split(",");
        // 预期大于 3，结果是 3
        System.out.println(ary.length);
    }
}
