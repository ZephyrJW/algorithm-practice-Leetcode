// Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Solve it without division and in O(n).

// For example, given [1,2,3,4], return [24,12,8,6].

//time limit exceed
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i =0; i<nums.length; i++){
            int product = 1;
            for(int j = 0;j<nums.length;j++){
                if(i == j) continue;
                else product *= nums[j];
            }
            res[i] = product;
        }
        return res;
        
        // // 0/0 is not appliable
        // int product = 1;
        // for(int i = 0; i<nums.length;i++){
        //     product *= nums[i];
        // }
        // int[] res = new int[nums.length];
        // for(int i = 0; i<res.length;i++){
        //     res[i] = product/nums[i];
        // }
        // return res;
    }
}


//right solution
public class Solution {
  public int[] productExceptSelf(int[] nums) {
      int n = nums.length;
      int[] output = new int[n];
      int temp = 1;
      output[0] = 1;
      for (int i = 1; i < n; i++)
      {
          output[i] = output[i-1] * nums[i-1];
      }
      for (int i = n - 1; i >= 0 ; i--)
      {
          output[i] = temp * output[i];
          temp = temp * nums[i];
      }
      return output;
  }
}
