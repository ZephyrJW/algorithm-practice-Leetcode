// Suppose a sorted array is rotated at some pivot unknown to you beforehand.

// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

// Find the minimum element.

// You may assume no duplicate exists in the array.

//but the inbuilt sort function may be too expensive to be executed
public class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }
}

//so better build function of your own, but it may not be a very good one
public class Solution {
    public int findMin(int[] nums) {
        if(nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];
        int min = nums[0];
        
        for(int i =1; i<nums.length; i++){
            if(nums[i] > nums[i-1]) continue;
            min = min>nums[i]? nums[i]:min;
            break;
        }
        return min;
    }
}

//binary search is an option o(lgn) @ zhibzhang 
public class Solution {
  public int findMin(int[] num) {
      int low = 0;
      int high = num.length - 1;
      while(low < high){
          int mid = (low + high) / 2;
          if(num[high] < num[mid]){
              low = mid + 1;
          } else {
              high = mid;
          }
      }
      return num[high];
  }
}
