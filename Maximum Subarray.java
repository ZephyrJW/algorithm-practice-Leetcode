// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

// For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
// the contiguous subarray [4,−1,2,1] has the largest sum = 6.

// DP 
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] res = new int[nums.length];
        int max = nums[0];
        res[0]= nums[0];
        
        for(int i =1; i<nums.length;i++){
            res[i] = Math.max(res[i-1] + nums[i], nums[i]);
            max = Math.max(res[i], max);
        }
        return max;
    }
}
