// Given a roman numeral, convert it to an integer.

// Input is guaranteed to be within the range from 1 to 3999.

public class Solution {
    public int romanToInt(String s) {
        int prev = 0, cur = 0;
        int res = 0;
        for (int i =0 ; i<= s.length()-1;i++){
            cur = r2i(s.charAt(i));
            if (prev < cur && prev !=0 ) res = res + cur - 2*prev;
            else{
                res += cur;
            }
            prev = cur;
         }
         return res;
    }
    
    private int r2i(char c){
      switch(c){
          case 'I':
              return 1;
          case 'V':
              return 5;
          case 'X':
              return 10;
          case 'L':
              return 50;
          case 'C':
              return 100;
          case 'D':
              return 500;
          case 'M':
              return 1000;
          default:
              return 0;
      }
  }
}


// another solution, inspiring, from the end of the roman numeber to transfer & uses a HashMap

public class Solution {
    public int romanToInt(String s) {
        if (s==null || s.isEmpty()) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int prev = 0, res=0;
        for (int i=s.length()-1; i>=0; i--) {
            int cur = map.get(s.charAt(i));
            if (cur<prev) res-=cur;
            else res+=cur;
            prev = cur;
        }
        return res;
    }
}
