// Given a binary tree, return the preorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//   1
//     \
//      2
//     /
//   3
// return [1,2,3].


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //iterative
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();  
        stack.add(root);
        
        while(!stack.isEmpty()){
                TreeNode now = stack.pop();
                res.add(now.val);
                if(now.right != null) stack.push(now.right);
                if(now.left != null) stack.push(now.left);
        }
        return res;
    }
}

//recursive
public class Solution {
    List<Integer> traversal = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root!=null){helper(root);}
        return traversal;
    }

    void helper (TreeNode root){
        traversal.add(root.val);
        if(root.left!=null){helper(root.left);}
        if(root.right!=null){helper(root.right);}

    }
}
