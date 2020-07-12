package com.heshi.jvm1;

/**
 * @Author: fukun
 * @Date: 2020/6/8 21:40
 * @since
 */
public class JVMDemoTest {
    public static void main(String[] args) {
        System.out.println(toMemoryInfo());
    }

    public static String toMemoryInfo() {
        Runtime runtime = Runtime.getRuntime();
        int freeMemory = (int) (runtime.freeMemory() / 1024 / 1024);
        int totalMemory = (int) (runtime.totalMemory() / 1024 / 1024);
        return freeMemory + "M/" + totalMemory + "M/(free/total)";
    }
}
