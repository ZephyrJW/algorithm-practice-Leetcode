// Given an array of integers, every element appears twice except for one. Find that single one.

// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for(i = 0;i<nums.length;i+=2){
            if(i == nums.length-1) break;
            if(nums[i]!=nums[i+1]) break;
        }
        return nums[i];
    }
}
