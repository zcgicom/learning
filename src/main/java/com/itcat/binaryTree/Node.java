package com.itcat.binaryTree;

/**
 * 定义二叉树的一个节点
 */
public class Node {
    Object val;
    Node left;
    Node right;

    public Node() {
    }

    public Node(Object val) {
        this.val = val;
    }

    public Node(Object val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
