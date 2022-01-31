package org.example.practice;


/**
 * @className: Solution8
 * @author: vic
 * @createDate: 2022/1/24 4:12 下午
 * @description:
 */
public class Solution8 {


    public static void main(String[] args) {
        //System.out.println(compare(432,43243));
        System.out.println(largestNumber(new int[]{432,43243}));
        //System.out.println(largestNumber(new int[]{3, 30}));
    }

    /**
     * @return : java.lang.String
     * @author : vic
     * @description :给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
     * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
     * @createDate : 2022/1/24 4:19 下午
     * @params : [nums] ex:[3,30,34,5,9]
     **/
    public static String largestNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuffer stringBuffer = new StringBuffer();
        for (int num : nums) {
            stringBuffer.append(num);
        }
        return stringBuffer.toString();
    }

    /**
     * @return : void
     * @author : vic
     * @description :快排
     * @createDate : 2022/1/24 4:21 下午
     * @params : [nums, left, right]
     **/
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int index = nums[left], low = left, higth = right, temp;

        while (low < higth) {

            while (low < higth && compare(index, nums[higth])) {
                higth--;
            }

            while (low < higth && !compare(index, nums[low])) {
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

    /**
     * @return : boolean
     * @author : vic
     * @description : 特定的比较规则
     * @createDate : 2022/1/24 4:41 下午
     * @params : [a, b]
     **/
    public static boolean compare(int a, int b) {

        char[] charA = (a + "").toCharArray();
        char[] charB = (b + "").toCharArray();
        int lengthA = charA.length, lengthB = charB.length;
        for (int i = 0; i < (Math.max(lengthA, lengthB)) * 2; i++) {
            if (charA[i % lengthA] != charB[i % lengthB]) {
                return charA[i % lengthA] > charB[i % lengthB];
            }
        }

        return lengthA > lengthB;
    }

}
