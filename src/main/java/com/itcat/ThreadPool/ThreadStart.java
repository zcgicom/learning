package com.itcat.ThreadPool;

/**
 * Thread.start() Thread.run()
 * .start()方法运行run方法是以开辟一个新的线程去执行的(DeBug模式下可以查看Dump信息)；
 * .run()方法属于方法级别的调用，是主线程(Example)直接调用run()方法
 */
public class ThreadStart extends Thread{
    private String name;

    public ThreadStart(String name) {
        this.name = name;
    }

    @Override
    public void run() {
//        super.run();
        System.out.println("Hello " + name);
    }

    public static void main(String[] args) {
//        new ThreadStart("world").start();
        new ThreadStart("world").run();
    }
}
