package com.algorithm.sort;

import java.util.Arrays;

public class HeapSort {
    private static int[] arr = new int[]{
            4, 10, 20, 3, 5, 6, 78
    };

    public static void main(String[] args) {
        buildHeap(arr);
        heapSort(arr);
        printArr(arr);
    }

    /**
     * 下沉法创建堆
     *
     * @param data
     */
    private static void buildHeap(int[] data) {
        // 从最后一个节点的父节点开始调整
        int parentIndex = getParentIndex(data.length - 1);

        // 从尾端开始创建最大堆，每次都是正确的堆
        for (int i = parentIndex; i >= 0; i--) {
            sink(data, data.length, i);
        }
    }

    /**
     * 排序，头尾交换，下沉头
     *
     * @paramdata
     */
    private static void heapSort(int[] data) {
        // 末尾与头交换，交换后下沉调整堆
        for (int i = data.length - 1; i > 0; i--) {
            swapArr(data, i, 0);
            sink(data, i, 0);
        }
    }

    private static void printArr(int[] arr) {
        Arrays.stream(arr)
              .forEach(x -> System.out.print(x + " "));
    }

    /**
     * 下沉法创建最小堆
     *
     * @param data
     * @param heapSize 需要创建最小堆的大小，一般在sort的时候用到，因为最多值放在末尾，末尾就不再归入最大堆了
     * @param index    当前需要创建最小堆的位置
     */
    private static void sink(int[] data, int heapSize, int index) {
        int minxIndex = getMinxIndex(data, index, heapSize);

        // 得到最小值下标后可能需要交换，如果交换了，其子节点可能就不是最小堆了，需要重新调整
        if (minxIndex != index) {
            swapArr(data, minxIndex, index);
            sink(data, heapSize, minxIndex);
        }
    }

    /**
     * 交换数组两个元素
     *
     * @param arr
     * @param index1
     * @param index2
     */
    private static void swapArr(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private static int getMinxIndex(int[] arr, int parentIndex, int heapSize) {
        int minIndex = parentIndex;

        int leftIndex = getChildLeftIndex(parentIndex);
        if (leftIndex < heapSize && arr[leftIndex] < arr[parentIndex]) {
            minIndex = leftIndex;
        }

        int rightIndex = getChildRightIndex(parentIndex);
        if (rightIndex < heapSize && arr[rightIndex] < arr[minIndex]) {
            minIndex = rightIndex;
        }

        return minIndex;
    }

    /**
     * 父节点位置
     *
     * @return
     * @paramcurrent
     */
    private static int getParentIndex(int current) {
        return (current - 1) >> 1;
    }

    /**
     * 左子节点position
     *
     * @return
     * @paramcurrent
     */
    private static int getChildLeftIndex(int current) {
        return (current << 1) + 1;
    }

    /**
     * 右子节点position
     *
     * @return
     * @paramcurrent
     */
    private static int getChildRightIndex(int current) {
        return (current + 1) << 1;
    }
}