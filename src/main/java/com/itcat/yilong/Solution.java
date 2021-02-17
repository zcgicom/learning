package com.itcat.yilong;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(-1);//定义一个虚拟节点
        ListNode tmp=node;//tmp标记此虚拟节点

        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                tmp.next=l1;
                l1=l1.next;
                tmp=tmp.next;
            }else{
                tmp.next=l2;
                l2=l2.next;
                tmp=tmp.next;
            }
        }

        if(l1!=null){
            tmp.next=l1;
        }
        if (l2!=null){
            tmp.next=l2;
        }
        return node.next;//返回除虚拟节点的链表
    }

    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(1);
        ListNode l1_2 = new ListNode(2);
        ListNode l1_3 = new ListNode(4);
        l1_1.next=l1_2;
        l1_2.next=l1_3;

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(3);
        ListNode l2_3 = new ListNode(4);
        l2_1.next=l2_2;
        l2_2.next=l2_3;

        Solution solution = new Solution();
        ListNode mergeTwoLists = solution.mergeTwoLists(l1_1, l2_1);
        ListNode temp=mergeTwoLists;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }
}

