// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
//however, ([]) is correct 







//previous solution, misunderstood the meaning of the problem.
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
