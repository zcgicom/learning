package com.itcat.traceBack;

public class TraceBackTree {

    private Node _root;
    private int _depth;


    private int[] _a;
    private int _m;


    public TraceBackTree(Node root,int depth,int[] a,int m){
        this._root = root;
        this._depth = depth;
        buildBTree();
        this._a = a;
        this._m = m;
    }

    /*
     * 构建解空间数据结构，题目所需要的是一个满三叉树。
     */
    private void buildBTree(){

        this._root.setLNode(createNode(1,2));
        this._root.setMNode(createNode(0,2));
        this._root.setRNode(createNode(-1,2));

    }

    private Node createNode(int data,int depth){

        if (depth <= this._depth){
            Node n = new Node(data,depth);
            n.setLNode(createNode(1,depth + 1));
            n.setMNode(createNode(0,depth + 1));
            n.setRNode(createNode(-1,depth +1));
            return n;
        }else{
            return null;
        }
    }

    /*
     * 按照根节点，左子节点，中子节点，右子节点的顺序对数进行遍历，打印所有节点。
     */
    public void preOrderTraverse(){
        preOrderTraverse(this._root);
    }

    private void preOrderTraverse(Node n){
        if (n != null){
            printNode(n);
            preOrderTraverse(n.getLNode());
            preOrderTraverse(n.getMNode());
            preOrderTraverse(n.getRNode());
        }
    }

    private void printNode(Node n){
        System.out.print(n.getData() + " ");

    }
    /*
     *回溯法求所有解。
     */
    public void backTrace(int[] a,int m){

        int[] x = new int[this._depth - 1]; //定义存储解向量的数组。该数组长度与题目给定的数组长度相等。
        backTrace(this._root,x);

    }
    private void backTrace(Node n,int[] x){
        if (n.getDepth() > 1) x[n.getDepth() - 2] = n.getData(); //将节点值付给解向量数组。

        if (constraints(x,n.getDepth() - 2)){
            printSolution(x,n.getDepth() - 2);
        }
        if (n.getLNode() != null)
            backTrace(n.getLNode(),x);
        if (n.getMNode() != null)
            backTrace(n.getMNode(),x);
        if (n.getRNode() != null)
            backTrace(n.getRNode(),x);
    }
    /*
     * 检查目前解向量是否满足题目要求，就和等于指定值。
     */
    private boolean constraints(int[] x,int boundary) {
        int sum = 0;
        for (int i=0;i<= boundary;i++){
            sum += _a[i] * x[i];
        }
        return (sum == _m && x[boundary] != 0);
    }


    private void printSolution(int[] x,int boundary) {
        for (int i =0;i<= boundary;i++){
            if (x[i] == 1){
                System.out.print("+"+ _a[i]);
            }else if (x[i] == 0){

            }else if (x[i] == -1){
                System.out.print("-" + _a[i]);
            }
        }

        System.out.println("=" + this._m);
    }

    public static void main(String[] args){
        int[] a = {5,4,6,7,1};
        int m = 9;
        //创建的数的深度为给定数组的长度加一
        TraceBackTree bt = new TraceBackTree(new Node(1,1),a.length + 1,a,m);
        //按照根节点，左子节点，中子节点，右子节点的顺序对数进行遍历，打印所有节点。
        // bt.preOrderTraverse();

        bt.backTrace(a,m);
    }
}
