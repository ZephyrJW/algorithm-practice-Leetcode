// Given a binary tree

//     struct TreeLinkNode {
//       TreeLinkNode *left;
//       TreeLinkNode *right;
//       TreeLinkNode *next;
//     }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

// Note:

// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
// For example,
// Given the following perfect binary tree,
//          1
//       /  \
//       2    3
//      / \  / \
//     4  5  6  7
// After calling your function, the tree should look like:
//          1 -> NULL
//       /  \
//       2 -> 3 -> NULL
//      / \  / \
//     4->5->6->7 -> NULL

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(true){
            TreeLinkNode mostleft = null;
            TreeLinkNode prev = null;
            while(root != null){
                if(root.left != null){
                    if(mostleft == null) mostleft = root.left;
                    if(prev == null) prev = root.left;
                    else{
                        prev.next = root.left;
                        prev = root.left;
                    }
                }
                
                if(root.right != null){
                    if(mostleft == null) mostleft = root.right;
                    if(prev == null) prev = root.right;
                    else{
                        prev.next = root.right;
                        prev = root.right;
                    }
                }
                root = root.next;
            }
            if(mostleft != null) root = mostleft;
            else return;
        }
    }
}
