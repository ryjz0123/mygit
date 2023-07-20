package com.Homework;

public class StringReverse {
    public static void main(String[] args) {
        String str = "abcdef";
        String s = null;
        try {
            s = reverse(str,0,7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(s);
    }
    public static String reverse(String str,int start,int end){
        //对输入的参数做验证
        if(!(str != null && start >= 0 && end >= start && end < str.length())){
            throw new RuntimeException("参数不正确");
        }
        char[] ss = str.toCharArray();
        char temp;
//        for (int i = 0; i < (end-start+1)*0.5; i++) {
//            temp = ss[start+i];
//            ss[start+i] = ss[end-i];
//            ss[end-i] = temp;
//        }
//        String s = "";
//        for (int i = 0; i < ss.length; i++) {
//            s += ss[i];
//        }
//        return s;
        int i,j;
        for ( i = start, j = end;i < j;i++,j--){
            temp = ss[i];
            ss[i] = ss[j];
            ss[j] = temp;
        }
        return new String(ss);
    }
}
