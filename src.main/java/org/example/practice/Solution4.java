package org.example.practice;

import java.util.Arrays;

/**
 * @className: Solution4
 * @author: vic
 * @createDate: 2022/1/22 3:39 下午
 * @description:
 */
public class Solution4 {

    /**
     * @return : int[][]
     * @author : vic
     * @description :以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * @createDate : 2022/1/22 10:04 下午
     * @params : [intervals]
     **/
    public static int[][] merge(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
        int start = intervals[0][0], end = intervals[0][1], index = 0;
        int[][] result = new int[intervals.length][2];

        for (int i = 1; i < intervals.length; i++) {
            if (end >= intervals[i][0]) {
                end = Math.max(end, intervals[i][1]);
            } else {
                result[index][0] = start;
                result[index][1] = end;
                index++;

                start = intervals[i][0];
                end = intervals[i][1];

            }
        }
        result[index][0] = start;
        result[index][1] = end;
        return Arrays.copyOf(result, index + 1);
    }

    public static void quickSort(int[][] nums, int left, int right) {
        if (left >= right) return;
        int low = left, higth = right;
        int[] temp, index = nums[left];
        while (low < higth) {
            while (low < higth && index[0] <= nums[higth][0]) {
                higth--;
            }
            while (low < higth && index[0] >= nums[low][0]) {
                low++;
            }
            temp = nums[higth];
            nums[higth] = nums[low];
            nums[low] = temp;
        }

        nums[left] = nums[low];
        nums[low] = index;
        quickSort(nums, left, higth - 1);
        quickSort(nums, higth + 1, right);
    }

    public static void main(String[] args) {
        //int[][] merge = merge(new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}});
        //int[][] merge = merge(new int[][]{new int[]{1, 4}, new int[]{4, 5}});
        //int[][] merge = merge(new int[][]{new int[]{1, 4}, new int[]{0, 4}});
        int[][] merge = merge(new int[][]{new int[]{1, 4}, new int[]{2, 3}});
        for (int[] ints : merge) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
