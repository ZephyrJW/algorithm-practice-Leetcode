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
        if (l1 == null)  return l2;
        if (l2 == null)  return l1;
        
        int carry = 0;
        
        while(l1 != null && l2 != null){
          sum = l1.val + l2.val;
          num = sum%10+carry;
          carry = sum/10;
          ListNode addSum = new ListNode(num);
          l1 = l1.next;
          l2 = l2.next;
        }
        
        if(l1 == null){
          while(l2!=null){
            addSum = new ListNode(l2.value);
            l2 = l2.next;
          }
        }
         if(l2 == null){
          while(l1!=null){
            addSum = new ListNode(l1.val);
            l1 = l1.next;
          }
        }
        return addSum;
    }
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
