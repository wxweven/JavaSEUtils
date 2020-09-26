package com.algorithm.sort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 二分查找算法
 *
 * @author wxweven
 * @version 1.0
 * @date 2017年3月7日
 * @email wxweven@qq.com
 * @blog wxweven.com
 * @Copyright: Copyright (c) wxweven 2009 - 2017
 */
public class BinarySearch {
    private static Logger logger = LoggerFactory.getLogger(BinarySearch.class);
    static int[] arr = {10, 55,99, 69, 78, 85};

    public static void main(String[] args) {
        partintion(0,arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }


        int x = 10;
        int pos = binaryFind(0, arr.length - 1, x);

        String res = pos == -1 ? "未找到元素" : "找到元素，下标为" + pos;
        logger.info(res);
    }

    /**
     * 二分查找
     *
     * @param arr   数组
     * @param start 查找开始范围
     * @param end   查找结束范围
     * @param value 被查找的值
     * @return 返回被查找值在数组中的下标
     */
    public static int binarySearch(int[] arr, int start, int end, int value) {
        while (start <= end) {
            int middle = (start + end) / 2;
            int temp = arr[middle];

            if (value < temp) {
                end = middle - 1;
            } else if (value > temp) {
                start = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

    public static void partintion( int left, int right){
        if(left>=right){
            return;
        }


        int low = left;
        int high = right;
        int record = arr[left];

        while(low<high){
            while(low<high && arr[high]>=record){
                high--;
            }

            while(low<high && arr[left]<=record){
                low++;
            }

            if(low<high){
                int tmp = arr[low];
                arr[low]=arr[high];
                arr[high]=tmp;
            }
        }

        arr[left] = arr[low];
        arr[low] = record;

        partintion( left, low-1);
        partintion( low+1, right);
    }


    public static int binaryFind( int left, int right, int num) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) >> 1;

        if (arr[mid] == num) {
            return mid;
        } else if (num < arr[mid]) {
            return binaryFind(left, mid - 1, num);
        } else {
            return binaryFind(mid + 1, right, num);
        }
    }
}
