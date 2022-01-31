package org.example.practice;

/**
 * @className: Solution6
 * @author: vic
 * @createDate: 2022/1/23 9:28 下午
 * @description:
 */
public class Solution7 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0, null)))));

        listNode = insertionSortList(listNode);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * @return : org.example.practice.ListNode
     * @author : vic
     * @description :对链表进行插入排序。
     * @createDate : 2022/1/23 11:02 下午
     * @params : [head]
     **/
    public static ListNode insertionSortList(ListNode head) {


        ListNode h = new ListNode(Integer.MIN_VALUE, head), node = h, temp;

        //删除
        while (node != null) {

            if (node.next != null && node.next.val < node.val) {
                temp = node.next;
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }

        node = h;



        return null;
    }


}


