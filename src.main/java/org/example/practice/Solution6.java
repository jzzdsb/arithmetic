/*
package org.example.practice;

*/
/**
 * @className: Solution6
 * @author: vic
 * @createDate: 2022/1/23 9:28 下午
 * @description:
 *//*

public class Solution6 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0, null)))));

        listNode = insertionSortList(listNode);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    */
/**
     * @return : org.example.practice.ListNode
     * @author : vic
     * @description :对链表进行插入排序。
     * @createDate : 2022/1/23 11:02 下午
     * @params : [head]
     **//*

    public static ListNode insertionSortList(ListNode head) {
        //优先处理特殊情况
        if (head.next == null) return head;
        //分割成有序区和无序区
        ListNode noSort = head.next;
        head.next = null;
        ListNode result = new ListNode(Integer.MIN_VALUE, head), isSort;

        //无序区删除，有序区新增
        while (noSort != null) {

            isSort = result;
            while (isSort != null) {
                if (isSort.next != null && isSort.next.val > noSort.val) {
                    isSort.next = new ListNode(noSort.val, isSort.next);
                    break;
                } else if (isSort.next == null) {
                    isSort.next = new ListNode(noSort.val, null);
                    break;
                }
                isSort = isSort.next;
            }

            noSort = noSort.next;
        }

        return result.next;
    }


}

class ListNode {
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
*/
