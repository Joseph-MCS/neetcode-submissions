class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> arr1 = new HashSet<>();
        for ( int p : nums1 )
        {
            arr1.add(p);
        }
        List<Integer> res = new ArrayList<>();
        for ( int num : nums2 )
        {

            if ( arr1.contains(num) ) 
            {
            res.add(num);
            arr1.remove(num);
            }

        }
        int[] result = res.stream().mapToInt(Integer::intValue).toArray();
        return result;
       
        

        
    }
}