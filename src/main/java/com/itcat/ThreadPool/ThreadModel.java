package com.itcat.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadModel {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> abq = new ArrayBlockingQueue<Runnable>(5);
        final ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,60,
                TimeUnit.SECONDS,abq, Executors.defaultThreadFactory());

        for (int i = 0; i < 9; i++) {
            //使用execute将任务提交到线程池，创建一个线程取处理任务(Task)
            pool.execute(new Task(i));//线程池执行的任务只能是Runnable(不带返回值)或Callable的接口(带返回值)
            System.out.println("活跃的线程数："+pool.getPoolSize());
            if (abq.size() > 0)System.out.println("==============阻塞线程数 ："+abq.size());
        }
        pool.shutdown();
    }
}
//Task
class Task implements Runnable{
    private int nov;

    public Task(int nov) {
        this.nov = nov;
    }

    @Override
    public void run() {
        System.out.println("当前任务的执行线程是："+Thread.currentThread().getName());
        try {
            Thread.sleep(20000);
        }catch (InterruptedException e){

        }
        System.out.println("正在执行："+nov);
    }
}
