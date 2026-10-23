class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = -1; 

        for ( int val : piles )
        {
            max = Math.max(max,val);
        }

        int L = 0;
        int R = max; 
        int hours; 
        int rate = R;
        int res = R;

        while ( L <= R )
        {

            rate = L + ( R - L )/2;
            hours = 0; 

            for ( int i = 0; i<piles.length; i++ )
            {
                hours += Math.ceil( (double) piles[i]/rate );
            }
            if ( hours > h )
            {
                L = rate + 1; 

            }
            else 
            {
               R = rate -1;
               res = Math.min(rate,res);
            }


        }
        return res;
        
    }
}
