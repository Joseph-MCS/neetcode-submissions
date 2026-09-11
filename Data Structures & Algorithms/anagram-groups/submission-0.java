class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();
        for ( String s : strs )
        {
            // instead of storing each string use character frequency to capture how many times each char 
            // appears 
            int[] count = new int[26]; 

            for ( char c : s.toCharArray() )
            {
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            res.putIfAbsent(key,new ArrayList<>());
            res.get(key).add(s);
        }
        return new ArrayList<>(res.values());

   
        
    }


}
