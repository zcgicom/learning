package com.itcat;


import java.util.LinkedList;
import java.util.List;

/**
 * JZ16-合并两个链表
 * 题目描述:
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class TestMergeListNode {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int value){
            val = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {0,2,4,6,8};
        List<ListNode> list1 = creatListNode(arr1);
        List<ListNode> list2 = creatListNode(arr2);
        int count = 0;
        while (count < list2.size()){//查看链表
            System.out.print(list2.get(count).val+"\t");
            count++;
        }
        System.out.println("\n===============================");
        List<ListNode> list = new LinkedList<ListNode>();
        Merger(list1.get(0), list2.get(0),list);
        int index = 0;
        while (index < list.size()){
            System.out.print(list.get(index).val+"\t");
            index++;
        }
    }
    //创建链表
    public static List<ListNode> creatListNode(int[] arr){
        List<ListNode> list = new LinkedList<ListNode>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new ListNode(arr[i]));
        }
        return list;
    }
    //合并两个链表
    public static ListNode Merger(ListNode list1,ListNode list2,List<ListNode> list){
        if(list1 == null)return list2;
        if(list2 == null)return list1;
        if(list1.val <= list2.val){
            list.add(list1);
            list1.next = Merger(list1.next,list2,list);
            return list1;
        } else {
            list.add(list2);
            list2.next = Merger(list1,list2.next,list);
            return list2;
        }
    }
}
