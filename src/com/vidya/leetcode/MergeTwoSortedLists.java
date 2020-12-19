package com.vidya.leetcode;

/**
 * 21. Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: l1 = [], l2 = []
 * Output: []
 * Example 3:
 *
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode.printNode(mergeTwoSortedLists(l1,l2));
    }

    static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode pre = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }

            pre = pre.next;
        }

        pre.next = l1 == null? l2 : l1;

        return head.next;
    }
}
