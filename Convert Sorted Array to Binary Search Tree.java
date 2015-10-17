//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

//1. definition of BST
  // A height balanced BST is a tree where the depths are the left and right subtrees differ by no more than 1. Assuming {4,2,5,1,3} is the OJ way of printing a tree (a modified level-order traversal, though the same as a standard one in this case), it looks like this:
  
  //      4
  //     / \
  //   2   5
  //   / \
  //  1   3
  // As you can see, the left subtree has a depth of 2, while the right subtree has a depth of 1. 2-1 = 1 <= 1, so it is a height balanced tree.
  
  // Based on your code, you are making the assumption that the list of values is an in-order traversal of the tree. Under that assumption, the tree looks like this:
  
  //      5
  //     / \
  //   2   1
  //   /     \
  //  4       3
  // Which I suppose is also a balanced binary tree, but it's not a binary search tree.
  
  //solution
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        return helper(nums, 0, nums.length-1);
    }
    
    public TreeNode helper(int[] nums, int start, int end){
        if(start > end) return null;
        int mid = start + (end-start)/2;
        TreeNode father = new TreeNode(nums[mid]);
        father.left = helper(nums, start, mid-1);
        father.right = helper(nums, mid+1, end);
        return father;
    }
}
