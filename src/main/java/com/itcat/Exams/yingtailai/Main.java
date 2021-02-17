package com.itcat.Exams.yingtailai;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Sheep {
    public int age = 1; // 默认一只新羊的年龄为0
}
public class Main {
    public static int getSheeps(int n ,int[] arr,int dead) {
        // sheeps表示整个羊的生态圈
        ArrayList<Sheep> sheeps = new ArrayList<Sheep>();
        sheeps.add(new Sheep());

        List<Sheep> newSheeps = new ArrayList<Sheep>();//待添加到生态圈的新羊
        List<Sheep> deadSheeps = new ArrayList<Sheep>();//待从生态圈删除的羊
        for (int i = 1; i <= n; i++) {
            for (Sheep s : sheeps) {
                for (int j = 0; j < arr.length; j++) {
                    if (s.age==arr[j]) {
                        Sheep temp = new Sheep();
                        temp.age++;
                        newSheeps.add(temp);
                    }
                }
                if (s.age==dead) {
                    deadSheeps.add(s);
                }
                s.age++;
            }
            sheeps.addAll(newSheeps);
            sheeps.removeAll(deadSheeps);
            newSheeps.clear();//清空addSheeps
            deadSheeps.clear();//清空待删除列表中的元素
        }
        return sheeps.size(); // 最后总羊数即羊生态圈中的羊数目
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age1 = sc.nextInt();
        int age2 = sc.nextInt();
        int[] arr = {age1,age2};

        int dead = sc.nextInt();
        int year = sc.nextInt();
        System.out.println(getSheeps(year,arr,dead));
    }
}
