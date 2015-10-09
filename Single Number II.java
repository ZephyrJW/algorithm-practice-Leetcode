// Given an array of integers, every element appears three times except for one. Find that single one.

public class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];
        int i =0;
        Arrays.sort(nums);
        for(i = 0; i< nums.length; i++){
            if(i == 0){
                if(nums[i] != nums[i+1]) break;
                else continue;
            }
            
            if(i == nums.length-1){
                break;
            }
            
            if(nums[i] == nums[i-1] || nums[i] == nums[i+1]){
                continue;
            }else{
                break;
            }
        }
        return nums[i];
    }
}
