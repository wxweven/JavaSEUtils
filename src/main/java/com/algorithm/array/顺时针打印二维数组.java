package com.algorithm.array;

/**
 * 顺时针打印二维数组
 *
 * @author wxweven
 * @date 2018/10/26
 */
public class 顺时针打印二维数组 {

    private static void meiyiquan(int[][] nums) {
        if (nums == null)
            return;
        int rows = nums.length;
        int columns = nums[0].length;
        int start = 0;

        /**
         * 每打印一圈，行和列都会减少2行和2列，所以只需要循环打印 min(rows/2, columns/2) + 1 次即可
         * 比如有4行4列，那么最少循环2次；如果有5行6列，最少3次（奇数除以2除不尽，所以要多一次）
         */
        while (start < Math.min(rows / 2, columns / 2) + 1) {
//        while (start * 2 < rows && start * 2 < columns) {
            printCircle(nums, start);
            start++;
        }
    }

    public static void printCircle(int[][] arr, int start) {
        /**
         *  当前循环中，最大可用的列（最后一列也可以打印）
         *  每循环一次，可用的列减少一次
         *  start从0开始，刚好最大可用的列就是：数组最大列 - 1 - start
         */
        int endCol = arr[0].length - 1 - start;

        /**
         *  当前循环中，最大可用的行（最后一行也可以打印）
         *  每循环一次，可用的行减少一次
         *  start从0开始，刚好最大可用的行就是：数组最大行 - 1 - start
         */
        int endRow = arr.length - 1 - start;

        /**
         * 向右打印：从当前列开始，向右打印，注意最大可用的列也要打印
         */
        for (int i = start; i <= endCol; i++) {
            System.out.print(arr[start][i] + " ");
        }

        /**
         * 向下打印：从当前行的下一行开始，向下打印，注意最大可用的行也要打印
         * 需要注意的是，能够向下打印，说明当前还没有达到最大可用的行，即 start < endRow
         */
        if (start < endRow) {
            // 这时候，列已经达到了最大可用列，行递增即可，直到最大可用行（包括）
            for (int i = start + 1; i <= endRow; i++) {
                System.out.print(arr[i][endCol] + " ");
            }
        }

        /**
         * 向左打印：能够向左打印，说明已经能够向下打印，所以同样要保证：start < endRow
         * 能够向左打印，还说明当前列没有达到最大可用列，即：start < endCol
         * 从当前列的左一列开始，向左打印
         */
        if (start < endRow && start < endCol) {
            // 这时候，行已经达到了最大可用行，列递减即可，直到开始列（包括）
            for (int i = endCol - 1; i >= start; i--) {
                System.out.print(arr[endRow][i] + " ");
            }
        }

        /**
         * 向上打印：能够向上打印，说明已经能够向左打印，所以同样要保证：start < endRow && start < endCol
         * 能够向上打印，还说明当前行和最大可用行之间至少有一个空行，即：start +1 < endRow
         * 结合以上两个条件：start < endRow - 1 && start < endCol
         * 从最后一行的上一行开始，向上打印
         */
        if (start < endCol && start < endRow - 1) {
            // 这时候，列已经达到了开始列，行递减即可，直到开始行（不包括）
            for (int i = endRow - 1; i > start; i--) {
                System.out.print(arr[i][start] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[][] tes = {
                {1, 2, 3, 11, 34},
                {4, 5, 6, 12, 45},
                {7, 8, 9, 13, 56},
        };
        meiyiquan(tes);
        System.out.println();

        int[][] tes2 = {
                {1, 2, 3, 11, 34}
        };
        meiyiquan(tes2);
        System.out.println();

        int[][] tes3 = {
                {1},
                {2}
        };
        meiyiquan(tes3);
        System.out.println();

        int[][] tes4 = {
                {1}
        };
        meiyiquan(tes4);
        System.out.println();
    }
}
