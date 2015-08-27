// Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

// For example:

// Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

//point: Could you do it without any loop/recursion in O(1) runtime?

public class Solution {
    public int addDigits(int num) {
        int result=10;
        while(result>9){
            result = 0;
            while(num>=10){
                result += num % 10;
                num = num/10;
            }
            result += num;
            num = result;
        }
        return result;
    }
}

//one line solution

 return ( num - 1 ) % 9 + 1;
