// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 //by @andywhite
 //Logic here is that if you find a node with either of right or left is absent, return the maximum of left/right because one of them is 0 anyway.
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null || root.right == null) 
        return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}
//basically the same
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if(left == 0) return right+1;
        if(right == 0) return left+1;
        return Math.min(left,right)+1;
    }
}
