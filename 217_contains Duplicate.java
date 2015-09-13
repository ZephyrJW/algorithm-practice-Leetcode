// Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

//using hashmap
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0) return false;
        int x = 1;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(nums[i])) {
                return true; 
            }
            map.put(nums[i],x);
            x++;
        }
        return false;
    }
}

//HASHSET what?
public  boolean containsDuplicate(int[] nums) {
         Set<Integer> set = new HashSet<Integer>();
         for(int i : nums) // equals : for(int i = 0; i<nums.length; i++) meaning every item in nums[]  like python :)
             if(!set.add(i))
                 return true; 
         return false;
     }
