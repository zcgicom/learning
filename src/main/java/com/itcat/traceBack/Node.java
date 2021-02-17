package com.itcat.traceBack;

/*
 * 构造树节点，包含左子节点，中子节点，和右子节点的引用。以及该节点深度及数据信息。
 */
public class Node {

    private Node _lnode;
    private Node _rnode;
    private Node _mnode;
    private int _data;

    private int _depth;

    public Node(int data,int depth){
        this._data = data;
        this._depth = depth;
    }


    public void setLNode(Node lnode){
        this._lnode = lnode;
    }

    public void setMNode(Node mnode){
        this._mnode = mnode;
    }

    public void setRNode(Node rnode){
        this._rnode = rnode;
    }



    public int getData(){
        return this._data;
    }

    public int getDepth(){
        return this._depth;
    }

    public Node getLNode(){
        return this._lnode;
    }

    public Node getMNode(){
        return this._mnode;
    }

    public Node getRNode(){
        return this._rnode;
    }



}
