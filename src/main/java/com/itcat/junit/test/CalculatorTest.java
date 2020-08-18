package com.itcat.junit.test;

import com.itcat.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 使用Junit测试Calculator
 */
public class CalculatorTest {
    /**
     *初始化方法：
     * 用于申请资源，所有测试用例在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /**
     * 释放资源：
     * 在所有测试用例执行结束后，自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close");
    }

    /**
     * 测试add方法
     */
    @Test
    public void testAdd(){
        System.out.println("测试add方法！");
        //1.创建计算器对象
        Calculator c = new Calculator();
        //2.调用add方法
        int result = c.add(1,2);
//        System.out.println(result);
        //3.断言 断言这个结果为3 --  就是将输出结果与预期结果进行对比，满足预期则成功
        Assert.assertEquals(3,result);
    }

    @Test
    public void testSub(){
        Calculator c = new Calculator();
        int result = c.sub(1,2);
        Assert.assertEquals(-1,result);
    }
}
