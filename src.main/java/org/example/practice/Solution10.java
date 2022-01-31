package org.example.practice;

/**
 * @className: Solution10
 * @author: vic
 * @createDate: 2022/1/30 1:47 下午
 * @description:
 */
public class Solution10 {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(4, new ListNode(2, new ListNode(3, new ListNode(1))));
        ListNode listNode1 = mergeSort(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static ListNode mergeSort(ListNode list) {
        //1.思路先找中间点，左右排然后合并
        if (list == null || list.next == null) return list;

        //快慢指针找到中间值
        ListNode q = list, s = list;
        while (q.next != null && q.next.next != null) {
            q = q.next.next;
            s = s.next;
        }

        ListNode mid = s.next;
        s.next = null;
        list = mergeSort(list);
        mid = mergeSort(mid);

        //合并
        ListNode head = new ListNode(0), result = head;

        while (list != null || mid != null) {
            if (list == null) {
                result.next = mid;
                mid = mid.next;
            } else if (mid == null) {
                result.next = list;
                list = list.next;
            } else {
                if (list.val < mid.val) {
                    result.next = list;
                    list = list.next;
                } else {
                    result.next = mid;
                    mid = mid.next;
                }
            }
            result = result.next;
        }
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
