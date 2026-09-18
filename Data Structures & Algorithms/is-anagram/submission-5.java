class Solution {
    public boolean isAnagram(String s, String t) 
    {

        if ( s.length() != t.length() ) return false; 
        if ( s.length() == 0 ) return true;
        char sChar, tChar;

        HashMap<Character,Integer> counts = new HashMap<>(); 

        for ( int i = 0; i<s.length(); i++)
        {

            sChar = s.charAt(i);
            tChar = t.charAt(i);
            counts.put( sChar, counts.getOrDefault(sChar, 0) + 1 );
            counts.put( tChar, counts.getOrDefault(tChar, 0) - 1 );
        
        }

        for ( int value : counts.values() )
        {
            if ( value != 0 ) return false;
        }
        return true;

        

    }
}
