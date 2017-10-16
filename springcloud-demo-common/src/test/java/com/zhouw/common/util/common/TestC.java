package com.zhouw.common.util.common;

import java.util.concurrent.CountDownLatch;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/22.
 * @since v1.0
 */
public class TestC {

    static class Test{
        public static void call(){
            System.out.println("------------------------");
        }
    }

    static class SyncTest implements Runnable{
        public static boolean flag =true;
        private static CountDownLatch countDownLatch = new CountDownLatch(200);
        @Override
        public void run() {
            try {
                synchronized (this) {
                    System.out.println(Thread.currentThread().getName() + " init Thread.....");
                    this.wait();
                    while (countDownLatch.getCount()>0) {
                        Test.call();
                        countDownLatch.countDown();

                        System.out.println(Thread.currentThread().getName() + "----" + countDownLatch.getCount());
                    }
                }
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public synchronized void notifyalltshi(){
            System.out.println("notifyalltshi");
            this.notifyAll();
        }
    }


    public static void main(String[] args) throws InterruptedException {

        SyncTest syncTest = new SyncTest();
        for (int i=0;i<20;i++){

            Thread thread = new Thread(syncTest);
            thread.start();
            System.out.println("111111－－－－－－－－－－" +i);
        }
        Thread.sleep(100);

        syncTest.notifyalltshi();
    }



}
