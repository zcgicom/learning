package com.itcat.LinkedTable;

/**
 * 链表测试类
 */
public class Test {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5,null);
        ListNode node4 = new ListNode(4,node5);
        ListNode node3 = new ListNode(3,node4);
        ListNode node2 = new ListNode(2,node3);
        ListNode node1 = new ListNode(1,node2);
        ListNode head = new ListNode(0,node1);
        System.out.println(head);
        ReverseList(head);
        System.out.println(head);

    }
    public static ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = null;
        ListNode next = null;
        while(head != null){
            next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
}
