class Solution {
    public int firstUniqChar(String s) {

        HashMap<Character, Integer> charFreq = new HashMap<>();
        for ( int i = 0; i<s.length(); i++ )
        {
            charFreq.put( s.charAt(i), charFreq.getOrDefault( s.charAt(i), 0 ) + 1 );
        }
        for ( int j = 0; j<s.length(); j++ )
        {
            if ( charFreq.get( s.charAt(j) ) == 1 )
            {
                return j; 
            }
        }
        return -1;
        
        
        
        
    }
}