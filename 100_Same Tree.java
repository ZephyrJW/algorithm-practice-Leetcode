// Given two binary trees, write a function to check if they are equal or not.

// Two binary trees are considered equal if they are structurally identical and the nodes have the same value.


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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q!=null || p!=null && q == null ) return false;
        if(p==null && q ==null) return true;
        if(p.val != q.val) return false;
        boolean a = isSameTree(p.left,q.left);
        boolean b = isSameTree(p.right,q.right);
        if(a== true && b==true) return true;
        return false;
    }
}


//laconic version by @Kelvin_Zhang 
public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null || q == null) return p == q; // if they are null at the same time

    if (p.val != q.val) return false;

    return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
}
