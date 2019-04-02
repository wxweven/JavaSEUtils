package com.algorithm.string;

import org.junit.Test;

/**
 * @author wxweven
 * @date 2019/2/18
 */
public class ReverseString {
    @Test
    public void test(){
        System.out.println(reverseWords("www toutiao com"));
    }
    public static String reverseWords(String s){
        String[] str=s.split(" ");
        for(int i=0;i<str.length;i++) str[i]=new StringBuilder(str[i]).reverse().toString();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length;i++){
            if(i==0){
                sb.append(str[i]);
            }else {
                sb.append(" ").append(str[i]);
            }
        }
        return sb.toString();
    }
}
