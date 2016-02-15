// Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

// Example 1:
// Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
// Return 16
// The two words can be "abcw", "xtfn".

// Example 2:
// Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
// Return 4
// The two words can be "ab", "cd".

// Example 3:
// Given ["a", "aa", "aaa", "aaaa"]
// Return 0
// No such pair of words.

public class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        int[] bytes = new int[words.length];
        for(int i=0;i<words.length;i++){
            int val = 0;
            for(int j=0;j<words[i].length();j++){
                val |= 1<<(words[i].charAt(j)-'a');
            }
            bytes[i] = val;
        }
        for(int i=0; i<bytes.length; i++){
            for(int j=i+1; j<bytes.length; j++){
                if((bytes[i] & bytes[j])==0)max = Math.max(max,words[i].length()*words[j].length());
            }
        }
        return max;
    }
}

// a|=b的意思就是把a和b按位或然后赋值给a   按位或的意思就是先把a和b都换成2进制，然后用或操作，相当于a=a|b
