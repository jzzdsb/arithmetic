package org.example.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @className: Solution
 * @author: vic
 * @createDate: 2022/1/18 12:25 上午
 * @description:
 */
public class Solution1 {

    /**
     * @return : java.util.List<java.lang.String>
     * @author : vic
     * @description :数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 1 <= n <= 8
     * @createDate : 2022/1/19 2:21 下午
     * @params : [n]
     **/
    public static List<String> generateParenthesis(int n) {

        Character l = '(', r = ')';

        //暂存集合、结果结果
        List<String> temp = new ArrayList<String>() {{
            add("()");
        }};

        if (n == 1) return temp;
        //动态规划，确认返回数组，状态转换方程
        for (int i = 1; i < n; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < temp.size(); j++) {
                String s1 = temp.get(j);
                int index = 0;
                //括号中增加
                while (true) {
                    StringBuffer s = new StringBuffer(s1);
                    index = s1.indexOf(l, index);
                    if (index == -1) break;
                    index++;
                    s.insert(index, "()");
                    list.add(s.toString());
                }

                index = 0;
                //右边增加
                while (true) {
                    StringBuffer s = new StringBuffer(s1);
                    index++;
                    index = s1.indexOf(r, index);
                    if (index == -1) break;
                    s.insert(index, "()");
                    list.add(s.toString());
                }
            }
            temp.clear();
            temp.addAll(list);
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateParenthesis(3).toArray()));
    }
}
