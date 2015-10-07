// Given a singly linked list, determine if it is a palindrome.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!= null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow.next == null) 
            return true;
        
        ListNode head2= slow.next;
        ListNode curr = slow.next.next;
       // ListNode temp = curr.next;
        slow.next = null;
        head2.next = null;// must have, head2 point curr, it's infinate loop head2->curr, curr->head2
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = head2;
            head2 = curr;
            curr = temp;
        }
        
        while(head2!= null && head != null){
            if(head.val != head2.val) return false;
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
}
