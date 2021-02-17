package com.itcat.ThreadLocal;

/**
 * 需求：线程隔离
 *      多线程并发场景下，保证每个线程的变量相互独立
 *      线程A： 设置（变量1）   获取（变量1）
 *      线程B： 设置（变量2）   获取（变量2）
 *
 *      ThreadLocal：
 *          1.set()：将变量绑定到当前线程中
 *          2.get()：获取当前线程绑定的变量
 */
public class Demo {

    //变量
    private String content;

    //new ThreadLocal
    ThreadLocal<String> tl = new ThreadLocal<String>();

    public String getContent() {
//        return content;

        return tl.get();
    }

    public void setContent(String content) {
//        this.content = content;
        //将变量content绑定到当前线程
        tl.set(content);
    }

    public static void main(String[] args) {
        final Demo demo = new Demo();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    /**
                     * 每个线程存一个变量，之后去一个变量
                     */
                    demo.setContent(Thread.currentThread().getName() + "的变量！");
                    System.out.println("---------------------------");
                    System.out.println(Thread.currentThread().getName() + "--->" + demo.getContent());
                }
            });
            thread.setName("线程" + i); //线程0~4
            thread.start();
        }
    }
}
