package com.itcat;

/**
 * JZ12 - 数值的整数次方
 */
public class TestPow {
    public static void main(String[] args) {
        int exponent = -3;
        double base = 2;
        System.out.println(Power1(base,exponent));
        System.out.println(Power2(base,exponent));

        Integer i1 = -128;
        int i2 = -128;
        Integer i3 = Integer.valueOf(-128);
        Integer i4 = new Integer(-128);

        System.out.println(i3==i4);
        System.out.println(i1==i3);
        System.out.println(i1==i2);
    }
    //
    public static double Power1(double base, int exponent) {
        double temp = 1;
        if(base == 0){return 0;}
        if(exponent == 0){return 1;}
        if(base != 0&&exponent != 0){
            return (double)Math.pow(base,exponent);
        }
        return temp - 1;
    }
    //
    public static double Power2(double base, int exponent) {
        double result = base;
        int n = exponent;
        if (exponent < 0) {
            exponent = - exponent;
        }
        else if(exponent == 0) {
            return 1;
        }
        for (int i = 1; i < exponent; i++) {
            result *= base;
        }
        return n < 0 ? 1 / result : result;
    }
}
