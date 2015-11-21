// The gray code is a binary numeral system where two successive values differ in only one bit.

// Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

// For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

// 00 - 0
// 01 - 1
// 11 - 3
// 10 - 2
// Note:
// For a given n, a gray code sequence is not uniquely defined.

// For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

// For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.


public class Solution {
public List<Integer> grayCode(int n) {

       List<Integer> answer = new ArrayList<Integer> ();
       if(n == 0){answer.add(0);return answer;}
       int layer = 0;
       answer.add(0);
       answer.add(1);
       for( layer = 1; layer < n; layer++){
           int last = answer.size() - 1;
           int bigbit = (int)Math.pow(2, layer);
           for(int i = last; i >= 0; i--){
              answer.add(bigbit + answer.get(i));

           }

       }
       return answer;
    }
}


// bit manipulation
public class Solution {
//analyze the pattern
//n=0  -> 0
//n=1  -> 0, 1
//n=2  -> (00,  01),  (10,  11)
//n=3  -> (000, 001, 010, 011), (111, 110, 101, 100)

//so the pattern is when n=n  -> add 0 in front of all the result of (n-1)'s binary value (This is just same as all the result of (n-1)
//                               and add 1 in front of all the result of(n-1)'s binary value (This need to calculate.)

public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList();
    result.add(0);

    for(int i=1; i<=n; i++){
        int front=1;
        //Create the correct value for binary format (10...0) which the value has i digi
        //so shift 1 to right (i-1) times
        for(int j=1; j<i; j++){
            front = front<<1;
        }

        //add the new generated value to the result list
        //the new generated value is the last result add front value
        int size=result.size();
        //we want to loop through the (n-1) result from end to start. This is just because want to make the test case match the Leetcode answer. You can use other way loop through the (n-1) result.
        for(int k=size-1; k>=0; k--){
            result.add(result.get(k)+front);
        }
    }

    return result;
}
}
