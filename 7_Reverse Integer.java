// Reverse digits of an integer.

// Example1: x = 123, return 321
// Example2: x = -123, return -321

// click to show spoilers.

// Have you thought about this?
// Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!

// If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.

// Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?

// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


//1. REMEMBER: when checking overflow, use >MAX_VALUE || <MIN_VALUE
public class Solution {
    public int reverse(int x) {
        if(x>-10&&x<10) return x;
        if (x == Integer.MIN_VALUE) return 0;
      //looks like when input -2147483648(MIN_VALUE), x*positive is useless although positive is actually -1
        int positive = x>=0?1:-1;
        
        x=x*positive;
        String s = x+"";
        long ans = 0;
        
        for(int i =0; i<=s.length()-1;i++){
            ans += Math.pow(10,i) * Integer.parseInt(s.charAt(i)+"");
        }
        return (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)?  0:(int)ans*positive;
    }  
}

//it's awesome and explicit but it's others (= =) notice that when transferring long to int,its !!not int(long) but (int)long!!
public class Solution {
    public int reverse(int x) {

        long rev = 0;

        while(x!=0) {
            rev = rev*10 + x%10;
            x /= 10;
        }
        return (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)? 0 : (int)rev;
    }
}
