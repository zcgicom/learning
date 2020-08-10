package com.itcat.netease;

/**
 * 考点：Java--多态
 * 口诀：
 * 1.调用成员变量：编译和运行都参考左边。
 * 2.调用成员方法（非静态）：编译看左边，运行看右边
 * 3.调用静态方法：编译和运行都看左边。
 * 题目中第14行代码Alpha a = new Beta();是多态的实现
 * 题目中第15行代码a.f();是调用成员成员方法，满足口诀第2条，编译看左边，运行看右边，编译阶段看左边，Alpha接口中含有f()方法，所以编译通过，运行时看右边，所以调用的是Beta类中的f()方法，所以输出Beta.f();
 * 题目中第16行代码a.getClass().getName()中的a.getClass()同理运行调用的是Beta类的Object父类的本地方法public final native Class<?> getClass();，得到Beta类的Class对象，最后再调用Class类中的public String getName()方法，最后输出Beta;
 * 题目中第18行代码Beta b = (Beta)a;向下转型为Beta类对象，所以可以直接调用Beta类的g()方法，最后输出Beta.g()。
 */
public class TestMultiStates {
    public static void main(String[] args) {
        Alpha a = new Beta();
//        a.f();
        System.out.println(a.getClass().getName());
        try {
            Beta b = (Beta)a;
            b.g();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
interface Alpha {
    void f();
}
class Beta implements Alpha {

    public void f() {
        System.out.println("Beta.f()");
    }
    public void g() {
        System.out.println("Beta.g()");
    }
}
