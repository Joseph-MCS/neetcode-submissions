class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int L = 0; 
        HashSet<Integer> window = new HashSet<>();
        for ( int R = 0; R<nums.length; R++)
        {
            if ( R - L  > k ) window.remove(nums[L++]);
            if ( window.contains(nums[R])) return true;
            else window.add(nums[R]);
        }
        return false;
        
    }
}