package com.itcat.mix;

import java.util.Scanner;
import java.util.Stack;

public class Maina {
    public static boolean isValidString(String str){
        Stack<Character> stack = new Stack<Character>();
        for (char ch:str.toCharArray()) {
            if (ch == ')'||ch == ']'||ch == '}'){
                if (stack.peek() == '('&&ch == ')'||stack.peek() == '{'&&ch == '}'||stack.peek() == '['&&ch == ']'){
                    stack.pop();
                    continue;
                }
            }
            stack.push(ch);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            System.out.println(isValidString(sc.next()));

        }
    }
}
