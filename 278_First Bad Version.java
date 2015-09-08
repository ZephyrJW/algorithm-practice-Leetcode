// You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

// Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

// You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while(left < right){
            int mid = left + (right-left) / 2;   //note
            if(!isBadVersion(mid)){
                left = mid+1;
            }
            else right = mid;
        }
        return left;
    }
}

//note: I used (left+right)/2 to calculate mid in the first place,but it went wrong. @fanshaopu(leetcoder) says this may cause
//mid to overflow,meaning mid>Integer.MAX_VALUE.   SO REMEMBER THIS EXPRESSION OF SUM;

