package com.itcat.aopProxy.staticProxy;

/**
 * 代理类 -- 静态代理
 */
public class staticProxy implements staticService{
    private Integer pay;

    public staticProxy(Integer pay) {
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
        staticTarget target = new staticTarget(pay);
        Integer in = target.rentPay();
        return in+100;
    }

}
