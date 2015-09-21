// Given an integer, write a function to determine if it is a power of two.

//Straightforward
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        while(n % 2 == 0){
            n /= 2;
        }
        if(n!=1) return false;
        return true;
    }
}

//bit manipulation by @ MAIR 
public class Solution {
  public boolean isPowerOfTwo(int n) {
  
      return n<=0?false:((n&(n-1))==0)?true:false;
      //(n&n-1) for example, 8, 1000 so 7 is, 0111, so the & manipulation return 0 
}
