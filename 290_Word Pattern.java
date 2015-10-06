// Given a pattern and a string str, find if str follows the same pattern.

// Examples:
// pattern = "abba", str = "dog cat cat dog" should return true.
// pattern = "abba", str = "dog cat cat fish" should return false.
// pattern = "aaaa", str = "dog cat cat dog" should return false.
// pattern = "abba", str = "dog dog dog dog" should return false.
// Notes:
// Both pattern and str contains only lowercase alphabetical letters.
// Both pattern and str do not have leading or trailing spaces.
// Each word in str is separated by a single space.
// Each letter in pattern must map to a word with length that is at least 1.

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] p = pattern.toCharArray();
        String[] exam = str.split(" ");
        if(p.length != exam.length) return false;
        HashMap<Character,String> map = new HashMap();
        
        for(int i =0; i< p.length; i++){
            if(!map.containsKey(p[i])){
                if(map.containsValue(exam[i])) return false;
                map.put(p[i],exam[i]);
            }else{
                if(!map.get(p[i]).equals(exam[i])) return false; //note .equals() differs from '=='
            }
        }
        return true;
    }
}

//I understood the problem in a wrong way, each character specificlly stand for one string
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
