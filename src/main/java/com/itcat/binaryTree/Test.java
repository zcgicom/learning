package com.itcat.binaryTree;
/**
 * 二叉树测试类
 */
public class Test {
    //王佳晨自增节点计数方法
    static void jiedianshu(Node root , int s ){
        if (root != null) {
            s++;
            jiedianshu(root.left, s);
            jiedianshu(root.right, s);
        }
    }
    public static void main(String[] args) {
        Node node5 = new Node(5);
        Node node4 = new Node(4,null,node5);

        Node node7 = new Node(7);
        Node node6 = new Node(6,null,node7);
        Node node3 = new Node(3);
        Node node2 = new Node(2,node3,node6);
        Node root = new Node(1,node4,node2);

        BinaryTree binaryTree = new LinkedBinaryTree(root);
        //判断树是否为空
        System.out.println(binaryTree.isEmpty());
        //先序遍历
        binaryTree.preOrderTraverse();
        //中序遍历
        binaryTree.inOrderTraverse();
        //后序遍历
        binaryTree.postOrderTraverse();
        //二叉树的深度
        int hegiht = binaryTree.getHeight();
        System.out.printf("二叉树的深度为：%d",hegiht);
        System.out.println();
        //二叉树中节点数量
        System.out.printf("二叉树中节点的数量为：%d",binaryTree.size());
    }
}
