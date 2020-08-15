package com.itcat.binaryTree;

/**
 * 定义二叉树的实现接口
 */
public interface BinaryTree {
    /**
     * 是否为空树
     * @return
     */
    public boolean isEmpty();

    /**
     * 树节点的数量
     * @return
     */
    public int size();

    /**
     * 获取树的深度
     * @return
     */
    public int getHeight();

    /**
     * 前序遍历 - 递归操作
     */
    public void preOrderTraverse();

    /**
     * 中序遍历 - 递归操作
     */
    public void inOrderTraverse();

    /**
     * 后序遍历 - 递归操作
     */
    public void postOrderTraverse();

    /**
     * 序列化二叉树
     * 采用前序遍历序列化
     * 序列化时通过 某种符号表示空节点（#），以！表示一个结点值的结束（value!）
     */
    public  String SerializeBinary();
    /**
     * 反序列化二叉树
     */
    public  Node DeserializeBinary();
}
