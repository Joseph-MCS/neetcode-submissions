class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {


        int ROWS = matrix.length; 
        int COLS = matrix[0].length; 
        int size = ROWS*COLS; 
        int L = 0; 
        int R = size-1; 
        int mid;
        int rowIndex; 
        int colIndex;


        while ( L <= R )
        {
            mid = L + ( R - L )/2;
            rowIndex = mid/COLS;
            colIndex = mid%COLS;
            int element = matrix[rowIndex][colIndex];
            if ( element == target ) return true;
            else if ( element > target ) R = mid - 1;
            else L = mid + 1;


        }
        return false;
        
        
    }
}
