class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maxRate = -1; 

        for ( int pile : piles )
        {
            maxRate = Math.max(pile,maxRate);
        }

        int L = 1; 
        int R = maxRate;
        int mid;
        int currHours;
        int res = Integer.MAX_VALUE;

        while ( L <= R )
        {
            mid = L + ( R - L )/2;
            currHours = 0; 
            for ( int i = 0; i<piles.length; i++)
            {
                currHours+=Math.ceil((double)piles[i]/mid);
            }
            if ( currHours <= h )
            {
                R = mid - 1;
                res = Math.min(res,mid);
            }
            else
            {
                L = mid + 1;
            }
           
            
        }
        return res;
        
    }
}
