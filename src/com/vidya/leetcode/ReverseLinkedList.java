package com.vidya.leetcode;

/**
 * Reverse a singly linked list.
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode.printNode(reverseList(head));
    }

    static ListNode reverseList(ListNode head){
        ListNode curr = null;
        ListNode temp = head;
        ListNode prev = null;

        while (temp !=null){
            prev = curr;
            curr = temp;
            temp = curr.next;
            curr.next = prev;
        }

        return curr;
    }
}
