// Reverse a singly linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cursor = head.next;
        ListNode preheader = head;
        preheader.next = null;
        
        ListNode tem;
        while(cursor!=null){
            tem = cursor.next;
            cursor.next = preheader;
            preheader = cursor;
            cursor = tem;
        }
        return preheader;
    }
}

//recursion by @ azheanda
public class Solution {
    public ListNode reverseList(ListNode curr){
        if(curr==null) return curr;
        ListNode rest = curr.next;
        if(rest==null) return curr;
        rest = reverseList(rest);
        curr.next.next = curr;    //  Here is the trick
        curr.next =null;          //
        return rest;
    }
}
