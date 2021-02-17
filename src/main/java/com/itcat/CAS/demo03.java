package com.itcat.CAS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 在count第三步的赋值操作上加锁实现该需求 -- 结果和耗时满足预期
 *
 * 主要内容：
 * 1.从网站计数器实现中一步步引出CAS操作
 * 2.介绍JAVA中的CAS以及CAS可能存在的问题
 * ===========================================================
 * 需求：假设我们开发了一个网站，需要对访问量进行统计，用户每发送一次请求，访问量+1，如何实现？
 *      模拟100个人同时访问，并且每个人对网站发起10次请求，最后访问量应该为1000次。
 */
public class demo03 {
    volatile static int count = 0;//总访问量
    // volatile保证多线程时，该变量是可见性的，线程获取该值时会去主存中获取，而不是获取当前线程中的缓存值

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
     *
     * Q：CAS实现原理是什么？
     * A：CAS通过调用JNI(Java Native Interface)实现。而compareAndSwapxxx系列的方法就是借助“C语言”来调用CPU底层指令实现的。以常用的Intel x86平台
     * 来说，CAS最终映射到CPU的指令为“cmpxchg”，这就是一个原子指令，CPU执行此命令时，实现比较并交换操作。
     *
     * Q：现代计算机动辄上百核心，cmpxchg怎么保证多核心下的线程安全？
     * A：系统底层进行CAS操作时，会判断系统是否多核心，若为多核心则会给“总线”加锁，只有一个线程会对总线加锁成功，加锁成功后会执行CAS操作，也就是说
     * CAS的原子性是平台级别的。
     *
     * Q：CAS存在的问题？
     *      1.ABA问题
     *      2.当线程获得的期望值与原来的值不一致时，返回false，会造成自旋循环一直进行
     */
    //模拟访问的方法
    public static void request() throws InterruptedException {
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
         * 处理结束之后，其他线程再进入，这样操作得到的count++就是排队进行的，结果一定是正确的。
         *
         * Q：怎么实现排队效果？
         * A：Java中的synchronize关键字和ReetrantLock都可以实现对资源加锁，保证并发正确性，多线程情况下可以保证被锁住的资源被串行访问。
         */
//        count++;
        int expectCount;//期望值
        while (!compareAndSwap(expectCount = getCount(),count + 1)){}
    }

    /**
     * @param expectCount 期望值
     * @param newCount  需要赋值给count赋值的+1后的count值
     * @return 赋值成功返回true，否则返回false
     */
    public synchronized static boolean compareAndSwap(int expectCount,int newCount){//CAS
        //判断count当前值是否和期望值expectCount一致，若一致，将newCount赋值给count
        if (getCount() == expectCount){
            count = newCount;
            return true;
        }
        return false;
    }
    public static int getCount(){//获取count的值
        return count;
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
