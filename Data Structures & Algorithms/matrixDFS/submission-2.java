class Solution {
    public int countPaths(int[][] grid) 
    {

        int ROWS = grid.length, COLS = grid[0].length;
        boolean[][] visit = new boolean[ROWS][COLS];
        return dfs(grid,0,0,visit);

    }

    public int dfs( int[][] grid, int r, int c, boolean[][] visit )
    {

        if ( Math.min(r,c) < 0 || r == grid.length || c == grid[0].length || (visit[r][c]==true) || grid[r][c] == 1 )
        {
            return 0;
        }

        if ( r == grid.length-1 && c == grid[0].length -1 )
        {
            return 1;
        }

        visit[r][c]=true;
        
        int count = 0;
        count += dfs(grid,r+1,c,visit);
        count += dfs(grid,r-1,c,visit);
        count += dfs(grid,r,c+1,visit);
        count += dfs(grid,r,c-1,visit);

        visit[r][c] = false;
        return count;

    }
}
