// Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

// Do not allocate extra space for another array, you must do this in place with constant memory. 

// For example,
//  Given input array nums = [1,1,2], 

// Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length. 


//very silly solution = = using hashmap, takes too much time to solve
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return 1;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 1;
        for(int j = 0;j<nums.length;j++){
            if(!map.containsKey(nums[j])) map.put(nums[j],1);
            else{
                count = map.get(nums[j]);
                count ++;
                map.put(nums[j],count);
            }
        }
        
        int ans = 1;
        for(int i=1; i < nums.length; i++){
            if(map.get(nums[i]) == 1) {
                nums[ans] = nums[i];
                ans++;
                continue;
            }
            else if(nums[ans-1] != nums[i])
            {
                nums[ans] = nums[i];
                ans++;
            }
        }
        return ans;
    }
}

//nothing to say
public class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            nums[j++] = nums[i];
        }
        return j;
    }
}

//another
public int removeDuplicates(int[] nums) {
    int i = 0;
    for (int n : nums)
        if (i == 0 || n > nums[i-1])
            nums[i++] = n;
    return i;
}

//this one is extremly fast
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length==0||A.length==1) return A.length;
        int curr=0, x=1;
        while(curr<A.length&&x<A.length){
            if(A[curr]==A[x]){
                x++;
            }else{
            A[++curr]=A[x++];
            }
        }
        return curr+1;}
}
