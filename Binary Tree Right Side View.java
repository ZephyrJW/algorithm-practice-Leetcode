// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// For example:
// Given the following binary tree,
//   1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
// You should return [1, 3, 4].



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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(i == size-1){
                    res.add(node.val);
                }
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
        }
        return res;
    }
}
