class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int targetColour = image[sr][sc];
        if ( targetColour == color ) return image;
        dfs(image,sr,sc,color,targetColour);
        return image;
        
    }

    public void dfs( int[][] image, int r, int c, int color, int targetColour )
    {

        if ( Math.min(r,c) < 0 || r == image.length || c == image[0].length )
        {
            return;
        }
        if ( image[r][c]!=targetColour ) return;
        else
        {
            image[r][c] = color;
            dfs(image,r+1,c,color,targetColour);
            dfs(image,r-1,c,color,targetColour);
            dfs(image,r,c-1,color,targetColour);
            dfs(image,r,c+1,color,targetColour);
            return;
        }

    }
}