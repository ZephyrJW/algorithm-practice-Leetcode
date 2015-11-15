// Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

// Example:
// Given nums = [-2, 0, 3, -5, 2, -1]

// sumRange(0, 2) -> 1
// sumRange(2, 5) -> -1
// sumRange(0, 5) -> -3
// Note:
// You may assume that the array does not change.
// There are many calls to sumRange function. !! very important description.. consider the efficiency of coding

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        if(nums.length>0)sum[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            sum[i]=sum[i-1]+nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if(i==0)return sum[j];
        return sum[j]-sum[i-1];
    }
}


//my solution, but it's too slow
public class NumArray {
    int[] num;
    
    public NumArray(int[] nums) {
        num = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            num[i] = nums[i];
        }
    }

    public int sumRange(int i, int j) {
        int sum = 0;
        while(i<=j){
            sum += num[i];
            i++;
        }
        return sum;
    }
}

