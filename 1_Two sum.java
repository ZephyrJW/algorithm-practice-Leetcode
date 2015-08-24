// my solution to this problem
public class Solution1_my {
    public static int[] twoSum(int[] nums, int target) {
        int index1,index2;
        for(index1=0;index1<nums.length-1;index1++){
        	for(index2=index1+1;index2<nums.length;index2++){
        		if(nums[index1]+nums[index2] == target){
        			return new int[]{index1+1,index2+1};
        		}
        	}
        }
        return new int[2];
    }
  }
  
  //use hashmap,review sometimes:
  
  public class Solution1 {
  	public static int[] twoSum(int[] nums, int target){
	      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	      for(int i = 0; i < nums.length; i++){
	          map.put(nums[i],i+1);
	    }
	    for(int i = 0; i < nums.length; i++){
	        if (map.containsKey(target-nums[i]) && map.get(target-nums[i]) > i+1 )
	            return new int[] {i+1, map.get(target-nums[i])};
	    }
	    return new int[2];
	}
	}
