package com.algorithm.string;

import org.junit.Test;

/**
 * @author wxweven
 * @date 2019/2/16
 */
public class StringToInt {
    @Test
    public  void  test(){
        String s = "88i7";
        System.out.println(stringToInt(s));
    }
    public static int stringToInt(String s){
        if(s == null || s.length() ==0)
            return 0;
        char[] arr = s.toCharArray();
        int temp = 0;
        if(arr[0] == '-'){
            temp = 1;
        }
        int res = 0;
        int mutil = 1;
        for(int i=arr.length-1; i>=temp;i--){
            if((arr[i]-48)>=0 && (arr[i]-48)<=9){
                res += (arr[i]-48)*mutil;
                mutil *= 10;
            }else{
                return 0;
            }

        }
        if (temp == 1){
            res = -res;
        }
        return res;
    }
}
