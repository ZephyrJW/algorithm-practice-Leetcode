// Remove all elements from a linked list of integers that have value val.

// Example
// Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
// Return: 1 --> 2 --> 3 --> 4 --> 5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        while(head.val == val) {               
            if(head.next == null) return null;  //be aware of the situation of 1->1 then it's empty
            else head = head.next;
        }
        ListNode l = head;
        while(head.next != null){
            if(head.next.val == val){
                if(head.next.next == null) head.next = null;
                else head.next = head.next.next;
            }
            else head = head.next;
        }
        return l;
    }
}
