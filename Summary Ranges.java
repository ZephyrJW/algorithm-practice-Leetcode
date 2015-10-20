// Given a sorted integer array without duplicates, return the summary of its ranges.

// For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].

//in case of overflow of list, don't panic and make i=1 as initialization, analyze it and THEN make a decision, ok? 
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 1){
            res.add(nums[0]+"");
            return res;
        }
        
        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            while(i+1<nums.length && nums[i+1] - nums[i] == 1){
                i++;
            }
            if(a == nums[i]){
                res.add(a+"");
            }else{
                res.add(a+"->"+nums[i]);
            }
        }
        return res;
    }
}
