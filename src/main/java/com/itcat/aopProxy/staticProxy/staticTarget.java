package com.itcat.aopProxy.staticProxy;

/**
 * 目标类 -- 静态代理
 */
public class staticTarget implements staticService{
    private Integer pay;

    public staticTarget(Integer pay) {
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
        System.out.println("租房计费(静态代理)...");
        return getPay();
    }

    @Override
    public String toString() {
        return "staticTarget{" +
                "pay=" + pay +
                '}';
    }
}
