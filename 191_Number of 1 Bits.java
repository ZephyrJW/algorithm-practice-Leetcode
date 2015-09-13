// Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

// For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

//inspired by @ alderith and @Todd2
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}

//you need to read a java book , by @ hello_today_
public int hammingWeight(int n) {
    int x = 0;
    while (n != 0) {
       x += (n & 1);
       n = n >>> 1;
    }
    return x;
}
