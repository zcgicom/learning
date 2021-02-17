package com.itcat.leetcode;

/**
 * 转变日期格式 -- 给你一个字符串 date ,它的格式为 Day Month Year,请你将字符串转变为 YYYY-MM-DD 的格式
 * Day集合 {“1st”, “2nd”, “3rd”, “4th”, …, “30th”, “31st”}
 * Month集合{“Jan”, “Feb”, “Mar”, “Apr”, “May”, “Jun”, “Jul”, “Aug”, “Sep”, “Oct”, “Nov”, “Dec”}
 * 示例 1：
 * 输入：date = “20th Oct 2052”
 * 输出：“2052-10-20”
 *
 * 示例 2：
 * 输入：date = “6th Jun 1933”
 * 输出：“1933-06-06”
 */
public class reformatDate {
    public static void main(String[] args) {
        String str = "12th Oct 2052";
        System.out.println(reformatDate(str));
    }
    public static String reformatDate(String string){
        if(string == null||string.length() == 0) return "";
        String[] str = string.split(" ");
        char[] days = str[0].toCharArray();
        String month = str[1];
        String day = "";
        for (char c :days) {//把日期内的数字取出，丢弃字符“th”
            if (Character.isDigit(c)){
                day += c;
            }
        }
        if (day.length() < 2){//格式化日期格式，如果日期长度小于2，则其前加0
            day = "0" + day;
        }
        String [] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String mon = "";
        for (int i = 0; i < months.length; i++) {//查找月份
            if (month.equals(months[i])){
                mon += i + 1;//月份为索引+1
                break;
            }
        }
        if (mon.length() < 2){
            mon = "0" + mon;
        }
        return str[2] + "-" + mon + "-" + day;
    }
}
