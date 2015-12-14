// Given an integer, convert it to a roman numeral.

// Input is guaranteed to be within the range from 1 to 3999.


//Most straightforward solution

public class Solution {
    public String intToRoman(int num) {
        if(num==0) return "";
        if(num>=1000) return "M"+intToRoman(num-1000);
        if(num>=900) return "CM"+intToRoman(num-900);
        if(num>=500) return "D"+intToRoman(num-500);
        if(num>=400) return "CD"+intToRoman(num-400);
        if(num>=100) return "C"+intToRoman(num-100);
        if(num>=90) return "XC"+intToRoman(num-90);
        if(num>=50) return "L"+intToRoman(num-50);
        if(num>=40) return "XL"+intToRoman(num-40);
        if(num>=10) return "X"+intToRoman(num-10);
        if(num>=9) return "IX"+intToRoman(num-9);
        if(num>=5) return "V"+intToRoman(num-5);
        if(num>=4) return "IV"+intToRoman(num-4);
        if(num>=1) return "I"+intToRoman(num-1);
        return ""; 
    }
}



// enum TYPE!
public class Solution {
    public enum Type{
        M(1000),CM(900),D(500),CD(400),C(100),XC(90),L(50),XL(40),X(10),IX(9),V(5),IV(4),I(1);
        private final int value;
        Type(int value) {
            this.value = value;
        }
    };
    public String intToRoman(int num) {
        StringBuilder output = new StringBuilder();
        for (Type t:Type.values()) {
            while (num>=t.value) {
                output.append(t);
                num -= t.value;
            }
        }
        return output.toString();
    }
}
