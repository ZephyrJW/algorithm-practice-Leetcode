// Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

// Range Sum Query 2D
// The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

// Example:
// Given matrix = [
//   [3, 0, 1, 4, 2],
//   [5, 6, 3, 2, 1],
//   [1, 2, 0, 1, 5],
//   [4, 1, 0, 1, 7],
//   [1, 0, 3, 0, 5]
// ]

// sumRegion(2, 1, 4, 3) -> 8
// sumRegion(1, 1, 2, 2) -> 11
// sumRegion(1, 2, 2, 4) -> 12
// Note:
// You may assume that the matrix does not change.
// There are many calls to sumRegion function.
// You may assume that row1 ≤ row2 and col1 ≤ col2.


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);

public class NumMatrix {
    int[][] sum;
    
    public NumMatrix(int[][] matrix) {
        sum = matrix;
        for(int i=0;i<sum.length;i++){
            for(int j=1; j< sum[0].length; j++){
                sum[i][j] += sum[i][j-1]; 
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res=0;
        for(int i=row1; i<= row2; i++){
            res += sum[i][col2];
            if(col1 != 0) res -= sum[i][col1-1];
            //very smart solution to marginal situation where col1 may be 1, and col1-1 would make no sense
        }
        return res;
    }
}
