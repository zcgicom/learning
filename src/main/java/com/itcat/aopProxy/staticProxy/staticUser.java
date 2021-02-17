package com.itcat.aopProxy.staticProxy;

/**
 * 用户类 -- 静态代理
 * 调用代理对象
 */
public class staticUser {
    public static void main(String[] args) {
        staticProxy proxy = new staticProxy(100);
        System.out.println(proxy.rentPay());
        proxy.setPay(200);//修改租金，获得租金200+代理佣金100
        System.out.println(proxy.rentPay());
    }
}
