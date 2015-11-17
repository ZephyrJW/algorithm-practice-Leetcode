// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given an encoded message containing digits, determine the total number of ways to decode it.

// For example,
// Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

// The number of ways decoding "12" is 2.

//dynamic programming @ zq670067
public class Solution {
    public int numDecodings(String s) {
        if(s.length() <= 0) return 0;
        int n = s.length();
        int[] sol = new int[n+1];
        sol[n] = 1;
        sol[n-1] = s.charAt(n-1) == '0'? 0:1; //trick here
        for(int i =n-2; i>=0; i--){
            if(s.charAt(i)!= '0'){
                sol[i] += sol[i+1];
                int val = Integer.parseInt(s.substring(i,i+2));
                if(val>0 && val<=26) sol[i] += sol[i+2];
            }
        }
        return sol[0];
    }
}
