package com.itcat;

import java.util.LinkedList;
import java.util.List;

/**
 * JZ4-重建二叉树
 * 题目描述：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class TestRebuildBinaryTree {
    private static int[] arr = new int[]{1,2,3,4,5,6,7};
    private static List<Node> nodeList = null;
    private static class Node{
        Node left;
        Node right;
        int data;
        Node(int newdata){
            left = null;
            right = null;
            data = newdata;
        }
    }
    //新建一个二叉树
    public static void createBintree(){
        nodeList=new LinkedList<Node>();
        for (int nodIndex = 0; nodIndex < arr.length; nodIndex++) {
            nodeList.add(new Node(arr[nodIndex]));
        }
        //
        for (int parentIndex = 0; parentIndex < arr.length/2-1; parentIndex++) {
            //左孩子
            nodeList.get(parentIndex).left =nodeList.get(parentIndex*2+1);
            //右孩子
            nodeList.get(parentIndex).right =nodeList.get(parentIndex*2+2);
        }
        //最后一个父节点，因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex=arr.length/2-1;
        //左孩子
        nodeList.get(lastParentIndex).left =nodeList.get(lastParentIndex*2+1);
        if (arr.length%2==1) {
            nodeList.get(lastParentIndex).right =nodeList.get(lastParentIndex*2+2);
        }
    }
    /**
     * 主函数
     */
    public static void main(String[] args) {
        TestRebuildBinaryTree bintree = new TestRebuildBinaryTree();
        bintree.createBintree();//二叉树创建
        Node root = nodeList.get(0);//获取根节点

        System.out.println("前序遍历：");
        preOrderTraverse(root);
        System.out.println("\n中序遍历：");
        inOrderTraverse(root);
        System.out.println("\n后序遍历：");
        postOrderTraverse(root);

        int[] pre = {1,2,4,7,3,5,6,8};//前序
        int[] in = {4,7,2,1,5,3,8,6};//中序
        String str = reBuildTree(pre,in);
        System.out.println("\n重建后的二叉树：\n"+str);
    }
    //前序遍历
    public static void preOrderTraverse(Node root){
        if(root == null) return;
        System.out.print(root.data+"\t");
        preOrderTraverse(root.left);
        preOrderTraverse(root.right);
    }
    //中序遍历
    public static void inOrderTraverse(Node root){
        if(root == null) return;
        inOrderTraverse(root.left);
        System.out.print(root.data+"\t");
        inOrderTraverse(root.right);
    }
    //先序遍历
    public static void postOrderTraverse(Node root){
        if(root == null) return;
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.data+"\t");
    }
    //重建二叉树
    public static String reBuildTree(int[] pre,int[] in){
        StringBuilder str = new StringBuilder();
        reBuild(pre,in,0,pre.length,0,in.length,str);
        return str.toString();
    }
    public static Node reBuild(int[] pre,int[] in,int pre_left,int pre_right,int in_left,int in_right,StringBuilder str){
        if(pre_left >= pre.length || in_left >= in.length || pre_left > pre_right || in_left > in_right){
            return null;
        }
        int val = pre[pre_left];//保留根节点的值
        int count = in_left;
        Node head = new Node(val);

        while (in[count] != val){//根据前序遍历找到根节点在中序遍历中的位置
            count++;
        }
        count -= in_left;

        head.left = reBuild(pre,in,pre_left+1,pre_left+count,in_left,in_left+count-1,str);
        head.right = reBuild(pre,in,pre_left+count+1,pre_right,in_left+count+1,in_right,str);
        str.append(head.data+"\t");
        return head;
    }
}
