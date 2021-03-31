package com.itcat.test;

import java.util.*;

/**
 * 转换Map数据，key作为values，values作为key
 * Map<站点id，商品id集合> --> Map<商品id，站点id集合>
 */
public class chrMap {
    public static void main(String[] args) {

        Map<Integer, List<Integer>> map = transList();

        long now = System.currentTimeMillis();//当前时间
        System.out.println(transMap(map));
        System.out.println("耗时：" + (System.currentTimeMillis() - now));//查看耗时
    }

    /**
     * 封装Map对象
     * @return
     */
    public static Map<Integer,List<Integer>> transList(){
        Map<Integer, List<Integer>> map = new HashMap<>();
        List list1 = creatList(2,4,6);
        List list2 = creatList(1,3,2);
        List list3 = creatList(4,5,6);
        List list4 = creatList(2,5,3,7);
        List list5 = creatList(1,4,5,2);

        map.put(1,list1);
        map.put(2,list2);
        map.put(3,list3);
        map.put(4,list4);
        map.put(5,list5);
        return map;
    }

    /**
     * 创建List集合
     * @param x
     * @param y
     * @param z
     * @return
     */
    public static List<Integer> creatList(Integer x,Integer y,Integer z){
        List list = new ArrayList();
        list.add(x);
        list.add(y);
        list.add(z);
        return list;
    }

    /**
     * 重载creatList()函数
     */
    public static List<Integer> creatList(Integer x,Integer y,Integer z,Integer w){
        List list = new ArrayList();
        list.add(x);
        list.add(y);
        list.add(z);
        list.add(w);
        return list;
    }

    /**
     * 转换Map数据
     * @param map
     * @return
     */
    public static Map<Integer,List<Integer>> transMap(Map<Integer,List<Integer>> map) {
        System.out.println(map);
        //获取所有list元素
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= map.size(); i++) {
            list.addAll(map.get(i));
        }

        //利用set集合去重
        HashSet<Integer> set = new HashSet<>();
        set.addAll(list);
        List<Integer> listset = new ArrayList<>(set);
        System.out.println("============================");

        //重新定义Map
        Map<Integer, List<Integer>> res = new HashMap<>();
        for (int i = 0; i < listset.size(); i++) {
            List<Integer> list1 = new ArrayList<Integer>();
            for (int i1 = 1; i1 <= map.size(); i1++) {
                if (map.get(i1).contains(listset.get(i))){
                    list1.add(i1);
                }
            }
            res.put(listset.get(i),list1);
        }
        return res;
    }
}
