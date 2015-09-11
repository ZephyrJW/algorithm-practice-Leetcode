// Rotate an array of n elements to the right by k steps.

// For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

// Note:
// Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.


//1.
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return;
        }
        k = k % nums.length;   //can't understand the '%', how can k > n ?  ans: rotate k=sums.length return the original sums
        //then k-sums.length should be the k actually
        int[] tmp = new int[k];
        System.arraycopy(nums, nums.length - k, tmp, 0, k);
        System.arraycopy(nums, 0, nums, k, nums.length - k);
        System.arraycopy(tmp, 0, nums, 0, k);
    }
}
//System.arraycopy: (array to copy from, start point, array copy to, start point, end point)

//2. @oybin1989 doubling the array
public void rotate(int[] nums, int k) {
    int length=nums.length;
    int rk=k%length;
    int [] copy=new int[length*2];
    for(int i=0;i<2*length;i++){
        copy[i]=nums[i%length];
    }
    for(int t=length-rk,i=0;t<2*length-rk;t++,i++)
    {
        nums[i]=copy[t];

    } 

}
