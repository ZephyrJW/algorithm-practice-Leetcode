// Given a binary tree, return the inorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//   1
//     \
//      2
//     /
//   3
// return [1,3,2].

// Note: Recursive solution is trivial, could you do it iteratively?

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null) return res;
        if(root.right != null) stack.push(root.right);
        stack.push(root);
        if(root.left != null) stack.push(root.left);
        root.left = null;
        root.right = null;
        
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.left == null && temp.right == null){
                res.add(temp.val);
            }else{
                if(temp.right != null) stack.push(temp.right);
                stack.push(temp);
                if(temp.left != null) stack.push(temp.left);
                temp.left = null;
                temp.right = null;
            }
        }
        return res;
    }
}
