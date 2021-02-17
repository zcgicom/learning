package com.itcat;

/**
 * 有个排序后的字符串数组，其中散布着一些空字符串，找出给定字符串的位置
 */
public class mm {
    public static void main(String[] args) {
        String [] ch = {"a","","","b","","","c","d","","","e","",""};
        String target = "d";
//        System.out.println(findPosition(ch,target));
        System.out.println(search(ch,target));
    }
    public static int findPosition(String[] ch,String target){
        if (ch.length == 0||ch == null){
            return -1;
        }
        int left = 0;
        int right = ch.length - 1;
        while (left <= right){
            while ("".equals(ch[left])){
                left++;
            }
            while ("".equals(ch[right])){
                right--;
            }
            int mid = left + ((right - left) / 2);
            while ("".equals(ch[mid])&&mid < right){
                mid++;
            }
            if (ch[mid].equals(target)) return mid;
            if (Integer.parseInt(ch[mid]) - Integer.parseInt(target) > 0){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static int searchR(String[] strings,String str,int first,int last){
        if(first>last) return -1;
        int mid=(first+last)/2;
        if(strings[mid].isEmpty()){
            int left=mid-1;
            int right=mid+1;
            while(true){
                if(left<first&&right>last){
                    return -1;
                }else if(right<=last&&!strings[right].isEmpty()){
                    mid=right;
                    break;
                }else if(left>=first&&!strings[left].isEmpty()){
                    mid=left;
                    break;
                }
                right++;
                left--;
            }
        }
        if(str.equals(strings[mid])){
            return mid;
        }else if(strings[mid].compareTo(str)<0){
            return searchR(strings,str,mid+1,last);
        }else {
            return searchR(strings,str,first,mid-1);
        }
    }
    public static int search(String[] strings,String str){
        if(strings==null||str==null||str==" "){
            return -1;
        }
        return searchR(strings,str,0,strings.length-1);
    }
}
