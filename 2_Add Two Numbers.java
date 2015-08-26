/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 //1-----pending solution
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode add = new ListNode(0);
        ListNode d = add;
        
        int sum = 0;
        while(l1!= null || l2!= null){
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            d.next = new ListNode(sum%10);
            sum = sum/10;
            d = d.next;
        }
        if(sum == 1)  d.next = new ListNode(1);
        return add.next;
}



//2-----a recursion solution by other people
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1,l2,0);
    }
    private ListNode helper(ListNode l1, ListNode l2, int carry){
        if(l1 == null && l2 == null){
            if(carry == 1)  return new ListNode(1);
            else    return null;
        }

        int sum = carry;
        sum = (l1 == null)?sum:sum+l1.val;
        sum = (l2 == null)?sum:sum+l2.val;

        carry = sum / 10;
        sum = sum % 10;

        ListNode node = new ListNode(sum);
        if(l1 == null)  
            node.next = helper(l1,l2.next,carry);
        else if(l2 == null)
            node.next = helper(l1.next,l2,carry);
        else
            node.next = helper(l1.next,l2.next,carry);
        return node;

    }
}


//3------an accpted solution
 public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode pre = new ListNode(0); // set pre head
        ListNode d = pre;
        int sum = 0; // the sum of two nodes
        while (c1 != null || c2 != null) { // traverse longer list
            if (c1 != null) { // add one list 
                sum += c1.val;
                c1 = c1.next; // move on 
            }
            if (c2 != null) { // add another list
                sum += c2.val;
                c2 = c2.next; // move on 
            }
            // build next node
            d.next = new ListNode(sum % 10); // digit for current node
            sum /= 10; // carry
            d = d.next; 
        }
        if (sum == 1) d.next = new ListNode(1); // note that can have carry at the last digit
        return pre.next;
    }
