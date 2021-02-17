package com.itcat.ThreadPool;

import java.util.concurrent.*;

public class cacheThreadPool {
    static int index;
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newScheduledThreadPool(3);//创建cacheThread线程池
        for (int i = 0; i < 10; i++) {
            index = i;
            executorService.execute(new exeTask(Integer.toString(index),index));//提交任务
        }
        executorService.shutdown();
    }
}

class exeTask implements Runnable{
    private final String name;
    private final int delay;

    public exeTask(String name, int delay) {
        this.name = name;//任务
        this.delay = delay;//延时
    }

    @Override
    public void run() {
        System.out.println("正在执行："+name);
        try {
            Thread.sleep(1000 * delay);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("完成："+name);
    }
}
