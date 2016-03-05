// Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.


// Example 1
// Input: "2-1-1".

// ((2-1)-1) = 0
// (2-(1-1)) = 2
// Output: [0, 2]


// Example 2
// Input: "2*3-4*5"

// (2*(3-(4*5))) = -34
// ((2*3)-(4*5)) = -14
// ((2*(3-4))*5) = -10
// (2*((3-4)*5)) = -10
// (((2*3)-4)*5) = 10
// Output: [-34, -14, -10, -10, 10]

//thanks to @mach7
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> curResults= new LinkedList<Integer>();
        for(int i=0; i<input.length(); ++i){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> leftResults = diffWaysToCompute(input.substring(0,i));
                List<Integer> rightResults = diffWaysToCompute(input.substring(i+1));
                for(Integer left: leftResults){
                    for(Integer right: rightResults){
                        int result = 0;
                        if(c == '+') result = left+right;
                        else if(c=='-') result = left - right;
                        else result = left*right;
                        curResults.add(result);
                    }
                }
            }
        }
        if(curResults.size() == 0){
            curResults.add(Integer.parseInt(input));
            return curResults;
        }
        return curResults;
    }
}

//one DP(dynamic programming) solution
public List<Integer> diffWaysToCompute(String input) {
    List<Integer> result=new ArrayList<>();
    if(input==null||input.length()==0)  return result;
    List<String> ops=new ArrayList<>();
    for(int i=0; i<input.length(); i++){
        int j=i;
        while(j<input.length()&&Character.isDigit(input.charAt(j)))
            j++;
        ops.add(input.substring(i, j));
        if(j!=input.length())   ops.add(input.substring(j, j+1));
        i=j;
    }
    int N=(ops.size()+1)/2; //num of integers
    ArrayList<Integer>[][] dp=(ArrayList<Integer>[][]) new ArrayList[N][N];
    for(int d=0; d<N; d++){
        if(d==0){
            for(int i=0; i<N; i++){
                dp[i][i]=new ArrayList<>();
                dp[i][i].add(Integer.valueOf(ops.get(i*2)));
            }
            continue;
        }
        for(int i=0; i<N-d; i++){
            dp[i][i+d]=new ArrayList<>();
            for(int j=i; j<i+d; j++){
                ArrayList<Integer> left=dp[i][j], right=dp[j+1][i+d];
                String operator=ops.get(j*2+1);
                for(int leftNum:left)
                    for(int rightNum:right){
                        if(operator.equals("+"))
                            dp[i][i+d].add(leftNum+rightNum);
                        else if(operator.equals("-"))
                            dp[i][i+d].add(leftNum-rightNum);
                        else
                            dp[i][i+d].add(leftNum*rightNum);
                    }
            }
        }
    }
    return dp[0][N-1];
}
