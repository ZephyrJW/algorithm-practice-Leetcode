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

//@ Nkeys  BOTH EXPLANATION AND SOLUTION
    // we use bitwise XOR to solve this problem :
    
    // first , we have to know the bitwise XOR in java
    
    // 0 ^ N = N
    // N ^ N = 0
    // So..... if N is the single number
    
    // N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
    
    // = (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
    
    // = 0 ^ 0 ^ ..........^ 0 ^ N
    
    // = N

public int singleNumber(int[] nums) {
    int ans =0;

    int len = nums.length;
    for(int i=0;i!=len;i++)
        ans ^= nums[i];

    return ans;

}
