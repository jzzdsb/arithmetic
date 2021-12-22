package org.example;

import java.util.Arrays;

public class Solution {

    /**
     * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
     * <p>
     * 返回这三个数的和。
     * <p>
     * 假定每组输入只存在恰好一个解。
     * <p>
     * 3 <= nums.length <= 1000
     * -1000 <= nums[i] <= 1000
     * -104 <= target <= 104
     *
     * @param nums   数组
     * @param target 目标值
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        //排序
        Arrays.sort(nums);

        int index = 0, resultSum = 0, result = Integer.MAX_VALUE;

        for (; index < nums.length - 1; index++) {
            int left = index + 1, right = nums.length - 1;
            int sum = nums[left] + nums[index] + nums[right];
            int abs = Math.abs(sum - target);
            if (abs < result) {
                resultSum = sum;
                result = abs;
            }
            while (left < right) {
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return target;
                }
                if (left < right) {
                    sum = nums[left] + nums[index] + nums[right];
                    abs = Math.abs(sum - target);
                    if (abs < result) {
                        resultSum = sum;
                        result = abs;
                    } else {
                        break;
                    }
                }
            }
        }
        return resultSum;
    }

    public static void main(String[] args) {
        int[] is = new int[]{-1, 2, 1, -4};
        System.out.println(threeSumClosest(is, 1));
    }
}
