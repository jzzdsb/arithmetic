package org.example.practice;

/**
 * @className: Solution
 * @author: vic
 * @createDate: 2022/1/18 12:25 上午
 * @description:
 */
public class Solution {

    public class ListNode {
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

    /**
     * @return : org.example.practice.Solution.ListNode
     * @author : vic
     * @description :将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * @createDate : 2022/1/18 12:26 上午
     * @params : [list1, list2]
     **/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //g构建一个默认头
        ListNode listNode = new ListNode(0, null);
        ListNode head = listNode;

        //两个链表已经有序直接双指针走起
        ListNode o = list1, t = list2;
        while (o != null && t != null) {
            if (o == null && t != null) {
                listNode.next = new ListNode(t.val, null);
                listNode = listNode.next;
                t = t.next;
            } else if (t == null && o != null) {
                listNode.next = new ListNode(o.val, null);
                listNode = listNode.next;
                o = o.next;
            } else {
                if (o.val > t.val) {
                    listNode.next = new ListNode(t.val, null);
                    listNode = listNode.next;
                    t = t.next;
                } else {
                    listNode.next = new ListNode(o.val, null);
                    listNode = listNode.next;
                    o = o.next;
                }
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        System.out.println(3/2);
    }


}
