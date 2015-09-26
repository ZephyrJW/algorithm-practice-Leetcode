// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

// Note:
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.

//@ jiuwanli
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m-1, tail2 = n-1, finished = m+n-1;
        while(tail1>=0 && tail2 >=0){
            nums1[finished--] = nums1[tail1]>nums2[tail2]?nums1[tail1--]:nums2[tail2--];
        }
        if(tail1<0){
            while(finished>=0){
                nums1[finished--] = nums2[tail2--];
            }
        }
    }
}
