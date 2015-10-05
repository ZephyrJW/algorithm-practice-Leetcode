//Write a function to find the longest common prefix string amongst an array of strings.

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1)
            return "";
       // Arrays.sort(strs);
        String candidate = strs[0];
        int len = candidate.length();
        boolean agreed;
        while (len >= 0) {
            agreed = true;
            String sub = candidate.substring(0, len);
            for (int i = 1; i < strs.length; i++)
                if (!strs[i].startsWith(sub)) {
                    agreed = false;
                    break;
                }
            if (agreed)
                return sub;
            else
                len--;
        }

        return "";

    }
}
