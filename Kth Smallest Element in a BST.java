// Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

// Note: 
// You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

// Follow up:
// What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int i=1;
    int res;
    public int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return res;
    }
    public void traversal(TreeNode root, int k){
        if(root == null) return;
        
        traversal(root.left,k);
        
        if(i++ == k){
            res = root.val;
            return;
        }
        
        traversal(root.right,k);
        
        return;
    }
}
