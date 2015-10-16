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

//clever solutions, both recursive and iterative by @ hello_today_
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    // method 1: recursion

    helper(root, res);
    return res;

    //helper function for method 1
    private void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
           }
       }
   }
   
   public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    // method 2: iteration
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        res.add(cur.val);
        cur = cur.right;
    }
    return res;        
}
