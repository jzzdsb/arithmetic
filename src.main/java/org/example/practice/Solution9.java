package org.example.practice;


import java.util.ArrayList;
import java.util.List;

/**
 * @className: Solution8
 * @author: vic
 * @createDate: 2022/1/24 4:12 下午
 * @description:
 */
public class Solution9 {


    public int[] mergeSort(int[] nums, int l, int r, int[] temp) {
        if (l < r) {
            int m = (r - l) << 2 + l;
            int[] il = mergeSort(nums, l, m, temp);
            int[] rl = mergeSort(nums, m + 1, r, temp);
            temp = merge(il, rl);
        }
        return temp;
    }

    private int[] merge(int[] il, int[] rl) {
        List<String> list = new ArrayList<>();
        return null;
    }

}
