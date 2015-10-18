// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
//however, ([]) is correct 

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        // Iterate through string until empty
        for(int i = 0; i<s.length(); i++) {
            // Push any open parentheses onto stack
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            // Check stack for corresponding closing parentheses, false if not valid
            else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '(')
                stack.pop();
            else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '[')
                stack.pop();
            else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }
        // return true if no open parentheses left in stack
        return stack.empty();
    }
}





//previous solution, misunderstood the meaning of the problem. It may have (){}[], 
public class Solution {
    public boolean isValid(String s) {
        char[] test = s.toCharArray();
        if(test.length <= 1) return false;
        int i = 0, j = test.length-1;
        while(i<j){
            if(!(test[i] == '(' || test[i] == '{' || test[i] == '[')){
                i++;
            }
            if(!(test[j] == ')' || test[j] == '}' || test[j] == ']')){
                j--;
            }
            if(test[i] == '(' && test[j] != ')' || test[i] == '{' && test[j] != '}' || test[i] == '[' && test[j] != ']'){
                return false;
            }else{
            i++;j--;
            }    
        }
        return true;
    }
}
