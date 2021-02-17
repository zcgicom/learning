package com.itcat.aopProxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理类 -- jdk代理模式
 * 问题一：如何根据加载到内存中的被代理类，动态创建一个代理类及其对象
 * 问题二：当通过代理类的对象调用方法时，如何动态调用被代理类中的同名方法
 */
public class jdkProxy{
    //调用此方法，返回一个代理类对象，解决问题一
    public static Object getProxyInstance(Object obj){//obj：被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);//将被代理对象绑定到handler，即将obj传入handler
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}
class MyInvocationHandler implements InvocationHandler{
    private Object obj;//需要使用被代理类的对象进行赋值
    public void bind(Object obj){
        this.obj = obj;
    }
    /**
     * 当我们通过代理类的对象，调用方法(被代理对象的方法)时，就会自动调用如下的方法：invoke()
     * 将被代理类要执行的方法的功能就声明在invoke方法中
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:即为代理类对象调用的方法
        //obj：被代理类的对象
        Object res = method.invoke(obj,args);
        //被代理对象调用方法的返回值
        return res;
    }
}
