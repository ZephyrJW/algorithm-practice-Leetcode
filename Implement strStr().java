// Implement strStr().

// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.


//*****notice: it's a good prblem to practice KMP algorithem, still learning that
// https://leetcode.com/discuss/53050/detailed-explanation-on-building-up-lps-for-kmp-algorithm

public class Solution {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if(haystack.equals(needle)) return 0;
        if(len == 0) return 0;
        if(len<1) return -1;
        int index = -1;
        for(int i = 0; i<= haystack.length()-len;i++){ // notice it's <=
            if(haystack.charAt(i) != needle.charAt(0)) continue;
            String test = haystack.substring(i,i+len);
            if(test.equals(needle)) {
                index = i;
                break;
            }
        }
        return index;
    }
}

//concise by @  jeantimex 
public int strStr(String haystack, String needle) {
  for (int i = 0; ; i++) {
    for (int j = 0; ; j++) {
      if (j == needle.length()) return i;
      if (i + j == haystack.length()) return -1;
      if (needle.charAt(j) != haystack.charAt(i + j)) break;
    }
  }
}
