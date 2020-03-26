package com.heshi.netty.demo1;

public class ServerBoot {
    public static void main(String[] args) {
        new Server(8000).start();
    }
}