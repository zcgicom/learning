package com.itcat.junit;

/**
 * 计算器(Calculator)类测试类
 * ## Junit单元测试：
 *      * 测试分类：
 *          1.黑盒测试：不需要写代码，给定输入值，看程序是否能够输出期望值
 *          2.白盒测试：需要些代码。关注程序具体的执行流程
 *      * Junit使用：白盒测试
 *          * 步骤：
 *              1.定义一个测试类(测试用例)
 *                  *建议：
 *                      * 测试类名：被测试的类名+Test  -- 如CalculatorTest
 *                      * 包名    ：xxx.xxx.xxx.test   --如com.itcat.test
 *              2.定义测试方法：可以独立运行
 *                  * 建议：
 *                      * 方法名：test+测试的方法名   --如testAdd()
 *                      * 返回值：void                --只需要查看输出结果，不需要返回值
 *                      * 参数列表：空参
 *             3.给方法加“@Test”                    --这样就不需要每一个测试用例，单独写一个main函数了
 *             4.导入Junit依赖
 *          * 判定结果：
 *              * 红色：失败
 *              * 绿色：成功
 *              * 一般我们会使用断言操作来处理结果
 *                  * Assert.assertEquals(预期结果,程序运算结果);
 *          * 补充：
 *              * @Before:  --申请资源
 *                  * 修饰的方法在测试用例执行之前被自动执行
 *              * @After：  --释放资源
 *                  * 修饰的方法在测试用例执行之后被自动执行
 */
public class CalculatorTest {
    public static void main(String[] args) {
        //创建对象
        Calculator c = new Calculator();
        //调用方法
//        int result = c.add(1,2);
//        System.out.println(result);
        int result = c.sub(1,1);
        System.out.println(result);
    }
}
