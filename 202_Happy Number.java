// Write an algorithm to determine if a number is "happy".

// A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

// Example: 19 is a happy number

// 12 + 92 = 82
// 82 + 22 = 68
// 62 + 82 = 100
// 12 + 02 + 02 = 1


public class Solution {
    ArrayList<Integer> array = new ArrayList<>();
    public boolean isHappy(int n) {
        if(n == 1) return true;
        if(array.contains(n)) return false;
        array.add(n);
        int sum = 0;
        while(n!=0){
            sum += Math.pow(n%10,2);
            n /= 10;
        }
        return isHappy(sum);
    }
}

//another is using hashset, basically same thinking but notice different uses
public boolean isHappy(int n) {
    HashSet<Integer> hash = new HashSet<Integer>();
    if(n <= 0) return false;
    while(n < Integer.MAX_VALUE){
        int i = 0;
        int j = 10;
        if(n == 1) return true;
        if(hash.contains(n)) return false;
        else hash.add(n);
        while(n != 0){
            i += (n % j) * (n % j);
            n = (n - n % j) / 10;
        }
        n = i;
    }
    return false;
}
