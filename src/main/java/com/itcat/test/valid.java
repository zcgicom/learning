package com.itcat.test;

import java.util.Stack;

public class valid {
    public static void main(String[] args) {
        String str = "{()}{}";
        System.out.println(isValid(str));
    }
    public static boolean isValid(String str){
        Stack<Character> st = new Stack<Character>();
        for (char c :str.toCharArray()) {
            if (c == ')'||c == ']'||c == '}'&&!st.isEmpty()){
                if (st.peek() == '('&&c == ')'||st.peek() == '['&&c == ']'||st.peek() == '{'&&c == '}'){
                    st.pop();
                    continue;
                }else {
                    return false;
                }
            }
            st.push(c);
        }
        return st.isEmpty();
    }
}
