// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R
// And then read line by line: "PAHNAPLSIIGYIR"
// Write the code that will take a string and make this conversion given a number of rows:

// string convert(string text, int nRows);
// convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || s.length()==0) return s;
        int size = numRows * 2 - 2;
        StringBuilder sb = new StringBuilder();
        int i=0, j=0;
        for(i=0;i<numRows;i++){
            for(j=i;j<s.length();j+=size){
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows-1){
                    int index = j+size - 2*i;
                    if(index < s.length()) sb.append(s.charAt(index));
                }
            }
        }
        return sb.toString();
    }
}
