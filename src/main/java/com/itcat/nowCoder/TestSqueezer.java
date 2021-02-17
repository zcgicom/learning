package com.itcat.nowCoder;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * TestSqueezer:
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成
 * 任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，
 * 否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class TestSqueezer {
    public static void main(String[] args) {
        int[] list1 = {1,4,0,6,0};
        System.out.println(isContinuous(list1));
        System.out.println(isContinuous1(list1));
        int[] list2 = {1,4,0,5,0};
        System.out.println(isContinuous(list2));

    }
    //主判断函数，返回boolean
    public static boolean isContinuous(int [] numbers) {
        if(numbers.length == 0){return false;}
        Arrays.sort(numbers);//相对数组排序
        int temp = 0;//统计0的个数
        int temp1 = 0;//统计除了0以外，其他元素相差多大
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == 0){
                temp++;
            }
        }
        for(int i=temp;i<numbers.length-1;i++){
            if(numbers[i]+1 != numbers[i+1]){
                if(numbers[i] == numbers[i+1]){ return false;}
                else{
                    temp1 = temp1 + numbers[i+1] - numbers[i] - 1;
                }
            }
        }
        if(temp1 > temp){
            return false;
        }else{
            return true;
        }
    }
    public static boolean isContinuous1(int[] nums){
        if (nums.length != 5) return false;
        Arrays.sort(nums);
        int zindex = 0;
        while (nums[zindex] == 0) zindex++;
        for (int i = zindex+1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) return false;
        }
        return nums[4] - nums[zindex] <= 4;
    }
}
