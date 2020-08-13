package com.itcat.binaryTree;

/**
 * 接口实现类
 */
public class LinkedBinaryTree implements BinaryTree {
    private Node root;//代表根节点，不是根节点，是指向根节点的
    private int size;//树的节点数量

    public LinkedBinaryTree() {
    }

    public LinkedBinaryTree(Node root) {
        this.root = root;
    }

    public LinkedBinaryTree(Node root, int size) {
        this.root = root;
        this.size = size;
    }

    public boolean isEmpty() {
        return isEmpty(root);
    }

    private boolean isEmpty(Node root) {
        return root == null ? true : false;
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null){
            size = 0;
        }else {
            size = size(root.left) + size(root.right) + 1;
        }
        return size;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(Node root) {
        if(root == null){
            return 0;
        }else {
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            return leftHeight > rightHeight ? leftHeight+1 : rightHeight+1;
        }
    }

    public void preOrderTraverse() {
        System.out.println("先序遍历");
        preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(Node root) {
        if (root != null){//递归的结束条件
            //输出根的val
            System.out.printf(root.val+"\t");
            //对左子树进行先序遍历
            preOrderTraverse(root.left);
            //对右子树进行先序遍历
            preOrderTraverse(root.right);
        }
    }

    public void inOrderTraverse() {
        System.out.println("中序遍历");
        inOrderTraverse(root);
        System.out.println();
    }

    private void inOrderTraverse(Node root) {
        if (root != null){
            //遍历左子树
            inOrderTraverse(root.left);
            //输出根节点的值
            System.out.printf(root.val+"\t");
            //遍历右子树
            inOrderTraverse(root.right);
        }
    }

    public void postOrderTraverse() {
        System.out.println("后序遍历");
        postOrderTraverse(root);
        System.out.println();
    }

    private void postOrderTraverse(Node root) {
        if (root != null){
            //遍历左子树
            postOrderTraverse(root.left);
            //遍历右子树
            postOrderTraverse(root.right);
            //输出根节点的值
            System.out.printf(root.val+"\t");
        }
    }
}
