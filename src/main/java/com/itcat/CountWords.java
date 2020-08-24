package com.itcat;

import java.util.*;

/**
 *将字符串中单词按首字母大小排序(不区分大小写)，并打印出现的次数
 */
public class CountWords {
    public static void main(String[] args) {
//        countWords(" Hi, this is first line. This is second line.");
        countWords("I started my career as a programmer");
    }

    public static void countWords(String string) {
        // 正则表达式，获得句子中的单词
        String[] str = string.trim().split("[，。？,.? ]");
        // LinkedHashMap基于链表，可以保证有序;LinkedHashMap相当于HashMap和LinkedList的集合体
//        LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < str.length; i++) {
            if (!("".equals(str[i]))) {//该结束语句等价于!(str[i] == null)
                // 遍历key的集合，判断key（不区分大小写）是否已存在
                Iterator<String> it = map.keySet().iterator();
                // 用来标记key在map集合中是否存在
                boolean exist = false;
                // 遍历key的set集合
                while (it.hasNext()) {
                    String key = it.next();
                    // 如果key已存在，值加1
                    if (key.equalsIgnoreCase(str[i])) {
                        exist = true;
                        map.put(key, map.get(key) + 1);
                    }
                }
                // map中不存在就添加
                if (exist == false) {
                    map.put(str[i], 1);
                }
            }
        }
        //排序
        Set set=map.keySet();
        Object[] arr=set.toArray();
        Arrays.sort(arr);
        for(Object key:arr){
            System.out.println(key+": "+map.get(key));
        }
        System.out.println("======忽略字符大小写进行排序=======");
        for (Object key:sortIngoreCase(map)) {
            System.out.println(key+":"+map.get(key));
        }
    }
    public static List<String> sortIngoreCase(HashMap<String ,Integer> map){
        List<String> list = new ArrayList<String>(map.keySet());//Map转为List
        Collections.sort(list, new Comparator<String>() {//重写排序方法，具体用法参考TestSortIgnoreCase和TestPrintMinNumber文件
            @Override
            public int compare(String o1, String o2) {
                return o1.toUpperCase().compareTo(o2.toUpperCase());
            }
        });
        return list;
    }
}
