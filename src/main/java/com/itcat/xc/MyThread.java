package com.itcat.xc;

import java.util.Scanner;

public class MyThread extends Thread{
    public MyThread(){
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
 class MainThread{
    public static void main(String[] args) {
        Thread.currentThread().setName("mainThread");
        MyThread myThread = new MyThread();
        myThread.setName("myThread");
        myThread.start();
        Scanner sc = new Scanner(System.in);
        String [] str = null;
        str = sc.nextLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}
