// Implement atoi to convert a string to an integer.

// Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

// Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.


public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length()==0){
            return 0;
        }
        
        str = str.trim();
        int len = str.length();
        int sign = 1;
        int res = 0;
        
        for(int i=0; i<len; i++){
            if(str.charAt(i) == '+' || str.charAt(i) == '-'){
                if(i == 0){
                    sign = str.charAt(i)=='+'?1:-1;
                }
                else{
                    return sign*res;
                }
            }
            else if(str.charAt(i) == '.'){
                return sign*res;
            }
            else if(!Character.isDigit(str.charAt(i))){
                return sign*res;
            }
            else{
                int charnum = Integer.parseInt(str.charAt(i)+""); // note the parseInt require string input
                int temp = res*10 + charnum;
                if(res>=Integer.MAX_VALUE/10&&charnum>=8||(temp-charnum)/10!=res){
                    return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
                }
                res = temp;
            }
        }
        return res*sign;
    }
}

//why "(res>=Integer.MAX_VALUE/10&&charnum>=8||(temp-charnum)/10!=res)"?
