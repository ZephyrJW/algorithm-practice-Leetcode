// Given a collection of distinct numbers, return all possible permutations.

// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].


public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(nums.length == 0) return ans;
        List<Integer> interior = new ArrayList<Integer>();
        interior.add(nums[0]);
        ans.add(interior);
        
        for(int i=1; i<nums.length; i++){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>();
            for(int j=0; j<=i; j++){
                for(List<Integer> l : ans){
                    List<Integer> new_list = new ArrayList<Integer>(l);
                    new_list.add(j,nums[i]);
                    new_ans.add(new_list);
                }
            }
            ans = new_ans;
        }
        return ans;
    }
}


//note:
// the basic idea is, to permute n numbers, we can add the nth number into the resulting List<List<Integer>> from the n-1 numbers, in every possible position.

// For example, if the input num[] is {1,2,3}: First, add 1 into the initial List<List<Integer>> (let's call it "answer").

// Then, 2 can be added in front or after 1. So we have to copy the List in answer (it's just {1}), add 2 in position 0 of {1}, then copy the original {1} again, and add 2 in position 1. Now we have an answer of {{2,1},{1,2}}. There are 2 lists in the current answer.

// Then we have to add 3. first copy {2,1} and {1,2}, add 3 in position 0; then copy {2,1} and {1,2}, and add 3 into position 1, then do the same thing for position 3. Finally we have 2*3=6 lists in answer, which is what we want.
