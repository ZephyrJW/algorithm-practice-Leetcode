// Given two strings s and t, write a function to determine if t is an anagram of s.

// For example,
// s = "anagram", t = "nagaram", return true.
// s = "rat", t = "car", return false.

// Note:
// You may assume the string contains only lowercase alphabets.


//a very efficient solution
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        s = new String(chars);
        t = new String(chart);
        return s.equals(t);
    }
}


//Solution using HashMap--
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        //initialize the hashmap to store the chars in s
        for (int i = 0; i <= s.length()-1; i++){
            int num = 1;
            char c = s.charAt(i);
            if(map.containsKey(c)){
                num = map.get(c);
                num++;
            }
            map.put(c,num);
        }
        //chars stored
        for(int j = 0; j <= t.length()-1; j++){
            char c = t.charAt(j);
            if(!map.containsKey(c)) return false;
            else{
            int count = map.get(c);
            count--;
            if(count == 0) map.remove(c);
            if(count > 0) map.put(c,count);}
        }
        return map.isEmpty();
    }
}
