// Given an index k, return the kth row of the Pascal's triangle.

// For example, given k = 3,
// Return [1,3,3,1].

// Note:
// Could you optimize your algorithm to use only O(k) extra space?

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] res = new Integer[rowIndex+1];
        Arrays.fill(res,0);
        res[0]=1;
        
        for(int i = 0; i <= rowIndex; i++){
            for(int j=i; j>0; j--){
                res[j] += res[j-1];
            }
        }
        return Arrays.asList(res);
    }
}
