// The count-and-say sequence is the sequence of integers beginning as follows:
// 1, 11, 21, 1211, 111221, ...

// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.
// Given an integer n, generate the nth sequence.

// Note: The sequence of integers will be represented as a string.

public class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String str = "1";
        for(int i = 1; i<n;i++){
            str = helper(str);
            
        }
        return str;
    }
    
    public String helper(String str){
        String newstr = "";
        for(int i = 0;i<str.length();i++){
            int count = 1;
            char prev = str.charAt(i);
            while(i+count< str.length() && prev == str.charAt(i+count)){
                count++;
            }
            newstr += String.valueOf(count)+prev;
            i += count-1;
        }
        return newstr;
    }
}
