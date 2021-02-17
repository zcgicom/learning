package com.itcat.nowCoder;

import java.util.Stack;

/**
 * 两个栈，右边栈接受元素，左边栈存最小的元素
 * 入栈时，先入右边栈，随后进行比较，左边和右边栈顶元素进行比较，如果新元素小，就把新元素放在左边的栈顶位置，如果新元素大，则还是把左边栈顶元素放在栈顶的位置
 * 出栈时，出的是最后一个入栈元素，所以就是右边的栈出栈
 * 出最小值时，就是左边的栈顶元素出栈
 * 出栈时两个都得出
 */
class mStack {
    static Stack<Integer> left = new Stack<Integer>();//存最小值
    static Stack<Integer> right = new Stack<Integer>();//存增长值

    public mStack() {
    }

    //push]
    public void push(int n){
        right.push(n);
        int min;
        if (!left.isEmpty()&&left.peek() <= n){
            min = left.peek();
        }
    }

    //pop
    public void pop(){
        right.pop();
        left.pop();
    }

    //getMin
    public int getMin(){
        return left.peek();
    }

    //top
    public int top(){
        return right.peek();
    }
}
public class minStack{
    public static void main(String[] args) {
        mStack mStack = new mStack();
        mStack.push(-2);
        mStack.push(0);
        mStack.push(-3);
        System.out.println(mStack.getMin());
        mStack.pop();
        System.out.println(mStack.top());
        System.out.println(mStack.getMin());

    }
}
