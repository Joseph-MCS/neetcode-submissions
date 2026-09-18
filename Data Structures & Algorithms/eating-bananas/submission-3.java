class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxRate = -1;
        for ( int pile : piles )
        {
            maxRate = Math.max(pile,maxRate);
        }
        
        int L = 1; 
        int R = maxRate; 
        int M, rate, res = maxRate, hours;
        
        while( L <= R )
        {

            M = L + ( R - L )/2;
            rate = M;
            hours = 0;
            for ( int i = 0; i<piles.length; i++)
            {
                hours += Math.ceil((double) piles[i]/rate);
            }
            if ( hours > h )
            {
                L = M + 1; 
            }
            else
            {
                res = Math.min( res, rate );
                R = M-1;
            }
            

        }
        return res;

    
        
    }
}
