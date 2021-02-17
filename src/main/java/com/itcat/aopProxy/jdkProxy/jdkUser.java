package com.itcat.aopProxy.jdkProxy;

/**
 *用户类 -- jdk代理模式
 */
public class jdkUser {
    public static void main(String[] args) {
        jdkTarget jdkTarget = new jdkTarget(100);
        jdkService proxyInstance = (jdkService) jdkProxy.getProxyInstance(jdkTarget);
        System.out.println(proxyInstance.rentPay());
    }
}
