package com.zhouw.common;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/18.
 * @since v1.0
 */
public class SignUtil {

    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run(){
                pong();
            }
        };
        thread.run();
        System.out.println("ping");
    }

    public static void pong(){
        System.out.println("pong");
    }
}
