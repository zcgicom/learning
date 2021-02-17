package com.itcat.CAS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 在request方法上加锁实现该需求 -- 结果满足预期，但耗时长
 *
 * 主要内容：
 * 1.从网站计数器实现中一步步引出CAS操作
 * 2.介绍JAVA中的CAS以及CAS可能存在的问题
 * ===========================================================
 * 需求：假设我们开发了一个网站，需要对访问量进行统计，用户每发送一次请求，访问量+1，如何实现？
 *      模拟100个人同时访问，并且每个人对网站发起10次请求，最后访问量应该为1000次。
 */
public class demo02 {
    static int count = 0;//总访问量

    /**
     * Q：使用synchronize方法后耗时太长的原因？
     * A：程序中的request()方法使用了synchronize关键字修饰，保证了并发情况下，request方法同时刻只能有一个线程进入，request方法加锁相当于串行执行了
     * count的结果与我们预期一致，但是耗时过长
     *
     * Q：如何解决耗时过长的问题？
     * A：count++操作实际上是由3步来完成的！（可以参考JVM执行引擎）
     *      1.获取count的值，记为A：A=count
     *      2.将A的值+1，获得B：B=A+1
     *      3.将B的值赋值给count
     *      修改上述第3步，将锁加到第三步：
     *          #1.获取锁
     *          #2.获取count最新的值，记为LV
     *          #3.判断LV是否等于A，如果相等，则将B的值赋值给count，并返回true；否则，返回false（为false时，再去获取count，再去判断）
     *          #4.释放锁
     */
    //模拟访问的方法
    public synchronized static void request() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(5);//模拟延时5毫秒
        /**
         * Q：分析一下问题出现在那儿？（总访问次数不等于1000）
         * A：count++操作实际上是由3步来完成的！（可以参考JVM执行引擎）
         *      1.获取count的值，记为A：A=count
         *      2.将A的值+1，获得B：B=A+1
         *      3.将B的值赋值给count
         *
         * 如果有A、B两个线程同时执行count++，他们同时执行到上面步骤的第一步，得到的count是一样的，3步操作完成之后，count只加1，导致count结果不正确！
         *
         * Q：怎么解决结果不正确的问题？
         * A：对count++操作的时候，我们让多个线程排队处理，多个线程同时到达request()方法时，只允许一个线程进入操作，其他线程在方法外等候，等待前一个线程
         * 处理结束之后，其他线程再进入，这丫昂操作得到的count++就是排队进行的，结果一定是正确的。
         *
         * Q：怎么实现排队效果？
         * A：Java中的synchronize关键字和ReetrantLock都可以实现对资源加锁，保证并发正确性，多线程情况下可以保证被锁住的资源被串行访问。
         */
        count++;//如果我们尝试将synchronized关键字加在count属性上，而不是放在request()方法上，可以大大降低耗时
    }

    public static void main(String[] args) throws Exception{
        long startTime = System.currentTimeMillis();//业务计时开始时间
        int threadSize = 100;

        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        for (int i = 0; i < threadSize; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //for循环模拟用户行为，每个用户访问10次网站
                        for (int j = 0; j < 10; j++) {
                            request();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        countDownLatch.countDown();
                    }
                }
            });
            thread.start();
        }
        countDownLatch.await();//怎么保证100个线程结束之后，再执行后面的代码？
        
        long entTime = System.currentTimeMillis();
        System.out.println(Thread.currentThread().getName()+" 耗时："+(entTime-startTime)+" count："+count);//业务结束时间，总耗时
    }
}
