// Given a sorted linked list, delete all duplicates such that each element appear only once.

// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode l = head;
        while(head.next!=null){
        if(head.val == head.next.val) head.next = head.next.next;
        else head = head.next;}
        return l;
    }
}

//by @ wen587sort  smart recursion 
public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)return head;
        head.next = deleteDuplicates(head.next);
        return head.val == head.next.val ? head.next : head;
}
