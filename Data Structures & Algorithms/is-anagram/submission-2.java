class Solution {
    public boolean isAnagram(String s, String t) {
        if ( s.length()!=t.length()) return false;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for ( int i = 0; i<s.length(); i++)
        {
            char currChar = s.charAt(i);
            if ( sMap.containsKey( currChar ) )
            {
                sMap.replace( currChar, sMap.get( currChar ) + 1 );
            }
            else
            {
                sMap.put( currChar, 1 );
            }
        }

        for ( int i = 0; i<t.length(); i++)
        {
            char currChar = t.charAt(i);
            if ( tMap.containsKey( currChar ) )
            {
                tMap.replace( currChar, tMap.get( currChar ) + 1 );
            }
            else
            {
                tMap.put(currChar,1);
            }
        }

        for ( Character key : tMap.keySet() )
        {

            if ( !(sMap.containsKey(key) && tMap.containsKey(key)) )
            {
               return false;
            }
            if ( !sMap.get(key).equals(tMap.get(key)) )
            {
                return false;
            }
 

        }

        return true;
   

    }
}
