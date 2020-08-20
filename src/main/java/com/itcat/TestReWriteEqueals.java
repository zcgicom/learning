package com.itcat;

import java.util.HashSet;

/**
 * 重写hashSet的equals方法
 */
public class TestReWriteEqueals {
    public static class Person {
        private String name;
        private int age;
        private double salary;

        @Override
        public int hashCode() {
            return name.hashCode();//重写equals方法时，也要重写hashCode方法
        }

        @Override
        public boolean equals(Object obj) {
            Person p = (Person)obj;//这里传入的obj对象的name和this的name相同则返回true，否则为false
            return p.name == this.name ? true : false;
        }
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "pwz";//如果p1和p2的name相同，则认为添加的Person是同一个对象
        p1.age = 17;
        p1.salary = 200;
        Person p2 = new Person();
        p2.name = "pwz1";
        p2.age = 17;
        p2.salary = 200;
        HashSet<Person> set = new HashSet<Person>();
        set.add(p1);
        set.add(p2);
        for (Person p:set){
            System.out.println(p.name);
        }
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
    }
}
