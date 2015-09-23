// Given numRows, generate the first numRows of Pascal's triangle.

// For example, given numRows = 5,
// Return

// [
//      [1],
//     [1,1],
//   [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0) return res;
        List<Integer> fir = new ArrayList<>();
        fir.add(1);
        res.add(fir);
        
        for(int i=1; i<numRows; i++){
            List<Integer> pas = new ArrayList<Integer>();
            pas.add(1);
            for(int j = 0; j<i-1; j++){
                int temp = res.get(i-1).get(j)+res.get(i-1).get(j+1);
                pas.add(temp);
            }
            pas.add(1);
            res.add(pas);
        }
        return res;
    }
}
