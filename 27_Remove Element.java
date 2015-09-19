// Given an array and a value, remove all instances of that value in place and return the new length.

// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

//inspired  by @vimukthi  in Leetcode Problem: 'Move Zeroes'
public class Solution {
    public int removeElement(int[] nums, int val) {
        int pointer = 0;
        for(int i=0; i<nums.length;i++){
            if(nums[i] == val) continue;
            if(nums[i] != val) {
                nums[pointer]=nums[i];
                pointer++;
            }
        }
        return pointer;
    }
}
