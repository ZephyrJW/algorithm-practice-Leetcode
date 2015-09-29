// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

//   Given linked list: 1->2->3->4->5, and n = 2.

//   After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode p1 = start, p2 = start;
        int i = n;
        while(i > 0 && p2.next != null) {
            p2 = p2.next;
            i--;
        }
        if(i > 0) {
            return head;
        }
        while(p2.next !=null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return start.next;
    }
}


//one pass
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head;
    ListNode slow = head;
    while(fast != null) {
        fast = fast.next;
        if(n-- < 0) {
            slow = slow.next;
        }
    }

    if(n == 0) {
        head = head.next;
    } else if(n < 0) {
        slow.next = slow.next.next;
    } else {
        return null;
    }

    return head;
}
