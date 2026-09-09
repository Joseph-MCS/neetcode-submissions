class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {

        int left = 1; 
        int right = 0; 
        for ( int curr : piles )
        {
            right = Math.max( curr, right );
        }

        int res = h; 
        
        while ( left <= right )
        {
            int middle = left + ( right - left )/2; 
            int hoursTaken = 0; 
            for ( int p : piles )
            {
                hoursTaken += Math.ceil( (double) p / middle );
            }
            if ( hoursTaken <= h )
            {
                res = middle; 
                right = middle-1; 
            }
            else 
            {
                left = middle + 1; 
            }
        }
        return res;
        
    }
}
