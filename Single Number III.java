// Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

// For example:

// Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

// Note:
// The order of the result is not important. So in the above example, [5, 3] is also correct.
// Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?


public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Arrays.sort(nums);
        int count = 0;
        for(int i =0; i< nums.length; i++){
            if(i == nums.length - 1){
                if(nums[i-1] != nums[i]){
                    res[count] = nums[i];
                    count++;
                }
                continue;
            }
            if(nums[i] == nums[i+1]){
                i++;
                continue;
            }
            if(nums[i] != nums[i+1]){
                res[count] = nums[i];
                count++;
               // break;
            }
        }
        return res;
    }
}
