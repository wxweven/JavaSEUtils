package com.algorithm.list;

public class 数组去重 {
    public static void distinct(int[] arr){
        if(arr==null || arr.length <=1){
            return;
        }

        int slow = 0;
        int fast = 1;

        while(fast< arr.length){
          if(arr[slow] != arr[fast]){
              slow++;
              fast++;
          }else {

          }

        }

    }
}
