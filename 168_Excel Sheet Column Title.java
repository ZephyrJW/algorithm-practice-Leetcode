//Given a positive integer, return its corresponding column title as appear in an Excel sheet.

//For example:

//    1 -> A
//    2 -> B
//    3 -> C
//    ...
//    26 -> Z
//    27 -> AA
//    28 -> AB 

public class Solution {
    public String convertToTitle(int n) {
      String ans = "";
      if(n<=0) return "n error";
      
      while(n>0){
        int remain = n % 26;
        n /= 26;
        if(remain == 0){
          remain = 26;
          n --;
        }
        ans = (char)(remain-1 + 'A') + ans;
      }
    }

}
