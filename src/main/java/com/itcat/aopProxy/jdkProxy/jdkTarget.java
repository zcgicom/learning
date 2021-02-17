package com.itcat.aopProxy.jdkProxy;

/**
 * 目标类 -- jdk代理模式
 */
public class jdkTarget implements jdkService{
    private Integer pay;

    public jdkTarget(Integer pay) {
        this.pay = pay;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }

    @Override
    public Integer rentPay() {
        System.out.println("租房计费(jdk代理)...");
        return getPay();
    }
}
