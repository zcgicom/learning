package com.itcat.Exams.bilibili;

import java.util.Stack;

public class Valid {
    public static void main(String[] args) {
        String str = "I like apple!";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String str){
        if (str.length() == 0) return true;
        Stack<Character> stack = new Stack<Character>();
        for(Character c:str.toCharArray()){
            if (c == '}'||c == ')'||c == ']'){
                if (c == '}'&& stack.peek() == '{'||c == ')'&&stack.peek() == '('||c == ']'&&stack.peek() == '['){
                    stack.pop();
                    continue;
                }
                return false;
            }
            if (c == '{'||c == '('||c == '['){
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
