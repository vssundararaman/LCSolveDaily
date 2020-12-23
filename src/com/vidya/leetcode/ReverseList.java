package com.vidya.leetcode;

public class ReverseList {
    public static void main(String[] args) {
        ListNode1 listNode1 = new ListNode1(1);
        listNode1.next = new ListNode1(2);
        listNode1.next.next = new ListNode1(3);
        listNode1.next.next.next = new ListNode1(4);
        listNode1.next.next.next.next = new ListNode1(5);

        printNode(listNode1);

        listNode1 = reverseListNode(listNode1);

        printNode(listNode1);
    }

    static void printNode(ListNode1 head){
        while(head !=null){
            System.out.print(head.val + "->");
            head = head.next;
        }
    }

    static ListNode1 reverseListNode(ListNode1 head){
        ListNode1 prev = null;
        ListNode1 temp = head;
        ListNode1 curr = null;

        while(temp !=null){
            prev = curr;
            curr = temp;
            temp = curr.next;
            curr.next = prev;
        }

        return curr;
    }
}

class ListNode1{
    int val;
    ListNode1 next;
    ListNode1(int val){
        this.val = val;
    }
    ListNode1(int val, ListNode1 next){
        this.val = val;
        this.next = next;
    }
}
