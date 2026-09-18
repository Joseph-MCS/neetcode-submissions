class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int COLS = matrix[0].length; 
        int ROWS = matrix.length; 
        int size = COLS*ROWS - 1; 
        int L = 0, R = size, mid, row, col, element; 
       

        while ( L <= R )
        {
        mid = L + ( R - L )/2;
        row = (mid/COLS); 
        col = mid%COLS;
        if ( target > matrix[row][col])
        {
           L = mid + 1;
        }
        else if ( target < matrix[row][col])
        {
            R = mid - 1;
        }
        else{
            return true;
        }
        
        }
        return false;
        
    }
}
