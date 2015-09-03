// Given a binary tree, return all root-to-leaf paths.

// For example, given the following binary tree:

//   1
//  /   \
// 2     3
//  \
//   5
// All root-to-leaf paths are:

// ["1->2->5", "1->3"]


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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l=new ArrayList<>();
        if(root!=null)
            pre(l,root,"");
        return l;
    }
     void pre(List<String> l,TreeNode r,String s){
         if(r==null)return;
         if(s.isEmpty())
            s+=r.val;
        else s+=("->"+r.val);
        if(r.left!=null||r.right!=null){
            pre(l,r.left,s);
            pre(l,r.right,s);
        }else
            l.add(s);
     }
}
     
// public class Solution {
//     public List<String> binaryTreePaths(TreeNode root) {
//         List<String> paths = new LinkedList<>();

//         if(root == null) return paths;

//         if(root.left == null && root.right == null){
//             paths.add(root.val+"");
//             return paths;
//         }

//          for (String path : binaryTreePaths(root.left)) {
//              paths.add(root.val + "->" + path);
//          }

//          for (String path : binaryTreePaths(root.right)) {
//              paths.add(root.val + "->" + path);
//          }

//          return paths;

//     }
// }
