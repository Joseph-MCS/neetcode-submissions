class Solution {
    public int orangesRotting(int[][] grid) {

        int ROWS = grid.length; 
        int COLS = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        int fresh = 0;
        int minutes = 0; 

        for ( int i = 0; i<grid.length; i++)
        {
            for ( int j = 0; j<grid[0].length; j++ )
            {
                if ( grid[i][j] == 1 )
                {
                    fresh++;
                }

                if ( grid[i][j] == 2 )
                {
                    queue.add(new int[]{i,j});
                }
            }
        }


        while ( fresh > 0 && !queue.isEmpty() )
        {
            int size = queue.size();
            for ( int i = 0; i < size; i++ )
            {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

            
                

                int[][] neighbours = {{ r, c - 1 },{r, c + 1},{r - 1, c},{r + 1, c}};
               
                for ( int j = 0; j<4; j++ )
                {
                     r = neighbours[j][0];
                     c = neighbours[j][1];
                     if ( Math.min(r,c) < 0 || r == ROWS || c == COLS || grid[r][c] == 0 || grid[r][c] == 2)
                     {
                        continue;
                     }
                     queue.add(neighbours[j]);
                     grid[r][c] = 2;
                     fresh--;
                    
                    
                }
                
            }
            minutes++;
        }
        return fresh == 0 ? minutes : -1;

        

       
        
    }
}
