public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length()==0) return 0;
        int count=0;
        for (int i = s.length()-1;i>=0;i--){
            if(s.charAt(i)!=' ') count++;
            if(count != 0 && s.charAt(i)==' ') return count;
        }
        return count;
    }
}


// a array version
public int lengthOfLastWord(String s) {
    s = s.trim();
    String[] strArr = s.split(" ");
    return strArr[strArr.length-1].length();
}
