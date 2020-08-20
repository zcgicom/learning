package com.itcat;

import java.util.ArrayList;
import java.util.Arrays;

public class TestUndo {
    public static void main(String[] args) {
        String str = "  Hello Undo      Redo World";
        System.out.println(str.trim());
        String[] s = str.trim().split("[ ,\t]");
        System.out.println(Arrays.toString(s));
        getN(s);
    }
    public static String getN(String [] strs){
        ArrayList<String> arrayList = new ArrayList<String>();
//        for (int i = 0; i < strs.length; i++) {
//            arrayList.add(strs[i]);
//        }
        String cmd = strs[0];
        arrayList.add(cmd);
        for (int i = 1; i < strs.length-1; i++) {
            if(strs[i].equals("Undo")){
                arrayList.remove(i-1);
                continue;
            }
            if(strs[i].equals("Redo")){
                arrayList.add(cmd);
                continue;
            }
            cmd = strs[i];
            arrayList.add(cmd);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
        return " ";
    }
}
