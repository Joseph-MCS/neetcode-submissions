class Solution {
    public int firstUniqChar(String s) {

        int n = s.length(); 
        HashMap<Character,Integer> count = new HashMap<>(); 
        for ( int i = 0; i< n; i++ )
        {
            char c = s.charAt(i);
            if ( !count.containsKey(c))
            {
                count.put( c,i);
            }
            else 
            {
                count.put( c, n );
            }
        }

        int res = n; 
        for ( int index : count.values() )
        {
            res = Math.min(res,index);
        }
        return res == n ? -1 : res;

    
        
        
        
        
    }
}