// Invert a binary tree.

//      4
//   /   \
//   2     7
//  / \   / \
// 1   3 6   9
// to
//      4
//   /   \
//   7     2
//  / \   / \
// 9   6 3   1


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //inspired by @ gaoxingliang
  public class Solution {
      public TreeNode invertTree(TreeNode root) {
          if(root == null) return null;
          Stack<TreeNode> s = new Stack<TreeNode>();
          s.push(root);
          
          while(!s.isEmpty()){
              TreeNode n = s.pop();
              if(n.left==null && n.right==null) continue;
              
              TreeNode tem = n.left;
              n.left = n.right;
              n.right = tem;
              
              if(n.left!=null) s.push(n.left);
              if(n.right!=null) s.push(n.right);
          }
          return root;
      }
  }

//by @SOY , notice his recursion thinking
  public class Solution {
      public TreeNode invertTree(TreeNode root) {
          if(root == null) return null;
          TreeNode tmp = root.left;
          root.left = invertTree(root.right);
          root.right = invertTree(tmp);
          return root;
      }
  }
