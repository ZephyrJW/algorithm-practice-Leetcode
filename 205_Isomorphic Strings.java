// Given two strings s and t, determine if they are isomorphic.

// Two strings are isomorphic if the characters in s can be replaced to get t.

// All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

// For example,
// Given "egg", "add", return true.

// Given "foo", "bar", return false.

// Given "paper", "title", return true.

// Note:
// You may assume both s and t have the same length.


public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> map = new HashMap<>();
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        
        for(int i = 0; i < sarr.length; i++){
            if(!map.containsKey(sarr[i])){
                if(map.containsValue(tarr[i])){
                    return false;
                }
            map.put(sarr[i],tarr[i]);
            }else{
                if(!(map.get(sarr[i]) == tarr[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
