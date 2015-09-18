// Given a binary tree, determine if it is height-balanced. 

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 

//brilliant solution by @ FreeTymeKiyan  (Github user)
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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(maxDepth(root)!=-1) return true;
        else return false;
    }
    //based on the solution to get the depth of a tree
    public int maxDepth(TreeNode root){
        if(root == null) return 0;
        
        int lh = maxDepth(root.left);
        if(lh == -1) return -1; // otherwise it will return math.max(bla,bla)
        int rh = maxDepth(root.right);
        if(rh == -1) return -1;
        if(Math.abs(lh-rh)>1) return -1;  //this is to varify if the problem raised is right
        return Math.max(lh,rh)+1; // actually return -2+1 (false situation)  then, isBalanced() then returns false
        
    }
}
