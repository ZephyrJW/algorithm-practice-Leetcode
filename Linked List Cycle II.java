// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// Note: Do not modify the linked list.

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                while(slow != head){
                    slow = slow.next;
                    head = head.next;
                }
            return slow;
            }
        }
        return null;
    }
}

//explanation
// Definitions: Cycle = length of the cycle, if exists. C is the beginning of Cycle, S is the distance of slow pointer from C when slow pointer meets fast pointer.

// Distance(slow) = C + S, Distance(fast) = 2 * Distance(slow) = 2 * (C + S). To let slow poiner meets fast pointer, only if fast pointer run 1 cycle more than slow pointer. Distance(fast) - Distance(slow) = Cycle => 2 * (C + S) - (C + S) = Cycle => C + S = Cycle
// => C = Cycle - S => This means if slow pointer runs (Cycle - S) more, it will reaches C. So at this time, if there's another point2 running from head => After C distance, point2 will meet slow pointer at C, where is the beginning of the cycle.
