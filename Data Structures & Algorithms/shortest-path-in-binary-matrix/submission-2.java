class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int N = grid.length; 
        if ( grid[0][0] == 1 || grid[N-1][N-1]==1) return -1;

        boolean[][] visit = new boolean[N][N];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        visit[0][0] = true;

        int length = 1;
        while ( !queue.isEmpty() )
        {
            int size = queue.size();
            for ( int i = 0; i<size; i++)
            {
                int[] pair = queue.poll();
                int r = pair[0];
                int c = pair[1];
                if ( r == N-1 && c == N-1 ) return length;
                
                int[][] neighbours = { {r,c+1}, {r,c-1}, {r-1,c}, {r+1,c}, {r+1,c+1}, {r+1,c-1}, {r-1,c+1}, {r-1,c-1} };
                for ( int j = 0; j<8;j++)
                {
                    int newR = neighbours[j][0];
                    int newC = neighbours[j][1];
                    if ( Math.min(newR,newC) < 0 || newR == N || newC == N ) continue;
                    if ( visit[newR][newC] || grid[newR][newC]==1) continue;
                    queue.add(new int[]{newR,newC});
                    visit[newR][newC] = true;
                }
            }
            length++;
        }
        return -1;
        
    }
}