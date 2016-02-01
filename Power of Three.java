//  Given an integer, write a function to determine if it is a power of three.

// Follow up:
// Could you do it without using any loop / recursion? 

// straightforward solution
public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==0) return false;
        
        while(n % 3 ==0){
            n = n/3;
        }
        return n == 1;
    }
}


//solution by @ oluwasayo 
public boolean isPowerOfThree(int n) {
  double a = Math.log(n) / Math.log(3);
  return Math.abs(a - Math.rint(a)) <= 0.00000000000001;
}

//and it's comments
//If N is a power of 3:
/*
    It follows that 3^X == N
    It follows that log (3^X) == log N
    It follows that X log 3 == log N
    It follows that X == (log N) / (log 3)
    For the basis to hold, X must be an integer.

However, due to precision issues that arise from the fact that log 3 cannot be precisely represented on a binary computer;
X is considered to be an integer if it's decimal component falls within a guard range of +/-0.00000000000001. */
