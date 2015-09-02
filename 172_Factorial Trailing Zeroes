// Given an integer n, return the number of trailing zeroes in n!.

// Note: Your solution should be in logarithmic time complexity.

public class Solution {
    public int trailingZeroes(int n) {
    int rs = 0;
    while (n != 0) {
        rs += (n / 5);
        n /= 5;
    }
    return rs;
    }
}
