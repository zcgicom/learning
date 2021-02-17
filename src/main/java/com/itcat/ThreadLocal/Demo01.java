package com.itcat.ThreadLocal;

/**
 * 需求：线程隔离
 *      多线程并发场景下，保证每个线程的变量相互独立
 *      线程A： 设置（变量1）   获取（变量1）
 *      线程B： 设置（变量2）   获取（变量2）
 *
 *      使用Synchronized关键字实现
 */
public class Demo01 {

    //变量
    private String content;

    //new ThreadLocal
    ThreadLocal<String> tl = new ThreadLocal<String>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
        final Demo01 demo = new Demo01();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    /**
                     * 使用synchronized同步代码块实现：每个线程存一个变量，之后去一个变量
                     */
                    synchronized (Demo01.class){
                        demo.setContent(Thread.currentThread().getName() + "的变量！");
                        System.out.println("---------------------------");
                        System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
                    }
                }
            });
            thread.setName("线程" + i); //线程0~4
            thread.start();
        }
    }
}
