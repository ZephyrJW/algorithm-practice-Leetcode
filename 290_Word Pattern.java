public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] exam = str.split(" ");
        if(p.length != exam.length) return false;
        if(p.length == 1) return true;
        
        for(int i =1; i< p.length; i++){
            if(p[i-1] == p[i] && !exam[i-1].equals(exam[i])) return false;
        }
        return true;
    }
}
