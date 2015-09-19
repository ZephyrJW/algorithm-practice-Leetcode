// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

// Note:
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

//inspired by @ Kurteck
public class Solution {
    public void moveZeroes(int[] nums) {
        int n = 0;
        for(int num:nums){
            if(num != 0) {
                nums[n] = num;
                n++;
            }
        }
        while(n<nums.length) nums[n++] =0;
    }
}
