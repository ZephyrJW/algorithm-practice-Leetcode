// Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

// Note:
// Have you consider that the string might be empty? This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string as valid palindrome.


//cumbersome solution
public class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==0||s.length()<2) return true;
        String str = s;
        if(str.trim().length()==0) return true;
        
        s = s.toLowerCase();
        int front = 0, rear = s.length()-1;
        for(;front<=rear;){
            char frontc = s.charAt(front);
            char rearc = s.charAt(rear);
            
            if( (isValid(frontc) && isValid(rearc)) ){
                if(frontc == rearc) {
                    front++;
                    rear--;
                    continue;
                }
                if(frontc != rearc) break;
            }
            if(!isValid(frontc)) front++;
            if(!isValid(rearc)) rear--;
        }
        
        if(front>=rear) return true;
        else return false;
    }
     private boolean isValid(char c) {
        boolean isNumber = c >= '0' && c <= '9';
        boolean isLetter = c >= 'a' && c <= 'z';
        return isNumber || isLetter;
    }
}


//Laconic solution impressed by others

s=s.toLowerCase().replaceAll("[^a-z0-9]", "");
//[^a-z0-9] is a regular expression that select elements that're not in the category of (a to z) or (0 to 9)  正则表达式
return new StringBuilder(s).reverse().toString().equals(s);
