class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if ( grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1) return -1;

        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] visit = new int[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{0,0});
        visit[0][0] = 1;

        int length = 1; 

        while( !queue.isEmpty() )
        {
            int queueLength = queue.size();
            for ( int i = 0; i<queueLength; i++ )
            {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];
                if ( r == ROWS-1 && c == COLS-1 )
                {
                     return length;
                }

                int[][] neighbours = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c},{r-1, c - 1}, {r+1, c - 1}, {r + 1, c+ 1}, {r - 1, c+1}};
                for ( int j = 0; j<8; j++ )
                {
                    r = neighbours[j][0];
                    c = neighbours[j][1];
                    if ( Math.min(r,c) < 0 || r == ROWS || c == COLS || visit[r][c] == 1 || grid[r][c] == 1) continue;
                    queue.add(neighbours[j]);
                    visit[r][c]=1;
                }
            }
            length++;
        }
        return -1;
        
    }
}