package org.example.practice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @className: DailyPractice
 * @author: vic
 * @createDate: 2022/1/14 4:18 下午
 * @description:
 */
public class DailyPractice {

    /**
     * @return : java.lang.String
     * @author : vic
     * @description :最大前缀
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     * @createDate : 2022/1/14 4:19 下午
     * @params : [strs]
     **/
    public static String longestCommonPrefix(String[] strs) {
        //特殊值处理
        if (strs.length == 1) {
            return strs[0];
        }

        //多指针同时动,不相等时停止，停止的位置就是最大长度
        char temp = 0;
        int index = 0;
        boolean key = true;
        w:
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                String str = strs[i];
                if (index >= str.length()) {
                    index--;
                    break w;
                }
                if (i == 0) {
                    temp = strs[i].charAt(index);
                } else {
                    if (temp != strs[i].charAt(index)) {
                        index--;
                        break w;
                    }
                }
            }

            key = false;
            index++;
        }

        return key ? "" : strs[0].substring(0, index + 1);
    }

    /**
     * @return : boolean
     * @author : vic
     * @description :
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * @createDate : 2022/1/14 11:55 下午
     * @params : [s]
     **/
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        //初始化
        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('(', ')');
            put('{', '}');
            put('[', ']');
        }};

        //典型的栈
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (map.get(stack.pop()) != c) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * @return : * @return null
     * @author : vic
     * @description :给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * @createDate : 2022/1/16 4:44 下午
     * @params : * @param: null
     **/
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode h = head, q = head, l = head;
        //快指针先走n点，慢指针再走
        for (int i = 0; i < n; i++) {
            //超过直接跳出
            if (q == null) {
                return null;
            } else {
                q = q.next;
            }
        }

        if (q == null) {
            h = h.next;
            return h;
        }

        //同时往前走
        while (q.next != null) {
            q = q.next;
            l = l.next;
        }

        l.next = l.next.next;
        return h;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        ListNode listNode = removeNthFromEnd(new ListNode(1, new ListNode(2, null)), 2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
