package com.itcat.test;


public class test {
    public static void main(String[] args) {
       String a = "hello i love java";
        System.out.println(43%3 == 1);
    }
    public static void test(){
        byte c = (byte)(1 << 29) - 1;
        System.out.println(c);
        String str = "goodsDao";
        System.out.println(str.substring(0,1).toUpperCase()+str.substring(1));
    }

}
class Test1 {
    public static int a = 0;
    static {// Step 1
        a = 10;
        System.out.println("静态代码块在执行a=" + a);
    }

    {// Step 4
        a = 8;
        System.out.println("非静态代码块（构造代码块）在执行a=" + a);
    }

    public Test1() {
        this("调用带参构造方法1，a=" + a); // Step 2
        System.out.println("无参构造方法在执行a=" + a);// Step 7
    }

    public Test1(String n) {
        this(n, "调用带参构造方法2，a=" + a); // Step 3
        System.out.println("带参构造方法1在执行a=" + a); // Step 6
    }

    public Test1(String s1, String s2) {
        System.out.println(s1 + "；" + s2);// Step 5
    }

    public static void main(String[] args) {
        Test1 t = null;// JVM加载Test类，静态代码块执行
        System.out.println("下面new一个Test实例：");
        t = new Test1();
    }
}

class Test2 {
    /**
     * 大数乘法
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param s string字符串 第一个整数
     * @param t string字符串 第二个整数
     * @return string字符串
     */
    public static String solve (String s, String t) {
        // write code here
        if(s.length() == 0||t.length() == 0)return "";
        int[] res = new int[s.length() + t.length()];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=t.length()-1;j>=0;j--){
                res[i+j+1] += (s.charAt(i) - '0')*(t.charAt(j) - '0');
            }
        }
        int val = 0;
        int mod = 0;
        String str = "";
        for(int i=res.length-1;i>0;i--){
            val = res[i] / 10;
            mod = res[i] % 10;
            res[i] = mod;
            res[i-1] = res[i-1]+val;
        }
        for (int i = 0; i < res.length; i++) {
            str += res[i];
        }
        return res[0] == 0? str.substring(1):str;
    }

    public static void main(String[] args) {
        System.out.println(solve("11","99"));
    }
}