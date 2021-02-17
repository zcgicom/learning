package com.itcat.nowCoder;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟商品超卖 -- 多线程
 */
public class overSell {
    //库存数（AtomicInteger原子操作）
    public static AtomicInteger stockNum = new AtomicInteger(1000);
    //订单数
    public static AtomicInteger orderNum = new AtomicInteger(0);

    //获取库存
    public static int getStockNum() {
        try {
            //模拟运行耗时
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return stockNum.get();
    }

    //更新库存+i，i<0时表示减库存
    public static int updateStockNum(int i) {
        try {
            //模拟运行耗时
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //返回当前库存数
        return stockNum.addAndGet(i);
    }

    //添加订单+1
    public static int insertOrder() {
        try {
            //模拟运行耗时
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return orderNum.addAndGet(1);
    }

    public static void main(String[] args) throws InterruptedException {
        //简单模拟1100个人并发抢购
        for (int i = 0; i < 1100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    //查询库存
                    int stockNum = getStockNum();
                    if (stockNum <= 0) {
                        System.out.println("售罄！！！");
                    } else {
                        //减库存
                        updateStockNum(-1);
                        //添加订单
                        insertOrder();
                    }
                }
            }).start();
        }
        Thread.sleep(5 * 1000);
        System.out.println("最终下单数：" + orderNum.get()+" , 库存数："+stockNum.get());
    }
}
