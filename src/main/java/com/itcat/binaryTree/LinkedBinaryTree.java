package com.itcat.binaryTree;

/**
 * 接口实现类
 */
public class LinkedBinaryTree implements BinaryTree {
    private Node root;//代表根节点，不是根节点，是指向根节点的
    private int size;//树的节点数量
    private String str;//经过序列化生成的二叉树字符串

    public LinkedBinaryTree() {
    }

    public LinkedBinaryTree(Node root, int size, String str) {
        this.root = root;
        this.size = size;
        this.str  = str;
    }

    public LinkedBinaryTree(Node root, String str) {
        this.root = root;
        this.str  = str;
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

    @Override
    public String SerializeBinary() {
        StringBuilder str = new StringBuilder();
        SerializeBinary(root,str);
        return str.toString();
    }

    private void SerializeBinary(Node root,StringBuilder str) {
        if(root != null){
            str.append(root.val + "!");
            SerializeBinary(root.left,str);
            SerializeBinary(root.right,str);
        }else{
            str.append("#!");
        }

    }

    @Override
    public Node DeserializeBinary() {
        return DeserializeBinary(str);
    }

    private Node DeserializeBinary(String str) {
        if(str.length() == 0){
            return null;
        }
        String[] strs = str.split("!");
        return DeserializeBinary(strs);
    }
    int index = -1;
    private Node DeserializeBinary(String[] strs) {
        index++;
        if(index == strs.length){
            return null;
        }
        if(!strs[index].equals("#")){
            Node head = new Node();
            head.val = Integer.parseInt(strs[index]);
            head.left = DeserializeBinary(strs);
            head.right = DeserializeBinary(strs);
            return head;
        }
        return null;
    }

}
