package com.itcat.Exams.bilibili;

import java.util.Stack;
/**
 * 括号的有效性
 */
public class test2 {
    public static void main(String[] args) {
        String str = "{}{}";
        System.out.println(isValid(str));
    }
        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<Character>();
            for(Character c : s.toCharArray()){
                if((c==')' || c==']' || c=='}') && !stack.isEmpty()){
                    if((stack.peek()=='('&&c==')') || (stack.peek()=='['&&c==']') || (stack.peek()=='{'&&c=='}')){
                        stack.pop();
                        continue;
                    }
                    return false;
                }
                stack.push(c);
            }
            return stack.isEmpty();
        }
    }
