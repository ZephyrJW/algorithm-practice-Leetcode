// Given a binary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //a straightforward version
public class Solution {  
    int max= 0; //note: method searchTree needs this variable.
    
    public int maxDepth(TreeNode root) {
        searchTree(root,1);
        return max;
    }
    
    public void searchTree(TreeNode root, int depth){
        if(root == null) return ;
        
        if(depth>max) max= depth;
        
        if(root.left != null ) searchTree(root.left,depth+1);
        if(root.right != null) searchTree(root.right,depth+1);
    }
}

//a very cool version
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return helper(root);
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(helper(root.left), helper(root.right)) + 1;
        }
    }
}
