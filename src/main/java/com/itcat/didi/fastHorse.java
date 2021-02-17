package com.itcat.didi;

public class fastHorse {
    /**
     * Created by liud on 2017/8/26.
     */
    public static void main(String[] args) {
        int count = 0;
        /**
         * 25匹赛马，没有秒表，五条跑道。用最少的比赛场次找出三匹跑得最快的马。
         * 关键在于不能一次让25匹马一次跑来比较，一次最多比较5匹马
         * 用分组排除的方式找到最快的三匹马
         */

        /**
         * 假设现在分5个组
         * 每一组都跑,记录下每组最快的3个，并标记排名
         */
        String[] compare_first_1 = {"A1", "A4", "A5", "A2", "A3"};
        String[] compare_first_2 = {"B4", "B5", "B1", "B2", "B3"};
        String[] compare_first_3 = {"C1", "C4", "C5", "C2", "C3"};
        String[] compare_first_4 = {"D2", "D1", "D3", "D4", "D5"};
        String[] compare_first_5 = {"E1", "E2", "E3", "E4", "E5"};
        //5轮比试后的结果
        String[] horses1_first = {"A1", "A2", "A3"};
        String[] horses2_first = {"B1", "B2", "B3"};
        String[] horses3_first = {"C1", "C2", "C3"};
        String[] horses4_first = {"D1", "D2", "D3"};
        String[] horses5_first = {"E1", "E2", "E3"};
        count = 5;
        /**
         * 还剩下15匹马
         * 将每组排名第一的马屁进行比较，选出前三，并标记排名
         */
        String[] compare_two = {"A1", "B1", "C1", "D1", "E1"};
        count += 1;
        /**
         * 找到最快的前3名马屁
         * 根据结果：
         * 可以排除跑的慢的两只队伍（"D1", "E1"所在的队伍）
         */
        //假如A1第一，B1第二，C1第三，就可以排除掉D队所有马屁，以及E1所有马屁
        //则还剩下:

        String[] horses1_num_one = {"A1", "A2", "A3"};
        String[] horses2_num_two = {"B1", "B2", "B3"};
        String[] horses3_num_three = {"C1", "C2", "C3"};
        /**
         * 最快的那匹马假设为 A1，而要找到还剩下两匹快马，我们可以继续排除一些马儿
         * 比如说B3，如果B3是最快的三匹马之一，那么B1、B2比她快，
         * 此时就是 A1、B1、B2、B3则有4匹了，所以可以果断排毒B3
         * 而跑的最慢的C队，我们可以排除C2、C3,依然用反证法，C2是跑的最快的3匹马之一，
         * 那么比它快的则有C1，而B1又比C1快，则至少为A1、B1、C1、C2，也多了，
         * 所以C2排除，自然C3比C2慢，依然排除
         *
         * 此轮比试 得到的结果，A1 为跑的最快的那匹马，剩余没比较的马屁为：
         */
        String[] compare_three = {"A2", "A3", "B1", "B2", "C1"};
        /**
         * 刚好五匹马，一次比较，找到最快的两只，跟A1加起来就是我们要找的最快的那三匹马儿
         */
        count += 1;
        System.out.println(count);
        /**
         * count最后结果为7次
         */
    }
}
