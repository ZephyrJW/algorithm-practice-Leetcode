// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

// You may assume that the array is non-empty and the majority element always exist in the array.

//Using hashmap
public class Solution {    
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
      // int times= nums.length%2==0? 
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int n = map.get(nums[i]);
                map.put(nums[i],n+1);
                if(map.get(nums[i]) > (nums.length-1)/2) return nums[i];  // notice that it's '(nums.length-1)/2)' in case of even nums
            } 
            else{map.put(nums[i],1);}
        }
        return nums[0];
    }
}

//laconic one smart
public class MajorityElement {
    public int majorityElement(int[] nums) {
        assert nums.length > 0;
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
