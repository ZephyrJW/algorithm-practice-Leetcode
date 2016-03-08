// Implement int sqrt(int x).
// Compute and return the square root of x.


//used mid*mid == x , will overflow if margin situations
public class Solution {
    public int mySqrt(int x) {
        if(x<0) return -1;
        if(x<=1) return x;
        int low = 1, high = x;
        while(low<=high){
            int mid = low + (high-low)/2; //or int mid = (low+high) >>> 1;
            if(mid == x/mid){
                return mid;
            }else if(mid > x/mid){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
}

//review: 1. (low+high)/2 may overflow.
//        2.  uses >>> because it's clear that low+high must be non-negative. >> cannot guarantee no overflow happens
//使用(low + high) >>> 1求平均值仅适用于结果保证不是负数的情况，但好处是即使两个数的和int溢出也能求出正确的结果
