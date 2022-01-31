package org.example.practice;

import java.util.Arrays;

/**
 * @className: Solution3
 * @author: vic
 * @createDate: 2022/1/19 10:44 下午
 * @description:
 */
public class Solution3 {

    /**
     * @return : void
     * @author : vic
     * @description :
     * @createDate : 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
     * <p>
     * 快排，从小到大
     * @params : [nums]
     **/
    public void sortColors(int[] nums) {

    }

    public static void quickSort(int[] nums, int left, int right) {

        if (left >= right) return;

        int num = nums[left], low = left, higth = right, temp;

        //不能等于
        while (low < higth) {
            //大的放右边
            while (low < higth && num <= nums[higth]) {
                higth--;
            }
            //小的放左边
            while (low < higth && num >= nums[low]) {
                low++;
            }

            temp = nums[higth];
            nums[higth] = nums[low];
            nums[low] = temp;
        }

        nums[left] = nums[low];
        nums[low] = num;
        quickSort(nums, left, low - 1);
        quickSort(nums, low + 1, right);
    }


    public static void main(String[] args) {
        int[] ints = {};
        quickSort(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

}
