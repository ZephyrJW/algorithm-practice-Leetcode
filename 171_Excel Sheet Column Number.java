public class Solution {
    public int titleToNumber(String s) {
      int i,sum = 0;
      for(i=0;i<s.length();i++){
      sum = sum * 26 + (s.charAt(i)-'A'+1);
      }
    return sum;
  }
}
