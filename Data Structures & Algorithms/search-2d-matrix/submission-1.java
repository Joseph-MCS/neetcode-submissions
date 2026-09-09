class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int ROWS = matrix.length; 
        int COLS = matrix[0].length; 

        int left = 0; 
        int right = ROWS*COLS-1;

        while ( left <= right )
        {
            int middle = left + ( right - left ) /2;
            // 1D --> 2D
            int row = middle / COLS; 
            int col = middle % COLS;      
            if ( target == matrix[row][col]) return true;
            else if ( target > matrix[row][col] )
            {
                left = middle + 1; 
            }
            else
            {
                right = middle - 1;
            }
        }
        return false;
        
    }
}
