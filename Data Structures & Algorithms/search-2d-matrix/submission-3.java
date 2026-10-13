class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int COLS = matrix[0].length;
        int ROWS = matrix.length;

        int L = 0; 
        int R = (COLS*ROWS)-1;
        int mid,row,col,element;

        while ( L<=R )
        {
            mid = L + ( R - L )/2;
            row = mid/COLS;
            col = mid%COLS;
            element = matrix[row][col];

            if ( element == target ) return true; 
            else if ( element > target ) R = mid - 1; 
            else L = mid + 1;
        }
        return false;

        
        
    }
}
