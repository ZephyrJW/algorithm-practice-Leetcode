// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

//         _______3______
//       /              \
//     ___5__          ___1__
//   /      \        /      \
//   6      _2       0       8
//          /  \
//          7   4
// For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // using stack to solve the problem
 public class Solution {

public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Stack<TreeNode> pStack = new Stack<TreeNode>();
    Stack<TreeNode> qStack = new Stack<TreeNode>();
    TreeNode target = null;
    if (findPath(root, p, pStack) && findPath(root, q, qStack)) {
        while (!pStack.isEmpty()) {
            TreeNode pNode = pStack.pop();
            if (qStack.contains(pNode))
                target = pNode;
        }
    } 
    return target;
}

private boolean findPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
    if (root == null)
        return false;
    if (root == node) {
        stack.push(root);
        return true;
    } else {
        if (findPath(root.left, node, stack) ||  findPath(root.right, node, stack)) {
            stack.push(root);
            return true;
        }
    }
    return false;
}
 
 
 // one incredible efficient way to solve the problem.. try try to comprehend it ! HOW @xcv58 THINK OF THIS SOLUTION.
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p || root == q || root == null) { return root; }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return (left != null && right != null) ? root : (left != null ? left : right);
    }
}
