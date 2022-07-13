package com.lh.money.thread;

import java.util.concurrent.Callable;

/**
 * @author lihao
 */
public class NewThread{

    /**多线程资源**/
    static volatile int threadResources = 0;

    public void createThread(){
        new NewThreadExtend().start();
    }

    public void createRunnable(){
        new NewImplementationRunnable().run();
    }

    public void createCallable(){
        try {
            new NewImplementationCallable().call();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void forThreadResources(){
        for (int i = 1; threadResources < 100; i++) {
            System.out.println("资源争夺中：当前资源数字" + ++threadResources);
        }
    }

    public static void main(String[] args) {
        new NewThread().createThread();
        new NewThread().createRunnable();
        new NewThread().createCallable();
    }


    class NewThreadExtend extends Thread
    {
        @Override
        public void run(){
            forThreadResources();
            System.out.println("继承Thread类,实现多线程");
        }
    }
    class NewImplementationRunnable implements Runnable{
        @Override
        public void run() {
            forThreadResources();
            System.out.println("实现多线程的Runnable接口");
        }
    }

    class NewImplementationCallable implements Callable {
        @Override
        public Object call() throws Exception {
            forThreadResources();
            System.out.println("实现多线程的Callable接口");
            return null;
        }
    }

}
