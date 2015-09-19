// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

// For example, this binary tree is symmetric:

//     1
//   / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following is not:
//     1
//   / \
//   2   2
//   \   \
//   3    3


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //recursive smart solution
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,root.right);
    }
    
    private boolean helper(TreeNode t1, TreeNode t2){
        if(t1== null || t2== null) return t1 == t2; 
        //otherwise you need two lines of code: if(t1 == null && t2 == null) return true; || return false
        return (t1.val == t2.val && helper(t1.left,t2.right) && helper(t1.right,t2.left));
    }
}

//using stack to check 
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root.left);
        stack.push(root.right);
        
        while(!stack.empty()){
            TreeNode t1 = stack.pop();
            TreeNode t2 = stack.pop();
            if(t1 == null && t2 == null) continue;
            if(t1==null || t2==null || t1.val != t2.val) return false;
            //note (t1.val != t2.val) must be put in the end of this line, recall || computation rules
            stack.push(t1.left);
            stack.push(t2.right);
            stack.push(t1.right);
            stack.push(t2.left);
        }
        return true;
    }
}
