class Solution {
    public int shortestPath(int[][] grid) {

        if ( grid[0][0] == 1 ) return -1;

        // BFS 

        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] visit = new int[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[]{0,0});
        visit[0][0]=1;

        int length = 0; 

        while ( !queue.isEmpty() )
        {
             int queueLength = queue.size();
             for ( int i = 0; i<queueLength; i++ )
             {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];

                if ( r == ROWS - 1 && c == COLS -1 ) return length;

                int[][] neighbours = {{r,c+1},{r,c-1},{r+1,c},{r-1,c}};
                for ( int j =0;j<4;j++)
                {
                    int newR = neighbours[j][0];
                    int newC = neighbours[j][1];
                    if ( Math.min(newR,newC) < 0 || newR == ROWS || newC == COLS || visit[newR][newC]==1 || grid[newR][newC] == 1 )
                    {
                        continue;
                    }
                    queue.add(neighbours[j]);
                    visit[newR][newC]=1;
                }
             }
             length++;
        }
        return -1;

    }
}
