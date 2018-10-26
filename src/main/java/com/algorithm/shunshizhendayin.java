package com.algorithm;

public class shunshizhendayin {

    private static void meiyiquan(int[][] nums) {
        if (nums == null)
            return;
        int rows = nums.length;
        int columns = nums[0].length;
        int start = 0;
        while (start * 2 < rows && start * 2 < columns) {
            shunshidayin(nums, start);
            start++;
        }
    }

    private static void shunshidayin(int[][] a, int start) {
        int endx = a[0].length - start - 1;// 右边界
        int endy = a.length - 1 - start;// 下边界

        // 打印最上面的行
        for (int i = start; i <= endx; i++) {
            System.out.print(a[start][i] + "\t");
        }

        // 从上到下打印
        if (start < endy) {
            for (int i = start + 1; i <= endy; i++) {
                System.out.print(a[i][endx] + "\t");
            }
        }

        // 从右向左打印
        if (start < endx && start < endy) {
            for (int i = endx - 1; i >= start; i--) {
                System.out.print(a[endy][i] + "\t");
            }
        }

        // 从下到上打印
        if (start < endx && start < endy - 1) {
            for (int i = endy - 1; i >= start + 1; i--) {
                System.out.print(a[i][start] + "\t");
            }
        }

    }

    public static void main(String[] args) {
        int[][] tes = {{1, 2, 3,},
                {4, 5, 6},
                {7, 8, 9},
        };
        meiyiquan(tes);
    }

}