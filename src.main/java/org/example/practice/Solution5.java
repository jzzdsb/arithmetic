package org.example.practice;

import java.util.Arrays;

/**
 * @className: Solution5
 * @author: vic
 * @createDate: 2022/1/22 11:44 下午
 * @description:
 */
public class Solution5 {

    //归并倒车入库
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index = nums1.length - 1;

        while (m >= 1 || n >= 1) {
            if (m < 1) {
                nums1[index--] = nums2[--n];
            } else if (n < 1) {
                nums1[index--] = nums1[--m];
            } else {
                nums1[index--] = nums1[m - 1] > nums2[n - 1] ?
                        nums1[--m] : nums2[--n];
            }
        }
    }

}
